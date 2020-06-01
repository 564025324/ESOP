package com.find.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import com.java.method.ExecuteMethod;

public class ReadUtils {
	private static String Find_Str = "OBF2020032900027";
	private static String File_Dir = "C:\\Users\\ecclijw3\\Desktop\\新建文件夹\\";

	
	
	/**
	 * 获取指定路径下的所有文件数组
	 * 
	 * @param dir
	 * @return
	 */
	private static String[] getFileListByDir(String dir) {
		String[] fileList = new File(dir).list();
		return fileList;
	}

	/**
	 * 从指定文件中检索文本内容
	 * 
	 * @param content-被查询字符串
	 * @param file-指定文件
	 * @return Map<String，String> 结果集
	 */

	private static Map<String, String> searchFileContent(String content, File file) {
		Map<String, String> map = null;
		FileReader read;
		try {
			read = new FileReader(file);
			BufferedReader br = new BufferedReader(read);
			String line = "";
			while ((line = br.readLine()) != null) {
				if (line.toUpperCase().contains(Find_Str.toUpperCase())) {
					System.out.println("文件：" + file);
					System.out.println("--------");
					System.out.println("行信息：" + line);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return map;
	}

	/**
	 * 根据查询文本到指定文件目录下查询
	 */
	public static void searchFileContextByFindStr(String file_dir, String find_str) {
		System.out.println("----     程序执行开始           ------");
		int fileNo = 0;
		for (String filename : getFileListByDir(file_dir)) {
			fileNo++;
			File file = new File(file_dir + filename);
			searchFileContent(Find_Str, file);
		}
		System.out.println("----     程序执行结束           ------");
	}

	/**
	 * 校验文件目录的有效性
	 * 
	 * @return
	 */
	public static boolean fileConnectTest(String filePath) {
		String[] fileList = new File(filePath).list();
		int i = 1;
		for (String fileName : fileList) {
			System.out.println("【" + (i++) + "】文件名称：" + fileName.toString());
		}
		return true;
	}

	/**
	 * 每 X 分钟执行一次
	 */
	public static void runFrequencyByTime(long period) {
		Calendar calendar = Calendar.getInstance();
		Date firstTime = calendar.getTime();
		// 间隔时间：2分钟
		// long
		period = 1000 * 5 * 1;
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				System.out.println("执行时间：" + new Date().toLocaleString());

			}
		}, firstTime, period);
	}

	/**
	 * 每 @period 时间频率执行一次 @Method 方法
	 * 
	 * @period = 间隔时间
	 */
	public static void runMethodByFrequency(long period,String clazzPath, String methodStr) {
		Calendar calendar = Calendar.getInstance();
		Date firstTime = calendar.getTime();
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("执行时间：" + new Date().toLocaleString());
				// 执行一次 @method 方法
				ExecuteMethod e = new ExecuteMethod();
				e.executeMethod(clazzPath, methodStr);
			}
		}, firstTime, period);
	}

	/**
	 * main method
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// searchFileContextByFindStr(File_Dir,Find_Str);

		// String filePath = "\\\\ecc-ecsapp1P\\c$\\infospace\\datafile\\input";
		// fileConnectTest(filePath);F

		//runFrequencyByTime(1000 * 5 * 1);
		runMethodByFrequency(1000 * 5 * 1,"com.file.utils.OpenFileUtils","openFile");

	}
}
