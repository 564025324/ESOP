package com.encode.utils;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class Base64JDK {

	private static final String DATA = "EPNJ709Y_004";
	private static final String encrypt_DATA = "L2w1K1YwRkFwOU5IOWc4aHBnTmJFUnB5OWkvc2xLR24=";

	public static void main(String[] args) {
		Base64JDK b = new Base64JDK();
		b.Base64Decode();
		b.Base64Encrypt();
	}

	/**
	 * base64加密
	 * 
	 * @return
	 */
	private String Base64Encrypt() {
		Encoder encode = Base64.getEncoder();
		byte[] data = encode.encode(DATA.getBytes());
		System.out.println("Base64加密：" + new String(data));
		return new String(data);
	}

	private String Base64Decode() {
		Decoder decoder = Base64.getDecoder();
		byte[] bytes = decoder.decode(encrypt_DATA);
		System.out.println("BASE64解密：" + new String(bytes));
		return new String(bytes);
	}
}
