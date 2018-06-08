package kata; /**
 * 2018/6/5 16:13 add by wutaotao
 */

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.assertArrayEquals;

public class ZooDisasterKata {

    @Test
    public void example() {
        final String input = "fox,bug,chicken,grass,sheep";
        final String[] expected = 	{
                "fox,bug,chicken,grass,sheep",
                "chicken eats bug",
                "fox eats chicken",
                "sheep eats grass",
                "fox eats sheep",
                "fox"};
        String[] strings = Dinglemouse.whoEatsWho(input);
        assertArrayEquals(expected, strings);
    }
    @Test
    public void example2() {
        final String input = "big-fish,giraffe,fox,cow,leaves,antelope,banana,banana,panda,giraffe,panda,leaves,chicken";
        final String[] expected = 	{
                "big-fish,giraffe,fox,cow,leaves,antelope,banana,banana,panda,giraffe,panda,leaves,chicken",
                "panda eats leaves",
                "big-fish,giraffe,fox,cow,leaves,antelope,banana,banana,panda,giraffe,panda,chicken"};
        String[] strings = Dinglemouse.whoEatsWho(input);
        assertArrayEquals(expected, strings);
    }
    @Test
    public void test3(){
        final String input = "antelope,lion";
        final String[] expected = 	{
                "antelope,lion",
                "lion eats antelope",
                "lion"};
        String[] strings = Dinglemouse.whoEatsWho(input);
        assertArrayEquals(expected, strings);
    }
/**
 * Random Test #1: ZOO = leaves,little-fish,chicken
 leaves,little-fish,chicken
 Random Test #2: ZOO = antelope,lion,giraffe,giraffe,bug,little-fish,grass
 lion eats antelope
 lion,giraffe,giraffe,bug,little-fish,grass
 */
}

class Dinglemouse {

    private static EatMap eatMap = new EatMap();
    static {
        eatMap.add("antelope", "grass");
        eatMap.add("big-fish", "little-fish");
        eatMap.add("bug", "leaves");
        eatMap.add("bear", "big-fish");
        eatMap.add("bear", "bug");
        eatMap.add("bear", "chicken");
        eatMap.add("bear", "cow");
        eatMap.add("bear", "leaves");
        eatMap.add("bear", "sheep");
        eatMap.add("chicken", "bug");
        eatMap.add("cow", "grass");
        eatMap.add("fox", "chicken");
        eatMap.add("fox", "sheep");
        eatMap.add("giraffe", "leaves");
        eatMap.add("lion", "antelope");
        eatMap.add("lion", "cow");
        eatMap.add("panda", "leaves");
        eatMap.add("sheep", "grass");
    }

    public static String[] whoEatsWho(final String zoo) {
        // Your code here
        String[] animals = zoo.split(",");
        AnimalChain animalChain = new AnimalChain();
        for (String animal : animals) {
            animalChain.add(animal);
        }

        ArrayList<String> resultList = new ArrayList<>();
        resultList.add(zoo);

        boolean canEatExisted = true;
        while(canEatExisted) {

            List<AnimalChain.Node> list = animalChain.traverse();
            for (int i = 0; i < list.size(); i++) {

                AnimalChain.Node node = list.get(i);
                AnimalChain.Node leftAnimalNode = node.left;
                AnimalChain.Node rightAnimalNode = node.right;
                if (eat(animalChain, resultList, node, leftAnimalNode)) break;
                if (eat(animalChain, resultList, node, rightAnimalNode)) break;
                if (i == list.size() - 1) {
                    StringBuilder sb = new StringBuilder();
                    for (AnimalChain.Node amNode : animalChain.traverse()) {
                        sb.append(amNode.item + ",");
                    }
                    String s = sb.toString();
                    resultList.add(s.substring(0, s.length() - 1));
                    canEatExisted = false;
                }
            }
        }
        String[] strings = new String[resultList.size()];
        String[] res = resultList.toArray(strings);
        return res;
    }

    private static boolean eat(AnimalChain animalChain, ArrayList<String> resultList, AnimalChain.Node node, AnimalChain.Node sideNode) {
        if (sideNode != null) {
            boolean canEatLeft = eatMap.canEatOrNot(node.item, sideNode.item);
            if (canEatLeft) {
                String eatThing = node.item + " eats " + sideNode.item;
                resultList.add(eatThing);
                animalChain.delete(sideNode);
                return true;
            }
        }
        return false;
    }

}
class AnimalChain {

