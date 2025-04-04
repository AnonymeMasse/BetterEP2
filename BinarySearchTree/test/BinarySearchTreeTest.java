import interfaces.IBinarySearchTreeTest;

public class BinarySearchTreeTest implements IBinarySearchTreeTest<BinarySearchTree> {
    @Override
    public BinarySearchTree createBinarySearchTree() {
        return new BinarySearchTree();
    }
}
