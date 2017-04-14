package guava.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/4/11.
 * 获取spring容器 访问容器中的bean
 * @author 张小虎
 * @version 1.0
 */
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return SpringContextUtil.applicationContext;
    }

    /**
     * 根据beanName获取bean
     * @param beanName beanName
     * @return bean
     */
    public static Object getBean(String beanName) throws BeansException {
        return SpringContextUtil.applicationContext.getBean(beanName);
    }

    /**
     * 根据beanType获取bean
     * @param requiredType 如 aaa.class
     * @return bean
     */
    public static <T>Object getBean(Class<T> requiredType) throws BeansException {
        return SpringContextUtil.applicationContext.getBean(requiredType);
    }

    /**
     * 根据beanType获取bean集合
     * @param type aaa.class
     * @return <name,Object>
     */
    public static Map<String,? extends Object> getBeanByType(Class<? extends Object> type) throws BeansException {
        return SpringContextUtil.applicationContext.getBeansOfType(type);
    }
}
