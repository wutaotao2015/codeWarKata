/**
 * Created by wutaotao
 * 2018/1/23 19:48
 */

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * 假如不能引用map，应使用switch，case调用公共函数拼接数组实现。
 */
public class DnaStrandTest {
    @Test
    public void test01() {
        assertEquals("TTTT", DnaStrand.makeComplement("AAAA"));
    }
    @Test
    public void test02() {
        assertEquals("TAACG", DnaStrand.makeComplement("ATTGC"));
    }
    @Test
    public void test03() {
        assertEquals("CATA", DnaStrand.makeComplement("GTAT"));
    }
}

 class DnaStrand {
     public static String makeComplement(String dna) {
         //Your code
//        HashMap<Character, Character> map = new HashMap<>();
//        map.put('A', 'T');
//        map.put('T', 'A');
//        map.put('G', 'C');
//        map.put('C', 'G');
//        String result = "";
//        for (char c : dna.toCharArray()) {
//            result += map.get(c);
//        }
//         char[] chars = dna.toCharArray();
//         for (int i = 0; i < chars.length; i++) {
//             chars[i] = switchLetter(chars[i]);
//         }
//         return new String(chars);
         //以下解法巧妙利用了中间变量的思想
         dna = dna.replaceAll("A", "Z");
         dna = dna.replaceAll("T", "A");
         dna = dna.replaceAll("Z", "T");
         dna = dna.replaceAll("G", "Z");
         dna = dna.replaceAll("C", "G");
         dna = dna.replaceAll("Z", "C");
         return dna;
     }

     private static char switchLetter(char c) {

         switch (c) {
             case 'A':
                 return 'T';
             case 'T':
                 return 'A';
             case 'G':
                 return 'C';
             case 'C':
                 return 'G';
         }
         return c;
     }
 }
