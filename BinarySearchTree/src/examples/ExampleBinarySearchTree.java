package examples;

import interfaces.IBinarySearchTree;

public class ExampleBinarySearchTree implements IBinarySearchTree {
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

    private Node root;

    /**
     * construct an empty tree
     */
    public ExampleBinarySearchTree() {
        this.root = null;
    }

    /**
     * inserts key into the tree
     *
     * @param key key to be inserted
     */
    @Override
    public void put(int key) {
        if (this.root == null) {
            this.root = new Node(key);
            return;
        }
        put(this.root, key);
    }

    // NOTE: in contrast to ExampleLinkedListRecursive we will now use method overloading
    //       to simplyfy the names of the methods

    /**
     * recursively inserts key somewhere under current
     * @param current   current root node of subtree
     * @param key       key to be inserted
     */
    private void put(Node current, int key) {
        if (current.key == key) {
            return;
        }
        if (key < current.key) {
            if (current.left == null) {
                current.left = new Node(key);
                return;
            }
            put(current.left, key);
        } else {
            if (current.right == null) {
                current.right = new Node(key);
                return;
            }
            put(current.right, key);
        }
    }

    /**
     * checks if key is present in the tree
     *
     * @param key key to be looked for
     * @return true if key is present in the tree and false if the key is not present
     */
    @Override
    public boolean contains(int key) {
        return contains(this.root, key);
    }

    // note: we are using method overloading

    /**
     * recursively checks if the current subtree contains key
     * @param current   root of current subtree
     * @param key       key to be looked for
     * @return          true if the key is present or false if it is not present
     */
    private boolean contains(Node current, int key) {
        if (current == null) {
            return false;
        }

        if (key < current.key) {
            return contains(current.left, key);
        }

        if (key > current.key) {
            return contains(current.right, key);
        }

        // if we reach here we know: current.key == key
        return true;
    }

    /**
     * DFS the subtree wit root node and call put on every key
     * Helper Method for remove & popMin & popMax -> puts every child of a removed node back into the tree
     * @param node
     */
    private void reputNodes(Node node) {
        if (node == null) {
            return;
        }
        put(node.key);
        reputNodes(node.left);
        reputNodes(node.right);
    }

    /**
     * removes key from the tree
     *
     * @param key key which is to be removed
     * @return either key or `null` if the key was not present in the tree
     */
    @Override
    public Integer remove(int key) {
        return remove(null, this.root, key);
    }

    // note: we are using method overloading

    /**
     * remove key from current subtree
     * this works be recursively searching until current.key == key then setting parent.left / parent.right to null
     * and reputting the child nodes of current into the tree
     * @param parent    parent node of current
     * @param current   current root of subtree
     * @param key       key of the node which is to be removed
     * @return          either key or `null` if the key is not present
     */
    private Integer remove(Node parent, Node current, int key) {
        // we didn't find key in tree
        if (current == null) {
            return null;
        }

        // we found key
        if (current.key == key) {
            if (parent == null) {
                // current is root
                this.root = null;
            } else {
                // current is not root
                if (parent.left == current) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
            // reput every child node of current into the tree
            reputNodes(current.left);
            reputNodes(current.right);
            return current.key;
        }

        // search further for key
        if (key < current.key) {
            return remove(current, current.left, key);
        } else {
            return remove(current, current.right, key);
        }
    }

    /**
     * empties the tree
     */
    @Override
    public void clear() {
        this.root = null;
    }

    /**
     * finds the smallest key stored in the tree
     *
     * @return the smallest key stored in the tree or `null` if the tree is empty
     */
    @Override
    public Integer findMin() {
        // check if the tree is empty, now we don't need to check in the helper method
        if (this.root == null) {
            return null;
        }

        // actually find min
        return findMin(this.root);
    }

    // note: we are using method overloading

    /**
     * recursively find the minimum child of current
     * @param current   current subtree
     * @return          the minimum key stored in the current subtree
     */
    private Integer findMin(Node current) {
        // if current node doesn't have a left child we have found our mininum
        if (current.left == null) {
            return current.key;
        }
        // otherwise we search further to the left
        return findMin(current.left);
    }

    /**
     * finds the largest key stored in the tree
     *
     * @return the largest key stored in the tree or `null` if the tree is empty
     */
    @Override
    public Integer findMax() {
        // check if the tree is empty, now we don't need to check in the helper method
        if (this.root == null) {
            return null;
        }
        return findMax(this.root);
    }

    /**
     * recursively find the maximum in the current subtree
     * @param current   current root of the subtree
     * @return          maximum of current subtree
     */
    private Integer findMax(Node current) {
        // if current node doesn't have a right child we have found our maximum
        if (current.right == null) {
            return current.key;
        }
        // otherwise we look further to the right
        return findMax(current.right);
    }

    /**
     * removes the smallest key stored in the tree and returns it
     *
     * @return the smallest key stored in the tree or `null` if the tree is empty
     */
    @Override
    public Integer popMin() {
        // if the tree is empty there is no minimum
        if (this.root == null) {
            return null;
        }

        // otherwise we find the minimum and remove it
        int min = findMin();
        return remove(min);
    }

    /**
     * remove the largest key stored in the tree and return it
     *
     * @return the largest key stored in the tree or `null` if the tree is empty
     */
    @Override
    public Integer popMax() {
        // if the tree is empty there is no maximum
        if (this.root == null) {
            return null;
        }

        // otherwise we find the maximum and remove it
        int max = findMax();
        return remove(max);
    }

    /**
     * length of the tree (count of how many keys are stored in the tree)
     *
     * @return the number of keys stored in the tree
     */
    @Override
    public int length() {
        return length(this.root);
    }

    // note: we are using method overloading

    /**
     * recursively count how many nodes are present in the tree
     * @param current
     * @return
     */
    private int length(Node current) {
        // if the current node is null the current subtree has a length of 0
        if (current == null) {
            return 0;
        }

        // get the length of the left subtree
        int left = length(current.left);

        // get the length of the right subtree
        int right = length(current.right);

        // the length of this subtree is the sum of the left and the right + 1 for the current node
        return 1 + left + right;
    }
}
