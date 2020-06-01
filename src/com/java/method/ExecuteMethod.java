package com.java.method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ExecuteMethod {

	/**
	 * 根据 classPath-MethodStr执行某个方法
	 * 
	 * @param classPath
	 * @param methodStr
	 */
	public static void executeMethod(String classPath, String methodStr) {
		Class clazz;
		try {
			clazz = Class.forName(classPath);
			Method method = clazz.getMethod(methodStr);
			method.invoke(null);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.out.println("未找到相关方法");
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}
}
