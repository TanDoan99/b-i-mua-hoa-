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

@WebServlet("/EditProduct2")
@MultipartConfig
public class EditProductController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DIR_UPLOAD = "images" + File.separator + "tmp";

	public EditProductController2() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Lấy thông tin hoa muốn sửa
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));

		} catch (NumberFormatException e) {
			request.getRequestDispatcher("/PageNotFound.jsp").forward(request, response);
			return;
		}
		Product objPro = ProductDAO.getItem(id);
		if (objPro == null) {
			request.getRequestDispatcher("/PageNotFound.jsp").forward(request, response);
			return;
		}
		request.setAttribute("objPro", objPro);
		request.getRequestDispatcher("/edit2.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String tenHoa = request.getParameter("tenHoa");
		String moTa = request.getParameter("moTa");
		String giaBanString = request.getParameter("giaBan");
		if (tenHoa.equals("")) {
			request.getRequestDispatcher("/edit2.jsp?err=1").forward(request, response);
			return;
		}
		if (moTa.equals("")) {
			request.getRequestDispatcher("/edit2.jsp?err=2").forward(request, response);
			return;
		}
		String fileName = "";
		Part filePart = request.getPart("hinhAnh");
		String fileType = filePart.getContentType();// kiểm tra file hình ảnh
		fileName = filePart.getSubmittedFileName();// lấy tên thư mục gốc
		Product objPro = ProductDAO.getItem(id);
		if (fileName.equals("")) {
			fileName = objPro.getHinhAnh();
		} else {
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
				request.getRequestDispatcher("/edit2.jsp?err=3").forward(request, response);
				return;
			}
			
		}
		request.setAttribute("hinhAnh", fileName);
		if (giaBanString.equals("")) {
			request.getRequestDispatcher("/edit2.jsp?err=4").forward(request, response);
			return;
		}
		int giaBan = 0;
		try {

			giaBan = Integer.parseInt(giaBanString);

		} catch (NumberFormatException e) {
			request.getRequestDispatcher("/edit2.jsp?err=5&giaBan=0").forward(request, response);
			return;
		}
		Product objPro1 = new Product(id, tenHoa, moTa, fileName, giaBan);
		if (ProductDAO.Edititems(objPro1) > 0) {
			response.sendRedirect(request.getContextPath() + "/IndexProduct?msg=2");
			return;
		} else {
			request.getRequestDispatcher("/edit2.jsp?err=0").forward(request, response);
			return;
		}

	}

}
