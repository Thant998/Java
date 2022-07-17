package bookmanagement.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookmanagement.model.BookBean;

/**
 * Servlet implementation class UpdateBookServlet
 */
@WebServlet("/UpdateBookServlet")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBookServlet() {
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
		BookBean bookObj=new BookBean();
		String code=request.getParameter("code");
		bookObj.setCode(code);
		bookObj.setTitle(request.getParameter("title"));
		bookObj.setAuthor(request.getParameter("author"));
		bookObj.setPrize(request.getParameter("prize"));
		if (bookObj.getCode().equals("") || bookObj.getTitle().equals("") || bookObj.getAuthor().equals("") || bookObj.getPrize().equals("") ) {
			request.setAttribute("error","Fill the blank!!!");
			request.setAttribute("bean",bookObj);
			request.getRequestDispatcher("updateBook.jsp").forward(request,response);
		}else {
			List<BookBean> list=(List<BookBean>) request.getServletContext().getAttribute("list");
			Iterator<BookBean> itr=list.iterator();
			while (itr.hasNext()) {
				if (itr.next().getCode().equals(code)) {
					itr.remove();
				}
			}
			list.add(bookObj);
			request.getServletContext().setAttribute("list",list);
			request.getRequestDispatcher("displayBook.jsp").forward(request,response);
		}
	}
}
