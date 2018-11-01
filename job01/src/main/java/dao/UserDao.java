package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Users;
import util.DBUtils;

public class UserDao {
	public static List<Users> selectUser(){
		List<Users> users=new ArrayList<Users>();
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtils.getConnection();
			String sql = "SELECT * FROM users";
			statement = connection.prepareStatement(sql);
			resultSet=statement.executeQuery();
			
			while(resultSet.next()){
				int id=resultSet.getInt("id");
				String name=resultSet.getString("name");
				String password=resultSet.getString("password");
				Users u = new Users();
				u.setId(id);
				u.setName(name);
				u.setPassword(password);
				users.add(u);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(connection, statement, resultSet);
		}
		
		return users;
	}
	
	public static Users check(String name,String password){
		Users users=new Users();
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		boolean flag = false;
		try {
			connection = DBUtils.getConnection();
			String sql = "select name,password from users";
			statement = connection.prepareStatement(sql);
			resultSet=statement.executeQuery();
			
			while(resultSet.next()){
				String nString=resultSet.getString("name");
				String pString=resultSet.getString("password");
				if(name.equals(nString)&&password.equals(pString)){
					flag=true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(connection, statement, resultSet);
		}
		
		if(flag){
			users.setName(name);
			users.setPassword(password);
		}else {
			users=null;
		}
		
		return users;
	}
	
	public static int insertUser(String name,String password){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtils.getConnection();
			String sql = "insert into users values(null,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2, password);
			
			statement.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(connection, statement, resultSet);
		}
		
		
		return 0;
	}
	
	public static int updateUserPWD(Integer id,String pwd){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtils.getConnection();
			String sql = "update users set password=? where id=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, pwd);
			statement.setInt(2, id);
			
			statement.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(connection, statement, resultSet);
		}
		
		
		return 0;
	}
	
	public static int deleteUserPWD(Integer id){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtils.getConnection();
			String sql = "delete from users where id=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			statement.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(connection, statement, resultSet);
		}
		
		
		return 0;
	}
}