     class Node{
        Node left;
        Node right;
        String item;

        public Node(Node left, Node right, String item) {
            this.left = left;
            this.right = right;
            this.item = item;
        }
    }
    private Node head;
    private Node tail;

    public void add(String animal) {

        if (head == null) {
            head = new Node(null, null, animal);
            tail = head;
        }else{
            Node newNode = new Node(tail, null, animal);
            tail.right = newNode;
            tail = newNode;
        }
    }
    public void delete(Node curNode) {

        if (curNode == head) {
            head = curNode.right;
            head.left = null;
        }else if(curNode == tail) {
            tail = curNode.left;
            tail.right = null;
        }else{
            Node leftNode = curNode.left;
            Node rightNode = curNode.right;
            if (leftNode != null) {
                leftNode.right = rightNode;
            }
            if (rightNode != null) {
                rightNode.left = leftNode;
            }
        }
    }
    public List<Node> traverse() {
        List<Node> nodeList = new ArrayList<>();
        Node cur = this.head;
        while(cur != null) {
            nodeList.add(cur);
            cur = cur.right;
        }
        return nodeList;
    }
}
class EatMap {

    private Map<String, Set<String>> eatMap = new HashMap<>();

    public void add(String leftAnimal, String rightAnimal) {

        if (eatMap.containsKey(leftAnimal)) {
            Set<String> set = eatMap.get(leftAnimal);
            set.add(rightAnimal);
        }else{
            Set<String> set = new HashSet<>();
            set.add(rightAnimal);
            eatMap.put(leftAnimal,set);
        }
    }
    public boolean canEatOrNot(String leftAnimal, String rightAnimal) {

        if (!eatMap.containsKey(leftAnimal)) return false;
        Set<String> canEatSet = eatMap.get(leftAnimal);
        if (canEatSet.contains(rightAnimal)) {
            return true;
        }else{
            return false;
        }
    }
}

/**
 * 直接对animal用list装，在while循环中控制下标的移动即可
 *
 * public class Dinglemouse {

 private static Map<String, List<String>> whoEats = new HashMap<>();

 private static void initWhoEats() {
 whoEats.put("antelope", Arrays.asList("grass"));
 whoEats.put("big-fish", Arrays.asList("little-fish"));
 whoEats.put("bug", Arrays.asList("leaves"));
 whoEats.put("bear", Arrays.asList("big-fish", "bug", "chicken", "cow", "leaves", "sheep"));
 whoEats.put("chicken", Arrays.asList("bug"));
 whoEats.put("cow", Arrays.asList("grass"));
 whoEats.put("fox", Arrays.asList("chicken", "sheep"));
 whoEats.put("giraffe", Arrays.asList("leaves"));
 whoEats.put("lion", Arrays.asList("antelope", "cow"));
 whoEats.put("panda", Arrays.asList("leaves"));
 whoEats.put("sheep", Arrays.asList("grass"));
 }

 public static String[] whoEatsWho(final String zoo) {
 initWhoEats();
 List<String> result = new ArrayList<>();
 result.add(zoo);
 List<String> animals = new ArrayList<>(Arrays.asList(zoo.split(",")));

 int i = 0;
 while (i < animals.size()) {
 if (i != 0)
 if (canEat(animals.get(i), animals.get(i - 1))) {
 result.add(animals.get(i) + " eats " + animals.get(i - 1));
 animals.remove(i - 1);
 i = 0;
 continue;
 }

 if (i < animals.size() - 1)
 if (canEat(animals.get(i), animals.get(i + 1))) {
 result.add(animals.get(i) + " eats " + animals.get(i + 1));
 animals.remove(i + 1);
 i = 0;
 continue;
 }

 i++;
 }

 result.add(String.join(",", animals));
 return result.toArray(new String[result.size()]);
 }

 private static boolean canEat(String animal, String animal1) {
 if (whoEats.containsKey(animal))
 if (whoEats.get(animal).indexOf(animal1) != -1)
 return true;
 return false;
 }

 }
 */





