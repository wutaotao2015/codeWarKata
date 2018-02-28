/**
 * Detect Pangram
 *
 * Created by wutaotao
 * 2018/1/28 08:33
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class PangramTest {
    @Test
    public void test1() {
        String pangram1 = "The quick brown fox jumps over the lazy dog.";
        PangramChecker pc = new PangramChecker();
        assertEquals(true, pc.check(pangram1));
    }
    @Test
    public void test2() {
        String pangram2 = "You shall not pass!";
        PangramChecker pc = new PangramChecker();
        assertEquals(false, pc.check(pangram2));
    }
}
 class PangramChecker {
    public boolean check(String sentence){
        //code
//        boolean flag = true;
//        for (int i = 97; i <= 122 ; i++) {
//            if (sentence.toLowerCase().indexOf((char)i) == -1) {
//                flag = false;
//                break;
//            }
//        }
//        return flag;
        for (char c = 'a'; c <= 'z'; c++) {
            if (!sentence.toLowerCase().contains(c + "")) return false;
        }
        return true;
    }

//     public static void main(String[] args) {
//         System.out.println((int)'a');//97
//         System.out.println((int)'z');// 122
//         System.out.println((char)97);
//     }
}
