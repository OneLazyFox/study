package guava.cache.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * <p>Title: 抽象缓存类，缓存模板</p>
 * <p>Description: 子类需要实现fetchData(key),从DB或是其他数据源(如Redis)中获取数据。
 *    子类调用getValue(key),从缓存中获取数据，并处理不同的异常，比如value为null时的InvalidCacheLoadException.</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/4/8.
 *
 * @author 张小虎
 * @version 1.0
 */
public abstract class GuavaAbstractLoadingCache<K,V> {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    //初始化Cache的参数及其初始值
    private int maximumSize = 1000;
    private int expireAfterWriteDuration = 60;
    private TimeUnit timeUnit = TimeUnit.MINUTES;
    private Date resetTime;
    private long highestSize;
    private Date highestTime;

    private LoadingCache<K,V> cache;

    public LoadingCache<K, V> getCache() {
        if (cache == null) {
            synchronized (this) {
                if (cache == null) {
                    cache = CacheBuilder.newBuilder()
                            .maximumSize(maximumSize)  //缓存的最大条目
                            .expireAfterAccess(expireAfterWriteDuration,timeUnit)  //过期时间
                            .recordStats()  // 启用统计
                            .build(new CacheLoader<K, V>() {
                                @Override
                                public V load(K key) throws Exception {
                                    return fetchData(key);
                                }
                            });
                    this.resetTime = new Date();
                    this.highestTime = new Date();
                    logger.debug("本地缓存初始化成功------" + this.getClass().getSimpleName());
                }
            }
        }
        return cache;
    }

    /**
     * 根据key从数据库或其他数据源中获取一个value，并被自动保存到缓存中。
     * @param key key
     * @return value
     */
    protected abstract V fetchData(K key);

    protected V getValue(K key) throws ExecutionException {
        V result = getCache().get(key);
        if (getCache().size() > highestSize) {
            highestSize = getCache().size();
            highestTime = new Date();
        }
        return result;
    }

    public int getMaximumSize() {
        return maximumSize;
    }

    /**
     * 设置最大缓存条数
     * @param maximumSize int
     */
    public void setMaximumSize(int maximumSize) {
        this.maximumSize = maximumSize;
    }

    public int getExpireAfterWriteDuration() {
        return expireAfterWriteDuration;
    }

    /**
     * 设置过期时间
     * @param expireAfterWriteDuration int
     */
    public void setExpireAfterWriteDuration(int expireAfterWriteDuration) {
        this.expireAfterWriteDuration = expireAfterWriteDuration;
    }

    public Date getResetTime() {
        return resetTime;
    }

    public void setResetTime(Date resetTime) {
        this.resetTime = resetTime;
    }

    public long getHighestSize() {
        return highestSize;
    }

    public void setHighestSize(long highestSize) {
        this.highestSize = highestSize;
    }

    public Date getHighestTime() {
        return highestTime;
    }

}
