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
				<form action="<%=request.getContextPath()%>/AddProduct"
					method="post" enctype="multipart/form-data">

					<div>
						 
							<h4 style="color: green"><span class="notification n-success">${msg}</span></h4>
							<p style="color: red; font-weight: bold">${err}</p>
								 
						
					</div>

					

					<p>
						<label>Tên hoa</label>
						 <input type="text" class="input-medium" name="tenHoa"value="${tenHoa}"/>
						
					</p>

					<p>
						<label>Mô tả</label>
						<textarea rows="7" cols="30" class="input-medium" name="moTa" >${moTa}</textarea>
					</p>
						
					<p>
						<img alt="" src="<%=request.getContextPath()%>/images/tmp/${hinhAnh}">
						<label>Hình ảnh</label> <input type="file" value=""name="hinhAnh" />
					</p>

					<p>
						<label>Giá bán</label>
						<textarea rows="7" cols="30" class="input-medium" name="giaBan">${giaBan}</textarea>
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