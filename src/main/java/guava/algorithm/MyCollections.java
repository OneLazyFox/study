package guava.algorithm;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/4/24.
 *
 * @author 张小虎
 * @version 1.0
 */
public class MyCollections {
    public static void intersection() {
        Set<String> set1 = new LinkedHashSet<>();
        Set<String> set2 = new LinkedHashSet<>();

        set1.add("1");
        set1.add("2");
        set1.add("3");
        set1.add("4");

        set2.add("1");
        set2.add("2");
        set2.add("3");
        set2.add("4");

        System.out.println(set1);
        set1.retainAll(set2);
        System.out.println(set1);
    }

    public static void main(String[] args) {
        MyCollections.intersection();
    }

}
