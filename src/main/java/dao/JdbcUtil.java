package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//jdbc 공통 메소드 
public class JdbcUtil {
	public static Scanner sc = new Scanner(System.in);
	
	
	PreparedStatement pstmt;
	ResultSet rs;
	Statement stmt;
	static {
		// 클래스당 1번 실행
		// 오라클 드라이버를 메모리에 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 로딩 실패");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
	//클래스 메소드
	public static Connection getConnection() {
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ICIA", "1234");
			System.out.println("db 연결 성공");
			//con.setAutoCommit(false); //기본값 : 자동커밋(true),수동커밋(false)
			return con;

		} catch (SQLException se) {
			System.out.println("db 연결 실패");
			se.printStackTrace();
		}
		
		return null;

	}

//	public Connection close() {

//	}
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs, PreparedStatement pstmt,Connection con) {
		
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null) con.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("close 예외 발생");
			e.printStackTrace();
		}
		
	}

	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
