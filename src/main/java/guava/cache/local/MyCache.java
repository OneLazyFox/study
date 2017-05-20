package guava.cache.local;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/5/17.
 *
 * @author 张小虎
 * @version 1.0
 */
public class MyCache {

    public static Logger logger = LoggerFactory.getLogger(MyCache.class);

    /**
     * 存放规则{key, CacheObject(value, expireDate)}
     * e.g. {class_code, CacheObject(Map{code, name}, expireDate)}
     */
    private Map<String,CacheObject> cache;

    private int auditIntervalInSeconds = 20;

    public MyCache() {
        cache = new ConcurrentHashMap<>();

        Timer taskTimer = new Timer(true);

        taskTimer.scheduleAtFixedRate(new LocalCacheAuditor(), 1000*3, auditIntervalInSeconds*1000);

        logger.info("Local cache instance and auditor created.");
    }

    public boolean keyExists(String key) {
        if (key == null || "".equals(key)) {
            logger.error("The key[{}] is empty.", key);
            return false;
        }
        return cache.containsKey(key);
    }

    public boolean put(String key, Object value) {
        if (key == null || "".equals(key)) {
            return false;
        }

        CacheObject cacheObject = new CacheObject(value);
        cache.put(key,cacheObject);
        return true;
    }

    public boolean put(String key, Object value, long ageInSeconds) {
        if (key == null || "".equals(key)) {
            return false;
        }

        CacheObject cacheObject = new CacheObject(value, ageInSeconds);
        cache.put(key,cacheObject);
        return true;
    }

    public CacheObject get(String key) {
        if (key == null || "".equals(key)) {
            return null;
        }

        CacheObject cacheObject = cache.get(key);
        if (cacheObject == null) {
            return null;
        }

        if (cacheObject.isAvailable()) {
            return cacheObject;
        }else {
            //已经过期
            logger.debug("Remove expired data [{}] from local cache.", key);
            cache.remove(key);
            return null;
        }
    }

    @Override
    public String toString() {
        return "LocalCache [cacheDataMap = " + cache + " ].";
    }

    /**
     * 清理过期cacheObject
     */
    class LocalCacheAuditor extends TimerTask {
        @Override
        public void run() {
            logger.info("Clear the expired data from local cache...");
            Set<String> keySet = cache.keySet();

            for (String key : keySet) {
                if (!cache.get(key).isAvailable()) {
                    logger.info("Local Cache Auditor : remove expired data [{}] from local cache.", key);
                }
            }
        }
    }
}
