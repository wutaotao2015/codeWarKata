package kata;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 用到Character.toUpperCase()会更方便
 * 2. 另外将第一个大写字母放到循环外会提高效率。
 * Created by wutaotao
 * 2018/1/22 19:52
 */
public class Accumul {

    //Accumul.accum("abcd");    // "A-Bb-Ccc-Dddd"
    //Accumul.accum("RqaEzty"); // "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
    //Accumul.accum("cwAt");    // "C-Ww-Aaa-Tttt"
    public static String accum(String s) {
        // your code
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(char c : s.toCharArray()){
            if (i > 0) sb.append('-');
            sb.append(Character.toUpperCase(c));
            for (int j =0;j<i;j++) sb.append(Character.toLowerCase(c));
            i++;
        }
        return sb.toString();


//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            for (int j = 0; j <= i; j++) {
//                String cString = c + "";
//                if (j == 0) {
//                    if(i != 0){
//                        sb.append("-");
//                    }
//                    sb.append(cString.toUpperCase());
//                } else {
//                    sb.append(cString.toLowerCase());
//                }
//            }
//        }
//        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(accum("RqaEzty"));
    }
}
