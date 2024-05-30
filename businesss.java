package xyz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class businesss extends requirement {
	businesss(){
		Connection conn;
		try {
			conn = DriverManager.getConnection(url,uname,pass);
		 PreparedStatement preparedStatement;
	
			preparedStatement = conn.prepareStatement("create table hotels(sno int primary key,hotelname varchar(20)))");
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

    public void manage() throws Exception {
    	try {
        System.out.println("\n-----------------------------------------");
        System.out.println("\t\tBusiness Section");
        System.out.println("-----------------------------------------\n");
        Connection con = DriverManager.getConnection(url, uname, pass);
        /*
         * here we need to make the the changes like 
         * insertion into hotels and adding of the hotels
         * here we can perform the activities like  d22
         * 2eletion when the item are or not avilable 
         * to ensure that we need to keep y/n in the items because it will tell about the avlalbilty*/
        int x = 1;
        do {
            int option;
            System.out.print("\nSelect (1. Add a hotel, 2. Add an item to a hotel): ");
            option = scanner.nextInt();
            switch (option) {
                case 1: 
                	{
                        PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO hotels(sno,hotelname) VALUES (?, ?)");
                        System.out.print("\nEnter hotel id: ");
                        int hotelId = scanner.nextInt();

                        System.out.print("\nEnter hotel name: ");
                        String hotelName = scanner.next();

                        preparedStatement.setInt(1, hotelId);
                        preparedStatement.setString(2, hotelName);
                        preparedStatement.executeUpdate();
                        System.out.println("\nHotel successfully added.");

                        preparedStatement.close();
                    }
                    break;
                case 2:
                    {
                    	System.out.print("\nEnter hotel name: ");
                        String hotelname = scanner.next();

                        System.out.print("\nEnter item id: ");
                        int itemId = scanner.nextInt();

                        System.out.print("\nEnter the item name: ");
                        String itemName = scanner.next();

                        System.out.print("\nEnter the item price: ");
                        int price = scanner.nextInt();
                        PreparedStatement prepared = con.prepareStatement("INSERT INTO " + hotelname + " " + "VALUES (?, ?, ?)");
                        prepared.setInt(1, itemId);
                        prepared.setString(2, itemName);
                        prepared.setInt(3, price);
                        prepared.executeUpdate();
                        prepared.close();
                    }
                    break;

            }
            con.close();
            System.out.println("To add another item press 1.");
            x = scanner.nextInt();
        } while (x == 1);
    	}
    	catch(Exception e1){
    		System.out.println("an error occured ");
    	}
    }
}