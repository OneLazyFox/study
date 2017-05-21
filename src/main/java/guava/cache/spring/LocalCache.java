package guava.cache.spring;

import guava.cache.local.CacheObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/5/20.
 *
 * @author 张小虎
 * @version 1.0
 */
public class LocalCache implements Cache {

    private static Logger logger = LoggerFactory.getLogger(LocalCache.class);

    private String name;

    private ConcurrentMap<String,CacheObject> store = new ConcurrentHashMap<>();

    private int auditIntervalInSeconds = 20;

    public LocalCache() {
        System.out.println("LocalCache()");
        Timer taskTimer = new Timer(true);
        taskTimer.scheduleAtFixedRate(new LocalCacheAuditor(), 1000*3, auditIntervalInSeconds * 1000);

        logger.info("Local cache instance and auditor created.");
    }

    public LocalCache(String name) {
        this();
        System.out.println("LocalCache(name): name: " + name);
        this.name = name;
    }

    @Override
    public String getName() {
        System.out.println("getName: name: " + name);
        return name;
    }

    public void setName(String name) {
        System.out.println("setName: name: " + name);
        this.name = name;
    }

    @Override
    public ConcurrentMap<String,CacheObject> getNativeCache() {
        return store;
    }

    @Override
    public ValueWrapper get(Object key) {
        System.out.println("get: key: " + key);
        CacheObject cacheObject = store.get(key);
        return new SimpleValueWrapper(cacheObject);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T get(Object key, Class<T> type) {
        System.out.println("getKeyType: key: " + key);
        return (T) store.get(key);
    }

    @Override
    public <T> T get(Object key, Callable<T> valueLoader) {
        return null;
    }

    @Override
    public void put(Object key, Object value) {
        System.out.println("put: key: " + key + " value: " + value);
        store.put((String) key, (CacheObject) value);
    }

    @Override
    public ValueWrapper putIfAbsent(Object key, Object value) {
        System.out.println("putIfAbsent: key: " + key + " value: " + value);
        CacheObject cacheObject = store.putIfAbsent((String) key, (CacheObject) value);
        return new SimpleValueWrapper(cacheObject);
    }

    @Override
    public void evict(Object key) {
        store.remove(key);
    }

    @Override
    public void clear() {
        store.clear();
    }

    /**
     * 清理过气的CacheObject
     */
    class LocalCacheAuditor extends TimerTask {

        @Override
        public void run() {
            logger.info("Clear the expired data from local cache...");
            Set<String> keySet = getNativeCache().keySet();
            for (String key : keySet) {
                CacheObject cacheObject = getNativeCache().get(key);
                if (!cacheObject.isAvailable()) {
                    evict(key);
                    logger.info("Local Cache Auditor : remove expired data[{}] from local cache.", key);
                }
            }
        }
    }
}
