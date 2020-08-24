<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>VinaEnter EDU - Đã học là làm được</title>
		<meta name="description" content="Thiet ke website, dao tap lap trinh">
		<meta name="keywords" content="thiet ke website, dao tap lap trinh">
		<link href="css/style.css" rel="stylesheet" type="text/css">
	</head>
	<body>
    	<!-- Header -->
        <div id="header">
            <!-- Header. Status part -->
            <div id="header-status">
                <div class="container_12">
                    <div class="grid_4">
                    	<ul class="user-pro">
							<li><a href="<%= request.getContextPath() %>/index.jsp">Logout</a></li>
							<li>Chào, <a href="<%= request.getContextPath() %>/index.jsp">admin</a></li>
                    	</ul>
                    </div>
                </div>
                <div style="clear:both;"></div>
            </div> <!-- End #header-status -->
            
            <!-- Header. Main part -->
            <div id="header-main">
                <div class="container_12">
                    <div class="grid_12">
                        <div id="logo">
                            <ul id="nav">
                                <li id="current"><a href="<%= request.getContextPath() %>/index.jsp">Quản trị</a></li>
                                <li><a href="<%= request.getContextPath() %>/add.jsp">Tài khoản</a></li>
                            </ul>
                        </div><!-- End. #Logo -->
                    </div><!-- End. .grid_12-->
                    <div style="clear: both;"></div>
                </div><!-- End. .container_12 -->
            </div> <!-- End #header-main -->
            <div style="clear: both;"></div>
            <!-- Sub navigation -->
            <div id="subnav">
                <div class="container_12">
                    <div class="grid_12">
                        <ul>
                            <li><a href="<%= request.getContextPath() %>/Index">sản phẩm</a></li>
                            <li><a href="<%= request.getContextPath() %>/IndexProduct">Danh mục sản phẩm</a></li>
                            <li><a href="<%= request.getContextPath() %>/list.jsp">Giới thiệu</a></li>
                            <li><a href="<%= request.getContextPath() %>/IndexProduct">Đơn hàng</a></li>
                            <li><a href="<%= request.getContextPath() %>/list.jsp">Liên hệ</a></li>
                        </ul>
                        
                    </div><!-- End. .grid_12-->
                </div><!-- End. .container_12 -->
                <div style="clear: both;"></div>
            </div> <!-- End #subnav -->
        </div> <!-- End #header -->