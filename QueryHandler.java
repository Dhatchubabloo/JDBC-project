package javaDatabaseDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryHandler {
	
	String url = "jdbc:mysql://localhost:3306/userdb";
	String username = "root";
	String password = "Root@123";
	Connection connection = null;
	
	public Connection settings() throws SQLException {
		if (connection == null);
		connection = DriverManager.getConnection(url,username,password);
		return connection;
	}
	public ResultSet customer(){
		QueryHandler handler = new QueryHandler();
		Connection custom_connection = null;
		ResultSet custom_rs = null;
		Statement stmt =null;
		try {
			custom_connection = handler.settings();
			stmt = custom_connection.createStatement();
			String sql1 = "select name,customer_id from customer_details";
			custom_rs = stmt.executeQuery(sql1);
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return custom_rs;
	}
	public ResultSet accounts() {
		QueryHandler handler = new QueryHandler();
		Connection account_connection=null;
		ResultSet account_rs = null;
		Statement stmt = null;
		try {
			account_connection = handler.settings();
			stmt = account_connection.createStatement();
			String sql1 = "select customer_id,account_no,salary from account_details";
			account_rs = stmt.executeQuery(sql1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account_rs;
	}
}
