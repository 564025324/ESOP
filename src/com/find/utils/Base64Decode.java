package com.find.utils;

import java.lang.reflect.Method;

/**
 * base64解密
 */
public class Base64Decode {
	public static void main(String[] args) {
		Class clazz = null;
		Method mainMethod = null;
		try {
			clazz = Class.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");
		} catch (ClassNotFoundException e1) {
			System.out.println("找不到类");
			e1.printStackTrace();
		}
		try {
			mainMethod = clazz.getMethod("encode", byte[].class);
		} catch (NoSuchMethodException | SecurityException e) {
			System.out.println("找不到Method");
			e.printStackTrace();
		}
		System.out.println(mainMethod);

	}
}