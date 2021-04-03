package member;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//import java.util.ArrayList;
public class MemberDAO {
	// 전역변수
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	MemberDAO() { //
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/mysql");
			conn = ds.getConnection();
			System.out.println("DB Connected");
		} catch (Exception e) {
			System.out.println("DB Disconnected" + e);
			return;
		}
	}
	// insert method
	public void insert(MemberBean mbean) throws Exception {

		try {
			String sql = "";
			sql = "insert into member "
					+ "values (?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql); // value 입력보다 먼저 실행되어야함
			pstmt.setString(1, mbean.getId() );
			pstmt.setString(2, mbean.getPw() );
			pstmt.setString(3, mbean.getName() );
			pstmt.setString(4, mbean.getBirth() );
			pstmt.setInt(5, mbean.getAge() );
			pstmt.setString(6, mbean.getGender() );
			pstmt.setString(7, mbean.getEmail() );
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn!=null) conn.close(); // conn이 null이 아닐 때 (쿼리문 수행 후) 종료
			if (pstmt!=null) pstmt.close(); 
		}
	}
	// update method
	public void update(MemberBean mbean) throws Exception {

		try {
			String sql = "";
			sql = "update member set name=?, email=?, password=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mbean.getName() );
			pstmt.setString(2, mbean.getEmail() );
			pstmt.setString(3, mbean.getPw() );
			pstmt.setString(4, mbean.getId() );
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn!=null) conn.close(); // conn이 null이 아닐 때 (쿼리문 수행 후) 종료
			if (pstmt!=null) pstmt.close(); 
		}
	}
	
	// delete method
	public void delete(MemberBean mbean) throws Exception {
		ResultSet rs = null;

		try {
			String userpw = "";
			String checksql = "";
			checksql = "select password from member where id=?";
			PreparedStatement checkpstmt = conn.prepareStatement(checksql);
			checkpstmt.setString(1, mbean.getId() );
			rs = checkpstmt.executeQuery();
			if (rs.next()) {
				userpw = rs.getString("password");
				checkpstmt.close();
			}
			if (userpw == mbean.getPw()) {
				String sql = "";
				sql = "delete from member where id=? and password=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mbean.getId());
				pstmt.setString(2, mbean.getPw());
				pstmt.executeUpdate();
			} else {
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn!=null) conn.close();
			if (pstmt!=null) pstmt.close();			
		}
	}
	
	// select member list method
	public ArrayList<MemberBean> list() throws Exception {
		ResultSet rs = null;
		ArrayList<MemberBean> mlist = new ArrayList();
		try {
			String sql = "";
			sql = "select id, name from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberBean mbean = new MemberBean();
				mbean.setId(rs.getString("id"));
				mbean.setName(rs.getString("name"));
				
				mlist.add(mbean);
			}
		} catch (Exception e) {
			e.printStackTrace(); // console에 error 출력
		} finally {
			if (conn!=null) conn.close(); // conn이 null이 아닐 때 (쿼리문 수행 후) 종료
			if (conn!=null) pstmt.close();
			if (rs!=null) rs.close();
		}
		return mlist;
	}
	
	// select member detail method
	public MemberBean detail(MemberBean mbean) throws Exception {
		ResultSet rs = null;
		MemberBean member = null;
		try {
			String sql = "";
			sql = "select * from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mbean.getId() );
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new MemberBean();
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setBirth(rs.getString("birth"));
				member.setAge(rs.getInt("age"));
				member.setGender(rs.getString("gender"));
				member.setEmail(rs.getString("email"));
				
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn!=null) conn.close();
			if (pstmt!=null) pstmt.close();
			if (rs!=null) rs.close();
		}
		return member;
	}
}
