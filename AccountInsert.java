package javaDatabaseDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountInsert {
	public void insersion() throws SQLException {
		QueryHandler handler = new QueryHandler();
		Connection account_connection = null;
		PreparedStatement stmt1=null;
		DatabaseMain input = new DatabaseMain();
		ArrayList <Integer>accountList = input.mainAccountInput();
		try {
			account_connection = handler.settings();
			String sql = "insert into account_details(account_no,customer_id,salary)values(?,?,?)";
			stmt1 = account_connection.prepareStatement(sql);
			System.out.println();
			System.out.println("Account details:");
			Account accountInput = new Account();
			int count = accountList.size()/3;
			for(int i=0;i<count;i++) {
				accountInput.setCustomer_id(accountList.get((i*3)+0));
				accountInput.setAccount_no(accountList.get((i*3)+1));
				accountInput.setSalary(accountList.get((i*3)+2));
				stmt1.setInt(1, accountInput.getAccount_no());
				stmt1.setInt(2, accountInput.getCustomer_id());
				stmt1.setInt(3, accountInput.getSalary());
				stmt1.executeUpdate();
			}
		}catch(Exception e) {
			
		}
		finally {
			try {
				stmt1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
