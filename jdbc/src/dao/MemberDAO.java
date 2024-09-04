package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import vo.MemberVO;

public class MemberDAO {
	
//	1.연결
	Connection connection;
	
//	2. 쿼리 실행
	PreparedStatement preparedStatement;
	
//	3. 결과
	ResultSet resultSet;

//  로그인 시 공용 저장소 세션(서버쪽 임시)
	public static Long session;
	
//	아이디 중복검사
	public boolean checkId(String memberId) {
		connection = DBConnecter.getConnect();
		String query = "SELECT ID FROM TBL_MEMBER "
				+ "WHERE MEMBER_ID = ?";
		boolean check = false;
		
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, memberId);
			
//			결과값이 있을 때
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			resultSet.getLong(1);
			
		} catch (SQLException e) {
//			못찾으면 오류
			check = true;
			System.out.println("checkId query 오류");
			e.printStackTrace();
		} finally {
			
			try {
				
				if(resultSet != null) {
					resultSet.close();
				}
				
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				
				if(connection != null) {
					connection.close();
				}
				
			} catch (SQLException e) {
				System.out.println("checkId query 종료시 오류");
				e.printStackTrace();
			}
		} 
		
		
		
		
		return check;
		
	}
	
	
//	회원가입
	public void join(MemberVO memberVO) {
		connection = DBConnecter.getConnect();
		String query = "INSERT INTO TBL_MEMBER"
				+ "(ID, MEMBER_ID, MEMBER_PASSWORD, MEMBER_NAME, MEMBER_ADDRESS) "
				+ "VALUES(MEMBER_SEQ.NEXTVAL, ?, ?, ?, ?)";
		
		try {
//			쿼리를 보낼 준비
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, memberVO.getMemberId());
			preparedStatement.setString(2, memberVO.getMemberPassword());
			preparedStatement.setString(3, memberVO.getMemberName());
			preparedStatement.setString(4, memberVO.getMemberAddress());
			
//			결과값이 없다.
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("join query문 오류");
			e.printStackTrace();
		} finally {
			
			try {
				
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				
				if(connection != null) {
					connection.close();
				}
				
			} catch (SQLException e) {
				System.out.println("join query 종료시 오류");
				e.printStackTrace();
			}
		}
		
	}
	
//	로그인
//	아이디, 비밀번호 -> DB 
//	결과가 있고 ID
//	15분
	public boolean login(MemberVO memberVO) {
		connection = DBConnecter.getConnect();
		String query = "SELECT ID FROM TBL_MEMBER WHERE MEMBER_ID = ? AND MEMBER_PASSWORD = ?";
		boolean check = true;
		
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, memberVO.getMemberId());
			preparedStatement.setString(2, memberVO.getMemberPassword());
			
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			session = resultSet.getLong(1);
			
		} catch (SQLException e) {
			check = false;
			System.out.println("login query 오류");
			e.printStackTrace();
		} finally {
			try {
				
				if(resultSet != null) {
					resultSet.close();
				}
				
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				
				if(connection != null) {
					connection.close();
				}
				
			} catch (SQLException e) {
				System.out.println("login query 종료시 오류");
				e.printStackTrace();
			}
		}
		
		return check;
		
	}
	
//	마이페이지
	public MemberVO findById() {
		connection = DBConnecter.getConnect();
		String query = "SELECT ID, MEMBER_ID, MEMBER_PASSWORD, MEMBER_NAME, MEMBER_ADDRESS, RECOMMENDER_ID "
				+ "FROM TBL_MEMBER WHERE ID = ?";
		
		MemberVO memberVO = new MemberVO();
		
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, session);
			
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
		
			memberVO.setId(resultSet.getLong(1));
			memberVO.setMemberId(resultSet.getString(2));
			memberVO.setMemberPassword(resultSet.getString(3));
			memberVO.setMemberName(resultSet.getString(4));
			memberVO.setMemberAddress(resultSet.getString(5));
			memberVO.setRecommenderId(resultSet.getString(6));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				
				if(resultSet != null) {
					resultSet.close();
				}
				
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				
				if(connection != null) {
					connection.close();
				}
				
			} catch (SQLException e) {
				System.out.println("findById query 종료시 오류");
				e.printStackTrace();
			}
		}
		
		return memberVO;
	}
	
	
//	로그아웃
	public void logout() {
		session = null;
	}
	
//	정보수정
//	비밀번호 변경
//	1. 비밀번호 찾기
//	2. 새로운 비밀번호 변경
//	3. 로그인 하고 나서 수정
//	회원탈퇴
//	추천수
//	나를 추천한 사람
//	내가 추천한 사람
	
	
	
	
	
	
	
	
	
}
























