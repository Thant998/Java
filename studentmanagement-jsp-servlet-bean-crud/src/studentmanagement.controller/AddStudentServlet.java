package studentmanagement.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import studentmanagement.model.StudentBean;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentBean sb=new StudentBean();
		sb.setId(request.getParameter("id"));
		sb.setName(request.getParameter("name"));
		sb.setDob(request.getParameter("birthday"));
		sb.setSubjects(request.getParameter("course"));
		if (sb.getId().equals("") || sb.getName().equals("") || sb.getDob().equals("") || sb.getSubjects().equals("")) {
			request.setAttribute("error","Fill the blank!!!");
			request.setAttribute("bean",sb);
			request.getRequestDispatcher("addStudent.jsp").forward(request,response);
		}else {
			List<StudentBean> list=(List<StudentBean>) request.getServletContext().getAttribute("list");
			if (list==null) {
				list=new ArrayList<>();
			}
			list.add(sb);
			request.getServletContext().setAttribute("list",list);
			request.getRequestDispatcher("displaystudent.jsp").forward(request,response);
			
		}
		}
}
