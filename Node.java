public class Node {
    private Node leftChild;
    private Node rightChild;
    private String hash;
    
    public Node(Node leftChild, Node rightChild, String hash) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.hash = hash;
    }

    // Setters
    public void setLeftNode(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setReftNode(Node rightChild) {
        this.rightChild = rightChild;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
 
    // Getters
    public Node getLeftNode() {
        return this.leftChild;
    }

    public Node getRightNode() {
        return this.rightChild;
    }

    public String getHash() {
        return this.hash;
    }
}
