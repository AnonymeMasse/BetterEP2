import interfaces.IBinarySearchTree;

public class ExampleBinarySearchTree implements IBinarySearchTree {
    private class Node {
        int key;
        int value;
        Node left;
        Node right;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int length;

    public ExampleBinarySearchTree() {
        this.root = null;
        this.length = 0;
    }


    public void put(int key, int value) {
        if (this.root == null) {
            this.root = new Node(key, value);
            this.length = 1;
            return;
        }
        Node parent = null;
        Node current = this.root;
        while (current != null && current.key != key) {
            parent = current;
            if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current != null) {
            current.value = value;
            return;
        }

        if (key < parent.key) {
            parent.left = new Node(key, value);
        } else {
            parent.right = new Node(key, value);
        }

        this.length += 1;
    }

    public Integer get(int key) {
        Node current = this.root;

        while (current != null && current.key != key) {
            if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current == null) {
            return null;
        }
        return current.value;
    }

    public boolean contains(int key) {
        return get(key) != null;
    }

    public Integer remove(int key) {
        Node parent = null;
        Node current = this.root;

        while (current != null && current.key != key) {
            parent = current;
            if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current == null) {
            return null;
        }

        if (parent == null) {
            this.root = null;
        } else if (parent.left == current) {
            parent.left = null;
        } else {
            parent.right = null;
        }
        putSubTreeBack(current.left);
        putSubTreeBack(current.right);
        this.length -= 1;

        return current.value;
    }

    private void putSubTreeBack(Node node) {
        if (node == null) {
            return;
        }
        Node parent = null;
        Node current = this.root;
        while (current != null) {
            parent = current;
            if (node.key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (parent == null) {
            this.root = node;
            return;
        }

        if (node.key < parent.key) {
            parent.left = node;
        } else {
            parent.right = node;
        }

    }

    public int length() {
        return this.length;
    }
}
