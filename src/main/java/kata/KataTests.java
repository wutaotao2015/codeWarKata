package kata; /**
 * Created by wutaotao
 * 2018/1/23 19:33
 */

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class KataTests {
    @Test
    public void countPositivesSumNegatives_BasicTest() {
        int[] expectedResult = new int[] {10, -65};
        assertArrayEquals(expectedResult,
                Kata.countPositivesSumNegatives(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15}));
    }

    @Test
    public void countPositivesSumNegatives_InputWithZeroes() {
        int[] expectedResult = new int[] {8, -50};
        assertArrayEquals(expectedResult,
                Kata.countPositivesSumNegatives(new int[] {0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14}));
    }
}
class Kata
{
    public static int[] countPositivesSumNegatives(int[] input)
    {
        if (input == null || input.length == 0){
            return new int[0];
        }
        int positiveCount = 0;
        int negativeSum = 0;
        for (int i : input) {
            if(i > 0) {
                positiveCount++;
            }else{
                negativeSum += i;
            }
        }
        return new int[]{positiveCount, negativeSum}; //return an array with count of positives and sum of negatives
    }
}
