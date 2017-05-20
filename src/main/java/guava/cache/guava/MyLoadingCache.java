package guava.cache.guava;

import java.util.concurrent.TimeUnit;

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
public class MyLoadingCache extends MyAbstractLoadingCache<String, String> {

    private static final int MAXIMUM_SIZE = 1000;
    public static final int REFRESH_AFTER_WRITE_DURATION = 200;
    public static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;

    //饿汉单例模式
    public static final MyLoadingCache lc= new MyLoadingCache();
    private MyLoadingCache() {
        super(MAXIMUM_SIZE, REFRESH_AFTER_WRITE_DURATION, TIME_UNIT);
    }
    public static MyLoadingCache getInstance() {
        return lc;
    }

    @Override
    protected String fetchData(String key) {
        System.out.println("fetchData method..." + key);

        //返回缓存数据(模拟)
        return "{key:"+key+", value:"+key+"'s value}";
    }

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 100; i++) {
                String value = lc.getCache().get("I am key" + i);
                System.out.println(value);
            }
            Thread.sleep(3000);
            System.out.println("========================");

            for (int i = 0; i < 101; i++) {
                String value = lc.getCache().get("I am key" + i);
                System.out.println(value);
                Thread.sleep(500);
            }

            for (int i = 101; i >= 0; i--) {
                String value = lc.getCache().get("I am key" + i);
                System.out.println(value);
                Thread.sleep(200);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
