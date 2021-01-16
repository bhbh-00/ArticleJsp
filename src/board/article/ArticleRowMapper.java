package board.article;
import java.sql.ResultSet;
import java.sql.SQLException;

import board.RowMapper;

public class ArticleRowMapper implements RowMapper<Article>{
	
	@Override
	public Article getRow(ResultSet rs) throws SQLException {
		
		int ArticleNum = rs.getInt("ArticleNum");
		String title = rs.getString("title");
		String body = rs.getString("body");
		String nickname = rs.getString("nickname");
		int hit = rs.getInt("hit");
		String regdate = rs.getString("regdate");
		int likeCnt = rs.getInt("likeCnt");
		
		Article article = new Article();
		article.setArticleNum(ArticleNum);
		article.setTitle(title);
		article.setBody(body);
		article.setNickname(nickname);
		article.setHit(hit);
		article.setRegdate(regdate);
		article.setLikeCnt(likeCnt);
		
		return article;
	}
	
}
