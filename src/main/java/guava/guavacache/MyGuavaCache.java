package guava.guavacache;

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
 * Created by neco on 2017/4/8.
 *
 * @author 张小虎
 * @version 1.0
 */
public class MyGuavaCache<K,V> {
    private Cache<K,V> cache = CacheBuilder.newBuilder().maximumSize(2).expireAfterAccess(10, TimeUnit.MINUTES).build();

    public Object getCache(K key, final String threadName) {
        Object value = null;
        try {
            System.out.println("Thread===Guava===getCache===" + threadName);
            value = cache.get(key, new Callable<V>() {
                @SuppressWarnings("unchecked")
                public V call() throws Exception {
                    System.out.println("ThreadName 执行业务数据并返回处理结果的数据（访问数据库等）=============="+threadName);
                    return (V) "neco's Guava!";
                }
            });
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return value;
    }
}
