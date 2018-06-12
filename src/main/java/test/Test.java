package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 2018/6/8 16:58 add by wutaotao
 */
public class Test {

    public static void main(String[] args) {

//        ArrayList<String> list = new ArrayList<>();
//        list.add("2");
//        list.add("1");
//        list.add("3");
//        String[] strings = new String[3];
//        String[] strings1 = list.toArray(strings);
//        for (String s : strings1) {
//            System.out.println(s);
//        }
//        System.out.println((int)'z');
//        System.out.println(Character.isLowerCase('*'));
//        System.out.println((char)97);
//        System.out.println(Math.max(1,1));
//        System.out.println("begin");
//        String s1 = "cdasgsaasdf";
//        String s1_char = s1.replaceAll("[^"+"a"+"]+","");
//        System.out.println(s1_char);
//        System.out.println("over");

        char[][] triplets = {
                {'t', 'u', 'p'},
                {'w', 'h', 'i'},
                {'t', 's', 'u'},
                {'a', 't', 's'},
                {'h', 'a', 'p'},
                {'t', 'i', 's'},
                {'w', 'h', 's'}
        };

        for (char[] triplet : triplets) {
            System.out.println(Arrays.toString(triplet));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ccc");
        sb.insert(0,'a');
        System.out.println(sb);
    }
}
