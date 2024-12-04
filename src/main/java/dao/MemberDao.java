package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Member;

//회원관리 db 서비스 
public class MemberDao {
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;

	public void connect() {
		con = JdbcUtil.getConnection();

	}

	public void close() {
		JdbcUtil.close(rs, stmt, con);

	}

	public boolean join(Member member) {
		String sql = "insert into member(username, userpw, irum, gender)" + "values (?,?,?,?)";
		try {
			stmt = con.prepareStatement(sql); // 파싱
			stmt.setString(1, member.getUsername());
			stmt.setString(2, member.getUserpw());
			stmt.setString(3, member.getIrum());
			stmt.setString(4, member.getGender());
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
}
