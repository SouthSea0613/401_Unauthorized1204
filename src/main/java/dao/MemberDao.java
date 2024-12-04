package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import dto.Member;

//회원관리 DB 서비스
public class MemberDao { 
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	HttpServletRequest req;
	
	public void connect() {
		con =JdbcUtill.connect();

	}
	
	public void setRequest(HttpServletRequest req) {
		this.req = req;
	}
	
	public void close() {
		JdbcUtill.close(rs);
		JdbcUtill.close(con);
		JdbcUtill.close(stmt);
	}
	public boolean join(Member member) {
		String sql = "INSERT INTO MEMBER (USERNAME, USERPW, IRUM, GENDER) VALUES(?,?,?,?)";
		try {
			stmt = con.prepareStatement(sql);  //파싱
			stmt.setString(1, member.getUsername());
			stmt.setString(2, member.getUserpw());
			stmt.setString(3, member.getIrum());
			stmt.setString(4, member.getGender());
			int result = stmt.executeUpdate(); // insert, update, delete
			if(result>0) {
				System.out.println("join Dao 성공");
				JdbcUtill.commit(con);
				req.setAttribute("name", member.getIrum());
				return true;
			}else {
				System.out.println("join Dao 실패");

				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return false;

	}
}
