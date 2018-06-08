package kata; /**
 * Moves in squared strings (I)
 *
 * Created by wutaotao
 * 2018/1/28 14:45
 */
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OpstringsTest {

    private static void testing(String actual, String expected) {
        assertEquals(expected, actual);
    }
    @Test
    public void test() {
        System.out.println("Fixed Tests vertMirror");
        String s = "hSgdHQ\nHnDMao\nClNNxX\niRvxxH\nbqTVvA\nwvSyRu";
        String r = "QHdgSh\noaMDnH\nXxNNlC\nHxxvRi\nAvVTqb\nuRySvw";
        testing(Opstrings.oper(Opstrings::vertMirror, s), r);
        s = "IzOTWE\nkkbeCM\nWuzZxM\nvDddJw\njiJyHF\nPVHfSx";
        r = "EWTOzI\nMCebkk\nMxZzuW\nwJddDv\nFHyJij\nxSfHVP";
        testing(Opstrings.oper(Opstrings::vertMirror, s), r);

        System.out.println("Fixed Tests horMirror");
        s = "lVHt\nJVhv\nCSbg\nyeCt";
        r = "yeCt\nCSbg\nJVhv\nlVHt";
        testing(Opstrings.oper(Opstrings::horMirror, s), r);
        s = "njMK\ndbrZ\nLPKo\ncEYz";
        r = "cEYz\nLPKo\ndbrZ\nnjMK";
        testing(Opstrings.oper(Opstrings::horMirror, s), r);
    }
}
class Opstrings {

//    public static String vertMirror (String strng) {
////         your code
//        String result = "";
//        int length = strng.indexOf('\n');
//        for (int i = 0; i < length; i++) {
//            for (int j = length; j > 0; j--) {
//                result += strng.charAt(j - 1 + i * (length + 1));
//            }
//            if (i != length - 1){
//                result += '\n';
//            }
//        }
//        return result;
//    }
//    public static String horMirror (String strng) {
//        // your code
//        String result = "";
//        String[] splitStrings = strng.split("\n");
//        int length = splitStrings.length;
//        for (int i = 0; i < length; i++) {
//            result += splitStrings[length - 1 - i];
//            if (i != length - 1){
//                result += '\n';
//            }
//        }
//        return result;
//    }
    public static String vertMirror (String strng) {

        return splitString(strng).stream().map(e -> reverse(e)).collect(Collectors.joining("\n"));
    }
    public static String horMirror (String strng) {
        return reverse(splitString(strng)).stream().collect(Collectors.joining("\n"));
    }
    private static List<String> splitString(String str) {
        return Arrays.asList(str.split("\n"));
    }
    private static String reverse(String string){
        return new StringBuilder(string).reverse().toString();
    }
    private static List<String> reverse(List<String> list) {
        Collections.reverse(list);
        return list;
    }
    public static String oper(Function<String, String> operator, String s) {
        // your code and complete ... before operator
        return operator.apply(s);
    }
}
