package guava.util;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/5/31.
 * 随机数工具，单例模式
 * @author 张小虎
 * @version 1.0
 */
public class RandomUtils {

    /**
     * 获得一个Random单例
     */
    public static ThreadLocalRandom getRandom() {
        return ThreadLocalRandom.current();
    }

    /**
     * 获得一个[0,max)之间的随机整数
     */
    public static int getRandomInt(int max) {
        return getRandom().nextInt();
    }

    /**
     * 获得一个[min,max]之间的随机整数
     */
    public static int getRandomInt(int min, int max) {
        return getRandom().nextInt(max - min + 1) + min;
    }

    /**
     * 获得一个[0,max)之间的长整数
     */
    public static long getRandomLong(long max) {
        return getRandom().nextLong(max);
    }

    /**
     * 从数组中随即获取一个元素
     */
    public static <E> E getRandomElement(E[] array) {
        return array[getRandomInt(array.length)];
    }

    /**
     * 从list中随机获取一个元素
     */
    public static <E> E getRandomElement(List<E> list) {
        return list.get(getRandomInt(list.size()));
    }

    /**
     * 从set中获取一个随机元素
     */
    public static <E> E getRandomElement(Set<E> set) {
        int rn = getRandomInt(set.size());
        int i = 0;
        for (E e : set) {
            if (i == rn) {
                return e;
            }
            i++;
        }
        return null;
    }

    /**
     * 从Map中随机获得一个key
     */
    public static <K, V> K getRandomKeyFromMap(Map<K, V> map) {
        int rn = getRandomInt(map.size());
        int i = 0;
        for (K key : map.keySet()) {
            if (i == rn) {
                return key;
            }
            i++;
        }
        return null;
    }

    /**
     * 从Map中随机获得一个value
     */
    public static <K, V> V getRandomValueFromMap(Map<K, V> map) {
        int rn = getRandomInt(map.size());
        int i = 0;
        for (V value : map.values()) {
            if (i == rn) {
                return value;
            }
            i++;
        }
        return null;
    }

    /**
     * 生成一个n位随机数，用于生成验证码等
     */
    public static String getRandomNumber(int n) {
        String rn = "";
        if (n > 0 && n < 10) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < n; i++) {
                str.append('9');
            }
            int num = Integer.parseInt(str.toString());
            while (rn.length() < n) {
                rn = String.valueOf(ThreadLocalRandom.current().nextInt(num));
            }
        } else {
            rn = "0";
        }
        return rn;
    }

    public static void main(String[] args) {
        System.out.println(getRandomNumber(5));
    }
}
