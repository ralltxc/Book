package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Book;
import util.DBUtils;

public class BookDAO {
	

	public void update(String isbn,int typeid,String bookname,String author,String publish,String publishdate,int publishtime,double unitprice){
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			try {
				conn = DBUtils.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			String sql = "update book set typeid=?,bookname=?,author=?,publish=?,publishdate=?,publishtime=?,unitprice=? where isbn=?";
			prep = conn.prepareStatement(sql);
			prep.setInt(1, typeid);
			prep.setString(2, bookname);
			prep.setString(3, author);
			prep.setString(4, publish);
			prep.setString(5, publishdate);
			prep.setInt(6, publishtime);
			prep.setDouble(7, unitprice);
			prep.setString(8, isbn);
			prep.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.close(conn, prep, null);
		}
	}
	
	public void delete(String isbn) throws SQLException{
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			try {
				conn = DBUtils.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			String sql = "delete from book where isbn=?";
			prep = conn.prepareStatement(sql);
			prep.setString(1, isbn);
			prep.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtils.close(conn, prep, null);
		}
	}
	
	
	
	//��ѯ����ͼ��������Ϣ
	public List<Book> findAll() throws SQLException{
		List<Book> books = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "select * from book";
			prep = conn.prepareStatement(sql);
			rs = prep.executeQuery();
			while(rs.next()){
				String isbn=rs.getString("isbn");
				int typeid=rs.getInt("typeid");
				String bookname=rs.getString("bookname");
				String author=rs.getString("author");
				String publish=rs.getString("publish");
				String publishdate=rs.getString("publishdate");
				int publishtime=rs.getInt("publishtime");
				double unitprice=rs.getDouble("unitprice");
				Book book = new Book();
				book.setIsbn(isbn);
				book.setTypeid(typeid);
				book.setBookname(bookname);
				book.setAuthor(author);
				book.setPublish(publish);
				book.setPublishdate(publishdate);
				book.setPublishtime(publishtime);
				book.setUnitprice(unitprice);
				books.add(book);
						
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.close(conn, prep, rs);
		}
		
		return books;
	}
	
	

		//��ͼ����Ϣ���뵽���ݿ���
	public void save(Book book) throws Exception{
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "insert into book values(?,?,?,?,?,?,?,?)";
			prep = conn.prepareStatement(sql);
			prep.setString(1, book.getIsbn());
			prep.setInt(2, book.getTypeid());
			prep.setString(3, book.getBookname());
			prep.setString(4, book.getAuthor());
			prep.setString(5, book.getPublish());
			prep.setString(6, book.getPublishdate());
			prep.setInt(7, book.getPublishtime());
			prep.setDouble(8, book.getUnitprice());
			prep.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtils.close(conn, prep, null);
		}
	}
}
