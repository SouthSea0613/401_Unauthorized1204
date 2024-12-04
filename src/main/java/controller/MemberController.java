package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;

// "/" default servlet 정적리소스 사용하기 위함.
@WebServlet({"/main","/joinfrm","/join","/login","/logout"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  @Override
protected void service(HttpServletRequest req, 
		HttpServletResponse resp) 
				throws ServletException, IOException {
	  String cmd = req.getServletPath();
	  System.out.println("cmd="+cmd);
	  String path=null;
	  switch (cmd) {
	case "/joinfrm": 
		//회원가입 창열기전에 인증확인
		path="joinfrm.jsp";
		break;
		
	case "/join":
		//db에 회원가입하기
		MemberService mSer = new MemberService(req, resp);
		mSer.join();  //회원가입 성공 : loginfrm.jsp, 실패 : joinfrm.jsp
		break;

	}
	  
	  //포워딩
	  req.getRequestDispatcher(path).forward(req, resp);
  }
}
