package cyh.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class SHAUtil {
	public static final String KEY_SHA="SHA";
	public static String getEncrypted(String str){
		BigInteger sha=null;
		System.out.println(str);
		byte[] inputData = str.getBytes();
		try {
		       MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA); 
		       messageDigest.update(inputData);
		       sha = new BigInteger(messageDigest.digest()); 
		       System.out.println("SHA加密后:" + sha.toString()); 
		    } catch (Exception e) {e.printStackTrace();}
	return sha.toString();
	}
	public static void main(String [] args){
		getEncrypted("dfafer3343fe");
	}
}
