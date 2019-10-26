package co.edureka.main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Load the driver
		try {
			
			//Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loadded first step");
		
		//create connection
		String user="root";
		String pass="";
		String url="jdbc:mysql://localhost/edureka?serverTimezone=UTC";
		
		Connection conn=DriverManager.getConnection(url,user,pass);
		
		String sqlQuery="insert into Student values(null,'Soham','sohamerajput@gmail.com',10,'pune')";
		
		Statement stmt=conn.createStatement();
		int i=stmt.executeUpdate(sqlQuery);
		System.out.println("Rows has been inserted rows "+i);
		conn.close();
		stmt.close();
		
		}
		catch(Exception e)
		{
			System.out.println("Boss Exception occured "+e);
		}

	}

}
