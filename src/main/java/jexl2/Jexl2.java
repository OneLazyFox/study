package jexl2;

import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/4/4.
 *
 * @author 张小虎
 * @version 1.0
 */
public class Jexl2 {
    /**
     *
     * <pre>
     * 需求描述：数据库中有如下表：test,列定义如下：
     * --------
     * c1 c2 c3
     * --------
     * 1 2 3
     * 2 1 0
     * ...
     * --------
     * 业务需要在用户录入数据后，进行数据校验，对不符合条件的数据，禁止保存；
     *
     * 条件1：如c1>c2，则c3=0;否则c3值不变；
     * 此问题可以使用客户端或服务器端简单实现，但是对于这样的表达式有几千个，
     * 并且需求经常发生变更时，代码维护量将成指数级增加，需要考虑优化算法。
     *
     * 解决办法：
     * 使用jexl表达式，将各条件保存为表达式，数据保存时，校验即可。
     * commons-jexl-2.1.1.jar
     */
    public static void main(String[] args) {
        Expression expression;
        JexlContext context = new MapContext();
        JexlEngine engine = new JexlEngine();

        String exp = "if(c1 > c2) {c3 = 0};";
        expression = engine.createExpression(exp);

        context.set("c1",1);
        context.set("c2",2);
        context.set("c3",5);
        expression.evaluate(context);
        System.out.println(context.get("c3"));

        context.set("c1",3);
        expression.evaluate(context);
        System.out.println(context.get("c3"));
    }
}
