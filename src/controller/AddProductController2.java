package controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.bean.Product;
import model.dao.ProductDAO;

@WebServlet("/AddProduct2")
@MultipartConfig
public class AddProductController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DIR_UPLOAD = "images" + File.separator + "tmp";

	public AddProductController2() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/add2.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String tenHoa = request.getParameter("tenHoa");
		String moTa = request.getParameter("moTa");
		String giaBanString = request.getParameter("giaBan");
		String fileName = "";
		Part filePart = request.getPart("hinhAnh");
		fileName = filePart.getSubmittedFileName();// lấy tên thư mục gốc
		String fileType  = filePart.getContentType();
		try {
			if (!fileType.startsWith("image")) {
				throw new Exception();
			}
			String contextRoot = request.getServletContext().getRealPath("");
			String dirUpload = contextRoot + DIR_UPLOAD;
			File saveDir = new File(dirUpload);
			if (!saveDir.exists()) {
				saveDir.mkdir();
			}

			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmss");
			String fname = sdf.format(date);
			String firstName = fileName.split("\\.")[0];
			String lastName = fileName.split("\\.")[1];
			fileName = firstName + "_" + fname + "." + lastName;
			String filePath = dirUpload + File.separator + fileName;
			filePart.write(filePath);
		} catch (Exception e) {
			request.getRequestDispatcher("/add2.jsp?err=4").forward(request, response);
			return;
		}
		request.setAttribute("hinhAnh", fileName);
		if (tenHoa.equals("")) {
			request.getRequestDispatcher("/add2.jsp?err=1").forward(request, response);
			return;
		}
		if (moTa.equals("")) {
			request.getRequestDispatcher("/add2.jsp?err=2").forward(request, response);
			return;
		}

		if (giaBanString.equals("")) {
			request.getRequestDispatcher("/add2.jsp?err=5").forward(request, response);
			return;
		}
		int giaBan = 0;
		try {
			giaBan = Integer.parseInt(giaBanString);

		} catch (NumberFormatException e) {
			request.getRequestDispatcher("/add2.jsp?err=6&giaBan=0").forward(request, response);
			return;
		}
		Product objAdd = new Product(0, tenHoa, moTa, fileName, giaBan);
		if (ProductDAO.additems(objAdd) > 0) {
			response.sendRedirect(request.getContextPath() + "/IndexProduct?msg=1");
			return;
		} else {
			request.getRequestDispatcher("/add2.jsp?err=0").forward(request, response);
			return;
		}

	}

}
