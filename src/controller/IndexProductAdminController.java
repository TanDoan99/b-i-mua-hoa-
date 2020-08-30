package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ProductDAO;
@WebServlet("/IndexProduct")
public class IndexProductAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public IndexProductAdminController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO productDAO=new ProductDAO();
		request.setAttribute("listPro", productDAO.getItems());
		request.getRequestDispatcher("/list.jsp").forward(request, response);	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
