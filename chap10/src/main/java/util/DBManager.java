package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager { // 데이터베이스에 접근하여 Connection 객체를 얻어오기 위한 DBManager 작성
	public static Connection getConnection() { // Connection 객체를 얻어오는 메소드 객체생성 없이 메소드를 호출하기위해 static으로 선언
		Connection conn = null; 
		try {
			Context initContext = new InitialContext(); // InitialContext 객체 생성
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			// jdbc/oracle이란 이름을 객체를 찾아서 DataSource가 받는다.
			DataSource ds = (DataSource) envContext.lookup("jdbc/oracle");
			// ds가 생성되었으므로 Connection을 구합니다.
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	// select을 수행한 후 리소스 해제를 위한 메소드
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			rs.close(); // 연결 해제 
			stmt.close(); // 문장 해제
			conn.close(); // 실행 해제
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// insert, update, delete 작업을 수행한 후 리소스 해제를 위한 메소드
	public static void close(Connection conn, Statement stmt) {
		try {
			stmt.close(); // 문장 해제 
			conn.close(); // 연결 해제
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
