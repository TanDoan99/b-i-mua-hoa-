<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

        <%@include file="/inc/header.jsp" %>
		<div class="container_12">
            
            <!-- Dashboard icons -->
            <div class="grid_main_l">
            	<a href="<%= request.getContextPath() %>/AddProduct2" class="dashboard-module">
                	<img src="images/Crystal_Clear_write.gif" width="64" height="64" alt="edit" />
                	<span>Thêm tin sản phẩm</span>
                </a>
                
                <a href="<%= request.getContextPath() %>/IndexProduct" class="dashboard-module">
                	<img src="images/Crystal_Clear_files.gif" width="64" height="64" alt="edit" />
                	<span>Thông tin sản phẩm</span>
                </a>
                <div style="clear: both"></div>
            </div> <!-- End .grid_7 -->
            
            <!-- Account overview -->
            <div class="grid_main_r">
                <div class="module">
                        <h2><span>Quản trị hệ thống</span></h2>
                        
                        <div class="module-body">
                        	<p class="p">
                                <strong>Phần mềm</strong> được viết trên nền tảng JAVA <br />
                                <strong>Học viên thực hiện: </strong>*********<br />
                                <strong>Email: </strong>******@vn.net<br /> 
                                <strong>Phone: </strong>0909.123.456<br />
                            </p>
                        </div>
                </div>
                <div style="clear:both;"></div>
                <div class="padding-bottom"></div>
            </div> <!-- End .grid_5 -->
            
            <div style="clear:both;"></div>
             <%@include file="/inc/footer.jsp" %>
       