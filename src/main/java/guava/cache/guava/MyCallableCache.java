package guava.cache.guava;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/5/11.
 *
 * @author 张小虎
 * @version 1.0
 */
public class MyCallableCache extends MyAbstractCallableCache<String, String, String> {
    //饿汉式单例模式
    private static final MyCallableCache cc = new MyCallableCache();
    private MyCallableCache(){};
    public static MyCallableCache getInstance() {
        return cc;
    }

    @Override
    public String fetchOrCalculateData(String key, String t) {
        System.out.println("fetchOrCalculateData method...");

        //返回缓存数据(模拟)
        return "{key:" + key + ", value:" + key + "'s value, and args: " + t + "}";
    }

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 15; i++) {
                String value = getInstance().getCacheData("I am key","I am arg.");
                System.out.println(value);
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
