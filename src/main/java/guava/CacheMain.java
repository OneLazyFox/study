package guava;

import guava.currenthashmap.CurrentHashMapCache;
import guava.currenthashmap.FutureCache;
import guava.guavacache.MyGuavaCache;
//ReflectionWorld$ReflectionWorldException
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
public class CacheMain {
    public static void main(String[] args) {
        final CurrentHashMapCache<String,String> testCache = new CurrentHashMapCache<String, String>();
        final FutureCache<String,String> futureCache = new FutureCache<String, String>();
        final MyGuavaCache<String,String> guavaCache = new MyGuavaCache<String, String>();
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("T1===start===");

                /*Object neco = testCache.getCache("neco", "neco's 1");
                System.out.println("T1-=-value-=-" + neco);*/
                /*Object neco1 = testCache.getSyncCache("neco", "neco's 1");
                System.out.println("T1-=-value-=-" + neco1);*/
                /*Object neco2 = futureCache.getCache("neco", "neco's 1");
                System.out.println("T1-=-value-=-" + neco2);*/
                Object neco3 = guavaCache.getCache("neco", "neco's 1");
                System.out.println("T1-=-value-=-" + neco3);

                System.out.println("T1--- end ---");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                System.out.println("T2===start===");

                /*Object neco = testCache.getCache("neco", "neco's 2");
                System.out.println("T2-=-value-=-" + neco);*/
                /*Object neco1 = testCache.getSyncCache("neco", "neco's 2");
                System.out.println("T2-=-value-=-" + neco1);*/
                /*Object neco2 = futureCache.getCache("neco", "neco's 2");
                System.out.println("T2-=-value-=-" + neco2);*/
                Object neco3 = guavaCache.getCache("neco", "neco's 2");
                System.out.println("T2-=-value-=-" + neco3);

                System.out.println("T2--- end ---");
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            public void run() {
                System.out.println("T3===start===");

                /*Object neco = testCache.getCache("neco", "neco's 3");
                System.out.println("T3-=-value-=-" + neco);*/
                /*Object neco1 = testCache.getSyncCache("neco", "neco's 3");
                System.out.println("T3-=-value-=-" + neco1);*/
                /*Object neco2 = futureCache.getCache("neco", "neco's 3");
                System.out.println("T3-=-value-=-" + neco2);*/
                Object neco3 = guavaCache.getCache("neco", "neco's 3");
                System.out.println("T3-=-value-=-" + neco3);

                System.out.println("T3--- end ---");
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
