package examples;

import interfaces.IBinarySearchTreeTest;

public class ExampleBinarySearchTreeTest implements IBinarySearchTreeTest {
    @Override
    public ExampleBinarySearchTree createBinarySearchTree() {
        return new ExampleBinarySearchTree();
    }
}
