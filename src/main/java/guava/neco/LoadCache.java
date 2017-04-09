package guava.neco;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/4/8.
 * 本地缓存接口
 * @author 张小虎
 * @version 1.0
 */
public interface LoadCache<K,V> {
    /**
     * 从缓存中获取数据
     * @param key key
     * @return value
     */
    public V get(K key);
}
