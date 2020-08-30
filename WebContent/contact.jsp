<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/inc/header.jsp"%>

<div class="container_12">
	<!-- Form elements -->
	<div class="grid_12">

		<div class="contact">
	 <div class="container">
		 <div class="contact-head">
			 <h3>Liên hệ</h3>
			 <h3 style="color: green">${msg}</h3>
			 <h3 style="color: red">${err}</h3>
			  <form action="<%=request.getContextPath() %>/" method="post">
				  <div class="col-md-6 contact-left">
						<input type="text" placeholder="Name" name="name" value="${name }"><br/><br/><br/>
						<input type="text" placeholder="E-mail"  name="email" value="${email }"><br/><br/><br/>
						<input type="text" placeholder="Phone" name="phone" value="${phone}"><br/><br/><br/>
				 </div>
				 <div class="col-md-6 contact-right">
						 <textarea placeholder="Message" name="mess">${mess}</textarea>
						 <input type="submit" value="SEND">
				 </div>
				 <div class="clearfix"></div>
			 </form>
		 </div>
	 </div>
</div>
	
	</div>
	<!-- End .grid_12 -->

	<div style="clear: both;"></div>

	<%@include file="/inc/footer.jsp"%>