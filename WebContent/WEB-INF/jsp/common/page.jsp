<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
	<!-- 分页 -->
	<input id="totalPage" value="${page.totalPage }" hidden="true"/>
	<div align="center">
		<a href="javascript:void(0)">
			<span id="firstPage" title="首页" class="glyphicon glyphicon-fast-backward"></span>
		</a>
		<a href="javascript:void(0)">
			<span id="previousPage" title="上一页" class="glyphicon glyphicon-step-backward"></span>
		</a>
		<a href="javascript:void(0)">
	   		<span>
	   			<input id="pageNum" type="number" name="currentPage" 
	   				value="${page.currentPage }" 
	   				maxlength="5" min="1" max="${page.totalPage }" />
	   		</span>
	   	</a>
	   	<a href="javascript:void(0)">
    		<span id="nextPage" title="下一页" class="glyphicon glyphicon-step-forward"></span>
    	</a>
    	<a href="javascript:void(0)">
	   		<span id="lastPage" title="末页" class="glyphicon glyphicon-fast-forward" ></span>
	   	</a>
	   	
	    <span>共${ page.totalPage }页</span>
	    <span>每页显示
	       	<select name="pageSize" id="pageSize">
	      		<c:forEach var="size" begin="1" end="4">
	      			<c:choose>
						<c:when test="${ page.pageSize == size * 5 }">
							<option value=${ size * 5 } selected="selected">${ size * 5 }</option>
						</c:when>
						<c:otherwise>
							<option value=${ size * 5 }>${ size * 5 }</option>
						</c:otherwise>
					</c:choose>
	      		</c:forEach>
           </select>
	           行
       </span>
	</div>
</body>
</html>