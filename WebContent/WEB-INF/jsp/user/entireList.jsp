<%@page import="cn.jxy.employee.web.model.User"%>
<%@ page contentType="text/html; charset=utf-8" language="java"
	errorPage="" import="java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head></head>
<body>
	<table id="user_entire_table" class="table table-hover table-condensed table-striped smart-form">
		<thead>
			<tr>
				<th>用户编号</th>
				<th>用户名</th>
				<th>联系电话</th>
				<th>电子邮箱</th>
				<th>所属部门</th>
				<th>是否为负责人</th>
				<th>用户角色</th>
				<th>可用状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${ userList }">
				<tr>
					<td>${ user.username }</td>
					<td>${ user.userCode }</td>
					<td>${ user.phoneNo }</td>
					<td>${ user.email }</td>
					<td>${ user.departmentName }</td>
					<td>
						<c:if test="${ user.isManager=='0'}">
							是
						</c:if> 
						<c:if test="${ user.isManager=='1'}">
							否
						</c:if>
					</td>
					<td>${ user.roleName }</td>
					<td>
						<c:if test="${ user.availState=='0'}">
							不可用
						</c:if> 
						<c:if test="${ user.availState=='1'}">
							可用
						</c:if>
					</td>
					<td>
						<button class="btn btn-link" onclick="showDetail('${ user.userId }')">查看详情</button>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	<div>
		<%@include file="../common/page.jsp"%>
	</div>
	
	<script type="text/javascript">
		function showDetail(userId) {
			$.post('user/showDetail',
					{
						userId : userId
					},
					function(data) {
						$('#detailModalBody').html(data);
						$('#detailModal').modal('toggle');
					}
			);
		}
		
		pageSetUp();

		loadScript("js/plugin/datatables/jquery.dataTables-cust.min.js",
				runDataTables);

		function runDataTables() {
			$("#user_entire_table").DataTable({
				bPaginate : false,
				bFilter : false,
				bInfo : false,
				"bAutoWidth" : true,
				"sScrollX" : "100%"
			});
		}
		
		$(document).ready(
				listenClickEvent($('#mainArea'), 'user/listEntireByPage')		
		);
	</script>
</body>
</html>