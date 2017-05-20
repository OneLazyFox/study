package guava.cache.local;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;

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
public class MyCacheManager {

    private static Logger logger = LoggerFactory.getLogger(MyCacheManager.class);
    private static MyCache localCache;

    private static MyCache getCache() {
        if (localCache == null) {
            logger.debug("Creating local cache instance...");
            localCache = new MyCache();
        }
        return localCache;
    }

    private static void putPaymentMethods() {
        String key = "paymentMethods";
        long age = 60;
        Map<String, String> methods = new LinkedHashMap<>();
        methods.put("0","支付宝");
        methods.put("1", "微信支付");
        methods.put("2", "银联");
        methods.put("3", "连连支付");
        methods.put("5", "苹果支付");
        methods.put("9", "余额支付");
        methods.put("10", "优惠券支付");
        methods.put("21", "他人支付-支付宝");
        methods.put("22", "他人支付-财付通");

        getCache().put(key,methods,age);
    }

    @SuppressWarnings("unchecked")
    public static Map<String, String> getPaymentMethods() {
        CacheObject cacheObject = getCache().get("paymentMethods");
        if (cacheObject != null) {
            return (Map<String, String>) cacheObject.getValue();
        }else {
            return null;
        }
    }

    public static String getPaymentMethodName(String number) {
        Map<String, String> pm = getPaymentMethods();
        if (pm != null) {
            return pm.get(number);
        }else {
            return null;
        }
    }
}
