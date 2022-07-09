package net.javaguides.usermanagement.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import net.javaguide.usermanagement.dao.UserDao;
import net.javaguides.usermanagement.model.User;
/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userdao;

    public void init() {
    	userdao= new UserDao();
    }   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 String action = request.getServletPath();
		 try {
	            switch (action) {
	                case "/new":
	                    showNewForm(request, response);
	                    break;
	                case "/insert":
	                    insertUser(request, response);
	                    break;
	                case "/delete":
	                    deleteUser(request, response);
	                    break;
	                case "/edit":
	                    showEditForm(request, response);
	                    break;
	                case "/update":
	                    updateUser(request, response);
	                    break;
	                default:
	                    listUser(request, response);
	                    break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        } 
	}
	 private void listUser(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException, ServletException {
			        List < User > listUser = userdao.selectAllUser();
			        request.setAttribute("listUser", listUser);
			        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
			        dispatcher.forward(request, response);
			    }

			    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException {
			        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
			        dispatcher.forward(request, response);
			    }

			    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, ServletException, IOException {
			        int id = Integer.parseInt(request.getParameter("id"));
			        User existingUser = userdao.selectUser(id);
			        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
			        request.setAttribute("user", existingUser);
			        dispatcher.forward(request, response);

			    }

			    private void insertUser(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        String name = request.getParameter("name");
			        String email = request.getParameter("email");
			        String country = request.getParameter("country");
			        User newUser = new User(name, email, country);
			        userdao.insertUser(newUser);
			        response.sendRedirect("list");
			    }

			    private void updateUser(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        int id = Integer.parseInt(request.getParameter("id"));
			        String name = request.getParameter("name");
			        String email = request.getParameter("email");
			        String country = request.getParameter("country");

			        User book = new User(id, name, email, country);
			        userdao.updateUser(book);
			        response.sendRedirect("list");
			    }

			    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        int id = Integer.parseInt(request.getParameter("id"));
			        userdao.deleteUser(id);
			        response.sendRedirect("list");

			    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
