package board.article;

import java.util.ArrayList;

import board.DBUtil2;

public class ArticleDao {

	private DBUtil2 db = new DBUtil2();

	// 여러개 가져올 때 -> getRows
	// 한개 가져올 때(KEY로 가져올 때) -> getRow
	// 추가,수정,삭제시 가져올 때 -> updateQuery

	// 전체조회
	public ArrayList<Article> getArticles() {
		String sql = "SELECT a.*, Membernickname nickname FROM article a INNER JOIN `member` m ON a.MRegNum = MemberRegNum";
		return db.getRows(sql, new ArticleRowMapper()); // 조회가 필요한 것
	}

	// 게시물 수정
	public int updateArticle(String title, String body, int aid) {
		String sql = "update article set title = ?, body = ? where ArticleNum = ?";
		return db.updateQuery(sql, title, body, aid); // 추가,수정,삭제가 필요한 것
	}

	// 게시물 삭제
	public int deleteArticle(int aid) {
		String sql = "delete from article where ArticleNum = ?";
		return db.updateQuery(sql, aid);
	}

	// 게시물 추가
	public int insertArticle(String title, String body, int mid) {
		String sql = "insert into article set title = ?, body = ?, MRegNum = ?, regDate = NOW(), hit = 0, likecnt = 0";
		return db.updateQuery(sql, title, body, mid);
	}

//	// 게시물 댓글추가 기능
//	public int insertReply(int parentId, String replybody) {
//		String sql = "insert into reply set parentId = ?, replybody = ?, replynickname = '익명', replyregdate = NOW()";
//		return db.updateQuery(sql, parentId, replybody);
//	}

	// 댓글 불러오기
	public ArrayList<Reply> getRepliesByArticleId(int aid) {
		String sql = "SELECT * FROM reply r INNER JOIN `member` m ON r.parentId = m.MemberRegNum WHERE parentId = ?";
		return db.getRows(sql, new ReplyRowMapper(), aid);
	}

	// 댓글 삭제
	public ArrayList<Reply> deleteReply(int parentId) {
		String sql = "delete from reply where parentId = ?";
		return db.getRows(sql, new ReplyRowMapper(), parentId);
	}

	public Article getArticleById(int ArticleNum) {
		String sql = "SELECT a.*, Membernickname nickname, count(ArticleNum) FROM article a INNER JOIN `member` m ON a.MRegNum = MemberRegNum WHERE a.ArticleNum = ?";
		return db.getRow(sql, new ArticleRowMapper(), ArticleNum);
	}

	public Article searchArticleBytitle(String title, String body) {
		String sql = "select * from article where title like concat_ws('%', '?', '%')";
		return db.getRow(sql, new ArticleRowMapper(), title, body);
	}

	// 조회수 up!!
	public int increaseHitByArticle(int id) {
		String sql = "UPDATE article SET hit = hit + 1 WHERE ArticleNum = ?";
		return db.updateQuery(sql, id);
	}

	// 검색기능 1. 제목, 2. 내용, 3. 제목 + 내용, 4. 작성자
	public ArrayList<Article> getsearchedArticle(int flag, String keyword) {
		String sql1 = "SELECT a.*, Membernickname nickname FROM article a INNER JOIN `member` m ON a.MRegNum = MemberRegNum WHERE ";
		String sql2 = "";

		if (flag == 1) {
			sql2 = "title LIKE CONCAT_WS(?, '%', '%')";
		} else if (flag == 2) {
			sql2 = "body LIKE CONCAT_WS(?, '%', '%')";
		} else {
			sql2 = "m.Membernickname LIKE CONCAT_WS(?, '%', '%')";
		}

		/*
		 * 제목 + 내용은 잠시 보류 else if (flag == 3) { sql2 =
		 * "title LIKE CONCAT_WS(?, '%', '%') or body LIKE CONCAT_WS(?, '%', '%')"; }
		 */

		String sql = sql1 + sql2;

		return db.getRows(sql, new ArticleRowMapper(), flag, keyword);
	}

	public ArrayList<Article> getsortArticle(int sortFlag, int sortType) {
		String sql1 = "SELECT a.*, Membernickname nickname FROM article a INNER JOIN `member` m ON a.MRegNum = MemberRegNum order by ";
		String sql2 = sortFlag + " " + sortType;

		String sql = sql1 + sql2;

		return db.getRows(sql, new ArticleRowMapper());
	}

	public Like getLike(int aid, int mid) {

		String sql = "SELECT * FROM `Like` WHERE ArticleNum = ? AND MemberRegNum = ?";

		return db.getRow(sql, new LikeRowMapper(), aid, mid);
	}

	public void deleteLike(int aid, int mid) {

		String sql = "delete FROM `Like` WHERE ArticleNum = ? AND MemberRegNum = ?";

		db.updateQuery(sql, aid, mid);
	}

	public void insertLike(int aid, int mid) {

		String sql = "insert into `Like` set WHERE ArticleNum = ? , MemberRegNum = ?, regdate = now()";

		db.updateQuery(sql, aid, mid);
	}

	// ====================jsp

	public void deleteReplyById(int id) {
		String sql = "delete FROM reply where replyId = ? ";

		db.updateQuery(sql, id);
	}

	public void updateReply(String rbody, int rid) {
		String sql = "update reply set replybody = ? where replyId = ?";

		db.updateQuery(sql, rbody, rid);
	}

	// 게시물 댓글추가 기능2 - jps
	public void insertReply(int parentId, String replybody, int mid) {
		String sql = "insert into reply set parentId = ?, replybody = ?, `mId` = ?, replyregdate = NOW()";
		db.updateQuery(sql, parentId, replybody, mid);
	}
	
	// jsp 검색
	public ArrayList<Article> searchArticle(int date, String target, String keyword) {
		
		String dateInterval = "";
		if(date == 2) {
			dateInterval = "-1 year";
		} else if(date == 3) {
			dateInterval = "-1 week";
		}
		
		String sql = "SELECT * FROM article WHERE regdate > DATE_ADD(NOW(),  INTERVAL" + date + " ) AND " + target + " LIKE CONCAT_WS(" + keyword + ", '%', '%')" ;
		// 문자열 아닌 것은 ? 사용금지
		return db.getRows(sql, new ArticleRowMapper(), keyword);
	}

}
