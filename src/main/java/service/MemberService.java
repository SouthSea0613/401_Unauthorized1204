package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberService {
	HttpServletRequest req;
	HttpServletResponse resp;


	public MemberService(HttpServletRequest req,HttpServletResponse resp) {
		this.req=req;
 		this.resp=resp;
	}


	public void join() {
		// TODO Auto-generated method stub
		
	}
}