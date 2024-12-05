package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import dto.Member;

//회원관리 db 서비스 
public class MemberDao {
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	HttpServletRequest req;

	public void connect() {
		con = JdbcUtil.getConnection();

	}

	public void close() {
		JdbcUtil.close(rs, stmt, con);

	}
	public void setRequest(HttpServletRequest req) {
		this.req=req;
	}

	public boolean join(Member member) {
		String sql = "insert into member values (?,?,?,?)";
		try {
			stmt = con.prepareStatement(sql); // 파싱
			stmt.setString(1, member.getUsername());
			stmt.setString(2, member.getUserpw());
			stmt.setString(3, member.getIrum());
			stmt.setString(4, member.getGender());
			
			req.setAttribute("name", member.getIrum());
			
			int result = stmt.executeUpdate();// insert, update, delete
			if (result > 0) {
				System.out.println("join Dao 성공");
				return true;
			} else {
				System.out.println("join dao 실패");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Member login(HashMap<String, String> map) {
		String sql = "select * from member where username=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, map.get("username"));
			rs=stmt.executeQuery();
			if(rs.next()) { //아이디가 존재하면
				if(rs.getString("userpw").equals(map.get("userpw"))) {
					//로그인 성공
					Member mb = new Member();
					mb.setUsername(rs.getString("username"));
					mb.setUserpw(rs.getString("userpw"));
					mb.setIrum(rs.getString("irum"));
					mb.setGender(rs.getString("gender"));
					return mb;
				}		
			}
		} catch (SQLException e) {
			System.out.println("login dao 예외발생");
			e.printStackTrace();
		}
		return null;
	}
	

}
