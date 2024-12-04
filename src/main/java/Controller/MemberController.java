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
		System.out.println("cmd=" + cmd);
		String path=null;
		switch(cmd) {
		case "/joinfrm":
			//회원가입 창열기
			path="joinfrm.jsp";
			break;
		case "/join":
			MemberService mSer = new MemberService();
			path=mSer.join(); //회원가입성공 : loginfrm.jsp, 실패 : joinfrm.jsp
			//db에 회원가입하기
			break;
		}
		 
		req.getRequestDispatcher(path).forward(req, resp);
	}

}
