package guava.misc;

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
public class FinalTest {
    public static void main(String[] args) {
        FinalTest tf = new FinalTest();
        Person p = tf.new Person();
        p.setName("Li");
        p.setAge(18);

        System.out.println(p);

        tf.changeName(tf, p, "Wang");
        System.out.println(p);

    }

    private void changeName(FinalTest tf, final Person p, String newName) {
        //p = tf.new Person();
        p.setName(newName);
    }

    private class Person{
        private String name;
        private int age;

        public Person(){
            super();
        }

        public void setName(String name) {
            this.name = name;
        }
        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person [name=" + name + ", age=" + age + "]";
        }
    }
}
