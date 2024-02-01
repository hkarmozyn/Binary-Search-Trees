/*
HK
2/8/24
CZ
 */
public class Main {
    // Main method - entry point of the application
    public static void main(String[] args) {
        // Create an instance of BinarySearchTree for storing String keys and Integer values
        BinarySearchTree<String, Integer> bst = new BinarySearchTree<String, Integer>();

        // Print the initial size of the BST (expected to be 0)
        System.out.println("Size " + bst.size());

        // Print whether the BST is empty or not (expected to be true)
        System.out.println("Is Empty? " + bst.isEmpty());

        // Insert key-value pairs into the BST
        bst.put("A", 1);
        bst.put("B", 2);
        bst.put("C", 3);
        bst.put("D", 4);
        bst.put("E", 5);
        bst.put("G", 6); // Note: Skipping "F" to demonstrate non-continuous alphabet sequence
        bst.put("H", 7);
        bst.put("J", 8); // Note: Skipping "I" as well

        // Print the new size of the BST after insertions (expected to be 8)
        System.out.println("New Size " + bst.size());

        // Retrieve and print the values associated with each key
        System.out.println("A:" + bst.get("A"));
        System.out.println("B:" + bst.get("B"));
        System.out.println("C:" + bst.get("C"));
        System.out.println("D:" + bst.get("D"));
        System.out.println("E:" + bst.get("E"));
        System.out.println("G:" + bst.get("G"));
        System.out.println("H:" + bst.get("H"));
        System.out.println("J:" + bst.get("J"));

        // Print the minimum and maximum keys in the BST
        System.out.println("Min " + bst.min());
        System.out.println("Max " + bst.max());

        // Print the entire BST structure or contents (implementation dependent)
        System.out.println(bst.toString());

        // Remove certain keys from the BST and print the removed value
        System.out.println("Removed A " + bst.remove("A"));
        System.out.println("Removed B " + bst.remove("B"));
        System.out.println("Removed C " + bst.remove("C"));

        // Print the BST structure or contents after removals
        System.out.println(bst.toString());

        // Check and print whether certain keys are still present in the BST
        System.out.println("Does Contain:H " + bst.contains("H"));
        System.out.println("Does Contain:A " + bst.contains("A")); // This should print false since "A" was removed
    }
}
