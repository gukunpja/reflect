package com.gxk.reflect;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

public class DbUtil {

	public static void main(String[] args) throws Exception {

		// 读取配置文件信息
		Properties properties = new Properties();
		Class db = DbUtil.class;
		InputStream inputStream = db.getResourceAsStream("/db.properties");
		properties.load(inputStream);
		// 将配置文件的信息通过反射赋值
		Class jdbc = JdbcUtil.class;
		JdbcUtil ut = new JdbcUtil();
		Field url = jdbc.getDeclaredField("url");
		Field user = jdbc.getDeclaredField("user");
		Field pwd = jdbc.getDeclaredField("pwd");
		url.set(ut, properties.getProperty("url"));
		user.set(ut, properties.getProperty("userName"));
		pwd.set(ut, properties.getProperty("passWord"));
		ut.conDb();

	}
}
