package vo;

import java.util.Objects;

public class MemberVO {
//	1. 필드 구성 (DB의 테이블을 컬럼 기준으로)
//	2. private 붙이기
//	alt + shift + a
	private Long id;
	private String memberId;
	private String memberPassword;
	private String memberName;
	private String memberAddress;
	private String recommenderId;
	
//	3. 기본생성자
//	ctrl + space
	public MemberVO() {;}

//	4. 초기화생성자
//	alt + shift + s -> o
	public MemberVO(Long id, String memberId, String memberPassword, String memberName, String memberAddress,
			String recommenderId) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberAddress = memberAddress;
		this.recommenderId = recommenderId;
	}

//	5. getter, setter
//	alt + shift + s -> r -> alt + a -> r
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getMemberPassword() {
		return memberPassword;
	}


	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public String getMemberAddress() {
		return memberAddress;
	}


	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}


	public String getRecommenderId() {
		return recommenderId;
	}


	public void setRecommenderId(String recommenderId) {
		this.recommenderId = recommenderId;
	}

//	6. toString 재정의
//	alt + shift + s -> s
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", memberId=" + memberId + ", memberPassword=" + memberPassword + ", memberName="
				+ memberName + ", memberAddress=" + memberAddress + ", recommenderId=" + recommenderId + "]";
	}


//	7. hash equals 재정의
//	alt + shift + s -> h
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberVO other = (MemberVO) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	
	
	
}
