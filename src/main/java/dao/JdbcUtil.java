package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//jdbc 공통 메소드
public class JdbcUtil {
	public static Scanner sc=new Scanner(System.in);
	
	static {
		//클래스당 1번만 실행하는 영역
		//오라클 드라이버를 메모리에 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			//System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	//클래스 메소드
	public static Connection getConnection() {
		String url="jdbc:oracle:thin:@192.168.0.41:1521:xe";
		String id="icia";
		String pw="1111";
		//Connection con=null;
		try {
			Connection con = DriverManager.getConnection(url,id,pw);
			System.out.println("DB 연결 성공");
			//con.setAutoCommit(false); //기본값:자동커밋(true),수동커밋(false)
			return con;  //접속 성공
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		}
		return null; //접속 실패
	}//end connect
	
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection con) {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		} catch (SQLException e) {
			System.out.println("close 예외 발생");
			e.printStackTrace();
		}
	}
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {
			System.out.println("commit 예외 발생");
			e.printStackTrace();
		}
	}
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			System.out.println("rollback 예외 발생");
			e.printStackTrace();
		}
	}

	
}
