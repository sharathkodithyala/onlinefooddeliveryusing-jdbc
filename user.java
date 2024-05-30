package xyz;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

class user extends requirement {
	int opt;

	public void order() throws Exception {
		Connection connection =DriverManager.getConnection(url, uname, pass);

		System.out.println("\n---------------------------------------");
		System.out.println("\t\tUser Login.");
		System.out.println("-----------------------------------------");

		System.out.print("\nSelect (1. Create account, 2. Account Login): ");
		int userOption = scanner.nextInt();

		switch(userOption) {
			case 1: {
				try {
				System.out.print("\nEnter your username: ");
				String username = scanner.next();

				System.out.print("Enter your number: ");
				int phoneNumber = scanner.nextInt();
				
				System.out.print("Enter your password: ");
				String password = scanner.next();

				System.out.print("Enter confirm password: ");
				String confirmation = scanner.next();

				if(!(password.equals(confirmation))) {
					System.err.print("\nERROR: The confirmation password was not the same as the password.");
				}

				PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO userdetail(username, pass, mobile) VALUES (?, ?, ?)");
				preparedStatement.setString(1, username);
				preparedStatement.setString(2, password);
				preparedStatement.setInt(3, phoneNumber);
				
				preparedStatement.executeUpdate();

				preparedStatement.close();
				connection.close();

				//System.out.println("INFO: Account created Successfully");
			}
				catch(Exception e1) {
					System.out.println("error while running case 1");
				}
			}break;
			case 2:{
				System.out.print("\nEnter username: ");
				String username = scanner.next();
				
				System.out.print("Enter password");
				String password = scanner.next();
				String que="select username,pass from userdetail";
				int allow=0;
				Statement state=connection.createStatement();
				state.executeQuery(que);
				ResultSet result= state.executeQuery(que);
				while(result.next()) {
					String uname=result.getString("username");
					String pasword=result.getString("pass");
					if(uname.equals(username)) {
					if(pasword.equals(password)) {
						allow=1;
						System.out.println("program runnig succusfully");
					}
					}
				}
				if(allow==1) { 
				do{
					System.out.print("\nSelect (1. Display Hotels, 2. Select Hotel): ");
					int choose=scanner.nextInt();

					switch(choose){
					case 1:{
						String query1 ="select * from hotels";
						
						
						Statement stt=connection.createStatement();
						stt.executeQuery(query1);
						ResultSet rss=stt.executeQuery(query1);
						
						while(rss.next()){
							String name=rss.getString("hotelname");
							String ssno=rss.getString("sno");
							System.out.println(ssno+" "+name);
						}
					} break;
					case 2: {
						System.out.print("\nEnter the hotel name: ");
						String hotelname = scanner.next();
	
						String query1 = "select * from " + hotelname;
						Statement stt=connection.createStatement();
						stt.executeQuery(query1);
						ResultSet rss=stt.executeQuery(query1);
	
						while(rss.next()){
							String name = rss.getString("itemname");
							String ssno = rss.getString("itemno");
							String pr = rss.getString("price");
							System.out.println(ssno + " " + name + " " + pr);
						}
	
						//System.out.println("Items available in the selected hotel: ");
						// TODO: List the available items in the selected hotel
						System.out.print("\nEnter the item id: ");
						int itemId = scanner.nextInt();
						String query2 = "select price from driven where itemno=" + itemId;
						Connection con2 = DriverManager.getConnection(url, uname, pass);
	
						Statement st2 = con2.createStatement();
						st2.executeQuery(query2);
						ResultSet rs2 = st2.executeQuery(query2);
						while(rs2.next()){
							//String name=rs2.getString("itemname");
							//String ssno=rs2.getString("itemno");
							float pr = rs2.getFloat("price");
							System.out.println("The amount to be paid =" + pr);
							payment obj =new payment();
							obj.paymentMethod();
						}
					} break;
				}
				System.out.print("\n\nTo reselect hotel press 1: ");
				opt = scanner.nextInt();
				} while(opt==1);
				}
			} break;
		}
	}
}


