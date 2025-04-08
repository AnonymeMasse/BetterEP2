import interfaces.IBinarySearchTreeTest;

public class BinarySearchTreeTest implements IBinarySearchTreeTest {
    @Override
    public BinarySearchTree createBinarySearchTree() {
        return new BinarySearchTree();
    }
}
