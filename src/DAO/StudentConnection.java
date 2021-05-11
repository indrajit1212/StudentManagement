package DAO;
import java.sql.DriverManager;
import java.sql.*;
public class StudentConnection {
static Connection connect;
public static Connection createConnection() {
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String user="scg_indrajit";
		String password="1sT17CS068@";
		String url="jdbc:mysql://localhost:3306/Student";
		connect=DriverManager.getConnection(url,user,password);
		connect.setAutoCommit(false);
		//System.out.println("hello");
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return connect;
}
}
