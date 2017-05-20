package guava.cache.local;

import java.util.Calendar;
import java.util.Date;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/5/11.
 * 本地Cache类，用于村存放key，value和过期时间expiresDate
 * @author 张小虎
 * @version 1.0
 */
public class CacheObject {

    private Object value;
    private Date expireDate;

    /**
     * 永不过期
     * @param value Object
     */
    public CacheObject(Object value) {
        this.value = value;
        this.expireDate = null;
    }

    /**
     * 过期时间date
     * @param value Object
     * @param date Date
     */
    public CacheObject(Object value, Date date) {
        this.value = value;
        this.expireDate = date;
    }

    /**
     * 一段时间后过期
     * @param value Object
     * @param ageInSeconds 有效时长
     */
    public CacheObject(Object value, long ageInSeconds) {
        this.value = value;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis() + ageInSeconds * 1000);
        this.expireDate = calendar.getTime();
    }

    public boolean isAvailable() {
        return expireDate == null || expireDate.getTime() >= System.currentTimeMillis();
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return "CacheObject{" +
                "value=" + value +
                ", expireDate=" + expireDate +
                '}';
    }
}
