package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.JdbcUtil;
import dao.MemberDao;
import dto.Member;

public class MemberService {
	HttpServletRequest req;
	HttpServletResponse resp;


	public MemberService(HttpServletRequest req,HttpServletResponse resp) {
		this.req=req;
 		this.resp=resp;
	}


	public String join() {
		//파라미터 수집
		String username = req.getParameter("username");
		String userpw = req.getParameter("userpw");
		String irum = req.getParameter("irum");
		String gender = req.getParameter("gender");
		//데이터 뭉치기 : Dto or HashMap으로 데이터 저장
		Member member = new Member();
		member.setUsername(username);
		member.setUserpw(userpw);
		member.setIrum(irum);
		member.setGender(gender);
		//회원관리  DB 로직
		MemberDao mDao=new MemberDao();
		mDao.connect();
		mDao.setRequest(req);
		boolean result = mDao.join(member);
		mDao.close();
		if(result) {
			return "loginfrm.jsp";
		}else {
			return "joinfrm.jsp";
		}
	}
	public String login() {
	     String username = req.getParameter("username");
	      String userpw = req.getParameter("userpw");
	      MemberDao mDao = new MemberDao();
	      mDao.connect();
	      boolean result = mDao.login(username,userpw);
	      if(result) {
	    	  //서버에서 세션객체 가져오기
	      HttpSession session = req.getSession();
	      session.setAttribute("userName", username);
	      return "./main.jsp";
	      } else {
	         req.setAttribute("msg", "로그인 실패");
	         return "./loginfrm.jsp";
	      }
	      mDao.close();
//	      System.out.println(username+","+userpw);
	      return null;
	   }
}