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

//        for (char[] triplet : triplets) {
//            System.out.println(Arrays.toString(triplet));
//        }
//        StringBuilder sb = new StringBuilder();
//        sb.append("ccc");
//        sb.insert(0,'a');
//        System.out.println(sb);

//        StringBuilder sb = new StringBuilder("abd, sd, 343s");
//        int i = sb.lastIndexOf(",");
//        System.out.println(i);
//        sb.replace(i, i + 1, " and");
//        System.out.println(sb);

        String str = new String("<H1>Chapter 1 - 介绍正则表达式</H1>");
        // * 默认是贪婪的
        String kk = str.replaceAll("<.*>", "kk");
        System.out.println(kk);
        // *? 是非贪婪的
        kk = str.replaceAll("<.*?>", "kk");
        System.out.println(kk);
        // 只匹配了<H1>, </H1>未匹配上
        kk = str.replaceAll("<\\w+?>", "kk");
        System.out.println(kk);

        String wtt = "wur, wer, wer, 234";
        // 前面的先贪婪？
        wtt = wtt.replaceAll("(.+), (.+)", "$1 and $2");
        System.out.println(wtt);


        System.out.println("hello");
    }
}
