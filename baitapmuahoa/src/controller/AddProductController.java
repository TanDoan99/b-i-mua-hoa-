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

@WebServlet("/AddProduct")
@MultipartConfig
public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DIR_UPLOAD = "images" + File.separator + "tmp";

	public AddProductController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/add.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String tenHoa = request.getParameter("tenHoa");
		String moTa = request.getParameter("moTa");
		String giaBanString = request.getParameter("giaBan");

		request.setAttribute("tenHoa", tenHoa);
		request.setAttribute("moTa", moTa);
		if (tenHoa.equals("")) {
			request.setAttribute("err", "Vui lòng nhập tên hoa!!!");
			request.getRequestDispatcher("/add.jsp").forward(request, response);
			return;
		}
		if (moTa.equals("")) {
			request.setAttribute("err", "Vui lòng nhập thông tin mô tả!!!");
			request.getRequestDispatcher("/add.jsp").forward(request, response);
			return;
		}
		String fileName = "";

		Part filePart = request.getPart("hinhAnh");
		String fileType=request.getContentType();
		fileName = filePart.getSubmittedFileName();// lấy tên thư mục gốc

		try {
			// tự làm
//			if (!fileName.endsWith(".jpg") && !fileName.endsWith(".png") && !fileName.endsWith(".jpeg")
//					&& !fileName.endsWith(".gif")) {
//				throw new Exception();
//			}
			if(fileType.startsWith("image")) {
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
			request.setAttribute("err", "Vui lòng chọn file hình ảnh!!!");
			request.getRequestDispatcher("/add.jsp").forward(request, response);
			return;
		}

		request.setAttribute("hinhAnh", fileName);
		if (giaBanString.equals("")) {
			request.setAttribute("err", "Vui lòng nhập thông tin giá bán!!!");
			request.getRequestDispatcher("/add.jsp").forward(request, response);
			return;
		}
		int giaBan = 0;
		try {
			giaBan = Integer.parseInt(request.getParameter("giaBan"));

		} catch (NumberFormatException e) {
			request.setAttribute("err", "Vui lòng nhập thông tin giá bán là số!!!");
			request.getRequestDispatcher("/add.jsp").forward(request, response);
			return;
		}
		request.setAttribute("giaBan", giaBan);
		Product objAdd = new Product(0, tenHoa, moTa, fileName, giaBan);

		if (ProductDAO.additems(objAdd) > 0) {
			response.sendRedirect(request.getContextPath()+"/IndexProduct?msg=1");
			return;
		} else {
			request.setAttribute("msg", "Thêm sản phẩm thất bại!");
			request.getRequestDispatcher("/add.jsp").forward(request, response);
			return;
		}

	}

}
