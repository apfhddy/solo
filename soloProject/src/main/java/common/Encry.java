package common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Encry {
	public static String getSalt() {
	      SecureRandom random = new SecureRandom();
	      byte[] salt = new byte[20];
	      random.nextBytes(salt);
	      StringBuffer sb = new StringBuffer();
	      for(byte b : salt) {
	         sb.append(String.format("%02x", b));
	      }
	      return sb.toString();
	   }
	   
	   public static String encry(String password, String salt) {
	      String result = null;
	      
	      try {
	         MessageDigest md = MessageDigest.getInstance("SHA-256");
	         md.update((password+salt).getBytes());
	         byte[] pwSalt = md.digest();
	         StringBuffer sb = new StringBuffer();
	         for(byte b : pwSalt) {
	            sb.append(String.format("%02x", b));
	         }
	         result = sb.toString();
	      }catch (NoSuchAlgorithmException e) {
	         e.printStackTrace();
	      }
	      
	      return result;
	   }
}
