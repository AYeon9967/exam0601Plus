package exam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exam.service.Service;

public class LoginController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String position = request.getParameter("position");
		String path = null;
		
		if(id.isEmpty() || pwd.isEmpty() || position.isEmpty()) {
			request.setAttribute("error", "Please put all blanks!");
			HttpUtil.forward(request, response, "/index.jsp");
			return;
		}
		
		Service s = Service.getInstance();
		boolean result = s.login(id, pwd, position);
		
		if(result) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			if(position.equals("student")) {
				path = "/sMenu.jsp";
			} else {
				path = "/pMenu.jsp";
			}
		} else {
			path = "/index.jsp";
		}
		HttpUtil.forward(request, response, path);

	}

}
