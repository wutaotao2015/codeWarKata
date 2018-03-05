import static org.junit.Assert.*;

import org.junit.Test;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

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
class Decomp2 {

    public static String decomposeAux(String nrStr, String drStr) {
        long nr = Long.parseLong(nrStr);
        long dr = Long.parseLong(drStr);
        if (dr == 0 || nr == 0) {
            return "";
        }
        if (dr % nr == 0)
            return "1/" + dr / nr;
        String res = "";
        if (nr > dr) {
            long q = (int)Math.floor((double)(nr / dr));
            res += q + "";
            if (nr % dr != 0) {
                res += ", " + decomposeAux(Long.toString(nr % dr), Long.toString(dr));
                return res.trim();
            }
            else return res.trim();
        }
        long n = dr / nr + 1;
        res += "1/" + n + ", ";
        res += decomposeAux(Long.toString(nr * n - dr), Long.toString(dr * n));
        return res.trim();
    }
    public static String decompose(String nrStr, String drStr) {
        String res = decomposeAux(nrStr, drStr);
        return "[" + res + "]";
    }
}

class Decomp {
    public static final BigInteger ZERO = BigInteger.ZERO;
    public static final BigInteger ONE = BigInteger.ONE;

    public static String decompose(String nrStr, String drStr) {

        BigInteger numer = BigInteger.valueOf(Long.parseLong(nrStr));
        BigInteger denom = BigInteger.valueOf(Long.parseLong(drStr));

        List<String> fractions = new LinkedList<>();
        if (numer.compareTo(denom) >= 0) {
            fractions.add(numer.divide(denom).toString());
            numer = numer.mod(denom);
        }
        while (numer.compareTo(ZERO) > 0) {
            BigInteger next = denom.divide(numer);
            if (denom.mod(numer).compareTo(ZERO) != 0)
                next = next.add(ONE);
            fractions.add("1/" + next.toString());
            numer = numer.multiply(next).subtract(denom);
            denom = denom.multiply(next);
        }
        return fractions.toString();
    }

    public static void main(String[] args) {
        System.out.println(decompose("3", "7"));
    }
}