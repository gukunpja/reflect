package com.gxk.reflect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {

	String url;
	String user;
	String pwd;

	public void conDb() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, user, pwd);
		System.out.println(conn);
	}
}
