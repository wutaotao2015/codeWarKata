package kata;

/**
 * 2018/6/12 10:34 add by wutaotao
 *
 * 这是一个拓扑排序问题！！！！
 * 我只认识到了这是一个排序问题，没想到拓扑，每个三元组就是2个优先级关系，
 * 找出优先级全部满足的组合即典型的拓扑排序调度问题
 */

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class SecretStringTriplets {

    private SecretDetective detective;

    @Before
    public void setup() {
        detective = new SecretDetective();
    }

    @Test
    public void secret1() {
        char[][] triplets = {
                {'t', 'u', 'p'},
                {'w', 'h', 'i'},
                {'t', 's', 'u'},
                {'a', 't', 's'},
                {'h', 'a', 'p'},
                {'t', 'i', 's'},
                {'w', 'h', 's'}
        };
        assertEquals("whatisup", detective.recoverSecret(triplets));
    }
}

class SecretDetective {

    public String recoverSecret(char[][] triplets) {

        // 待排序
        ArrayList<CharObj> charObjList = new ArrayList<>();
        // 已经出现的字符集合
        StringBuilder sb = new StringBuilder();
        for (char[] triplet : triplets) {
            for (int i = 0; i < 3; i++) {
                count(charObjList, sb, triplet, i, triplet[i]);
            }
        }
        Collections.sort(charObjList);
        StringBuilder res = new StringBuilder();
        for (CharObj charObj : charObjList) {
            res.append(charObj.getC());
        }
        return res.toString();
    }

    private void count(ArrayList<CharObj> charObjList, StringBuilder sb, char[] triplet, int i, char c) {
        // 从后向前 增加比该字符小的set集合
        if (sb.indexOf(c + "") == -1) {
            sb.append(c);
            CharObj charObj = new CharObj(c);
            for (int j = 1; j <= i; j++) {
                charObj.increase(triplet[i - j]);
            }
            charObjList.add(charObj);
        } else {
            int index = sb.indexOf(c + "");
            CharObj charObj = charObjList.get(index);
            for (int j = 1; j <= i; j++) {
                if (!charObj.getPreCharSet().contains(triplet[i - j])) {
                    charObj.increase(triplet[i - j]);
                }
            }
        }
        // 从前向后 循环增加每个包含了该字符的对象，增加比它大的对象
        for (int j = i + 1; j <= 2 ; j++) {
            increaseBigger(charObjList, c, triplet[j]);
        }
    }

    private void increaseBigger(ArrayList<CharObj> charObjList, char c, char afterChar) {
        for (CharObj biggerChar : charObjList) {
            Set<Character> preCharSet = biggerChar.getPreCharSet();
            if (preCharSet.contains(afterChar)) {
                biggerChar.increase(c);
            }
        }
    }

}

class CharObj implements Comparable<CharObj> {

    private char c;
    private Set<Character> preCharSet;

    public CharObj(char c) {
        this.c = c;
        preCharSet = new HashSet<>();
    }

    public void add(Character preChar) {
        this.preCharSet.add(preChar);
    }

    public void increase(char a) {
        this.preCharSet.add(a);
    }

    public char getC() {
        return c;
    }

    public Set<Character> getPreCharSet() {
        return preCharSet;
    }

    @Override
    public int compareTo(CharObj o) {
        if (this.preCharSet.size() < o.preCharSet.size()) {
            return -1;
        }
        return 1;
    }
}
//// This is a topological sort problem.
//// This is _not_ a particularly fast algorithm, and isn't general, but it's straightforward.
//public class Test {
//
//    // Convert the input format to the data structure I want to use
//    private static Map<Character, Set<Character>> buildEdgeMap(char[][] triplets) {
//        Map<Character, Set<Character>> map = new HashMap<>();
//        for(char[] cs : triplets) {
//            for (char c : cs) {
//                if (!map.containsKey(c)) map.put(c, new HashSet<>());
//            }
//            map.get(cs[0]).add(cs[1]);
//            map.get(cs[1]).add(cs[2]);
//        }
//        return map;
//    }
//
//    // Find a node with no outgoing edges
//    private static char findLast(Map<Character, Set<Character>> map) {
//        for(Map.Entry<Character, Set<Character>> entry : map.entrySet()) {
//            if (entry.getValue().isEmpty()) {
//                return entry.getKey();
//            }
//        }
//        throw new RuntimeException("No end point");
//    }
//
//    // Remove a node from the graph
//    private static void remove(Map<Character, Set<Character>> map, Character c) {
//        map.remove(c);
//        for(Set<Character> cs : map.values()) {
//            cs.remove(c);
//        }
//    }
//
//    // Reconstruct the string
//    public String recoverSecret(char[][] triplets) {
//        StringBuilder builder = new StringBuilder();
//        Map<Character, Set<Character>> map = buildEdgeMap(triplets);
//
//        while(!map.isEmpty()) {
//            char last = findLast(map);
//            builder.insert(0, last);
//            remove(map, last);
//        }
//
//        return builder.toString();
//    }
//}