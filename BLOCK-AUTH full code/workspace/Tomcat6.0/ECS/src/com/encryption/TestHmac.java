package com.encryption;

public class TestHmac {
	public static void main(String[] args) {
		HMac hMac = new HMac();
		String ii=hMac.Sourcemac1("nitish", "pan card");
		System.out.println(ii);
	}

}
