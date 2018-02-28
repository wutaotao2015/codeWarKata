import java.util.HashMap;

/**
 * 1. 大小写都一样，应该对输入值进行处理，统一小写化
 * 2. 循环一次，按位取出每位的字符，然后根据字符利用indexOf和lastIndexOf方法进行比较索引，从而得到是否有重复的结论
 * Created by wutaotao
 * 2018/1/22 20:50
 */
public class DuplicateEncoder {
    static String encode(String word) {

//        HashMap<Character, Integer> map = new HashMap<>();
//        char[] chars = word.toCharArray();
//        for (char c : chars) {
//            char low = Character.toLowerCase(c);
//            if (!map.containsKey(low)) {
//                map.put(low, 0);
//            } else {
//                map.put(low, 1);
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        for (char c : chars) {
//            char low = Character.toLowerCase(c);
//            if (map.get(low) == 0) {
//                sb.append('(');
//            } else {
//                sb.append(')');
//            }
//        }
        word = word.toLowerCase();
        String result = "";
        //这里是++i，是因为第一次取0已经取过了
        for (int i = 0; i < word.length(); ++i){
            char c = word.charAt(i);
            result += word.indexOf(c) == word.lastIndexOf(c) ? '(' : ')';
        }
        return result;
    }

    public static void main(String[] args) {

        //"din" => "((("
        //"recede" => "()()()"
        //"Success" => ")())())"
        //"(( @" => "))(("
        System.out.println(encode("din"));
        System.out.println(encode("recede"));
        System.out.println(encode("Success"));
        System.out.println(encode("(( @"));
    }
}


