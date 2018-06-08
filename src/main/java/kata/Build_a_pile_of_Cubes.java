package kata;

import static org.junit.Assert.*;

import org.junit.Test;


public class Build_a_pile_of_Cubes {

    @Test
    public void test1() {
        assertEquals(2022, ASum.findNb(4183059834009L));
    }

    @Test
    public void test2() {
        assertEquals(-1, ASum.findNb(24723578342962L));
    }

    @Test
    public void test3() {
        assertEquals(4824, ASum.findNb(135440716410000L));
    }

    @Test
    public void test4() {
        assertEquals(3568, ASum.findNb(40539911473216L));
    }

}
class ASum {

    public static long findNb(long m) {

        return 0;
    }
}