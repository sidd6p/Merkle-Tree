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

        while (nodes.size() != 1) {
            int idx = 0, len = nodes.size();
            while (idx < len) {
                Node leftChild = nodes.get(idx);
                Node rightChild = null;
                if ((idx + 1) < len) {
                    rightChild = nodes.get(idx + 1);
                }
                else {
                    rightChild = new Node(null, null, leftChild.getHash());
                }

                String innerNodeHash = HashAlgo.getHash(leftChild.getClass() + rightChild.getHash());
                innerNodes.add(new Node(leftChild, rightChild, innerNodeHash));
                idx += 2;
            }

            nodes = innerNodes;
            innerNodes.clear();

        }
        return nodes.get(0);
    }

    public static void printMerkleTree(Node root) {
        if (root == null) {
            return ;
        }

        if (root.getLeftNode() == null && root.getRightNode() == null) {
            print(root.getHash());
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
