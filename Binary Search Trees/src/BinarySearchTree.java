/*
HK
2/8/24
CZ
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    public Node<Key, Value> root;
    // Constructor for an empty BST
    public BinarySearchTree() {
    }

    // Public method to get the size of the BST
    public int size() {
        return size(root);
    }

    // Private helper to calculate size recursively
    private int size(Node x) {
        if (x == null) {
            return 0; // Base case: empty tree has size 0
        } else {
            return 1 + size(x.getLeft()) + size(x.getRight()); // Count current node + left + right
        }
    }

    // Check if the tree is empty
    public boolean isEmpty() {
        return root == null;
    }

    // Public method to insert a key-value pair
    public void put(Key key, Value value) {
        root = put(root, key, value); // Insert recursively starting from the root
    }

    // Recursive helper for inserting a new node
    private Node<Key, Value> put(Node<Key, Value> n, Key key, Value val) {
        if (n == null) {
            return new Node<>(key, val, 1); // Create new node if empty spot found
        }
        int cmp = key.compareTo(n.getKey());
        if (cmp < 0) n.setLeft(put(n.getLeft(), key, val)); // Go left if key is smaller
        else if (cmp > 0) n.setRight(put(n.getRight(), key, val)); // Go right if key is larger
        return n;
    }

    // Public method to retrieve a value by key
    public Value get(Key key) {
        return get(root, key); // Start search from root
    }

    // Recursive helper for retrieval
    private Value get(Node<Key, Value> n, Key key) {
        if (n == null) return null; // Base case: key not found
        int cmp = key.compareTo(n.getKey());
        if (cmp == 0) return n.getValue(); // Key found
        else if (cmp < 0) return get(n.getLeft(), key); // Search left subtree
        else return get(n.getRight(), key); // Search right subtree
    }

    // Check if a key exists in the BST
    public boolean contains(Key key) {
        return get(key) != null;
    }

    // Public method to remove a node by key
    public Value remove(Key key) {
        Value v = get(key); // Get value before removing
        root = remove(root, key); // Remove recursively starting from root
        return v; // Return removed value
    }

    // Recursive helper for removal
    private Node remove(Node<Key, Value> n, Key key) {
        if (n == null) return null; // Base case: key not found
        int cmp = key.compareTo(n.getKey());
        if (cmp < 0) n.setLeft(remove(n.getLeft(), key)); // Go left if key is smaller
        else if (cmp > 0) n.setRight(remove(n.getRight(), key)); // Go right if key is larger
        else {
            // Case when node to remove is found
            if (n.getRight() == null) return n.getLeft(); // Node has only left child
            if (n.getLeft() == null) return n.getRight(); // Node has only right child
            // Node has two children: find successor, replace current node with successor
            Node<Key, Value> temp = n;
            n = min(temp.getRight()); // Successor is min of right subtree
            n.setRight(remove(temp.getRight(), n.getKey())); // Delete successor
            n.setLeft(temp.getLeft());
        }
        n.setSize(size(n.getLeft()) + size(n.getRight()) + 1); // Update size
        return n;
    }

    // Public method to find the minimum key
    public Key min() {
        return min(root).getKey(); // Start from root
    }

    // Helper to find the node with minimum key recursively
    private Node<Key, Value> min(Node<Key, Value> n) {
        if (n == null) return null; // Base case
        while (n.getLeft() != null) n = n.getLeft(); // Go to the leftmost node
        return n;
    }

    // Public method to find the maximum key
    public Key max() {
        return max(root).getKey(); // Start from root
    }

    // Helper to find the node with maximum key
    private Node<Key, Value> max(Node<Key, Value> n) {
        if (n == null) return null; // Base case
        while (n.getRight() != null) n = n.getRight(); // Go to the rightmost node
        return n;
    }

    // Override toString for tree
    public String toString() {
        String temp = toString(root);
        temp = temp.substring(0, temp.length() - 2);
        return "{" + temp + "}";
    }
    private String toString(Node<Key, Value> n) {
        if (n == null) return "";
        return toString(n.getLeft()) +
                n.getKey() + "=" + n.getValue() + ", " +
                toString(n.getRight());

    }
}