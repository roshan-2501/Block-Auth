package com.encryption;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class DiffieHellman {
	BigInteger c, c1, c2;
	static BigInteger p;
	String textBack;
	static Random sc = new SecureRandom();
	BigInteger EC, EC1, EC2;
	BigInteger brmodp, brmodp1, brmodp2;
	String constr = "";
	String levl = "good";
	String finhash = new String();

	String keyinfo;

	public static String createKey(String username) throws Exception {

		BigInteger secretKey = new BigInteger("1");
		BigInteger g = new BigInteger("2");
		Random r = new Random();
		p = BigInteger.probablePrime(150, sc);
		BigInteger a = new BigInteger(p.bitCount() - 1, r);
		String result = a.toString();
		BigInteger resulta = g.modPow(a, p);
		BigInteger b = new BigInteger(p.bitCount() - 1, r);
		String result1 = b.toString();
		BigInteger resultb = g.modPow(b, p);
		BigInteger KeyACalculates = resultb.modPow(a, p);
		BigInteger KeyBCalculates = resulta.modPow(b, p);
		// System.out.println("-------------"+KeyBCalculates);
		secretKey = KeyACalculates;
		String result2 = secretKey.toString();
		// System.out.println("key size is----"+result.length());
		// System.out.println("key size is----"+result1.length());
		// System.out.println("key size is----"+result2.length());
		return result2;
	}

	public void conStr(String forms) {
		constr = forms;
	}

	public String policyKey(String username) throws Exception {

		BigInteger secretKey = new BigInteger("1");
		BigInteger g = new BigInteger("2");
		Random r = new Random();
		p = BigInteger.probablePrime(150, sc);
		BigInteger a = new BigInteger(p.bitCount() - 1, r);
		String result = a.toString();
		BigInteger resulta = g.modPow(a, p);
		BigInteger b = new BigInteger(p.bitCount() - 1, r);
		String result1 = b.toString();
		BigInteger resultb = g.modPow(b, p);
		BigInteger KeyACalculates = resultb.modPow(a, p);
		BigInteger KeyBCalculates = resulta.modPow(b, p);
		// System.out.println("-------------"+KeyBCalculates);
		secretKey = KeyACalculates;
		String result2 = secretKey.toString();
		// System.out.println("key size is----"+result.length());
		// System.out.println("key size is----"+result1.length());
		// System.out.println("key size is----"+result2.length());
		elg1(a, b, secretKey);
		keyinfo = result + "&" + result1 + "&" + result2 + "&" + finhash;
		return keyinfo;

	}

	public void elg1(BigInteger b, BigInteger secretKey, BigInteger p)
			throws Exception {
		c1 = b.modPow(secretKey, p);
		BigInteger X = new BigInteger(constr.getBytes());
		BigInteger r = new BigInteger(64, sc);
		EC1 = X.multiply(c1.modPow(r, p)).mod(p);
		brmodp1 = b.modPow(r, p);
		calc1();
	}

	public void calc1() throws Exception {
		BigInteger X = new BigInteger(levl.getBytes());
		String hashC = X.toString(2);
		String hashb = brmodp1.toString(2);
		int len1 = hashC.length();
		int len2 = hashb.length();
		int b1 = 5, j = 1;
		if (len1 > len2) {
			int min = len1 - len2;
			for (int i = 0; i < min; i++) {
				hashb = "0" + hashb;
			}
		} else if (len2 > len1) {
			int min = len2 - len1;
			for (int i = 0; i < min; i++) {
				if (j <= b1) {
					hashC = hashC + "1";
				} else {
					j = 0;
					hashC = hashC + "0";
				}
				j++;
			}
		}
		for (int i = 0; i < hashC.length(); i++) {
			finhash = finhash
					+ String.valueOf(hashC.charAt(i) ^ hashb.charAt(i)).trim();
		}
		// System.out.println("----"+finhash1.length());
		System.out.println("Result Enc----------" + finhash);
	}
	public static void main(String []args) throws Exception{
		System.out.println(DiffieHellman.createKey("RSA Enc"));
		System.out.println(DiffieHellman.createKey("RSA Dec"));
	}
}
