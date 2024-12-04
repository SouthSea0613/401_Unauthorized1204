package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Member;

//회원관리 DB서비스!

public class MemberDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
		
	public void connect() {
		con = JdbcUtil.getConnect();
	}

	public void close() {
		JdbcUtil.close(rs, pstmt, con);
	}

	public boolean join(Member member) {
		String sql = "INSERT INTO MEMBER(USERNAME,USERPW,NAME,GENDER) VALUES (?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getUsername());
			pstmt.setString(2, member.getUserpw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getGender());
			pstmt.executeUpdate();  // 기억나지? 이건 insert, update, delete 할 때 쓰는거야

			// 회원가입 성공 여부를 콘솔에 찍어보고 싶다면~
//			int result = pstmt.executeUpdate();
//			if(result > 0) {
//				System.out.println("오예! 회원가입 성공");
//				return true;		
//			} else {
//				System.out.println("회원가입 실패야");
//				return false;
//			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
