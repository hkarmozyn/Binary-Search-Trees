public class Main {
    public static void main(String[] args) {
        BinarySearchTree<String, Integer> bst = new BinarySearchTree<String, Integer>();
        System.out.println("Size " + bst.size());
        System.out.println("Is Empty? "+bst.isEmpty());
        bst.put("A",1);
        bst.put("B",2);
        bst.put("C",3);
        bst.put("D",4);
        bst.put("E",5);
        bst.put("G",6);
        bst.put("H",7);
        bst.put("J",8);
        System.out.println("New Size " +bst.size());
        System.out.println("A:"+bst.get("A"));
        System.out.println("B:"+bst.get("B"));
        System.out.println("C:"+bst.get("C"));
        System.out.println("D:"+bst.get("D"));
        System.out.println("E:"+bst.get("E"));
        System.out.println("F:"+bst.get("G"));
        System.out.println("G:"+bst.get("H"));
        System.out.println("H:"+bst.get("J"));
        System.out.println("Min "+bst.min());
        System.out.println("Max "+bst.max());
        System.out.println(bst.toString());
        System.out.println( "Removed A "+bst.remove("A"));
        System.out.println( "Removed B "+bst.remove("B"));
        System.out.println( "Removed C "+bst.remove("C"));
        System.out.println(bst.toString());
        System.out.println("Does Contain:H "+bst.contains("H"));
        System.out.println("Does Contain:A "+bst.contains("A"));

    }
}