package com.sql.smms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class SmmsConnectFactory {

	static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static String dbURL = "jdbc:sqlserver://172.24.140.155:1433;DatabaseName=ecsp_MSCRM";
	static String userName = "sa";
	static String password = "i4$C#5.5";

	/**
	 * 数据库连接状态
	 * 
	 * @return
	 */
	public static boolean connectVaild() {
		try {
			Class.forName(driverName);
			System.out.println("驱动加载成功！");
			Connection dbConn = DriverManager.getConnection(dbURL, userName, password);
			System.out.println("数据库连接成功！");
			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("驱动加载失败！");
			return false;
		} catch (SQLException e) {
			System.out.println("数据库连接失败！");
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 获取数据库连接对象
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection dbConn = null;
		try {
			Class.forName(driverName);
			System.out.println("驱动加载成功！");
			dbConn = DriverManager.getConnection(dbURL, userName, password);
			System.out.println("数据库连接成功！");
			return dbConn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("驱动加载失败！");
			return null;
		} catch (SQLException e) {
			System.out.println("数据库连接失败！");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 根据Sql语句将结果显示
	 * 
	 * @param args
	 */
	public static List sqlResult(String sql) {
		Connection conn = getConnection();
		return null;
	}

	public static void main(String[] args) {
		connectVaild();

	}
}
