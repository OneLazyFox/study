package guava.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/4/22.
 * 获取类路径和流的工具
 * @author 张小虎
 * @version 1.0
 */
public class ClassPathUtil {

    /**
     * 获取项目所有类的根路径
     * @return 根路径(classpath目录)
     */
    public static String getClassPath() {
        final URL url = ClassPathUtil.class.getResource("/");
        return url.getPath();
    }

    /**
     * 获取指定类的路径
     * @param clazz 类
     * @return 路径
     */
    public static String getClassPath(final Class<?> clazz) {
        final URL url = clazz.getResource("");
        return url.getPath();
    }

    /**
     * 获取包路径
     * @param path 包名，格式 com/neco/util
     * @return 指定包所在路径
     */
    public static String getClassPath(String path) {
        final URL url = ClassPathUtil.class.getResource("/" + path);
        return url.getPath();
    }

    /**
     * 获取一个指定路径文件的输入流
     * @param filePath 指定的路径与文件名,eg:conf/config.properties
     * @return InputStream
     */
    public static InputStream getInputStream(final String filePath) {
        return ClassPathUtil.class.getResourceAsStream(filePath);
    }

    //测试
    public static void main(String[] args) throws IOException {
        System.out.println("根路径：" + getClassPath());
        System.out.println("类ClassPathUtils所在的路径：" + getClassPath(ClassPathUtil.class));
        System.out.println("包com.xjj.ftp所在的路径：" + getClassPath("guava/util"));
        System.out.println("包com.xjj.ftp所在的路径：" + getClassPath("guava/util"));

        System.out.println("配置目录springmvc所在的路径：" + getClassPath("springmvc"));

        InputStream in = getInputStream("springmvc/servlet.xml");
        //InputStream in = getInputStream("resources/css/common.css");
        int buffSize = 1024;
        byte[] b = new byte[buffSize];
        in.read(b, 0, buffSize);
        System.out.write(b);
    }
}
