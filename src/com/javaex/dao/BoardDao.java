package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaex.vo.BoardVo;
import com.javaex.vo.GuestbooksVo;
import com.javaex.vo.UserVo;

public class BoardDao {
	
	public int insert(BoardVo bvo) {

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
			String query = "insert into board values"
					+"(seq_no.nextval,?,?,0,sysdate, ?)";
				
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bvo.getTitle());
			pstmt.setString(2, bvo.getContent());
			pstmt.setInt(3, bvo.getNo());
			

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
	
	public List<BoardVo> select() {

		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		

		List<BoardVo> list = new ArrayList<BoardVo>();
		try {

			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 프로그램 로딩 가져옴

			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";// db주소
			conn = DriverManager.getConnection(url, "webdb", "webdb");// 정보 다 가짐
			System.out.println("접속성공");

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "select bo.no,title,name,hit,reg_Date "  
					+"from board bo,users us " 
					+"where bo.user_no=us.no";
			
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			// 4.결과처리
			while (rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String name=rs.getString("name");
				int hit = rs.getInt("hit");
				String reg_Date = rs.getString("reg_Date");
				
				BoardVo bvo = new BoardVo(no,title,name,hit,reg_Date);
				list.add(bvo);

			}
		} catch (ClassNotFoundException e) {
			System.out.println("error:드라이벌딩 실패." + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

			// 5. 자원정리
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

		return list;

	}
	

	public int update(BoardVo vo) {
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			
		//1. JDBC 드라이버 (Oracle) 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//프로그램 로딩 가져옴
		
		
		//2. Connection 얻어오기
		String url="jdbc:oracle:thin:@localhost:1521:xe";//db주소
		conn=DriverManager.getConnection(url,"webdb","webdb");//정보 다 가짐
		System.out.println("접속성공");
		
		
		//3. SQL문 준비 / 바인딩 / 실행
		String query="update board set title=?,"
				+"content=? where user_no=?";
		
		pstmt=conn.prepareStatement(query);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		pstmt.setInt(3, vo.getUser_no());
				
		pstmt.executeUpdate();//commit
		
		
		
		// 4.결과처리
		
	}catch(ClassNotFoundException e) {
		System.out.println("error:드라이벌딩 실패."+e);
	}catch(SQLException e) {
		System.out.println("error:"+e);
	}finally {
		
		
		//5. 자원정리
		try {
			if(pstmt!=null) {
				pstmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
			
		
			
		}catch(SQLException e) {
			System.out.println("error:"+e);
		}
		

	}
		return 1;
		
	}


}
