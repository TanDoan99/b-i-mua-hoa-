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
				<p style="color: red; font-weight: bold">${err}</p>
				<form action="<%=request.getContextPath()%>/EditProduct"
					method="post" enctype="multipart/form-data">
					<%
						Product objPro = new Product();
						if (request.getAttribute("objPro") != null) {
							objPro = (Product) request.getAttribute("objPro");
						}
					%>
					<input type="hidden" name="id" value="<%=objPro.getId()%>">
					<p>
						<label>Tên hoa</label> <input type="text" class="input-medium"
							name="tenHoa" value="${tenHoa}<%if(objPro.getTenHoa()!=null)out.print(objPro.getTenHoa());%>" />

					</p>

					<p>
						<label>Mô tả</label>
						<textarea rows="7" cols="30" class="input-medium" name="moTa">${moTa}<%if(objPro.getMoTa()!=null)out.print(objPro.getMoTa());%></textarea>
					</p>

					<p>
						<img alt="" src="<%=request.getContextPath()%>/images/tmp/${hinhAnh}<%if(objPro.getHinhAnh()!=null) out.print(objPro.getHinhAnh());%>"/>
						<label>Hình ảnh</label> <input type="file"
							value="" name="hinhAnh" />
					</p>

					<p>
						<label>Giá bán</label>
						<textarea rows="7" cols="30" class="input-medium" name="giaBan">${giaBan}<%if(objPro.getGiaBan()!=0) out.print(objPro.getGiaBan());%></textarea>
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