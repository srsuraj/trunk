package com.hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/company_tracker?useSSL=false&serverTimeZone=UTC";
		String user = "company";
		String pass = "company";
		try {
			System.out.println("connecting to database..." + jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection successful!!!");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
