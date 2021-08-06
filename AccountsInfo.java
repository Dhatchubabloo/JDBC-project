package javaDatabaseDemo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Set;

public class AccountsInfo {
	public static void accountdetails() throws SQLException {
		HashMap<Integer,HashMap<Integer,Account>> outer = new HashMap();
		QueryHandler query  = new QueryHandler();
		ResultSet result2 = query.accounts(); 
			while(result2.next()) {
				Integer customer_id = result2.getInt("customer_id");
				Integer account_no = result2.getInt("account_no");
				Integer salary = result2.getInt("salary");
				Account accounts = new Account();
				accounts.setCustomer_id(customer_id);
				accounts.setAccount_no(account_no);
				accounts.setSalary(salary);
				HashMap<Integer,Account>inner  = outer.getOrDefault(customer_id,new HashMap<>());
				inner.put(account_no,accounts);
				outer.put(customer_id, inner);
			}
		result2.close();
			DatabaseMain main = new DatabaseMain();
			Integer outer_key = main.getMainCustomerId();
			CustomerInfo.showCutomerDetails(outer_key);
			if(outer.containsKey(outer_key)){
				HashMap<Integer,Account> inner = outer.get(outer_key);
				Set<Integer> res = inner.keySet();
				System.out.println("____________________________________________________________");
				for(Integer num : res){
					System.out.println(" customer id:"+inner.get(num).getCustomer_id()+"|"+" account number:"+inner.get(num).getAccount_no()+"|"+" salary:"+inner.get(num).getSalary());
					System.out.println("____________________________________________________________");
				}
			}
			else
				System.out.println("OOPS!........invalid customer id");
		}
}
