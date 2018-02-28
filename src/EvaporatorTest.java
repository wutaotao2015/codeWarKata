package com.wtt.test;

/**
 * Created by wutaotao
 * 2018/1/24 22:27
 */
import static org.junit.Assert.*;
import org.junit.*;

public class EvaporatorTest {
    @Test
    public void testEvaporatorOne() {
        assertEquals(22 , Evaporator.evaporator(10, 10, 10));
    }
}
 class Evaporator {

    public static int evaporator(double content, double evap_per_day, double threshold) {
        // your code
        double remain =  1;
        int count = 0;
        while(remain >= threshold * 0.01) {
            remain = remain * (1 - evap_per_day * 0.01);
            ++count;
        }
        return count;
    }
}
