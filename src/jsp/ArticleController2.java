package jsp;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.article.Article;
import board.article.ArticleDao;
import board.article.Like;
import board.article.Reply;
import board.member.Member;

public class ArticleController2 {

	ArticleDao Adao = new ArticleDao();

	String doAction(HttpServletRequest request, HttpServletResponse response) {

		String action = request.getParameter("action");
		String dest = "";

		// 파일찾는 단축키 ctrl+shift+r

		if (action.equals("list")) {

			dest = List(request, response);

		} else if (action.equals("insert")) {

			dest = insert(request, response);

		} else if (action.equals("update")) {

			dest = update(request, response);

		} else if (action.equals("delete")) {

			dest = delete(request, response);

		} else if (action.equals("detail")) {

			dest = detail(request, response);

		} else if (action.equals("showAdd")) {
			// session에 저장했기 때문에 따로 설정? 하지 않아도 됌
			dest = "WEB-INF/jsp/addForm.jsp";

		} else if (action.equals("showUpdate")) {

			dest = showUpdate(request, response);

		} else if (action.equals("doDeleteReply")) {

			dest = deleteReply(request, response);

		} else if (action.equals("doInsertReply")) {

			dest = insertReply(request, response);

		} else if (action.equals("showReplyUpdate")) {

			dest = showReplyUpdate(request, response);

		} else if (action.equals("doDeleteReply")) {

			dest = deleteReply(request, response);

		} else if (action.equals("doUpdateReply")) {

			dest = updateReply(request, response);

		} else if (action.equals("doSearch")) {

			dest = doSearch(request, response);

		} else if(action.equals("doLike")) {
			dest = doLike(request, response);
		}
		
		
		return dest;
	}

	

	public String List(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Article> articles = Adao.getArticles();
		request.setAttribute("mydate", articles);
		return "WEB-INF/jsp/list.jsp";
	}

	private String insert(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String body = request.getParameter("body");

		int id = Integer.parseInt(request.getParameter("id"));

		// loginedMember는 계속 따라다녀야함 -> 그렇지않으면 게시물을 추가하면 사라짐
		// request는 if문 안에서 한번 타고 끝나면 정보가 사라짐
		// 해결 방법 -> request가 아닌 session저장소를 이용
		// session는 클라이언트 1명당 1개를 지급 -> 클라이언트가 바뀔 때만 새로 -> 바뀌지않으면 계속 유지
		// 로그인 정보는 session에 저장

		Adao.insertArticle(title, body, id);

		return List(request, response);
	}

	private String update(HttpServletRequest request, HttpServletResponse response) {
		int aid = Integer.parseInt(request.getParameter("aid"));

		String title = request.getParameter("title");
		String body = request.getParameter("body");

		Adao.updateArticle(title, body, aid);

		return detail(request, response);
	}

	private String detail(HttpServletRequest request, HttpServletResponse response) {
		
		// 흐름을 잘 파악할 것
		int aid = Integer.parseInt(request.getParameter("aid"));
		String flag = request.getParameter("flag");
		
		Article article = Adao.getArticleById(aid);
		ArrayList<Reply> replies = Adao.getRepliesByArticleId(aid);
		
		if(flag != null) {
			
			int rid = Integer.parseInt(request.getParameter("rid"));
			
			request.setAttribute("flag", flag);
			request.setAttribute("rid", rid);
		}

		request.setAttribute("mydate2", article);
		request.setAttribute("replies", replies);

		return "WEB-INF/jsp/detail.jsp";
	}

	private String delete(HttpServletRequest request, HttpServletResponse response) {

		int aid = Integer.parseInt(request.getParameter("aid"));

		Adao.deleteArticle(aid);

		return List(request, response);
	}

	private String showUpdate(HttpServletRequest request, HttpServletResponse response) {

		int aid = Integer.parseInt(request.getParameter("aid"));

		Article article = Adao.getArticleById(aid);

		request.setAttribute("mydate3", article);

		return "WEB-INF/jsp/updateForm.jsp";
	}
	
	// =======================검색
	private String doSearch(HttpServletRequest request, HttpServletResponse response) {
		
		int dateInterval = Integer.parseInt(request.getParameter("dateInterval"));
		String Target = request.getParameter("Target");
		String keyword = request.getParameter("keyword");
		
		ArrayList<Article> searcharticle = Adao.searchArticle(dateInterval, Target, keyword);
		request.setAttribute("mydate", searcharticle);
		
		return "WEB-INF/jsp/list.jsp";
	}
	// =======================댓글
	private String insertReply(HttpServletRequest request, HttpServletResponse response) {
		
		int aid = Integer.parseInt(request.getParameter("aid"));
		String rbody = request.getParameter("rbody");
		int mid = Integer.parseInt(request.getParameter("mid"));
		
		Adao.insertReply(aid, rbody, mid);
		
		// 리다이렉팅
		return "redirect: /board/article?action=detail&aid=" + aid;
	}
	
	private String deleteReply(HttpServletRequest request, HttpServletResponse response) {
		
		int rid = Integer.parseInt(request.getParameter("rid"));
		int aid = Integer.parseInt(request.getParameter("aid"));
		
		Adao.deleteReplyById(rid);

		return "redirect: /board/article?action=detail&aid=" + aid;
	}
	
	private String updateReply(HttpServletRequest request, HttpServletResponse response) {
		
		int aid = Integer.parseInt(request.getParameter("aid"));
		int rid = Integer.parseInt(request.getParameter("rid"));
		String rbody = request.getParameter("rbody");
		
		Adao.updateReply(rbody, rid);

		return "redirect: /board/article?action=detail&aid=" + aid;
	}
	
	private String showReplyUpdate(HttpServletRequest request, HttpServletResponse response) {
		
		int aid = Integer.parseInt(request.getParameter("aid"));
		int rid = Integer.parseInt(request.getParameter("rid"));

		return "redirect: /board/article?action=detail&aid=" + aid + "&flag=u&rid=" + rid;
	}
	
	// =============== 좋아요
	private String doLike(HttpServletRequest request, HttpServletResponse response) {
		
		int aid = Integer.parseInt(request.getParameter("aid"));
		HttpSession session = request.getSession();
		int mid = ((Member)session.getAttribute("loginedMember")).getMemberRegNum();
		
		Like likes = Adao.getLike(aid, mid);
		
		if(likes == null) {
			
		} 
		
		return "redirect: /board/article?action=detail&aid=" + aid;
	}
}
