package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Member;

public class MemberDao {
	Connection con ;
	PreparedStatement stmt;
	ResultSet rs;
	
	public void connect() {
		con=JdbcUtil.getConnection();
	}
	public void close() {
		JdbcUtil.close(rs, stmt, con);
	}
	 public boolean join(Member member) {
		 String sql = "INSERT INTO MEMBER VALUES(?,?,?,?)";
	      try {
	    	  
	    	  stmt=con.prepareStatement(sql);
	    	  stmt.setString(1, member.getUsername());
	    	  stmt.setString(2, member.getUserpw());
	    	  stmt.setString(3, member.getIrum());
	    	  stmt.setString(4, member.getGender());
	         
	         int result = stmt.executeUpdate();
	         if (result != 0) {
	            System.out.printf("join 성공");
	           
	            return true;
	         }
	         else {
	            System.out.printf("join 실패");
	            return false;
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return false;
	   }


}
