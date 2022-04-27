import java.security.NoSuchAlgorithmException;
import java.util.*;

public class MerkleTree {
    public static Node makeTree(List<String> data) throws NoSuchAlgorithmException {
        List<Node> nodes = new ArrayList<>();
        for (String d : data) {
            nodes.add(new Node(null, null, HashAlgo.getHash(d)));
        }
        return makeMerkleTree(nodes);
    }

    private static Node makeMerkleTree(List<Node> nodes) throws NoSuchAlgorithmException {
        List<Node> innerNodes = new ArrayList<>();
        int i = 0;
        while (nodes.size() != 1 && i < 10) {
            i++;
            int idx = 0, len = nodes.size();
            while (idx < len) {
                Node leftChild = nodes.get(idx);
                Node rightChild = null;
                if ((idx + 1) < len) {
                    rightChild = nodes.get(idx + 1);
                }
                else {
                    // If there are odd number of leaf node, 
                    //then this we will insert closest leftmost node as extra node
                    rightChild = new Node(null, null, leftChild.getHash());
                }

                String innerNodeHash = HashAlgo.getHash(leftChild.getClass() + rightChild.getHash());
                innerNodes.add(new Node(leftChild, rightChild, innerNodeHash));
                idx += 2;
            }

            nodes = innerNodes;
            innerNodes = new ArrayList<>();

        }
        return nodes.get(0);
    }

    public static void printMerkleTree(Node root) {
        if (root == null) {
            return ;
        }

        List<Node> nodes = new ArrayList<>();
        nodes.add(root);

        while (nodes.size() != 0) {
            Node curNode = nodes.get(0);
            nodes.remove(0);
            print(curNode.getHash());
            if (curNode.getLeftNode() != null) {
                nodes.add(curNode.getLeftNode());
            } 
            if (curNode.getRightNode() != null) {
                nodes.add(curNode.getRightNode());
            }
        }
    }

    public static void print(String data) {
        System.out.println(data);
    }
}
