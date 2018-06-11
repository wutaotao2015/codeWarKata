package kata;

/**
 * 2018/6/11 11:04 add by wutaotao
 */

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class StringsMix {

    @Test
    public void test() {
        System.out.println("Mix Fixed Tests");
        assertEquals("2:eeeee/2:yy/=:hh/=:rr", Mixing.mix("Are they here", "yes, they are here"));
        assertEquals("1:ooo/1:uuu/2:sss/=:nnn/1:ii/2:aa/2:dd/2:ee/=:gg",
                Mixing.mix("looping is fun but dangerous", "less dangerous than coding"));
        assertEquals("1:aaa/1:nnn/1:gg/2:ee/2:ff/2:ii/2:oo/2:rr/2:ss/2:tt",
                Mixing.mix(" In many languages", " there's a pair of functions"));
        assertEquals("1:ee/1:ll/1:oo", Mixing.mix("Lords of the Fallen", "gamekult"));
        assertEquals("", Mixing.mix("codewars", "codewars"));
        assertEquals("1:nnnnn/1:ooooo/1:tttt/1:eee/1:gg/1:ii/1:mm/=:rr",
                Mixing.mix("A generation must confront the looming ", "codewarrs"));
    }

}

class Mixing {

    public static String mix(String s1, String s2) {
        // your code
        Node[] lettersArray = new Node[26];
        for (int i = 0; i < 26; i++) {
            lettersArray[i] = new Node((char) (i + 97), 0, 0);
        }
        increaseCharLength(s1, lettersArray, 1);
        increaseCharLength(s2, lettersArray, 2);
        for (int i = 0; i < 26; i++) {
            lettersArray[i].setMax();
        }
        Arrays.sort(lettersArray);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < lettersArray.length; i++) {

            Node node = lettersArray[i];
            if (node.getMaxlength() > 1) {
                res.append(node.getStr() + ":");
                for (int j = 0; j < node.getMaxlength(); j++) {
                    res.append(node.getLetter());
                }
                res.append("/");
            }
        }
        if (res.length() == 0) return "";
        return res.substring(0, res.length() - 1).toString();
    }

    private static void increaseCharLength(String s, Node[] lettersArray, int flag) {
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lettersArray[c - 97].increaseCharLength(flag);
            }
        }
    }

    static class Node implements Comparable<Node> {

        private char letter; //单个小写字符
        private int charLength1; // 1的长度
        private int charLength2; // 2的长度
        private int maxlength;
        private char str;

        public Node(char letter, int charLength1, int charLength2) {
            this.letter = letter;
            this.charLength1 = charLength1;
            this.charLength2 = charLength2;
        }

        public char getLetter() {
            return letter;
        }

        public char getStr() {
            return str;
        }

        public int getMaxlength() {
            return maxlength;
        }

        public void increaseCharLength(int flag) {
            if (flag == 1) {
                this.charLength1++;
            } else {
                this.charLength2++;
            }
        }

        public void setMax() {
            if (this.charLength1 > this.charLength2) {
                this.maxlength = this.charLength1;
                this.str = '1';
            } else if (this.charLength1 < this.charLength2) {
                this.maxlength = this.charLength2;
                this.str = '2';
            } else {
                this.maxlength = this.charLength1;
                this.str = '=';
            }
        }

        /**
         * 排序规则
         * 1. 长度长的在前面
         * 2. 长度一样，1在前面，其次2，最后是= 这里用Character.compare方法比较这3者
         * 3. 前缀相同，按字母升序排列
         *
         * @param o
         * @return
         */
        @Override
        public int compareTo(Node o) {
            if (this.maxlength < o.maxlength) {
                return 1;
            }
            if (this.maxlength > o.maxlength) {
                return -1;
            }
            if (Character.compare(this.str, o.str) < 0) {
                return -1;
            }
            if (Character.compare(this.str, o.str) > 0) {
                return 1;
            }
            //字母升序
            if (this.letter < o.letter) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
// public static String mix(String s1, String s2) {
//
//        List<String> finalStr = new ArrayList();
//
//        for (char c = 'a'; c <= 'z'; c++) {
//            String s1_char = s1.replaceAll("[^"+c+"]+","");
//            String s2_char = s2.replaceAll("[^"+c+"]+","");
//
//            int s1_length = s1_char.length();
//            int s2_length = s2_char.length();
//
//            if(s1_length>1 || s2_length>1){
//                if(s1_length == s2_length){
//                    finalStr.add("=:"+s1_char);
//                }
//                if(s1_length>s2_length){
//                    finalStr.add("1:"+s1_char);
//                }
//                if(s1_length<s2_length){
//                    finalStr.add("2:"+s2_char);
//                }
//            }
//        }
//        Comparator<String> length = (x,y) -> y.length()-x.length();
//        Comparator<String> type_value = (x,y) -> Character.compare(x.charAt(0),y.charAt(0));
//
//        return finalStr.stream().sorted(length.thenComparing(type_value)).collect(Collectors.joining("/"));
//    }
