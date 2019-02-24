package conn;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.*;
import java.sql.Connection;

public class Sql {
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	
	/*
	 * ������������
	 */
	public void Conn()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(java.lang.ClassNotFoundException e)
		{
			System.err.println(e.getMessage());
		}
	}
	
	/*
	 * ִ�в�ѯ����
	 */
	public ResultSet select(String Sql) throws ClassNotFoundException
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/mymall?useUnicode=true&characterEncoding=UTF-8";
			conn= DriverManager.getConnection(url,"root","");
			stmt= conn.createStatement();
			rs=stmt.executeQuery(Sql);
			
		}catch(SQLException ex){
			System.err.println(ex.getMessage());
		}
		return rs;
	}
	
	
	
	/*
	 * ִ�и��²���
	 */
	public int update(String Sql) throws ClassNotFoundException  //(update,insert,delete)
	{
		int result=0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/mymall?useUnicode=true&characterEncoding=UTF-8";
			conn= DriverManager.getConnection(url,"root","");
			stmt= conn.createStatement();
			result=stmt.executeUpdate(Sql);
		}catch(SQLException ex){
			System.err.println(ex.getMessage());
		}
		return result;
	}
	
	/*
	 * �ر���������
	 */
	public void close()
	{
		try{
			if(rs!=null)
				rs.close();
		}catch(Exception e)
		{
			e.printStackTrace(System.err);
		}
		try{
			if(stmt!=null)
				stmt.close();
		}catch(Exception e)
		{
			e.printStackTrace(System.err);
		}
		try{
			if(conn!=null)
				conn.close();
		}catch(Exception e)
		{
			e.printStackTrace(System.err);
		}
	}

}
