package javaDatabaseDemo;

import java.sql.*;
import java.util.ArrayList;

public class CustomerInsert {
	public void insertion() throws SQLException {
		QueryHandler handler = new QueryHandler();
		Connection custom_connection = null;
		PreparedStatement stmt1 =null;
		DatabaseMain input = new DatabaseMain();
		ArrayList<String> customerList = input.mainCustomerInput();
		try {
			custom_connection = handler.settings();
			String sql = "insert into customer_details(name,city)values(?,?)";
			stmt1 = custom_connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			int count = customerList.size()/2;
			for(int i=0;i<count;i++) {
				CustomerInput customerIn = new CustomerInput();
				customerIn.setName(customerList.get(i*2));
				customerIn.setCity(customerList.get((i*2)+1));
				stmt1.setString(1, customerIn.getName());
				stmt1.setString(2, customerIn.getCity());
				stmt1.executeUpdate();
				ResultSet rs = stmt1.getGeneratedKeys();rs.next();
				System.out.println("customer id : "+rs.getInt(1));
				}
		}catch(Exception e){
			System.out.println(e);
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
