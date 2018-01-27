// https://www.codewars.com/kata/5a378f28eced70bef80004b3
// written for java8

import java.math.BigInteger;

public class LargeSum {

    public static String firstTenDigitsOfSum(String[] numbers) {
        BigInteger sum = BigInteger.ZERO;
        for(int i=0; i<numbers.length; i++){
            sum = sum.add(new BigInteger(numbers[i]));
        }

        return sum.toString().substring(0, 10);
    }
}
