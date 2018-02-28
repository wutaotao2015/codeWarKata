/**
 * Created by wutaotao
 * 2018/1/26 22:37
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

/**
 * Integers: Recreation One
 */
public class SumSquaredDivisorsTest {

    @Test
    public void test1() {
        assertEquals("[[1, 1], [42, 2500], [246, 84100]]", SumSquaredDivisors.listSquared(1, 250));
    }

    @Test
    public void test2() {
        assertEquals("[[42, 2500], [246, 84100]]", SumSquaredDivisors.listSquared(42, 250));
    }

    @Test
    public void test3() {
        assertEquals("[[287, 84100]]", SumSquaredDivisors.listSquared(250, 500));
    }

}
//class SumSquaredDivisors {
//
//    public static String listSquared(long m, long n) {
//        // your code
//        TreeMap<Long, Long> resultTreeMap = new TreeMap<>();
//        for (long i = m; i <= n; i++) {
//            long sum = 0;
//            for (int j = 1; j <= i; j++) {
//                if (i % j == 0) {
//                    sum += j * j;
//                }
//            }
//            if ((long)Math.sqrt(sum) * Math.sqrt(sum) == sum) {
//                resultTreeMap.put(i, sum);
//            }
//        }
//        Set<Map.Entry<Long, Long>> entries = resultTreeMap.entrySet();
//        StringBuilder sb = new StringBuilder("[");
//        int i = 0;
//        for (Map.Entry<Long, Long> entry : entries) {
//            sb.append("[" + entry.getKey() + ", " + entry.getValue() + "]");
//            ++i;
//            if (entries.size() != i) {
//                sb.append(", ");
//            }
//        }
//        sb.append("]");
//        return sb.toString();
//    }
//
//    public static void main(String[] args) {
//        System.out.println(Math.sqrt(21));
//        System.out.println(Math.sqrt(21) * Math.sqrt(21));
//        System.out.println(Math.sqrt(20) * Math.sqrt(20));
//        System.out.println((long)Math.sqrt(21));
//        System.out.println((long)Math.sqrt(21) * Math.sqrt(21));
//    }
//}
class SumSquaredDivisors {

    public static String listSquared(long m, long n) {
        // your code
        String s = "[";
        for (long i = m; i <= n; i++) {
            long divideSqrSum = getDivideSqrSum(i);
            if (divideSqrSum != 0) {
                s += s.length() == 1?"["+i+", "+divideSqrSum+"]" : ", ["+i+", "+divideSqrSum+"]";
            }
        }
        return s+="]";
    }
    /**
     *
     * @param k 要处理的数
     * @return 约数的平方和是完全平方数时返回该平方和，若不是统一返回0，因为和不可能是0
     */
    static long getDivideSqrSum(long k){
        long sum = k * k;
        for (int i = 1; i <= k / 2 ; i++) {
            if (k % i == 0) sum += i * i;
        }
        if ((long)Math.sqrt(sum) * Math.sqrt(sum) == sum) return sum;
        return 0;
    }
}

