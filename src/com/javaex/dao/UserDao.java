package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.javaex.vo.UserVo;

public class UserDao {

	public int insert(UserVo vo) {

		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 1.jbdc 드라이브 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			System.out.println("접속성공");

			// 3.SQLE 테스트문
			String query = "insert into users\r\n" + "values (seq_users_no.nextval,?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPassword());
			pstmt.setString(4, vo.getGender());

			count = pstmt.executeUpdate();

			// 바인딩을 안줘도 된다.
			// rs.next() =안에 있는 내용을 한칸씩 밀어 주어라
			// 4.결과처리
			System.out.println(count + "건 등록");

		} catch (ClassNotFoundException e) {
			System.out.println("error:드라이벌딩 실패." + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);

			}

		}

		return count;
	}

	public UserVo getUser(String email, String password) {// UserVo를 되 돌린다.

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVo vo = null;

		try {
			// 1.jbdc 드라이브 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			System.out.println("접속성공");

			// 3.SQLE 테스트문
			String query = "select no,name " + "from users " + "where email=? " + "and password=? ";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();

			// 바인딩을 안줘도 된다.
			// rs.next() =안에 있는 내용을 한칸씩 밀어 주어라
			// 4.결과처리

			while (rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");

				vo = new UserVo();
				vo.setNo(no);
				vo.setName(name);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("error:드라이벌딩 실패." + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);

			}

		}

		return vo;

	}
	
	
	

	public UserVo getUser(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVo vo = null;

		try {
			// 1.jbdc 드라이브 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			System.out.println("접속성공");

			// 3.SQLE 테스트문
			String query = "select no,name,email,gender " + "from users " + "where no=? ";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);

			rs = pstmt.executeQuery();

			// 바인딩을 안줘도 된다.
			// rs.next() =안에 있는 내용을 한칸씩 밀어 주어라
			// 4.결과처리

			while (rs.next()) {
				no = rs.getInt("no");
				String name = rs.getString("name");
				String email=rs.getString("email");
				String gender=rs.getString("gender");

				vo = new UserVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setEmail(email);
				vo.setGender(gender);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("error:드라이벌딩 실패." + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);

			}

		}

		return vo;

	}

}// joinform에서 <input type="text name="a" values="join" /> 는 뒤에 붙는 주석을 숨기기 위한 값
	// 42번라인
