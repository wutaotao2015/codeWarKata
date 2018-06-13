package kata;

/**
 * 2018/6/13 10:51 add by wutaotao
 */

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TimeFormatterTest {
    @Test
    public void testFormatDurationExamples() {
        // Example Test Cases
        assertEquals("1 second", TimeFormatter.formatDuration(1));
        assertEquals("1 minute and 2 seconds", TimeFormatter.formatDuration(62));
        assertEquals("2 minutes", TimeFormatter.formatDuration(120));
        assertEquals("1 hour", TimeFormatter.formatDuration(3600));
        assertEquals("1 hour, 1 minute and 2 seconds", TimeFormatter.formatDuration(3662));
        assertEquals("now", TimeFormatter.formatDuration(0));
    }
}

class TimeFormatter {

    private static int yearUnit = 365 * 24 * 60 * 60;
    private static int dayUnit = 24 * 60 * 60;
    private static int hourUnit = 60 * 60;
    private static int minuteUnit = 60;
    private static int secondUnit = 1;

    public static String formatDuration(int seconds) {

        int[] units = {yearUnit, dayUnit, hourUnit, minuteUnit, secondUnit};
        int[] nums = {0, 0, 0, 0, 0};

        while (seconds != 0) {

            for (int i = 0; i < 5; i++) {

                if (seconds < units[i]) continue;
                int unitNum = seconds / units[i];
                seconds = seconds - unitNum * units[i];
                nums[i] = unitNum;
                break;
            }
        }
        StringBuilder res = new StringBuilder();
        String[] names = new String[]{"year", "day", "hour", "minute", "second"};
        boolean first = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            if (first) {
                res.append(nums[i] + " " + names[i]);
                if (nums[i] > 1) {
                    res.append("s");
                }
                first = false;
            } else {
                res.append(", " + nums[i] + " " + names[i]);
                if (nums[i] > 1) {
                    res.append("s");
                }
            }
        }
        int i = res.lastIndexOf(",");
        if (i != -1) {
            res.replace(i, i + 1, " and");
        }
        if (res.length() == 0) {
            return "now";
        }
        return res.toString();
    }
}
//class TimeFormatter {
//
//  private static int S_PER_MIN = 60;
//  private static int S_PER_HR  = 60 * S_PER_MIN;
//  private static int S_PER_DAY = 24 * S_PER_HR;
//  private static int S_PER_YR =  365 * S_PER_DAY;
//
//  private static String unit(int n, String kind) {
//    return n == 0 ? "" : String.format("%d %s%s, ", n, kind, n == 1 ? "" : "s");
//  }
//
//  public static String formatDuration(int s) {
//
//    if (s == 0) return "now";
//
//    int y, d, h, m;
//
//    s -= (y = s / S_PER_YR)  * S_PER_YR;
//    s -= (d = s / S_PER_DAY) * S_PER_DAY;
//    s -= (h = s / S_PER_HR)  * S_PER_HR;
//    s -= (m = s / S_PER_MIN) * S_PER_MIN;
//
//    String ret = unit(y,"year") + unit(d,"day") + unit(h,"hour") + unit(m,"minute") + unit(s,"second");
//    ret = ret.substring(0, ret.length()-2); // remove trailing ', '
//    return ret.lastIndexOf(",") == -1 ? ret : ret.replaceAll("(.+), (.+?)$", "$1 and $2"); // replace last , with "and"
//  }
//
//}

// 正则表达式概念
// 普通字符 asd
// 非打印字符 \n \r \b \s \t \v
// 特殊字符 ^ $ () * + ? . [] \ {}
// 限定符 * + ? {n,} {n,m}
// *? 非贪婪匹配
// 定位符 ^ $ \b \B
// 选择 用圆括号将所有选择项括起来，不同选择项之间用|分隔。
// 反向引用
