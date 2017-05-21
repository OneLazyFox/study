package guava.freemarker;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.Template;
import freemarker.template.Version;

import java.io.File;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/5/21.
 *
 * @author 张小虎
 * @version 1.0
 */
public class FreeMarkerUtils {

    //模版路径
    public static final String PATH = "guava/freemarker/template";

    public static Version version = new Version("2.3.22");

    public static Configuration config;

    // 模板对象
    public static Template template;

    public static DefaultObjectWrapperBuilder defaultObjectWrapperBuilder;

    //
    static {
        final File file = new File(FreeMarkerUtils.class.getResource("/"+PATH).getPath());
    }
}
