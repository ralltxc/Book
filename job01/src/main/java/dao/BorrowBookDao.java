package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Book;
import entity.BorrowBook;
import util.DBUtils;

public class BorrowBookDao {
	public static  List<BorrowBook> selectBorrowByReaderId(String readerid){
		List<BorrowBook> users = new ArrayList<BorrowBook>();
		BorrowBook bb = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = DBUtils.getConnection();
			String sql = "select * from borrowbook where readerid=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, readerid);
			rs = statement.executeQuery();
			while(rs.next()){
				String id = rs.getString("readerid");
				String ISBN = rs.getString("ISBN");
				Date borrowdate = rs.getDate("borrowdate");
				Date returndate = rs.getDate("returndate");
				int fine = rs.getInt("fine");
				bb = new BorrowBook();
				bb.setReaderid(id);
				bb.setISBN(ISBN);
				bb.setBorrowdate(borrowdate);
				bb.setReturndate(returndate);
				bb.setFine(fine);
				System.out.println(bb);
				users.add(bb);
			}
		} catch (Exception e) {	
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(connection, statement, rs);
		}
		
		return users;
		
	}
	
	public static int borrowBook(String readerid,String ISBN, Date borrowdate) throws Exception{
		Connection connection = null;
		PreparedStatement statement = null;
		int id;
		try {
			connection = DBUtils.getConnection();
			String sql = "insert into borrowbook(readerid,ISBN,borrowdate) values(?,?,?)";
			statement.setString(1, readerid);
			statement.setString(2, ISBN);
			statement.setDate(3, borrowdate);
			id = statement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtils.close(connection, statement, null);
		}
		return id;

	}
	
	public static int returnBook(String readerid,String ISBN,Date returndate) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int id;
		try {
			connection = DBUtils.getConnection();
			String sql = "insert into borrowbook(readerid,ISBN,returndate) values(?,?,?)";
			statement.setString(1, readerid);
			statement.setString(2, ISBN);
			statement.setDate(3, returndate);
			id = statement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtils.close(connection, statement, null);
		}
		return id;

	}
	
}
