import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class CaesarTwoTest {

    @Test
    public void test1() {
        String u = "I should have known that you would have a perfect answer for me!!!";
        List<String> v = Arrays.asList("ijJ tipvme ibw", "f lopxo uibu z", "pv xpvme ibwf ", "b qfsgfdu botx", "fs gps nf!!!");
        assertEquals(v, CaesarTwo.encodeStr(u, 1));
    }

    @Test
    public void test2() {
        String u = "O CAPTAIN! my Captain! our fearful trip is done;";
        List<String> v = Arrays.asList("opP DBQUBJ", "O! nz Dbqu", "bjo! pvs g", "fbsgvm usj", "q jt epof;");
        assertEquals(v, CaesarTwo.encodeStr(u, 1));
    }
    @Test
    public void test3() {
        String u = "O CAPTAIN! my Captain! our fearful trip is done;";
        List<String> v = Arrays.asList("opP DBQUBJ", "O! nz Dbqu", "bjo! pvs g", "fbsgvm usj", "q jt epof;");
        assertEquals(u, CaesarTwo.decode(v));
    }

    @Test
    public void test4() {
        String u = "...allen cold and dead.[ ]";
        List<String> v = Arrays.asList(".....b", "mmfo d", "pme bo", "e efbe", ".[ ]");
        assertEquals(v, CaesarTwo.encodeStr(u, 1));
    }

}

class CaesarTwo {

    public static List<String> encodeStr(String s, int shift) {
        // your code
        char firstLetter = Character.toLowerCase(s.charAt(0));
        char secondLetter = rotate(firstLetter, shift);
        s = firstLetter + "" + secondLetter + s;
        int length = s.length();
        int fourLength = 0, lastLength = 0;
        if (length % 5 == 0) {
            fourLength = length / 5;
            lastLength = fourLength;
        } else {
            int tmp = length / 5;
            while ((length - tmp) % 4 != 0 && tmp != 0) {
                tmp--;
            }
            if (tmp == 0) {
                fourLength = length / 4;
                lastLength = 0;
            } else {
                fourLength = (length - tmp) / 4;
                lastLength = tmp;
            }
        }
        ArrayList<String> resultList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            StringBuffer sb = new StringBuffer();
            if (i == 0) {
                sb.append(firstLetter).append(secondLetter);
                String tobeCodedString = s.substring(2, fourLength);
                for (char c : tobeCodedString.toCharArray()) {
                    sb.append(rotate(c, shift));
                }
            } else if (i != 4) {
                String tobeCodedString = s.substring(i * fourLength, i * fourLength + fourLength);
                for (char c : tobeCodedString.toCharArray()) {
                    sb.append(rotate(c, shift));
                }
            } else {
                if (lastLength == 0) break;
                String tobeCodedString = s.substring(i * fourLength, i * fourLength + lastLength);
                for (char c : tobeCodedString.toCharArray()) {
                    sb.append(rotate(c, shift));
                }
            }
            resultList.add(sb.toString());
        }
        return resultList;
    }

    private static char rotate(char c, int shift) {

        if (c >= 'a' && c <= 'z') {

            if (c + shift > 'z') {
                return (char) (c + shift - 'z' + 'a' - 1);
            } else if (c + shift < 'a') {
                return (char) (c + shift + 'z' - 'a' + 1);
            } else {
                return (char) (c + shift);
            }

        } else if (c >= 'A' && c <= 'Z') {

            if (c + shift > 'Z') {
                return (char) (c + shift - 'Z' + 'A' - 1);
            } else if (c + shift < 'A') {
                return (char) (c + shift + 'Z' - 'A' + 1);
            } else {
                return (char) (c + shift);
            }
        } else {
            return c;
        }
    }

    public static String decode(List<String> s) {
        // your code
        StringBuffer sb = new StringBuffer();
        for (String s1 : s) {
            sb.append(s1);
        }
        String stringToBeDecoded = sb.toString();
        char prefix0 = stringToBeDecoded.charAt(0);
        char prefix1 = stringToBeDecoded.charAt(1);
        int shift = prefix1 - prefix0;
        if (shift < 0) {
            if (Character.isLowerCase(prefix1)) {
                shift = prefix1 - 'a' + 'z' - prefix0 + 1;
            } else {
                shift = prefix1 - 'A' + 'Z' - prefix0 + 1;
            }
        }
        stringToBeDecoded = stringToBeDecoded.substring(2,stringToBeDecoded.length());
        StringBuffer res = new StringBuffer();
        for (char c : stringToBeDecoded.toCharArray()) {
            res.append(rotate(c,-shift));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(rotate(' ', 2));
        System.out.println((int) 'z');
        System.out.println((int) 'Z');
        System.out.println(68 / 5);
        System.out.println(Math.floor(68 / 5));
        System.out.println('b' - 'a' + 'z' - 'x' + 1);
        int i = 8;
        System.out.println(-i);
//        char c = 'a';
//        int shift = -2;
//        if (c + shift < 'a') {
//            System.out.println((char) ('z' - 'a' + (c + shift) + 1));
//        }
        String str = "absfdg";
        String res = str.chars()
                .mapToObj(c -> (char) c)
                .map(c -> String.valueOf(Character.toUpperCase(c))).collect(Collectors.joining());

    }
}
