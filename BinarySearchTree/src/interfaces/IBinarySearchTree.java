package interfaces;

public interface IBinarySearchTree {
    void put(int key, int value);

    Integer get(int key);

    boolean contains(int key);

    Integer remove(int key);

    int length();
}