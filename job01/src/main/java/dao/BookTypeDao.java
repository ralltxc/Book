package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import entity.Booktype;
import util.DBUtils;

public class BookTypeDao {
	public static List<Booktype> selectBookType(){
		List<Booktype> list = new ArrayList<Booktype>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtils.getConnection();
			String sql = "select * from booktype";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				Booktype booktype = new Booktype();
				Integer id = resultSet.getInt("id");
				String typename = resultSet.getString("typename");
				booktype.setTypeid(id);
				booktype.setTypename(typename);
				list.add(booktype);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(connection, statement, resultSet);
		}
		return list;
	}
	
	public static List<Booktype> selectBookType(String type){
		List<Booktype> list = new ArrayList<Booktype>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtils.getConnection();
			String sql = "select * from booktype where typename=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, type);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				Booktype booktype = new Booktype();
				Integer id = resultSet.getInt("id");
				String typename = resultSet.getString("typename");
				booktype.setTypeid(id);
				booktype.setTypename(typename);
				list.add(booktype);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(connection, statement, resultSet);
		}
		return list;
	}
	
	public static int insertBookType(Integer id,String typename){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int n=0;
		try {
			connection = DBUtils.getConnection();
			String sql = "insert into booktype values(?,?)";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.setString(2, typename);
			n = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(connection, statement, resultSet);
		}
		return n;
	}
	
	public static int updateBookType(Integer id,String typename){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int n=0;
		try {
			connection = DBUtils.getConnection();
			String sql = "update booktype set typename=? where id=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, typename);
			statement.setInt(2, id);
			n = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(connection, statement, resultSet);
		}
		return n;
	}
	
	public static int deleteBookType(Integer id){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int n=0;
		try {
			connection = DBUtils.getConnection();
			String sql = "delete from booktype where id=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			n = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(connection, statement, resultSet);
		}
		return n;
	}
}
