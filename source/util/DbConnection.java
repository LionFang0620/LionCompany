package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static void main(String[] args) {
		System.out.println(DbConnection.getDb());
		System.out.println("連接成功");
	}
	public static Connection getDb()
	{
		Connection conn=null;
		String url="jdbc:mysql://localhost:3306/lioncompany";
		String user="root";
		String password="1234";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url,user,password);
			} 
		catch (SQLException e) 
		{
			System.out.println("no driver");
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) 
		{
			System.out.println("無法連線");
			e.printStackTrace();
		}
		return conn;
		
	}

}
