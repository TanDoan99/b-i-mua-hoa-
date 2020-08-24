<%@page import="model.bean.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@include file="/inc/header.jsp" %>
        
		<div class="container_12">
            <div class="bottom-spacing">
                  <!-- Button -->
                  <div class="float-left">
                      <a href="<%=request.getContextPath() %>/AddProduct" class="button">
                      	<span>Thêm sản phẩm mới <img src="images/plus-small.gif" alt="Thêm tin mới"></span>
                      </a>
                  </div>
                  <div class="clear"></div>
            </div>
            <%
            	String msg = (String) request.getParameter("msg");
            	if("0".equals(msg)) out.print("<p style='color: red; font-weight: bold;'>Xảy ra lỗi trong quá trình xử lí!</p>");
            	if("1".equals(msg)) out.print("<p style='color: green; font-weight: bold;'>Đã thêm thành công!</p>");
            	if("2".equals(msg)) out.print("<p style='color: green; font-weight: bold;'>Đã sửa thành công!</p>");
            	if("3".equals(msg)) out.print("<p style='color: red; font-weight: bold;'>Đã Xóa thành công!</p>");
            	
            %>
            
            <div class="grid_12">
                <!-- Example table -->
                <div class="module">
                	<h2><span>Danh sách tin tức</span></h2>
                    
                    <div class="module-table-body">
                    	<form action="<%=request.getContextPath()%>/IndexProduct"method="get">
                        <table id="myTable" class="tablesorter">
                        	<thead>
                                <tr>
                                    <th style="width:4%; text-align: center;">ID</th>
                                    <th>Tên tin</th>
                                    <th style="width:20%">Mô Tả</th>
                                    <th style="width:16%; text-align: center;">Hình Ảnh</th>
                                    <th style="width:11%; text-align: center;">Giá Bán</th>
                                      <th style="width:11%; text-align: center;">Chức Năng</th>
                                    
                                </tr>
                            </thead>
                            <tbody>
                            <%
                            	if(request.getAttribute("listPro")!=null){
                            		ArrayList<Product> listPro=(ArrayList<Product>)request.getAttribute("listPro");
                            		if(listPro.size()>0){
                            			for(Product objPro: listPro){
                            				
                            %>
                                <tr>
                                    <td class="align-center"><%=objPro.getId() %></td>
                                    <td><a href=""><%=objPro.getTenHoa() %></a></td>
                                    <td><%=objPro.getMoTa() %></td>
                                    <td align="center"><img src="<%=request.getContextPath() %>/images/tmp/<%=objPro.getHinhAnh() %>" class="hoa" /></td>
                                    <td><%=objPro.getGiaBan() %></td>
                                    <td align="center">
                                        <a href="<%=request.getContextPath()%>/EditProduct?id=<%=objPro.getId()%>">Sửa <img src="<%=request.getContextPath() %>/images/pencil.gif" alt="edit" /></a>
                                        <a href="<%=request.getContextPath()%>/DeleteProduct?id=<%=objPro.getId()%>" onclick="return confirm('Bạn có chắc chắn muốn xóa không?')">Xóa <img src="<%=request.getContextPath() %>/images/bin.gif" width="16" height="16" alt="delete" /></a>
                                    </td>
                                </tr>
                               <%	
                               			}
                            		}
                            	}
                            %>
                               
                            </tbody>
                        </table>
                        </form>
                     </div> <!-- End .module-table-body -->
                </div> <!-- End .module -->
                
                
                     <div class="pagination">           
                        <div class="numbers">
                            <span>Page:</span> 
                            <a href="">1</a> 
                            <span>|</span> 
                            <a href="">2</a> 
                            <span>|</span> 
                            <span class="current">3</span> 
                            <span>|</span> 
                            <a href="">4</a> 
                            <span>|</span> 
                            <a href="">5</a> 
                            <span>|</span> 
                            <a href="">6</a> 
                            <span>|</span> 
                            <a href="">7</a> 
                            <span>|</span> 
                            <span>...</span> 
                            <span>|</span> 
                            <a href="">99</a>
                        </div> 
                        <div style="clear: both;"></div> 
                     </div>
                
			</div> <!-- End .grid_12 -->
                
            <div style="clear:both;"></div>
           
               <%@include file="/inc/footer.jsp" %>