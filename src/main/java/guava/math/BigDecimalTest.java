package guava.math;

import java.math.BigDecimal;
import java.text.NumberFormat;

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
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal bigLoanAmount = new BigDecimal("999999999999999999999");
        BigDecimal bigInterestRate = new BigDecimal("0.03289");
        BigDecimal bigInterest = bigLoanAmount.multiply(bigInterestRate);
        NumberFormat currency = NumberFormat.getCurrencyInstance(); //建立货币格式化引用
        NumberFormat percent = NumberFormat.getPercentInstance(); //建立百分比格式化引用
        percent.setMaximumFractionDigits(3);

        // 利用BigDecimal对象作为参数在format()中调用货币和百分比格式化
        System.out.println("Loan amount:\t" + currency.format(bigLoanAmount));
        System.out.println("Interest rate:\t" + percent.format(bigInterestRate));
        System.out.println("Interest:\t" + currency.format(bigInterest));

        //最好利用String来初始化一个BigDecimal：
        System.out.println(new BigDecimal(0.1));
        System.out.println(new BigDecimal("0.1"));
    }
}
