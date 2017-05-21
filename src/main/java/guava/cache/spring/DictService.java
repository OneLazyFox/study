package guava.cache.spring;

import guava.cache.local.CacheObject;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

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

@Component
public class DictService {

    @Cacheable(value = "dataDictCache")
    public CacheObject getPaymentMethodsByClassCode(String classCode) {
        System.out.println("开始读取数据...");
        return getPaymentMethodsFromDB(classCode);
    }

    private CacheObject getPaymentMethodsFromDB(String classCode) {
        Map<String,String> methods = new LinkedHashMap<>();
        methods.put("0", "支付宝");
        methods.put("1", "微信支付");
        methods.put("2", "银联");
        methods.put("3", "连连支付");
        methods.put("5", "苹果支付");
        methods.put("9", "余额支付");
        methods.put("10", "优惠券支付");
        methods.put("21", "他人支付-支付宝");
        methods.put("22", "他人支付-财付通");

        CacheObject cacheObject = new CacheObject(methods, 60);
        System.out.println("从数据库中读出...");
        return cacheObject;
    }
}
