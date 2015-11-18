package com.pizzaApp.core;
import java.sql.*;


public class database {
	Connection c = null;
	String connURL = "jdbc:sqlite:users.db";
	
	/*
	 * Creates the tables needed and adds users to those tables
	 */
	public void generateSeedData() throws SQLException{
		String sql;
		getConn();
		Statement stmt = null;
		
		//create users table
		stmt = c.createStatement();
		sql = "CREATE TABLE Users "
				+ "(ID INTEGER PRIMARY KEY, "
				+ "NAME TEXT NOT NULL, "
				+ "POINTS INT, "
				+ "TYPE TEXT, "
				+ "PHONE TEXT NOT NULL, "
				+ "EMAIL TEXT, "
				+ "ADDRESS TEXT, "
				+ "PASSWORD TEXT);";
		stmt.executeUpdate(sql);
		stmt.close();
		
		
		//add users to the users table
		stmt = c.createStatement();
		sql = "INSERT INTO Users (NAME, POINTS, TYPE, PHONE, EMAIL, ADDRESS) "
				+ "VALUES ('Peter Pizzapan', 0, 'CUSTOMER', '3033033030', 'customer@mail.com', '1234 EASY STREET, FOCO, CO, 80525', 'customer')";
		stmt.executeUpdate(sql);
		
		sql = "INSERT INTO Users (NAME, POINTS, TYPE, PHONE, EMAIL) "
				+ "VALUES ('Annie Boss', 0, 'MANAGER', 1111111111, 'manager@mail.com', 'manager')";
		stmt.executeUpdate(sql);
		
		sql = "INSERT INTO Users (NAME, POINTS, TYPE, PHONE, EMAIL) "
				+ "VALUES ('John Cash', 0, 'CASHIER', 2222222222, 'cashier@mail.com', 'cashier')";
		stmt.executeUpdate(sql);
		
		sql = "INSERT INTO Users (NAME, POINTS, TYPE, PHONE, EMAIL) "
				+ "VALUES ('Spongebob Squarepants', 0, 'COOK', 3333333333, 'cook@mail.com', 'cook')";
		stmt.executeUpdate(sql);
		stmt.close();
	}
	
	/*
	 * Add a user to the DB table
	 */
	public void addUser(Person p) throws SQLException{
		Statement stmt = c.createStatement();
		String sql = "";
		if(p.addr != null){
			sql = "INSERT INTO Users (NAME, TYPE, ADDRESS) "
					+ "VALUES ('" + p.name + "', '" + p.type + "', '" + p.addr + "')";
		}else{
			sql = "INSERT INTO Users (NAME, TYPE) "
					+ "VALUES ('" + p.name + "', '" + p.type + "')";
		}
		stmt.executeUpdate(sql);
		stmt.close();
	}
	
	/*
	 * Authenticates user by comparing given email and username to what is stored in the database
	 */
	public boolean Authenticate(String email, String password){
		getConn();
		Statement stmt = c.createStatement();
		String sql = "SELECT * FROM Users WHERE EMAIL = '" + email + "' AND PASSWORD = '" + password + "'";
		
		if(stmt.execute(sql)){
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 * Update Password 
	 */
	public boolean Authenticate(String email, String oldPassword, String newPassword){
		getConn();
		Statement stmt = c.createStatement();
		String sql = "SELECT * FROM Users WHERE EMAIL = '" + email + "' AND PASSWORD = '" + oldPassword + "'";
		
		if(stmt.execute(sql)){
			sql = "UPDATE Users SET PASSWORD = '" + newPassword + "' WHERE EMAIL = '" + email + "'";
			stmt.execute(sql);
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 * Updates user account with new points
	 */
	public void addPoints(int newPoints, String name, String type) throws SQLException{
		getConn();
		Statement stmt = c.createStatement();
		
		String sql = "UPDATE Users SET POINTS = POINTS + " + newPoints + " WHERE NAME = '" + name + "';";
		int temp = stmt.executeUpdate(sql);
		if(temp == 0)
			System.out.println("Found problem");
		
		stmt.close();
	}
	
	/*
	 * If the users.dbo file exists, connect to it.
	 * If the file doesn't exist, create and connect to it
	 * If unable to connect, Print error message and return null
	 */
	public void getConn(){
		if(c == null){
			try{
				Class.forName("org.sqlite.JDBC");
				c = DriverManager.getConnection(connURL);
				c.setAutoCommit(false);
				System.out.println("Opened database successfully");
				
			} catch(Exception e) {
				 System.out.println("HER");
				System.err.println("Unable to connect to DB: " + e.getMessage());
			}
		}
	}
	
	public void closeConn() throws SQLException{
		c.close();
	}
	/*
	public static void main( String args[] ) throws SQLException{
		database db = new database();
		Statement stmt = null;

		try{
			db.generateSeedData();
			db.addPoints(100, "Peter Pizzapan", "Customer");
		    db.addPoints(100, "Peter Pizzapan", "Customer");
			
			stmt = db.c.createStatement();
		    String sql = "SELECT * FROM Users;";
		    stmt.executeUpdate(sql);
		   // c.commit();

		    ResultSet rs = stmt.executeQuery( "SELECT * FROM Users;" );
		    while ( rs.next() ) {
		    	System.out.println("ID = " + rs.getInt("ID"));
		    	System.out.println("NAME = " + rs.getString("NAME"));
		    	System.out.println("POINTS = " + rs.getInt("POINTS"));
		    	System.out.println("TYPE = " + rs.getString("TYPE"));
		    	System.out.println("EMAIL = " + rs.getString("EMAIL"));
		    	System.out.println("ADDR = " + rs.getString("ADDRESS"));
		    }
		    rs.close();
		    stmt.close();
		    db.closeConn();
		} catch(Exception e) {
			System.err.println("Unable to connect to DB: " + e.getMessage());
		}
		
	
		
	}
	*/
}


