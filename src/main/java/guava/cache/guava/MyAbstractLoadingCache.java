package guava.cache.guava;

import com.google.common.cache.*;

import java.util.concurrent.TimeUnit;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/5/11.
 * 抽象缓存类、缓存模板
 * 子类需要实现fetchData从数据库或其他数据源中获取数据。
 * @author 张小虎
 * @version 1.0
 */
public abstract class MyAbstractLoadingCache<K, V> {

    private static int maximumSize = 100;
    private static int refreshAfterWriteDuration = 2;
    private static TimeUnit timeUnit = TimeUnit.SECONDS;

    LoadingCache<K, V> cache;

    public LoadingCache<K, V> getCache() {
        return cache;
    }

    public MyAbstractLoadingCache() {
        this(maximumSize,refreshAfterWriteDuration,timeUnit);
    }

    public MyAbstractLoadingCache(int maximumSize, int refreshAfterWriteDuration, TimeUnit timeUnit) {
        cache = CacheBuilder.newBuilder()
                .maximumSize(maximumSize)
                .expireAfterAccess(10,timeUnit)
                .recordStats()
                .removalListener(new RemovalListener<K, V>() {
                    @Override
                    public void onRemoval(RemovalNotification<K, V> notification) {
                        System.out.println(notification.getKey() + "被移出");
                    }
                }).build(new CacheLoader<K, V>() {
                    @Override
                    public V load(K key) throws Exception {
                        return fetchData(key);
                    }
                });
    }

    /**
     * 从数据库或其他数据源中获取一个key-value，并被加载到缓存中。
     * @param key K
     * @return 连同Key一起被加载到缓存中的。
     */
    protected abstract V fetchData(K key);
}
