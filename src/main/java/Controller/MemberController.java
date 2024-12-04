package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;

/**
 * Servlet implementation class MemberController
 */
@WebServlet({"/main","/joinfrm","/join","/login","/logout"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cmd = req.getServletPath();
		req.setCharacterEncoding("utf-8");
		System.out.println("cmd=" + cmd);
		MemberService mSer = new MemberService(req,resp);
		String path=null;
		switch(cmd) {
		case "/joinfrm":
			//회원가입 창열기
			path="joinfrm.jsp";
			break;
		case "/join":
			
			path=mSer.join(); //회원가입성공 : loginfrm.jsp, 실패 : joinfrm.jsp
			//db에 회원가입하기
			break;
		case "/loginfrm":
			MemberService m = new MemberService(req,resp);
			path="loginfrm.jsp";
			break;
			case "/login":
				path=mSer.login();
				break;
		}
		
		 
		req.getRequestDispatcher(path).forward(req, resp);
	}

}
