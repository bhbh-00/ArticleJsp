package board.member;
import java.sql.ResultSet;
import java.sql.SQLException;

import board.RowMapper;

public class MemberRowMapper implements RowMapper<Member> {
	
	@Override
	public Member getRow(ResultSet rs) throws SQLException {
		
		int MemberRegNum = rs.getInt("MemberRegNum");
		String MemberId = rs.getString("MemberId");
		String MemberPw = rs.getString("MemberPw");
		String Membernickname = rs.getString("Membernickname");
		String Memberregdate = rs.getString("Memberregdate");
		
		Member member = new Member();
		member.setMemberRegNum(MemberRegNum);
		member.setMemberId(MemberId);
		member.setMemberPw(MemberPw);
		member.setMembernickname(Membernickname);
		member.setMemberregdate(Memberregdate);
		
		return member;
	}
}
