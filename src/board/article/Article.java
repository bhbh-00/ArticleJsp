package board.article;

public class Article {
	
	private int ArticleNum;
	private String title;
	private String body;
	private String nickname;
	private int hit;
	private String regdate;
	private int likeCnt;
	
	public Article() {
		
	}
	
	
	public Article(int articleNum, String title, String body, String nickname, int hit, String regdate, int likeCnt) {

		this.ArticleNum = articleNum;
		this.title = title;
		this.body = body;
		this.nickname = nickname;
		this.hit = hit;
		this.regdate = regdate;
		this.likeCnt = likeCnt;
	}


	public int getArticleNum() {
		return ArticleNum;
	}


	public void setArticleNum(int articleNum) {
		ArticleNum = articleNum;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public int getHit() {
		return hit;
	}


	public void setHit(int hit) {
		this.hit = hit;
	}


	public String getRegdate() {
		return regdate;
	}


	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}


	public int getLikeCnt() {
		return likeCnt;
	}


	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}
}
