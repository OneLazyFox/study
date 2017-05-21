package guava.constant;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/5/21.
 * 地区类型，和数据库area表中的类型一致
 * @author 张小虎
 * @version 1.0
 */
public enum AreaType {
    COUNTRY(0),
    PROVINCE(1),
    CITY(2),
    DISTRICT(3),
    STREET(4);

    private int value;

    private AreaType(int value) {
        this.setValue(value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
