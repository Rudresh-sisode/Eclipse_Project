package co.edureka.main;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.Statement;
//import com.mysql.cj.jdbc.CallableStatement;
public class JDBCClient {
	/*CallableStatement cStmt;
	PreparedStatement pStmt;
	Statement stmt;
	
	public void executeProcedure() {
		

		String sqlQueryf="{call addStudent(?,?,?,?)}";
		cStmt=conn.prepareCall(sqlQueryf);
		
		cStmt.setString(1, "Aditya");
		cStmt.setString(2, "Aty@gmail.com");
		cStmt.setInt(3, 20);
		cStmt.setString(4, "Los Anjelose");
		
		System.out.println("Ok boss created, don't worry");*/
		
		
	

	
	
	
	
	
	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
		//Load the driver
		Scanner input=new Scanner(System.in);
		int a;
		try {
			
			//Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loadded first step");
		
		//create connection
		String user="root";
		String pass="";
		String url="jdbc:mysql://localhost/edureka?serverTimezone=UTC";
		
		Connection conn=DriverManager.getConnection(url,user,pass);
		
		
		
		
		
		String sqlQuery="insert into Student values(null,'Shobhana','shobhanarajput@gmail.com',21,'pune')";
		
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
		System.out.println("Enter 1 if you want to add more feature, To 0 for cancle");
		a=input.nextInt();
		if(a==1)
		{
			
		}
		else {
			System.out.println("it's ok!");
		}
		
	}

}
