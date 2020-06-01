package com.file.utils;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class OpenFileUtils {
	/**
	 * 根据指定目录打开文件或运行程序
	 * 
	 * @param filePath-文件目录
	 */
	public static void openFile() {
		String filePath = "C:\\Users\\ecclijw3\\Desktop\\新建文件夹\\text.txt";
		// 创建文件对象
		File file = new File(filePath);
		// 启动已经在电脑桌面上的关联文件
		try {
			Desktop.getDesktop().open(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
