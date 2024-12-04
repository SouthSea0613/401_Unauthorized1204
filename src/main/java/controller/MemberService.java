package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberService {
	HttpServletRequest req;
	HttpServletResponse resq;
	
	public MemberService(HttpServletRequest req, HttpServletResponse resp) {
		this.req=req;
		this.resq=resp;
	}

	public String join() {

		return null;
	}
	
}
