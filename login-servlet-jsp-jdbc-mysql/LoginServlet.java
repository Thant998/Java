package net.javaguide.login.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.javaguide.loginbean.LoginBean;
import net.javaguide.database.LoginDao;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;

    public void init() {
        loginDao = new LoginDao();
    }   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		// TODO Auto-generated method stub
		 String username = request.getParameter("username");
	     String password = request.getParameter("password");
	     LoginBean loginBean = new LoginBean();
	     loginBean.setUserName(username);
	     loginBean.setPassword(password);
	     doGet(request, response);
		 try {
	            if (loginDao.validate(loginBean)) {
	                //HttpSession session = request.getSession();
	                // session.setAttribute("username",username);
	                response.sendRedirect("loginsuccess.jsp");
	            } else {
	                response.sendRedirect("login.jsp");
	            }
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	}


