package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginFormHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		return "/WEB-INF/view/member/loginForm.jsp";
	}

}
