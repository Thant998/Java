package usermanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usermanagement.dao.UserDAO;
import usermanagement.dto.UserRequestDTO;
import usermanagement.model.UserBean;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
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
		UserBean ub=new UserBean();
		ub.setId(request.getParameter("id"));
		ub.setName(request.getParameter("name"));
		ub.setEmail(request.getParameter("email"));
		ub.setCountry(request.getParameter("country"));
		if (ub.getId().equals("") || ub.getName().equals("") || ub.getEmail().equals("") || ub.getCountry().equals("")) {
			request.setAttribute("error", "Field cannot be blank!!!");
			request.setAttribute("bean",ub);
			request.getRequestDispatcher("userform.jsp").forward(request,response);
		}else {
			UserDAO dao=new UserDAO();
			UserRequestDTO dto=new UserRequestDTO();
			dto.setUserId(ub.getId());
			dto.setUserName(ub.getName());
			dto.setUserEmail(ub.getEmail());
			dto.setUserCountry(ub.getCountry());
			dao.insertUser(dto);
			
			response.sendRedirect("DisplayUserServlet");
		}
	}

}
