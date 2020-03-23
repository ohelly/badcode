package ru.liga.intership.badcode.service;

import java.sql.*;

public class ConnectWithDataBaseAndQuery {
	private final Statement statement;

	public ConnectWithDataBaseAndQuery(String url, String user, String password) throws SQLException {
		Connection conn = DriverManager.getConnection(url, user, password);
		statement = conn.createStatement();
	}

	public ResultSet queryIntoDataBase(String sql) throws SQLException {
		return statement.executeQuery(sql);
	}
}
