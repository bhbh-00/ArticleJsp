package board.member;

public class Member {

	private int MemberRegNum;
	private String MemberId;
	private String MemberPw;
	private String Membernickname;
	private String Memberregdate;
	
	public Member() {
		
	}

	public Member(int memberRegNum, String memberId, String memberPw, String membernickname, String memberregdate) {
		this.MemberRegNum = memberRegNum;
		this.MemberId = memberId;
		this.MemberPw = memberPw;
		this.Membernickname = membernickname;
		this.Memberregdate = memberregdate;

	}

	public int getMemberRegNum() {
		return MemberRegNum;
	}

	public void setMemberRegNum(int memberRegNum) {
		MemberRegNum = memberRegNum;
	}

	public String getMemberId() {
		return MemberId;
	}

	public void setMemberId(String memberId) {
		MemberId = memberId;
	}

	public String getMemberPw() {
		return MemberPw;
	}

	public void setMemberPw(String memberPw) {
		MemberPw = memberPw;
	}

	public String getMembernickname() {
		return Membernickname;
	}

	public void setMembernickname(String membernickname) {
		Membernickname = membernickname;
	}

	public String getMemberregdate() {
		return Memberregdate;
	}

	public void setMemberregdate(String memberregdate) {
		Memberregdate = memberregdate;
	}

}
