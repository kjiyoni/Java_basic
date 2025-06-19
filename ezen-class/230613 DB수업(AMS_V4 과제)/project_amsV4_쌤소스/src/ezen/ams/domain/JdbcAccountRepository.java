package ezen.ams.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * RDB를 통해 은행계좌 목록 저장 및 관리(검색, 수정, 삭제) 구현체
 * 
 * @author 김기정
 * @author 강소영
 * @since 1.0
 */
public class JdbcAccountRepository  implements AccountRepository {
	
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String userid = "hr";
	private static String password = "hr";
		
	private Connection con;
	
	public JdbcAccountRepository() throws Exception {
		Class.forName(driver);
		con = DriverManager.getConnection(url, userid, password);
	}
	
	/**
	 * 전체 계좌 목록 수 반환
	 * @return 목록수
	 */
	public int getCount() {
		int count = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT count(*) cnt")
          .append(" FROM employees");

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (Exception e) {
			// 컴파일 예외를 런타임 예외로 변환
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
			
		}
		return count;
	}

	/**
	 * 
	 * @return 전체계좌 목록
	 */
	public List<Account> getAccounts() {
		return null;
	}
	
	/**
	 * 신규계좌 등록
	 * @param account 신규계좌
	 * @return 등록 여부
	 */
	public boolean addAccount(Account account){
		return true;
	}
	
	/**
	 * 
	 * @param accountNum 검색 계좌번호
	 * @return 검색된 계좌
	 */
	public Account searchAccount(String accountNum) {
		return null;
	}
	
	/**
	 * 
	 * @param accountOwner 검색 예금주명
	 * @return 검색된 계좌목록
	 */
	public List<Account> searchAccountByOwner(String accountOwner) {
		return null;
	}
	

	@Override
	/**
	 * 계좌번호로 계좌 삭제
	 */
	public boolean removeAccount(String accountNum) {
		
		return false;
	}
	
	
	public static void main(String[] args) throws Exception {
		
		AccountRepository accountRepository = new JdbcAccountRepository();
		int count = accountRepository.getCount();
		System.out.println(count);
		
		
		
	}
}























