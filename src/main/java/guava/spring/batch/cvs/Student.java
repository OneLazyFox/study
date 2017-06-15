package guava.spring.batch.cvs;

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
public class Student {
    /**
     * ID
     */
    private String ID = "";
    /**
     * 名字
     */
    private String name = "";
    /**
     * 年龄
     */
    private int age = 0;
    /**
     * 分数
     */
    private float score = 0;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
