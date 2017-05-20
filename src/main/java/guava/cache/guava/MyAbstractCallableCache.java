package guava.cache.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/5/11.
 * 抽象缓存类、缓存类模板
 * 子类需要实现fetchOrCalculateData从数据库或其他数据源中获取数据
 * @author 张小虎
 * @version 1.0
 */
public abstract class MyAbstractCallableCache<K, V, T> {
    private int maximumSize = 1000;  //最大缓存条数
    private int refreshAfterWriteDuration = 10;  //刷新数据时间
    private TimeUnit timeUnit = TimeUnit.SECONDS;  //缺省时间单位(秒)

    //创建缓存
    public Cache<K,V> cache;

    public MyAbstractCallableCache() {
        cache = CacheBuilder.newBuilder()
                .maximumSize(maximumSize)
                .expireAfterWrite(refreshAfterWriteDuration, timeUnit) //创建或更新后的移除时间
                .build();
    }

    public MyAbstractCallableCache(int maximumSize, int refreshAfterWriteDuration, TimeUnit timeUnit) {
        this.maximumSize = maximumSize;
        this.refreshAfterWriteDuration = refreshAfterWriteDuration;
        this.timeUnit = timeUnit;
        cache = CacheBuilder.newBuilder()
                .maximumSize(maximumSize)
                .expireAfterWrite(refreshAfterWriteDuration, timeUnit) //创建或更新后的移除时间
                .build();
    }

    public V getCacheData(final K key, final T t) {
        try {
            return cache.get(key, new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return fetchOrCalculateData(key, t);
                }
            });
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 从数据库中获取数据、或计算数据
     * @param key K
     * @param t T
     * @return V
     */
    public abstract V fetchOrCalculateData(K key, T t);
}
