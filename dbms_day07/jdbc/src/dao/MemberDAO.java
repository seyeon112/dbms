package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.MemberVO;

public class MemberDAO {
	
//	1. 연결 
	Connection connection;
//	2. 쿼리실행
	PreparedStatement preparedStatement;
//	3. 결과
	ResultSet resultSet;

//	회원가입
	public void join(MemberVO memberVO) {
		connection = DBConnecter.getConnect();
		String qeury = "INSERT INTO TBL_MEMBER"
				+ "(ID, MEMBER_ID, MEMBER_PASSWORD, MEMBER_NAME, MEMBER_ADDRESS) "
				+ "VALUES(MEMBER_SEQ.NEXTVAL, ?, ?, ?, ?);";
		
//		쿼리
		try {
//			쿼리문 완성
			preparedStatement = connection.prepareStatement(qeury);
			preparedStatement.setString(1, memberVO.getMemberId());
			preparedStatement.setString(2, memberVO.getMemberPassword());
			preparedStatement.setString(3, memberVO.getMemberName());
			preparedStatement.setString(4, memberVO.getMemberAddress());

//			결과값이 없는 것
			preparedStatement.executeUpdate();
			
//			결과값이 있는 것
//			preparedStatement.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
}




















