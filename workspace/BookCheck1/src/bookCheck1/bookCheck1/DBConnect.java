package bookCheck1;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DBConnect {
	private java.sql.Connection con;
	private java.sql.Statement stat;
	private ResultSet rslt;
	
	//
	//mescobar or mescobar5
	//5Antonio
	public void DBconnect(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://whateverTheUrlIs","Name","Password");
			stat=con.createStatement();
		}catch(Exception ex){
			System.out.println("Error"+ex);
		}
	}
	public void getData(){	
		try{
			String query="SQL Statement";
			rslt=stat.executeQuery(query);
			System.out.println("Record from DB");
			while(rslt.next()){
				String name=rslt.getString("name");
				String age=rslt.getString("age");
				System.out.println("Name"+name+"Age"+age);
			}
		}catch(Exception ex){
				System.out.println("Error"+ex);
		}
	}
}
