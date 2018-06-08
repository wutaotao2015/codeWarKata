package kata; /**
 * Created by wutaotao
 * 2018/1/25 20:16
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class MaxRotateTest {

    private static void testing(long actual, long expected) {
        assertEquals(expected, actual);
    }
    @Test
    public void test() {
        System.out.println("Fixed Tests maxRot");
        testing(MaxRotate.maxRot(38458215), 85821534);
        testing(MaxRotate.maxRot(195881031), 988103115);
        testing(MaxRotate.maxRot(896219342), 962193428);
        testing(MaxRotate.maxRot(69418307), 94183076);
    }
}
 class MaxRotate {

    public static long maxRot (long n) {
        // your code
        long max = n;
        String temp = "" + n;
        for (int i = 0; i < temp.length() - 1; i++) {
//            String replacedDigit = temp.substring(i, i + 1);
            temp = temp.substring(0, i) + temp.substring(i + 1) + temp.charAt(i);
            if (Long.parseLong(temp) > max) {
                max = Long.parseLong(temp);
            }
        }
        return max;
    }
}
