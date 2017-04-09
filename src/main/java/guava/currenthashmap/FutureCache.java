package guava.currenthashmap;

import java.util.concurrent.*;

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
public class FutureCache<K,V> {
    private final ConcurrentHashMap<K,Future<V>> cacheMap = new ConcurrentHashMap<K, Future<V>>();

    public Object getCache(K key, String threadName) {
        Future<V> value;
        try {
            System.out.println("Future===Thread===getCache===" + threadName);
            value = cacheMap.get(key);
            if (value == null) {
                value = setCache(key, threadName);
                return value.get();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Future<V> setCache(K key, final String threadName) {
        Future<V> value;
        Callable<V> callable = new Callable<V>() {
            @SuppressWarnings("unchecked")
            public V call() throws Exception {
                System.out.println("ThreadName 执行业务数据并返回处理结果的数据（访问数据库等）==============" + threadName);
                return (V) "neco's future value";
            }
        };
        FutureTask<V> futureTask = new FutureTask<V>(callable);
        value = cacheMap.putIfAbsent(key, futureTask);
        if (value == null){
            value = futureTask;
            futureTask.run();
        }
        return value;
    }
}
