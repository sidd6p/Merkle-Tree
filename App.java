import java.security.NoSuchAlgorithmException;
import java.util.*;

public class App {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        List<String> data = Arrays.asList("Siddhartha", "Gurur", "Java", "VIT");
        Node merkleTreeRoot = MerkleTree.makeTree(data);
        MerkleTree.printMerkleTree(merkleTreeRoot);
    }
}
