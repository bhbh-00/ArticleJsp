package board;

public class Test {
//	System.out.print("상세보기할 게시물 번호 : ");
//	int aid = Integer.parseInt(sc.nextLine());
//
//	Article article = articleDao.getArticleById(aid);
//
//	if (article == null) {
//		System.out.println("없는 게시물입니다.");
//	} else {
//		ArrayList<Reply> replies = articleDao.getRepliesByArticleId(article.getId());
//		printArticle(article, replies);
//
//		while (true) {
//			System.out.print("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 좋아요, 3. 수정, 4. 삭제, 5. 목록으로) : ");
//			int dcmd = Integer.parseInt(sc.nextLine());
//			if (dcmd == 1) {
//				System.out.print("내용을 입력해주세요 :");
//				String body = sc.nextLine();
//				articleDao.insertReply(article.getId(), body);
//				ArrayList<Reply> replies2 = articleDao.getRepliesByArticleId(article.getId());
//				printArticle(article, replies2);
//			} else {
//				break;
//			}
//		}
//	}
	
	/*
	 * public ArrayList<Reply> getRepliesByArticleId(int id) {
		String sql = "select * from reply where aid = ?";
		return db.getRows(sql, new ReplyRowMapper(), id);
	}*/
	
	/*
	 * 	public Article getArticleById(int aid) {
		String sql = "select * from article where id = ?";
		return db.getRow(sql, new ArticleRowMapper(), aid);
	}
	*/
}
