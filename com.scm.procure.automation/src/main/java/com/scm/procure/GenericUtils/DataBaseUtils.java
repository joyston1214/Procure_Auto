package com.scm.procure.GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtils {
	Connection con = null;

	public void connectDB() throws SQLException {
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");

	}

	public String executeAndGetData(int colData, String ExpData, String query) throws SQLException {
		Statement state = con.createStatement();
		ResultSet res = state.executeQuery(query);
		boolean flag = false;
		while (res.next()) {
			String actual = res.getString(colData);

			if (actual.equalsIgnoreCase(ExpData)) {
				flag = true;
				break;
			}

		}
		if (flag) {
			System.out.println("project created successfully");
			return ExpData;
		}

		else {
			System.out.println("project is not created");
			return "";
		}

	}

	public void disconnect() throws SQLException {
		con.close();
	}

}
