/*
 * Class HashSHA1
 * 
 * Chứa các phương thức hash chuỗi đầu vào thành mã sha1
 */
package com.runsystem.datnt.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashSHA1 {
	/*
	 * Hash chuỗi plaintext thành mã sha1
	 * 
	 * @param plaintext chuỗi input 
	 * @return chuỗi sha1 
	 */
	public static String hashSHA1(String plaintext) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return toString(md.digest(plaintext.getBytes()));
	}
	
	/*
	 * convert mã byte sang string
	 * 
	 * @param b       dãy byte
	 * @return result chuỗi convert
	 */
	private static String toString(byte[] b) {
		String result = "";
		for (int i = 0; i < b.length; i++) {
			result += Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
		}
		return result;
	}
}
