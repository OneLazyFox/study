package guava.algorithm;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/4/24.
 * 把两个排好序的数组按照值得顺序拼装成一个新数组
 * @author 张小虎
 * @version 1.0
 */
public class IntArraySort {

    /**
     * 把两个排好序的数组按照值得顺序拼装成一个新数组
     */
    public static int[] mergeTwoArrays(int[] a, int[] b) {
        int aIndex = 0, bIndex = 0, cIndex = 0;
        int[] c = new int[a.length + b.length];
        while ((aIndex < a.length) && (bIndex < b.length)) {
            if (a[aIndex] < b[bIndex]) {
                c[cIndex++] = a[aIndex++];
            }else {
                c[cIndex++] = b[bIndex++];
            }
        }
        //如果a数组后面还有剩余的数
        while (aIndex < a.length) {
            c[cIndex++] = a[aIndex++];
        }
        //如果b数组后面还有剩余的数
        while (bIndex < b.length) {
            c[cIndex++] = b[bIndex++];
        }
        return c;
    }

    public static void main(String[] args) {
        int[] a = {1,3,5,7,9,13,111,135,300};
        int[] b = {2,4,6,8,13,100,148,188,200,210};
        int[] c = mergeTwoArrays(a,b);
        for (int v : c) {
            System.out.println(v + " ");
        }
    }
}
