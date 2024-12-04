package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Member;

public class MemberDao {
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	
	public void connect() {
		connection = JdbcUtill.connect();
	}
	
	public void close() {
		JdbcUtill.close(connection);
		JdbcUtill.close(preparedStatement);
		JdbcUtill.close(resultSet);
	}
	
	public boolean join(Member member) {
		return false;
	}
}
