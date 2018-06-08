package test;

import java.util.ArrayList;

/**
 * 2018/6/8 16:58 add by wutaotao
 */
public class Test {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("2");
        list.add("1");
        list.add("3");
        String[] strings = new String[3];
        String[] strings1 = list.toArray(strings);
        for (String s : strings1) {
            System.out.println(s);
        }
        System.out.println("over");
    }
}
