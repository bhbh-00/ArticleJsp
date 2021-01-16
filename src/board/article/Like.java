package board.article;

public class Like {
	
	private int ArticleNum; // 게시물번호
	private int MemberRegNum; // 회원번호
	private String regdate;
	
	public Like() {
		
	}
		
	public Like(int articleNum, int memberRegNum, String regdate) {
		this.ArticleNum = articleNum;
		this.MemberRegNum = memberRegNum;
		this.regdate = regdate;
	}
	
	public int getArticleNum() {
		return ArticleNum;
	}
	public void setArticleNum(int articleNum) {
		ArticleNum = articleNum;
	}
	public int getMemberRegNum() {
		return MemberRegNum;
	}
	public void setMemberRegNum(int memberRegNum) {
		MemberRegNum = memberRegNum;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
	

}
