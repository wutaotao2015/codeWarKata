package kata;

import org.junit.Test;

import java.math.BigInteger;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class SomeEgyptianFractions {

    private static void testing(String actual, String expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        testing(Decomp.decompose("3", "4"), "[1/2, 1/4]");
        testing(Decomp.decompose("12", "4"), "[3]");
        testing(Decomp.decompose("0", "2"), "[]");
        testing(Decomp.decompose("9", "10"), "[1/2, 1/3, 1/15]");
        testing(Decomp.decompose("4", "12"), "[1/3]");
    }
}

//class Decomp {
//
//    public static String decompose(String nrStr, String drStr) {
//        // your code
//        int numerator = Integer.parseInt(nrStr);
//        int denominator = Integer.parseInt(drStr);
//        if (numerator / denominator == 0) return "[]";
//        if (numerator % denominator == 0) return "[" + numerator / denominator + "]";
//        int firstFraction = 0;
//        if (numerator / denominator > 1) {
//            firstFraction = numerator / denominator;
//            numerator = numerator - firstFraction * denominator;
//        }
//        ArrayList<String> numers = new ArrayList<>();
////        12 5
////        2 5
////        3, 3, 2, 5, 30,
////        15/30, 10/30, 2/30
//        //  9/10
//        // 81/90
//        // 45/90 30/90 6/90
//        // 5/7   25/35
//        return "";
//    }
//}
class Decomp {
    public static final BigInteger ZERO = BigInteger.ZERO;
    public static final BigInteger ONE = BigInteger.ONE;

    public static String decompose(String nrStr, String drStr) {
        BigInteger nr = BigInteger.valueOf(Long.parseLong(nrStr));
        BigInteger dr = BigInteger.valueOf(Long.parseLong(drStr));

        LinkedList<String> res = new LinkedList<>();
        if (nr.compareTo(dr) >= 0) {
            res.add(nr.divide(dr).toString());
            nr = nr.mod(dr);
        }
        while(nr.compareTo(ZERO) > 0) {
            BigInteger next = dr.divide(nr);
            if (dr.mod(nr).compareTo(ZERO) != 0) {
                next = next.add(ONE);
            }
            res.add("1/" + next);
            nr = nr.multiply(next).subtract(dr);
            dr = dr.multiply(next);
        }
        return res.toString();
    }

    //3/7
    //9/21 - 7/21
    //4/5 5/4是1.XXX,2就是其最大因子
    //8/10 - 5/10
//    public static void main(String[] args) {
//        System.out.println(decompose("3", "19"));
//        ArrayList<String> strings = new ArrayList<>();
//        strings.add("1");
//        strings.add("2");
//        System.out.println(strings.toString());
//    }
}