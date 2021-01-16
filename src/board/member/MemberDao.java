package board.member;

import board.DBUtil2;

public class MemberDao {
	
	/*	private int MemberRegNum;
	private String MemberId;
	private String MemberPw;
	private String Membernickname;
	private String Memberregdate;*/
	
	private DBUtil2 db = new DBUtil2();
	
	// 회원가입
	public int insertMember(String id, String pw, String nm) {
		String sql = "insert into member set MemberId = ?, MemberPw = ?, Membernickname = ? , Memberregdate = NOW()";
		return db.updateQuery(sql, id, pw, nm);
	}
	
	// 로그인
	public Member getMemberByLoginIdAndPw(String id, String pw) {
		String sql = "select * from member where MemberId = ? and MemberPw = ?";
		return db.getRow(sql, new MemberRowMapper(), id, pw);
	}

	public Member getMemberById(int id) {
		String sql = "select * from `member` where MemberRegNum = ?";
		return db.getRow(sql, new MemberRowMapper(), id);		
	}
}
