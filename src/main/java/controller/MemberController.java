package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Forward;
import service.MemberService;

// "/" default servlet 정적리소스 사용하기 위함.
@WebServlet({ "/main", "/joinfrm", "/join", "/loginfrm", "/login", "/logout" })
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String cmd = req.getServletPath();
		System.out.println("cmd=" + cmd);
		//String path = null;

		MemberService mSer = new MemberService(req, resp);
		
		Forward fw = null;
		fw = new Forward();
		switch (cmd) {
		case "/joinfrm":
			// 회원가입 창열기전에 인증확인
			fw=new Forward();
			fw.setPath("joinfrm.jsp");
			fw.setRedirect(false);
			//path = "joinfrm.jsp";
			break;
		case "/join":
			// db에 회원가입하기
			fw = mSer.join(); // 회원가입 성공 : loginfrm.jsp, 실패 : joinfrm.jsp
			//path = mSer.join();
			break;
		case "/loginfrm":
			fw=new Forward();
			fw.setPath("loginfrm.jsp");
			fw.setRedirect(false);
			//path = "loginfrm.jsp";
			break;
		case "/login":
			fw = mSer.login();
			//path = mSer.login();
			break;
		}
		if(fw!=null) {
			if(fw.isRedirect()) {
				resp.sendRedirect(fw.getPath());
			}else {
				req.getRequestDispatcher(fw.getPath()).forward(req, resp);
			}
		}
		// 포워딩
		//req.getRequestDispatcher(path).forward(req, resp);
		//req.sendRedirect(path); --> 새로운 요청
	}
}
