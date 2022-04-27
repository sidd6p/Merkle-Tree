import java.security.NoSuchAlgorithmException;
import java.util.*;

public class App {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // Data to add at leaf of the Merkle Tree
        List<String> data = Arrays.asList("Si", "Gurur", "Java", "VIT");

        // Making Merkle Tree from the data
        Node merkleTreeRoot = MerkleTree.makeTree(data);

        // Print Merkle Tree in BFS fashion (left to right)
        MerkleTree.printMerkleTree(merkleTreeRoot);
    }
}