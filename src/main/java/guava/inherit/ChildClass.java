package guava.inherit;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/6/3.
 *
 * @author 张小虎
 * @version 1.0
 */
public class ChildClass extends AbstractClass {
    private int iAmAVar = 200;

    protected static int aaa = 2000;

    public ChildClass() {
        System.out.println("Child : " + aaa);
    }

    @Override
    public int getiAmAVar() {
        return iAmAVar;
    }

    public static void main(String[] args) {
        ChildClass c = new ChildClass();
        System.out.println(c.getiAmAVar());
    }
}
