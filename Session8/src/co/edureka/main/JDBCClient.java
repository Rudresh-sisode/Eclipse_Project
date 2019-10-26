package co.edureka.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Load the driver
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loadded first step");
		
		//create connection
		String user="root";
		String pass="";
		String url="jdbc:mysql://localhost/edureka";
		
		Connection conn=DriverManager.getConnection(url,user,pass);
		
		String sqlQuery="insert into Student values(null,'rudresh','rudranjaput@gmail.com',21,'Jamner'";
		
		Statement stmt=conn.createStatement();
		stmt.executeUpdate(sqlQuery);
		System.out.println("Rows has been inserted");
		conn.close();
		stmt.close();
		
		}
		catch(Exception e)
		{
			System.out.println("Boss Exception occured "+e);
		}

	}

}
