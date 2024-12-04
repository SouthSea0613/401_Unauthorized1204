package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import dto.Member;

public class MemberDao {
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	HttpServletRequest req;
	
	public void connect() {
		connection = JdbcUtill.connect();
	}
	
	public void setRequest(HttpServletRequest req) {
		this.req = req;
	}
	
	public void close() {
		JdbcUtill.close(connection);
		JdbcUtill.close(preparedStatement);
		JdbcUtill.close(resultSet);
	}
	
	public boolean join(Member member) {
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO MEMBER VALUES(?, ?, ?, ?)");
			
			preparedStatement.setString(1, member.getUsername());
			preparedStatement.setString(2, member.getUserPW());
			preparedStatement.setString(3, member.getName());
			preparedStatement.setString(4, member.getGender());
			
			int result = preparedStatement.executeUpdate();
			if (result != 0) {
				System.out.printf("join 성공");
				JdbcUtill.commit(connection);
				req.setAttribute("name", member.getName());
				return true;
			}
			else {
				System.out.printf("join 실패");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
