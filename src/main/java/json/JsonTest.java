package json;

import com.neco.pojo.Course;
import com.neco.pojo.School;
import net.sf.json.JSONObject;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/4/19.
 *
 * @author 张小虎
 * @version 1.0
 */
public class JsonTest {
    public static void main(String[] args) {
        String json = JSONObject.fromObject(Course.class).toString();
        System.out.println(json);
    }
}
