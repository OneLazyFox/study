package guava.currenthashmap;

import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/4/8.
 *
 * @author 张小虎
 * @version 1.0
 */
public class CurrentHashMapCache<K,V> {
    private final ConcurrentHashMap<K,V> cacheMap = new ConcurrentHashMap<K, V>();

    public Object getCache(@SuppressWarnings("SameParameterValue") K key, String threadName) {
        System.out.println("Normal===ThreadName=====getCache======" + threadName);
        Object value;
        value = cacheMap.get(key);
        if (value == null) {
            return setCache(key,threadName);
        }
        return value;
    }

    public synchronized Object getSyncCache(@SuppressWarnings("SameParameterValue") K key, String threadName) {
        System.out.println("Synchronized===ThreadName=====getCache======" + threadName);
        Object value;
        value = cacheMap.get(key);
        if (value == null) {
            return setCache(key,threadName);
        }
        return value;
    }

    //@org.jetbrains.annotations.Contract(value = "_, _ -> null", pure = true)
    private Object setCache(K key, String threadName) {
        System.out.println("执行业务数据并返回处理结果的数据(访问数据库等)-------" + threadName);
        @SuppressWarnings("unchecked") V value = (V) "neco's value";
        cacheMap.put(key,value);
        return value;
    }

}
