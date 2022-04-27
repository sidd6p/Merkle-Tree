// A Java program to find the SHA-256 hash value  

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashAlgo {

   public static String getHash(final String input) throws NoSuchAlgorithmException {

      String hashtext = null;
      MessageDigest md = MessageDigest.getInstance("MD5");

      // Compute message digest of the input
      byte[] messageDigest = md.digest(input.getBytes());

      hashtext = convertToHex(messageDigest);

      return hashtext;
   }

   private static String convertToHex(final byte[] messageDigest) {
      BigInteger bigint = new BigInteger(1, messageDigest);
      String hexText = bigint.toString(16);
      while (hexText.length() < 32) {
         hexText = "0".concat(hexText);
      }
      return hexText;
   }
}