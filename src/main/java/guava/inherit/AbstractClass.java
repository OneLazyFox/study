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
public class AbstractClass {
    private int iAmAVar = 100;

    protected static int  aaa = 1000;

    public AbstractClass() {
        System.out.println("super: " + 1000);
    }

    public int getiAmAVar() {
        return iAmAVar;
    }

    public void setiAmAVar(int iAmAVar) {
        this.iAmAVar = iAmAVar;
    }
}
