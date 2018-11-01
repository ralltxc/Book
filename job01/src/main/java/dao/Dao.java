package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.DBUtils;

public class Dao {
	private static Connection conn;
	private static Statement sta;
	private static ResultSet resultSet;
	public Dao() throws SQLException{
		try{	
			conn = DBUtils.getConnection();
			sta=conn.createStatement();
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}
	}
	
	public static ResultSet executeQuery(String sql) throws SQLException {
		try {
			resultSet = sta.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		
		return resultSet;
	}
	
	public static int excuteUpdate(String sql)throws SQLException{
		int n;
		try {
			n = sta.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		 
		 return n;
	}
	
	public void close(){
		try {
			if(resultSet!=null)
				resultSet.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(sta!=null)
				sta.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn!=null)
				conn.setAutoCommit(true);
				conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
