import interfaces.IBinarySearchTree;

public class BinarySearchTree implements IBinarySearchTree {
    // NOTE: this Node class can be altered or moved to fit your needs!
    /**
     * Nested class for the Node as a Node without a Linked List is sorta wrong
     * for more information about nested classes see:
     * https://www.w3schools.com/java/java_inner_classes.asp
     * https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
     *
     * About if you should use nested classes see:
     * https://stackoverflow.com/questions/1028850/are-inner-classes-commonly-used-in-java-are-they-bad
     */
    private static class Node {
        public int key;
        public Node left;
        public Node right;

        public Node(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }
    /**
     * inserts key into the tree
     *
     * @param key key to be inserted
     */
    @Override
    public void put(int key) {

    }

    /**
     * checks if key is present in the tree
     *
     * @param key key to be looked for
     * @return true if key is present in the tree and false if the key is not present
     */
    @Override
    public boolean contains(int key) {
        return false;
    }

    /**
     * removes key from the tree
     *
     * @param key key which is to be removed
     * @return either key or `null` if the key was not present in the tree
     */
    @Override
    public Integer remove(int key) {
        return 0;
    }

    /**
     * empties the tree
     */
    @Override
    public void clear() {

    }

    /**
     * finds the smallest key stored in the tree
     *
     * @return the smallest key stored in the tree or `null` if the tree is empty
     */
    @Override
    public Integer findMin() {
        return 0;
    }

    /**
     * finds the largest key stored in the tree
     *
     * @return the largest key stored in the tree or `null` if the tree is empty
     */
    @Override
    public Integer findMax() {
        return 0;
    }

    /**
     * removes the smallest key stored in the tree and returns it
     *
     * @return the smallest key stored in the tree or `null` if the tree is empty
     */
    @Override
    public Integer popMin() {
        return 0;
    }

    /**
     * remove the largest key stored in the tree and return it
     *
     * @return the largest key stored in the tree or `null` if the tree is empty
     */
    @Override
    public Integer popMax() {
        return 0;
    }

    /**
     * length of the tree (count of how many keys are stored in the tree)
     *
     * @return the number of keys stored in the tree
     */
    @Override
    public int length() {
        return 0;
    }
}