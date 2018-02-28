/**
 * Created by wutaotao
 * 2018/1/23 22:26
 */
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

import java.util.HashMap;

public class SolutionTest {
    @Test
    public void abcdeReturnsZero() {
        assertEquals(0, CountingDuplicates.duplicateCount("abcde"));
    }

    @Test
    public void abcdeaReturnsOne() {
        assertEquals(1, CountingDuplicates.duplicateCount("abcdea"));
    }

    @Test
    public void indivisibilityReturnsOne() {
        assertEquals(1, CountingDuplicates.duplicateCount("indivisibility"));
    }
}
 class CountingDuplicates {
    public static int duplicateCount(String text) {
        // Write your code here
//        text = text.toLowerCase();
//        HashMap<Character, Integer> map = new HashMap<>();
//        int sum = 0;
//        for (int i = 0; i < text.length(); i++) {
//            char c = text.charAt(i);
//            if (i != text.lastIndexOf(c)){
//                if(!map.containsKey(c)){
//                    sum += 1;
//                    map.put(c, 1);
//                }
//            }
//        }
//        return sum;
        text = text.toLowerCase();
        int count = 0;
        while(text.length() > 0){
            String firstLetter = text.substring(0, 1);
            text = text.substring(1);
            if (text.contains(firstLetter)) count++;
            text = text.replace(firstLetter, "");
        }
        return count;
        //把剩下重复的都去掉
        //repaceAll 是匹配正则表达式，应用简单的replace方法,另外由于String的不可变性，需要将text再赋值
//            text.replaceAll(firstLetter, "");
    }
}
