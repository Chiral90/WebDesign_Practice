package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class BoardDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	BoardDAO() {
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
	
	public ArrayList<boardDataBean> list() throws Exception {
		ArrayList<boardDataBean> blist = new ArrayList();
		
		try {
			String sql = "";
			sql = "select * from board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				boardDataBean bbean = new boardDataBean();
				bbean.setNo(rs.getInt("no"));
				bbean.setTitle(rs.getString("title"));
				bbean.setContent(rs.getString("content"));
				bbean.setId(rs.getString("id"));
				bbean.setView(rs.getInt("view"));
				
				blist.add(bbean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn!=null) conn.close();
			if (pstmt!=null) pstmt.close();
			if (rs!=null) rs.close();
		}
		return blist;
	}
	public void likeCount(boardDataBean bbean) throws Exception {
		try {
			String sql = "";
			sql = "update board set like=like+1 where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bbean.getNo() );
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn!=null) conn.close();
			if (pstmt!=null) pstmt.close();
		}
	}
	public void viewCount(boardDataBean bbean) throws Exception {
		try {
			String sql = "";
			sql = "update board set view=view+1 where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bbean.getNo() );
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn!=null) conn.close();
			if (pstmt!=null) pstmt.close();
		}
	}
	
	public boardDataBean detail(boardDataBean bbean) throws Exception {
		
		boardDataBean member = new boardDataBean();
		try {
			String sql = "";
			sql = "select * from board where no=? order by no desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bbean.getNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member.setNo(rs.getInt("no"));
				member.setTitle(rs.getString("title"));
				member.setContent(rs.getString("content"));
				member.setId(rs.getString("id"));
				member.setView(rs.getInt("view"));
				member.setLike(rs.getInt("like"));
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
