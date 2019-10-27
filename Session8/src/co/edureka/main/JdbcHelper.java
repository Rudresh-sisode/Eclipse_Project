/*
 * work is in Running, sum issued happaned here and you need to fix, 
 * the developer are working in his back-side
 */











package co.edureka.main;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class JdbcHelper {

	CallableStatement cStmt;
	PreparedStatement pStmt;
	Statement stmt;
	Connection conn;
	public void executeProcedure() {
		try
		{
			
				String sqlQueryf="{call addStudent(?,?,?,?)}";
				cStmt=conn.prepareCall(sqlQueryf);
				
				cStmt.setString(1, "Aditya");
				cStmt.setString(2, "Aty@gmail.com");
				cStmt.setInt(3, 20);
				cStmt.setString(4, "Los Anjelose");
				
				System.out.println("Ok boss created, don't worry");
		}
		catch(Exception ex) {
			System.out.println("Boss Exceptoin Occured! "+ex);
		}
		finally
		{
			try
			{
				if(cStmt!=null) {
					cStmt.close();
				}
				if(pStmt!=null) {
					pStmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
				if(stmt!=null)
				{
					stmt.close();
				}
				System.out.println("boss connection has been closed by us!");
			}
			catch(Exception ex) {
				
			}
		}
		
		
		
		
	}

	public void creatConnection() {
		try {
					
					//Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Driver loadded first step");
				
				//create connection
				String user="root";
				String pass="";
				String url="jdbc:mysql://localhost/edureka?serverTimezone=UTC";
				
				Connection conn=DriverManager.getConnection(url,user,pass);
				
				System.out.println("Boss Connection Created !");
				
				
				}
				catch(Exception e)
				{
					System.out.println("Boss Exception occured "+e);
				}
				
			}
			
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JdbcHelper obj=new JdbcHelper();
		obj.creatConnection();
		obj.executeProcedure();
		
	}

}
