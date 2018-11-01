package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import entity.Booktype;
import entity.ReaderType;
import util.DBUtils;

public class ReaderTypeDao {
	public static List<ReaderType> selectReaderType(){
		List<ReaderType> list = new ArrayList<ReaderType>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtils.getConnection();
			String sql = "select * from readertype";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				ReaderType readerType = new ReaderType();
				int id = resultSet.getInt("id");
				String name = resultSet.getString("typename");
				int max = resultSet.getInt("maxborrownum");
				int limit = resultSet.getInt("daylimit");
				readerType.setId(id);
				readerType.setTypename(name);
				readerType.setMaxborrownum(max);
				readerType.setLimit(limit);
				list.add(readerType);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(connection, statement, resultSet);
		}
		return list;
	}
	
	public static List<ReaderType> selectReaderType(String type){
		List<ReaderType> list = new ArrayList<ReaderType>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtils.getConnection();
			String sql = "select * from readertype where typename=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, type);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				ReaderType readerType = new ReaderType();
				int id = resultSet.getInt("id");
				String name = resultSet.getString("typename");
				int max = resultSet.getInt("maxborrownum");
				int limit = resultSet.getInt("daylimit");
				readerType.setId(id);
				readerType.setTypename(name);
				readerType.setMaxborrownum(max);
				readerType.setLimit(limit);
				list.add(readerType);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(connection, statement, resultSet);
		}
		return list;
	}
	
	public static int insertReaderType(Integer id,String typename,Integer num,Integer limit){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int n=0;
		try {
			connection = DBUtils.getConnection();
			String sql = "insert into readertype values(?,?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.setString(2, typename);
			statement.setInt(3, num);
			statement.setInt(4, limit);
			n = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(connection, statement, resultSet);
		}
		return n;
	}
	
	public static int updateReaderType(Integer id,String typename,Integer num,Integer limit){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int n=0;
		try {
			connection = DBUtils.getConnection();
			String sql = "update readertype set typename=?,maxborrownum=?,daylimit=? where id=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, typename);
			statement.setInt(2, num);
			statement.setInt(3, limit);
			statement.setInt(4, id);
			n = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(connection, statement, resultSet);
		}
		return n;
	}
	
	public static int deleteReaderType(Integer id){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int n=0;
		try {
			connection = DBUtils.getConnection();
			String sql = "delete from readertype where id=?";
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

