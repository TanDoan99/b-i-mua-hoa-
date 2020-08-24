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

@WebServlet("/EditProduct")
@MultipartConfig
public class EditProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DIR_UPLOAD = "images" + File.separator + "tmp";

	public EditProductController() {
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
		request.getRequestDispatcher("/edit.jsp").forward(request, response);
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

		Product objPro1 = ProductDAO.getItem(id);// Lấy đối tượng Hoa muốn sửa
		String hinhAnh = objPro1.getHinhAnh();// Lấy lại ảnh cũ

		request.setAttribute("tenHoa", tenHoa);
		request.setAttribute("moTa", moTa);
		if (tenHoa.equals("")) {
			request.setAttribute("err", "Vui lòng nhập tên hoa!!!");
			request.getRequestDispatcher("/edit.jsp").forward(request, response);
			return;
		}
		if (moTa.equals("")) {
			request.setAttribute("err", "Vui lòng nhập thông tin mô tả!!!");
			request.getRequestDispatcher("/edit.jsp").forward(request, response);
			return;
		}
		if (giaBanString.equals("")) {
			request.setAttribute("err", "Vui lòng nhập thông tin giá bán!!!");
			request.getRequestDispatcher("/edit.jsp").forward(request, response);
			return;
		}
		int giaBan = 0;
		try {
			giaBan = Integer.parseInt(giaBanString);
		} catch (NumberFormatException e) {
			request.setAttribute("err", "Vui lòng nhập thông tin giá bán là số!!!");
			request.getRequestDispatcher("/edit.jsp").forward(request, response);
			return;
		}
		request.setAttribute("giaBan", giaBan);
		String fileName = "";

		Part filePart = request.getPart("hinhAnh");
		String fileType = filePart.getContentType();//kiểm tra file hình ảnh
		fileName = filePart.getSubmittedFileName();// lấy tên thư mục gốc
		try {
//			if (!fileName.endsWith(".jpg") && !fileName.endsWith(".png") && !fileName.endsWith(".jpeg")
//					&& !fileName.endsWith(".gif")&&!fileName.endsWith(".ico")) {
//				throw new Exception();
//			}
			if(!fileType.startsWith("image")) {
				throw new Exception();
			}
			String contextRoot = request.getServletContext().getRealPath("");
			String dirUpload = contextRoot + DIR_UPLOAD;
			File saveDir = new File(dirUpload);
			if (!saveDir.exists()) {
				saveDir.mkdir();
			}
			String firstName = fileName.split("\\.")[0];
			String lastName = fileName.split("\\.")[1];
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmss");
			String fname = sdf.format(date);
			fileName = firstName + "_" + fname + "." + lastName;
//			System.out.println(fileName);
			String filePath = dirUpload + File.separator + fileName;
//			System.out.println(filePath);
			filePart.write(filePath);
		} catch (Exception e) {
			request.setAttribute("err", "Vui lòng chọn file hình ảnh!!!");
			request.getRequestDispatcher("/edit.jsp").forward(request, response);
			return;
		}
		Product objPro = new Product(id, tenHoa, moTa, fileName, giaBan);
		if (ProductDAO.Edititems(objPro) > 0) {
			response.sendRedirect(request.getContextPath() + "/IndexProduct?msg=2");
			return;
		} else {
			request.setAttribute("hinhAnh", hinhAnh);
			request.setAttribute("err", "Sửa sản phẩm thất bại!");
			request.getRequestDispatcher("/edit.jsp").forward(request, response);
			return;
		}

	}

}
