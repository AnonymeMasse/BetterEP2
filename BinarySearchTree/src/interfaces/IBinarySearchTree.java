package interfaces;

public interface IBinarySearchTree {
    /**
     * inserts key into the tree
     * @param key   key to be inserted
     */
    void put(int key);

    /**
     * checks if key is present in the tree
     * @param key   key to be looked for
     * @return      true if key is present in the tree and false if the key is not present
     */
    boolean contains(int key);

    /**
     * removes key from the tree
     * @param key   key which is to be removed
     * @return      either key or `null` if the key was not present in the tree
     */
    Integer remove(int key);

    /**
     * empties the tree
     */
    void clear();

    /**
     * finds the smallest key stored in the tree
     * @return  the smallest key stored in the tree or `null` if the tree is empty
     */
    Integer findMin();

    /**
     * finds the largest key stored in the tree
     * @return  the largest key stored in the tree or `null` if the tree is empty
     */
    Integer findMax();

    /**
     * removes the smallest key stored in the tree and returns it
     * @return  the smallest key stored in the tree or `null` if the tree is empty
     */
    Integer popMin();

    /**
     * remove the largest key stored in the tree and return it
     * @return  the largest key stored in the tree or `null` if the tree is empty
     */
    Integer popMax();

    /**
     * length of the tree (count of how many keys are stored in the tree)
     * @return  the number of keys stored in the tree
     */
    int length();
}