//package jsp;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import board.member.Member;
//import board.member.MemberDao;
//
//@WebServlet("/member")
//public class MemberController extends HttpServlet {
//
//	MemberDao Mdao = new MemberDao();
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		response.setCharacterEncoding("UTF-8");
//		// jsp에서 출력 되는 것 이기 때문에 서블릿에서 출력할 때 있어야함
//
//		String action = request.getParameter("action");
//		String dest = "";
//
//		if (action.equals("showSignup")) {
//
//			dest = "WEB-INF/jsp/signupForm.jsp";
//
//		} else if (action.equals("signup")) {
//
//			dest = signup(request, response);
//
//		} else if (action.equals("signin")) {
//
//			dest = signin(request, response);
//
//		} else if (action.equals("showSignin")) {
//
//			dest = "WEB-INF/jsp/loginForm.jsp";
//
//		} else if (action.equals("error")) {
//
//			dest = "WEB-INF/jsp/loginFailed.jsp";
//
//		}
//
//	}
//
//	public String signup(HttpServletRequest request, HttpServletResponse response) {
//
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		String nm = request.getParameter("nm");
//
//		Mdao.insertMember(id, pw, nm);
//
//		return "WEB-INF/jsp/loginForm.jsp";
//	}
//
//	public String signin(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//		String loginid = request.getParameter("loginid");
//		String loginpw = request.getParameter("loginpw");
//
//		Member loginedMember = Mdao.getMemberByLoginIdAndPw(loginid, loginpw);
//
//		if (loginedMember != null) {
//			// session 저장소에 저장하는 법
//			HttpSession session = request.getSession();
//			session.setAttribute("loginedMember", loginedMember);
//
//			return "redirect: /board/article?action=list";

//		} else {
//
//			return "redirect: /board/member?action=error";
//
//		}
//	}
//}
