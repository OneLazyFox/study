package guava.web.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import guava.annotation.LoginNotRequired;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/4/15.
 * 方法拦截器，拦截controller中的方法，记录log
 * @author 张小虎
 * @version 1.0
 */
public class ControllerMethodInterceptor implements MethodInterceptor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final static ObjectMapper jsonMapper = new ObjectMapper();

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Method method = methodInvocation.getMethod();

        if (method.isAnnotationPresent(LoginNotRequired.class)) {
            logger.info("我不需要登录！");
        }

        logger.info("Before: interceptor name: {}", methodInvocation.getMethod().getName());

        Object result = methodInvocation.proceed();

        logger.info("After: result: {}", jsonMapper.writeValueAsString(result));

        return result;
    }
}
