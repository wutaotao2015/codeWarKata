/**
 * Created by wutaotao
 * 2018/1/31 21:50
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.runners.JUnit4;

public class DashatizeIt {

    @Test
    public void testBasic() {
        assertEquals("2-7-4", Solution.dashatize(274));
        assertEquals("5-3-1-1", Solution.dashatize(5311));
        assertEquals("86-3-20", Solution.dashatize(86320));
        assertEquals("9-7-4-3-02", Solution.dashatize(974302));
    }

    @Test
    public void testWeird() {
        assertEquals("0", Solution.dashatize(0));
        assertEquals("1", Solution.dashatize(-1));
        assertEquals("28-3-6-9", Solution.dashatize(-28369));
    }

    @Test
    public void testEdgeCases() {
        assertEquals("2-1-4-7-48-3-64-7", Solution.dashatize(Integer.MAX_VALUE));
        assertEquals("2-1-4-7-48-3-648", Solution.dashatize(Integer.MIN_VALUE));
        assertEquals("1-1-1-1-1-1-1-1-1-1", Solution.dashatize(-1111111111));
    }

}

class Solution {

    public static String dashatize(int num) {


//        char[] numChars = (num + "").toCharArray();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < numChars.length; i++) {
//            if (i == 0 && numChars[0] == '-') {
//                continue;
//            }
//            int intValue = Integer.parseInt(numChars[i] + "");
//            if (intValue % 2 == 0) {
//                sb.append(intValue);
//            } else {
//                sb.append('-');
//                sb.append(intValue);
//                sb.append('-');
//            }
//        }
//        return sb.toString().replaceAll("^-", "")
//                .replaceAll("-$", "")
//                .replaceAll("--", "-");
        return Integer.toString(num).replaceAll("([13579])", "-$1-")
                .replaceAll("--", "-")
                .replaceAll("^-", "")
                .replaceAll("-$", "");
    }
}