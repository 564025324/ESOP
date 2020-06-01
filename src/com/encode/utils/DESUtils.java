package com.encode.utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.apache.commons.codec.binary.Base64;

public class DESUtils {

	// 密钥算法
	private static final String ALGORITHM = "DES";
	/**
	 * 加密/解密算法-工作模式-填充模式
	 */
	private static final String CIPHER_ALGORITHM = "DES/CBC/PKCS5Padding";

	private static final String encrypt_DATA = "L2w1K1YwRkFwOU5IOWc4aHBnTmJFUnB5OWkvc2xLR24=";
	/**
	 * 默认编码
	 */
	private static final String CHARSET = "utf-8";

	/**
	 * 生成Key
	 */
	public static Key generateKey(String password) {
		Key key = null;
		DESKeySpec dks = null;
		SecretKeyFactory keyFactory = null;
		try {
			dks = new DESKeySpec(password.getBytes(CHARSET));
			keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
			key = keyFactory.generateSecret(dks);
		} catch (InvalidKeyException | NoSuchAlgorithmException | UnsupportedEncodingException
				| InvalidKeySpecException e) {
			e.printStackTrace();
			System.out.println("生成Key出错");
		}
		return key;

	}

	/**
	 * DES解密字符串
	 * 
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 * @throws InvalidAlgorithmParameterException
	 * @throws InvalidKeyException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 */
	public static String DESDecrpty(String password, String ivParam, String data)
			throws NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException, InvalidKeyException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		Key secretKey = generateKey(password);
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		IvParameterSpec iv = new IvParameterSpec(ivParam.getBytes(CHARSET));
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

		Base64 base64 = new Base64();
		byte[] bytes = base64.decodeBase64(new String(data).getBytes());

		return new String(cipher.doFinal(bytes), CHARSET);
	}

	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		// 偏移变量，固定占8位字节
//        String iv = "54a6cc76";
		String iv = null;
		// 密码
//		String password = "54a6cc76-e700-a1b2-fa3d-fb966efb7578";
		String password = null;

		// 解密
		String decrypt = DESDecrpty(password, iv, encrypt_DATA);
		System.out.println(decrypt);
	}
}
