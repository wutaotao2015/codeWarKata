package kata;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class ClockyMcClockFace {

    @Test
    public void test1200() {
        assertEquals("12:00", Dinglemouse.whatTimeIsIt(0));
        assertEquals("12:00", Dinglemouse.whatTimeIsIt(360));
    }

    @Test
    public void test0300() {
        assertEquals("03:00", Dinglemouse.whatTimeIsIt(90));
    }

    @Test
    public void test0600() {
        assertEquals("06:00", Dinglemouse.whatTimeIsIt(180));
    }

    @Test
    public void test0900() {
        assertEquals("09:00", Dinglemouse.whatTimeIsIt(270));
    }
    @Test
    public void testRandom() {
        assertEquals("06:39", Dinglemouse.whatTimeIsIt(199.765));
        assertEquals("12:41", Dinglemouse.whatTimeIsIt(20.6611));
    }

}
class Dinglemouse {

    public static String whatTimeIsIt(final double angle) {
        // Your code here
//        if (angle == 0 || angle == 360) return "12:00";
//        int hourInt,minuteInt;
//        if (angle < 30) {
//            hourInt = 12;
//            minuteInt = (int)Math.floor(angle / 30 * 60);
//        }else{
//            hourInt = (int)Math.floor(angle / 30);
//            double minuteAngle = angle - (hourInt * 30);
//            minuteInt = (int)Math.floor(minuteAngle / 30 * 60);
//        }
//        String hours = hourInt < 10 ? "0" + hourInt: "" + hourInt;
//        String minutes = minuteInt < 10 ? "0" + minuteInt : "" + minuteInt;
//        return hours+":"+minutes;
        int m = (int)(angle % 30 * 2);   //分针在中间 15度即为30分钟
        int h = (int)(angle / 30);
        if (h == 0) h = 12;
        return String.format("%02d:%02d", h, m);
    }

}