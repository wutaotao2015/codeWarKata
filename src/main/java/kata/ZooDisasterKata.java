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
        assertArrayEquals(expected, ZooDisaster.whoEatsWho(input));
    }

}

/**
 antelope eats grass
 big-fish eats little-fish
 bug eats leaves
 bear eats big-fish
 bear eats bug
 bear eats chicken
 bear eats cow
 bear eats leaves
 bear eats sheep
 chicken eats bug
 cow eats grass
 fox eats chicken
 fox eats sheep
 giraffe eats leaves
 lion eats antelope
 lion eats cow
 panda eats leaves
 sheep eats grass
 */
class ZooDisaster {

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
                    canEatExisted = false;
                }
            }
        }
        String[] strings = new String[zoo.length() - 1];
        return resultList.toArray(strings);
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
            tail = newNode;
        }
    }
    public void delete(Node curNode) {

        Node leftNode = curNode.left;
        Node rightNode = curNode.right;
        if (leftNode != null) {
            leftNode.right = rightNode;
        }
        if (rightNode != null) {
            rightNode.left = leftNode;
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





