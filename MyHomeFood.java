package xyz;
import java.sql.*;
import java.lang.*;
import java.util.*;
public class MyHomeFood {
	/*MyHomeFood(){
		try{
		String url = "jdbc:mysql://localhost:3306/hotel";
		String uname = "root";
		String pass = "sharath@75";
		Connection connection=DriverManager.getConnection(url,uname,pass);
		 PreparedStatement preparedStatement = connection.prepareStatement("create database hotel");
		 preparedStatement.executeUpdate();
		}
		catch(Exception e) {
			//System.out.println("hi");
		}
		}
	*/
	
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		user obj = new user();
		businesss obj2 = new businesss();

		int ch = 1;
		do {
			System.out.print("Select (1. User Login, 2. Buisiness): ");
			Scanner scanner = new Scanner(System.in);
			int option;
			option = scanner.nextInt();
			switch(option) {
				case 1: {
					obj.order();
				} break;
				case 2: {
					obj2.manage();
				} break;
			}
			System.out.print("If you want to run the program again press 1: ");
			ch = scanner.nextInt();
		} while(ch == 1);
		System.out.println("\n--------------------------------------------------");
		System.out.println("\t\tThanks for visiting.");
	}
}



