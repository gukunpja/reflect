package com.gxk.reflect;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

public class DbUtil {

	public static void main(String[] args) throws Exception {

		// ��ȡ�����ļ���Ϣ
		Properties properties = new Properties();
		Class db = DbUtil.class;
		InputStream inputStream = db.getResourceAsStream("/db.properties");
		properties.load(inputStream);
		// �������ļ�����Ϣͨ�����丳ֵ
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
