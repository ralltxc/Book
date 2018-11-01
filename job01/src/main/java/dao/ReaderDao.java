package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Reader;
import util.DBUtils;

public class ReaderDao {
	/*
	 * �������û���������Ϣ��ѯ����
	 */
	public List<Reader> findAll() throws Exception{
		List<Reader> reader = new ArrayList<Reader>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			String sql = "select * from reader";
			prep = conn.prepareStatement(sql);
			rs = prep.executeQuery();
			
			while (rs.next()) {				
				Reader read = new Reader();
				read.setReaderid(rs.getString("readerid"));;
				read.setType(rs.getInt("type"));
				read.setName(rs.getString("name"));
				read.setAge(rs.getInt("age"));
				read.setSex(rs.getString("sex"));
				read.setPhone(rs.getString("phone"));
				read.setDept(rs.getString("dept"));
				read.setRegedate(rs.getString("regdate"));
				reader.add(read);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(conn, prep, rs);
		}
		return reader;
	}
	//�ֱ���ݶ��߱�š��������������߲��š��������Ͳ�ѯ������Ϣ��
	public Reader selectReaderById(String id) throws Exception{
		Reader read = null;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			String sql = "select * from reader where readerid=?";
			prep = conn.prepareStatement(sql);
			prep.setString(1, id);
			rs = prep.executeQuery();
			
			if (rs.next()) {
				read = new Reader();
				read.setReaderid(id);
				read.setType(rs.getInt("type"));
				read.setName(rs.getString("name"));
				read.setAge(rs.getInt("age"));
				read.setSex(rs.getString("sex"));
				read.setPhone(rs.getString("phone"));
				read.setDept(rs.getString("dept"));
				read.setRegedate(rs.getString("regdate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtils.close(conn, prep, rs);
		}
		return read;
	}
	public Reader selectReaderByName(String name) throws Exception{
		Reader read = null;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			String sql = "select * from reader where name=?";
			prep = conn.prepareStatement(sql);
			prep.setString(3, name);
			rs = prep.executeQuery();
			
			if (rs.next()) {
				read = new Reader();
				read.setReaderid(rs.getString("id"));
				read.setType(rs.getInt("type"));
				read.setName(name);
				read.setAge(rs.getInt("age"));
				read.setSex(rs.getString("sex"));
				read.setPhone(rs.getString("phone"));
				read.setDept(rs.getString("dept"));
				read.setRegedate(rs.getString("regdate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtils.close(conn, prep, rs);
		}
		return read;
	}
	public Reader selectReaderByType(String type) throws Exception{
		Reader read = null;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			String sql = "select * from reader where name=?";
			prep = conn.prepareStatement(sql);
			prep.setString(2, type);
			rs = prep.executeQuery();
			
			if (rs.next()) {
				read = new Reader();
				read.setReaderid(rs.getString("id"));
				read.setType(Integer.parseInt(type));
				read.setName(rs.getString("name"));
				read.setAge(rs.getInt("age"));
				read.setSex(rs.getString("sex"));
				read.setPhone(rs.getString("phone"));
				read.setDept(rs.getString("dept"));
				read.setRegedate(rs.getString("regdate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtils.close(conn, prep, rs);
		}
		return read;
	}
	public Reader selectReaderByDept(String dept) throws Exception{
		Reader read = null;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			String sql = "select * from reader where dept=?";
			prep = conn.prepareStatement(sql);
			prep.setString(7, dept);
			rs = prep.executeQuery();
			
			if (rs.next()) {
				read = new Reader();
				read.setReaderid(rs.getString("id"));
				read.setType(rs.getInt("type"));
				read.setName(rs.getString("name"));
				read.setAge(rs.getInt("age"));
				read.setSex(rs.getString("sex"));
				read.setPhone(rs.getString("phone"));
				read.setDept(dept);
				read.setRegedate(rs.getString("regdate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtils.close(conn, prep, rs);
		}
		return read;
	}
	//���û�����Ϣ���뵽���ݿ�
	public void save(Reader read) throws Exception {
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "insert into reader values(?,?,?,?,?,?,?,?)";
			prep = conn.prepareStatement(sql);
			prep.setString(1, read.getReaderid());
			prep.setInt(2, read.getType());
			prep.setString(3, read.getName());
			prep.setInt(4, read.getAge());
			prep.setString(5, read.getSex());
			prep.setString(6, read.getPhone());
			prep.setString(7, read.getDept());
			prep.setString(8, read.getRegedate());
			prep.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtils.close(conn, prep, null);
		}
	}
	//ɾ������
	public void delete(String readerid) throws Exception{
		Connection conn = null;
		//Ԥ�����Statement
		PreparedStatement prep = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "delete from reader where readerid=?";
			prep = conn.prepareStatement(sql);
			prep.setString(1, readerid);
			prep.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(conn, prep, null);
		}
	}
	//�޸ķ���
	public void update(String id, Integer type, String name, Integer age,String sex, String phone, String dept, String regdate) throws Exception{
		Connection conn = null;
		//Ԥ�����Statement
		PreparedStatement prep = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "update reader set type=?,name=?,age=?,sex=?,phone=?,dept=?,regdate=? where readerid=?";
			prep = conn.prepareStatement(sql);
			prep.setInt(1, type);
			prep.setString(2, name);
			prep.setInt(3, age);
			prep.setString(4, sex);
			prep.setString(5, phone);
			prep.setString(6, dept);
			prep.setString(7, regdate);
			prep.setString(8, id);
			prep.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtils.close(conn, prep, null);
		}
	}
}
