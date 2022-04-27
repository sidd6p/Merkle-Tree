// A Java program to find the SHA-256 hash value  

import java.security.NoSuchAlgorithmException;  
import java.math.BigInteger;  
import java.security.MessageDigest;  
import java.nio.charset.StandardCharsets;  
  
public class HashAlgo {  
    public static byte[] obtainSHA(String s) throws NoSuchAlgorithmException  {  
        MessageDigest msgDgst = MessageDigest.getInstance("SHA-256");  
        return msgDgst.digest(s.getBytes(StandardCharsets.UTF_8));  
    }  
    
    public static String getHash(String data) throws NoSuchAlgorithmException {  
        byte[] hash = obtainSHA(data);
        BigInteger no = new BigInteger(1, hash);  
        StringBuilder hexStr = new StringBuilder(no.toString(16));  
        while (hexStr.length() < 32) {  
            hexStr.insert(0, '0');  
        }  
        return hexStr.toString();  
    }    
}  