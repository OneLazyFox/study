package guava.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/5/20.
 *
 * @author 张小虎
 * @version 1.0
 */
public class AtomicIntegerTest {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(0);
        int i1 = ai.get();
        v(i1);
        int i2 = ai.getAndSet(5);
        v(i2);
        int i3 = ai.get();
        v(i3);
        int i4 = ai.getAndIncrement();
        v(i4);
        int i5 = ai.get();
        v(i5);
    }

    static void v(int i) {
        System.out.println("i : " + i);
    }
}
