package exam.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import exam.service.Service;
import exam.vo.Enroll;

public class RegistedStudentController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Service service = Service.getInstance();
		
		String num = request.getParameter("num");
		
		ArrayList<Enroll> list = service.registedStudentList(num);
		
		request.setAttribute("list", list);
		HttpUtil.forward(request, response, "/result/registedStudentListResult.jsp");

	}

}
