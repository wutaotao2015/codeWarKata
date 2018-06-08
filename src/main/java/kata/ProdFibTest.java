package kata; /**
 * Created by wutaotao
 * 2018/2/1 21:30
 */
import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Product of consecutive Fib numbers
 */
class ProdFib { // must be public for codewars

//    public static long[] productFib(long prod) {
//        // your code
//        long fn1 = 1;
//        for (long n = 0;; n++) {
//            long nextOne = fib(n + 1);
//            long result = fn1 * nextOne;
//            if (result == prod) return new long[]{fn1, nextOne, 1};
//            if (result > prod) return new long[]{fn1, nextOne, 0};
//            fn1 = nextOne;
//        }
//    }
    //递归限制死了思路
//    private static long fib(long n) {
//        if (n == 0 || n == 1) {
//            return 1;
//        }else {
//            return fib(n - 1) + fib(n - 2);
//        }
//        long a = 0, b = 1;
//        while (a * b < prod) {
//            long temp = a;
//            a = b;
//            b = a + temp;
//        }
//        return new long[]{a, b, a * b == prod ? 1 : 0};
//    }
//}
    public static long[] productFib(long prod) {
        long fibProd = 0;
        int i = 1;
        while (fibProd < prod) {
            fibProd = fibNum(i) * fibNum(i + 1);
            i++;
        }
        if (fibProd == prod) return new long[] {fibNum(i - 1),fibNum(i),1};
        return new long[] {fibNum(i - 1),fibNum(i),0};
    }
    public static long fibNum(int n) {
        double a = (Math.sqrt(5) + 1) / 2;
        return (long) ((1 / Math.sqrt(5))*(Math.pow(a, n) + Math.pow(a-1, n)));
    }
}
public class ProdFibTest {

    @Test
    public void test1() {
        long[] r = new long[] {55, 89, 1};
        assertArrayEquals(r, ProdFib.productFib(4895));
    }
    @Test
    public void test2() {
        long[] r = new long[] {89, 144, 0};
        assertArrayEquals(r, ProdFib.productFib(5895));
    }

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(ProdFibTest.class);
        logger.info("", new ProdFibTest());
    }
}
