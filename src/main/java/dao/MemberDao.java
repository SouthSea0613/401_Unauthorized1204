package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Member;

//회원관리 db 서비스 
public class MemberDao {
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	public void connect() {
		con=JdbcUtil.getConnection();
		
	}
	public void close() {
		JdbcUtil.close(rs, stmt, con);
		
	}
	public boolean join(Member member) {
		// TODO Auto-generated method stub
		return false;
	}
}
