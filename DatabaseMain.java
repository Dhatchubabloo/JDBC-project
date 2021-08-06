package javaDatabaseDemo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class DatabaseMain {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) throws SQLException {
		execution();
	}

	private static void execution() throws SQLException {
		System.out.println("1.Enroll & Check both customer details and account details");
		System.out.println("2.Enroll & Check account details");
		System.out.println("3.Check account details");
		System.out.println("4.Exit");
		System.out.println("Enter your choice");
		int choice = scan.nextInt();
		switch (choice) {

			case 1:

				CustomerInsert customerToken = new CustomerInsert();
				customerToken.insertion();
				CustomerInfo.customerdetails();
				AccountInsert accountToken = new AccountInsert();
				accountToken.insersion();
				execution();
				break;

			case 2:
				CustomerInfo.customerdetails();
				AccountInsert accountToken1 = new AccountInsert();
				accountToken1.insersion();
				execution();
				break;

			case 3:

				CustomerInfo.customerdetails();
				AccountsInfo.accountdetails();
				execution();
				break;

			case 4:
				QueryHandler qh = new QueryHandler();
				Connection conn = qh.settings();
				conn.close();
				if (conn.isClosed())
					System.out.println("your Connection was closed........!");
				break;

			default:
				System.out.println("ERROR!.........Enter valid choice");
		}


	}

	public ArrayList mainCustomerInput() throws SQLException {
		ArrayList <String>customerList = new ArrayList();
		System.out.println("Enter number of customers do you want to enroll");
		int count = scan.nextInt();
		scan.nextLine();
		for (int i = 1; i <= count; i++) {
			System.out.println("customer details for customer" + i);
			System.out.println("Enter Name");
			String name = scan.nextLine();
			customerList.add(name);
			System.out.println("Enter City");
			String city = scan.next();
			customerList.add(city);
			scan.nextLine();
		}
		return customerList;
	}
	public ArrayList mainAccountInput() throws SQLException {
		ArrayList<Integer> accountList = new ArrayList<>();
		System.out.println("Enter number of accounts do you want to enroll");
		int count = scan.nextInt();
		scan.nextLine();
		for(int i=1;i<=count;i++) {
			System.out.println("Account details for customer"+i);
			System.out.println("Enter Customer id");
			int customer_id = scan.nextInt();
			boolean result = CustomerInfo.keyCompare(customer_id);
			if(result) {
				accountList.add(customer_id);
				System.out.println("Enter Account number");
				int account_no = scan.nextInt();
				accountList.add(account_no);
				System.out.println("Enter Salary");
				int salary = scan.nextInt();
				accountList.add(salary);
			}
			else{
				System.out.println("Invalid customer id!...");
				mainAccountInput();
			}
		}
		return accountList;
	}
	public int getMainCustomerId() {
		System.out.println();
		System.out.println("Enter valid customer id to check account details:");
		int id = scan.nextInt();
		return id;
	}
}

