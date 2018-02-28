/**
 * Created by wutaotao
 * 2018/1/25 21:58
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class BuyCarTest {

    @Test
    public void test1() {
        int[] r = new int[]{6, 766};
        assertArrayEquals(r, BuyCar.nbMonths(2000, 8000, 1000, 1.5));
    }

    @Test
    public void test2() {
        int[] r = new int[]{0, 4000};
        assertArrayEquals(r, BuyCar.nbMonths(12000, 8000, 1000, 1.5));
    }
}

class BuyCar {

    public static int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {
        // your code
        double saving = 0, oldCarPrice = startPriceOld, newCarPrice = startPriceNew, loss = 0;
        int months = 1;
        while (saving + oldCarPrice <= newCarPrice) {
            months++;
            saving += savingperMonth;
            if(months % 2 == 0) percentLossByMonth += 0.5d;
            newCarPrice = newCarPrice * (1 - percentLossByMonth / 100);
            oldCarPrice = oldCarPrice * (1- percentLossByMonth / 100);
        }
        return new int[]{months, (int) Math.round(saving + oldCarPrice - newCarPrice)};
    }
}
