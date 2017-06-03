package guava.http;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/5/31.
 *
 * @author 张小虎
 * @version 1.0
 */
public class SimpleGetTest {
    public static void main(String[] args) {
        HttpResult result = HttpHelper.doGet("http://blog.csdn.net/clementad/article/details/46592557");
        System.out.println(result);
    }
}
