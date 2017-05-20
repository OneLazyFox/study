package guava.algorithm;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/4/24.
 * 此方法干嘛
 * @author 张小虎
 * @version 1.0
 */
public class BinarySearch {
    static int binSearch(int[] sourceArray, int des) {
        int low = 0;
        int high = sourceArray.length-1;
        int mid = (low + high)/2;
        while (low <= high) {
            if (des == sourceArray[mid]) {
                return mid;
            }else if (des < sourceArray[mid]) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
            mid = (low + high)/2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,7,9,12};
        System.out.println(binSearch(a,1));
    }
}
