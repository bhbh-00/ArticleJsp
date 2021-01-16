//package jsp;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import board.article.Article;
//import board.article.ArticleDao;
//import board.member.Member;
//import board.member.MemberDao;
//
//@WebServlet("/article")
//public class ArticleController extends HttpServlet {
//	
//	ArticleDao Adao = new ArticleDao();
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		String action = request.getParameter("action");
//
//		String dest = "";
//
//		// http://127.0.0.1:9001/board/article?action=list
//		// 파일찾는 단축키 ctrl+shift+r
//		
//		if (action.equals("list")) {
//
//			dest = List(request, response);
//
//		} else if (action.equals("insert")) {
//			
//			dest = insert(request, response);
//
//		} else if (action.equals("update")) {
//			
//			dest = update(request, response);
//
//		} else if (action.equals("delete")) {
//			
//			dest = delete(request, response);
//
//		} else if (action.equals("detail")) {
//			
//			dest = detail(request, response);
//
//		} else if (action.equals("showAdd")) {
//			// session에 저장했기 때문에 따로 설정? 하지 않아도 됌
//			dest = "WEB-INF/jsp/addForm.jsp";
//
//		} else if (action.equals("showUpdate")) {
//			
//			dest = showUpdate(request, response);
//
//		} 
//
//		// 기능 패턴 : db를 접속 -> 최종목적지 설정
//		request.setAttribute("mydate", Adao.getArticles());
//
//		RequestDispatcher rd = request.getRequestDispatcher(dest);
//		rd.forward(request, response);
//
//	}
//
//	public String List(HttpServletRequest request, HttpServletResponse response) {
//
//		return "WEB-INF/jsp/list.jsp";
//	}
//
//	public String insert(HttpServletRequest request, HttpServletResponse response) {
//		String title = request.getParameter("title");
//		String body = request.getParameter("body");
//
//		int id = Integer.parseInt(request.getParameter("id"));
//
//		// loginedMember는 계속 따라다녀야함 -> 그렇지않으면 게시물을 추가하면 사라짐
//		// request는 if문 안에서 한번 타고 끝나면 정보가 사라짐
//		// 해결 방법 -> request가 아닌 session저장소를 이용
//		// session는 클라이언트 1명당 1개를 지급 -> 클라이언트가 바뀔 때만 새로 -> 바뀌지않으면 계속 유지
//		// 로그인 정보는 session에 저장
//
//		Adao.insertArticle(title, body, id);
//
//		return List(request, response);
//	}
//
//	public String update(HttpServletRequest request, HttpServletResponse response) {
//		int aid = Integer.parseInt(request.getParameter("aid"));
//
//		String title = request.getParameter("title");
//		String body = request.getParameter("body");
//
//		Adao.updateArticle(title, body, aid);
//
//		return detail(request, response);
//	}
//
//	public String detail(HttpServletRequest request, HttpServletResponse response) {
//		// 흐름을 잘 파악할 것
//		int aid = Integer.parseInt(request.getParameter("aid"));
//
//		Article article = Adao.getArticleById(aid);
//
//		request.setAttribute("mydate2", article);
//
//		return "WEB-INF/jsp/detail.jsp";
//	}
//
//	public String delete(HttpServletRequest request, HttpServletResponse response) {
//
//		int aid = Integer.parseInt(request.getParameter("aid"));
//
//		Adao.deleteArticle(aid);
//		
//		return List(request, response);
//	}
//
//	public String showUpdate(HttpServletRequest request, HttpServletResponse response) {
//		
//		int aid = Integer.parseInt(request.getParameter("aid"));
//
//		Article article = Adao.getArticleById(aid);
//
//		request.setAttribute("mydate3", article);
//
//		return "WEB-INF/jsp/updateForm.jsp";
//	}
//	
//}
