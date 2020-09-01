<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/inc/header.jsp"%>

<div class="container_12">
	<!-- Form elements -->
	<div class="grid_12">

		<div class="module">
			<h2>
				<span>Sửa sản phẩm</span>
			</h2>

			<div class="module-body">
				<form action="<%=request.getContextPath()%>/EditProduct2"
					method="post" enctype="multipart/form-data">
					<%
					String tenHoa = "";
					String moTa = "";
					String hinhAnh="";
					int giaBanString=0;
					String err = "";
					int id = Integer.parseInt(request.getParameter("id"));
					if(request.getParameter("tenHoa")!=null) tenHoa = (String) request.getParameter("tenHoa");
					if(request.getParameter("moTa")!=null) moTa = (String) request.getParameter("moTa");
					if(request.getParameter("giaBan")!=null) giaBanString = Integer.parseInt(request.getParameter("giaBan"));
					if(request.getParameter("err")!=null) err = (String) request.getParameter("err");
					
					if("0".equals(err)) out.print("<p style='color: red; font-weight: bold'>Thêm không thành công!</p>");
					if("1".equals(err)) out.print("<p style='color: red; font-weight: bold'>Vui lòng nhập tên hoa</p>");
					if("2".equals(err)) out.print("<p style='color: red; font-weight: bold'>Vui lòng nhập mô tả</p>");
					if("3".equals(err)) out.print("<p style='color: red; font-weight: bold'>Vui lòng chọn file hình ảnh</p>");
					if("4".equals(err)) out.print("<p style='color: red; font-weight: bold'>Vui lòng nhập giá bán</p>");
					if("5".equals(err)) out.print("<p style='color: red; font-weight: bold'>Vui lòng nhập giá bán là số</p>");
						Product objPro = new Product();
						if (request.getAttribute("objPro") != null) {
							objPro = (Product) request.getAttribute("objPro");
							tenHoa=objPro.getTenHoa();
							moTa=objPro.getMoTa();
							hinhAnh=objPro.getHinhAnh();
							giaBanString=objPro.getGiaBan();
							
						}
					%>
					<input type="hidden" name="id" value="<%=id%>">
					<p>
						<label>Tên hoa</label> <input type="text" class="input-medium"
							name="tenHoa" value="<%if(tenHoa!=null)out.print(tenHoa);%>" />

					</p>

					<p>
						<label>Mô tả</label>
						<textarea rows="7" cols="30" class="input-medium" name="moTa"><%if(moTa!=null)out.print(moTa);%></textarea>
					</p>

					<p>
						<img alt=""src="<%=request.getContextPath()%>/images/tmp/${hinhAnh}<%out.print(hinhAnh);%>"/>
						<label>Hình ảnh</label> <input type="file"
							name="hinhAnh"value="" />
					</p>

					<p>
						<label>Giá bán</label>
						<textarea rows="7" cols="30" class="input-medium" name="giaBan"><%if(giaBanString!=0)out.print(giaBanString);%></textarea>
					</p>


					<fieldset>
						<input class="submit-green" type="submit" value="Sửa tin" />
					</fieldset>
				</form>
			</div>
			<!-- End .module-body -->
		</div>
		<!-- End .module -->
		<div style="clear: both;"></div>
	</div>
	<!-- End .grid_12 -->

	<div style="clear: both;"></div>

	<%@include file="/inc/footer.jsp"%>