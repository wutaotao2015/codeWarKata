package com.wtt.test;

/**
 * Created by wutaotao
 * 2018/1/25 20:41
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class PersistTest {

    @Test
    public void BasicTests() {
        System.out.println("****** Basic Tests ******");
        assertEquals(3, Persist.persistence(39));
        assertEquals(0, Persist.persistence(4));
        assertEquals(2, Persist.persistence(25));
        assertEquals(4, Persist.persistence(999));
    }

}
class Persist {
    public static int persistence(long n) {
        // your code
//        long tempN = n;
//        int count = 0;
//        while((tempN + "").length() > 1) {
//            long tempResult = 1;
//            for (char c : (tempN + "").toCharArray()) {
//                tempResult *= Long.parseLong(c + "");
//            }
//            tempN = tempResult;
//            count++;
//        }
//        return count;
//        if ((n + "").length() == 1) return 0;
//        long sum = 1;
//        for (int i = 0; i < (n + "").length(); i++) {
//            sum *= Long.parseLong((n + "").charAt(i)+"");
//        }
//        return persistence(sum) + 1;

        long m = 1, r = n;
        if (r/10 == 0) return 0;
        for (r = n; r != 0; r /= 10) {
            m *= r % 10;
        }
        return persistence(m) + 1;
    }
}
