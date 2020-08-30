package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ProductDAO;

@WebServlet("/DeleteProduct")
@MultipartConfig
public class DeleteProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteProductController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		int id=0;
		try {
			 id = Integer.parseInt(request.getParameter("id"));
			
		} catch (Exception e) {
			request.getRequestDispatcher("/PageNotFound.jsp").forward(request, response);
			return;
		}
		if (ProductDAO.delitems(id) > 0) {
			response.sendRedirect(request.getContextPath() + "/IndexProduct?msg=3");
			return;
		} else {
			response.sendRedirect(request.getContextPath() + "/IndexProduct?msg=0");
			return;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

	}

}
