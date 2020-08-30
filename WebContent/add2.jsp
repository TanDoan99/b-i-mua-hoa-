<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/inc/header.jsp"%>

<div class="container_12">
	<!-- Form elements -->
	<div class="grid_12">

		<div class="module">
			<h2>
				<span>Thêm tin tức</span>
			</h2>
			<div class="module-body">
			<%
				String tenHoa = "";
				String moTa = "";
				String hinhAnh="";
				String giaBanString="";
				String err = "";
				if(request.getParameter("tenHoa")!=null) tenHoa = (String) request.getParameter("tenHoa");
				if(request.getParameter("moTa")!=null) moTa = (String) request.getParameter("moTa");
				if(request.getParameter("hinhAnh")!=null) hinhAnh =  (String)request.getParameter("hinhAnh");
				if(request.getParameter("giaBan")!=null) giaBanString = (String) request.getParameter("giaBan");
				if(request.getParameter("err")!=null) err = (String) request.getParameter("err");
				
				if("0".equals(err)) out.print("<p style='color: red; font-weight: bold'>Thêm không thành công!</p>");
				if("1".equals(err)) out.print("<p style='color: red; font-weight: bold'>Vui lòng nhập tên hoa</p>");
				if("2".equals(err)) out.print("<p style='color: red; font-weight: bold'>Vui lòng nhập mô tả</p>");
				if("4".equals(err)) out.print("<p style='color: red; font-weight: bold'>Vui lòng chọn file hình ảnh</p>");
				if("5".equals(err)) out.print("<p style='color: red; font-weight: bold'>Vui lòng nhập giá bán</p>");
				if("6".equals(err)) out.print("<p style='color: red; font-weight: bold'>Vui lòng nhập giá bán là số</p>");
			%>
				<form action="<%=request.getContextPath()%>/AddProduct2"
					method="post" enctype="multipart/form-data">


					

					<p>
						<label>Tên hoa</label>
						 <input type="text" class="input-medium" name="tenHoa" value="<%out.print(tenHoa);%>"/>
						
					</p>

					<p>
						<label>Mô tả</label>
						<textarea rows="7" cols="30" class="input-medium" name="moTa" ><%out.print(moTa);%></textarea>
					</p>
						
					<p>
						<img alt="" src="<%=request.getContextPath()%>/images/tmp/${hinhAnh}">
						<label>Hình ảnh</label> <input type="file" value="" name="hinhAnh" />
					</p>

					<p>
						<label>Giá bán</label>
						<textarea rows="7" cols="30" class="input-medium" name="giaBan"><%if(!"0".equals(giaBanString))out.print(giaBanString); %></textarea>
					</p>

					<fieldset>
						<input class="submit-green" type="submit" value="Thêm tin" /> 
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