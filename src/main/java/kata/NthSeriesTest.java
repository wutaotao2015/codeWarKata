package kata; /**
 * Created by wutaotao
 * 2018/1/23 21:36
 */
import static org.junit.Assert.*;

import java.util.stream.IntStream;

import org.junit.Test;


public class NthSeriesTest {

    @Test
    public void test1() {
        assertEquals(NthSeries.seriesSum(5), "1.57");
    }
    @Test
    public void test2() {
        assertEquals(NthSeries.seriesSum(9), "1.77");
    }
    @Test
    public void test3() {
        assertEquals(NthSeries.seriesSum(15), "1.94");
    }
}
 class NthSeries {

    public static String seriesSum(int n) {
        // Happy Coding ^_^
        double sum = 0.00;
        //利用 1 = 1 + 3 * 0 可以减少一个变量
//        int alpha = 1;
//        for (int i = 1; i <= n; i++) {
//            sum += 1 / (alpha * 1.00);
//            alpha += 3;
//        }
//        for (int i = 0; i < n; i++) {
//            sum += 1.0 / (1 + 3 * i);
//        }
//        return String.format("%.2f", sum);
        //jdk8 java.util.stream.IntStream
        return String.format("%.2f",
                IntStream.range(0, n).mapToDouble(num -> 1.0 / (1 + 3 * num)).sum());
    }
}

