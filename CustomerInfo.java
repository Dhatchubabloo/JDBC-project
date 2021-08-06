package javaDatabaseDemo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class CustomerInfo {
	static HashMap<Integer, String> entry = null;

	public static  void customerdetails() throws SQLException {
		QueryHandler query = new QueryHandler();
		ResultSet result1 = query.customer();
		entry = new HashMap<>();
		while (result1.next()) {
			Integer id = result1.getInt("customer_id");
			String name = result1.getString("name");
			entry.put(id, name);
		}
		result1.close();
	}
	public static void showCutomerDetails(Integer value) {
		System.out.println("Name : "+entry.get(value));
	}
	public static boolean keyCompare(Integer customer_id) throws SQLException {
		HashMap<Integer, String> keymap = entry;
		Set keys = keymap.keySet();
		Iterator key = keys.iterator();
		int count = 0;
		while (key.hasNext()) {
			Integer comapare = (Integer) key.next();
			if (customer_id == comapare) {
				count++;
				break;
			}
		}
		if (count > 0)
			return true;
		else
			return false;
	}

}

