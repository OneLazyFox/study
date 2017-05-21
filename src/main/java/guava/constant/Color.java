package guava.constant;

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
public enum Color {
    RED("红色") {
        public String getHint() {
            return "我是红色! ";
        }
    },
    GREEN("绿色") {
        public String getHint() {
            return "我是绿色! ";
        }
    },
    BLUE("蓝色") {
        public String getHint() {
            return "我是蓝色! ";
        }
    };

    private String name;

    Color(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract String getHint();

    public static void main(String[] args) {
        System.out.println("RED: " + Color.RED.getHint());
    }

}
