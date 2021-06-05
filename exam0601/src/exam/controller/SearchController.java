package exam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exam.service.Service;
import exam.vo.Subject;

// 학생: 과목검색
public class SearchController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String s = null;
		String id = request.getParameter("id");
		
		if(id.isEmpty()) {
			request.setAttribute("error", "Insert ID");
			HttpUtil.forward(request, response, "/subjectSearch.jsp");
			return;
		}
		
		Subject subject = Service.getInstance().search(id);
		if(subject == null) {
			//request.setAttribute("result", "No Subject!!!");
			s = "No";
		} else {
			s = "Yes";
		}
		request.setAttribute("subject", subject);
		request.setAttribute("s", s);
		
		HttpUtil.forward(request, response, "/subjectSearch.jsp");

	}

}
