package interfaces;

public interface IBinarySearchTree {
    void put(int key, int value);

    int get(int key);

    boolean contains(int key);

    int remove(int key);

    int length();
}