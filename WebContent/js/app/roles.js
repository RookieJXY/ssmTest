function listEntireRoles(){
	var keywords = $('#keywords').val();
	$.post('role/listEntireByPage',
			{
				keywords : keywords
			},
		function(data){
			$('#mainArea').html(data);
		}
	);
}

//function listUpdateDepartments(){
//	var keywords = $('#keywords').val();
//	$.post('department/listUpdateByPage',
//			{
//				keywords : keywords
//			},
//		function(data){
//			$('#mainArea').html(data);
//		}
//	);
//}
//
//function listDeleteDepartments(){
//	var keywords = $('#keywords').val();
//	$.post('department/listDeleteByPage',
//			{
//				keywords : keywords
//			},
//		function(data){
//			$('#mainArea').html(data);
//		}
//	);
//}
		
function showDetail(roleName, roleCode, roleDesc, crtTime) {
	$('#roleName').val(roleName);
	$('#roleCode').val(roleCode);
	$('#roleDesc').val(roleDesc);
	$('#crtTime').val(crtTime.toString());
	
	
	$('#detailModal').modal('toggle');
}

//function toRegister() {
//	legalOfName = false;
//	legalOfCode = false;
//	$.post('department/toRegister',
//			function(data){
//				$('#registerModalBody').html(data);
//				$('#registerModal').modal('show');
//			});
//}
//
//function register(){
//	if (!(legalOfName && legalOfCode)) {
//		alert('请完善信息！');
//		return;
//	}
//	
//	var registerForm = $('#department_register_form');
//	$.post(registerForm.attr('action'),
//			registerForm.serialize(),
//			function (data){
//				var responseType = data.responseType;
//				var responseMessage = data.responseMessage;
//				if ('N' == responseType) {
//					registerForm[0].reset();
//				}
//					alert(responseMessage);
//			}
//			);
//}
//
//function toModify(departmentId) {
//	legalOfName = true;
//	legalOfCode = true;
//	$.post('department/toModify',
//			{departmentId : departmentId},
//			function(data){
//				$('#modifyModalBody').html(data);
//				$('#modifyModal').modal('toggle');
//			});
//}
//
//function modify(){
//	if (!(legalOfName && legalOfCode)) {
//		alert('请完善信息！');
//		return;
//	}
//	
//	var modifyForm = $('#department_modify_form');
//	$.post(modifyForm.attr('action'),
//			modifyForm.serialize(),
//			function (data){
//				var responseType = data.responseType;
//				var responseMessage = data.responseMessage;
//				if ('N' == responseType) {
//					listUpdateDepartments();
//					alert(responseMessage);
//					$('#modifyModal').modal('hide');
//				} else {
//					alert(responseMessage);
//				}
//			}
//			);
//}
//
//function deleteById(departmentId) {
//	$.post('department/delete',
//			{departmentId : departmentId},
//			function(data){
//				var responseType = data.responseType;
//				var responseMessage = data.responseMessage;
//				if ('N' == responseType) {
//					listDeleteDepartments();
//				} 
//				alert(responseMessage);
//			}
//			);
//}
//
//var legalOfName = false;
//var legalOfCode = false;
//function checkDepartmentName(currentElement) {
//	var url = 'department/checkDepartmentName';
//	var tips = $(currentElement).next();
//	var departmentName = $.trim($(currentElement).val());
//	if (departmentName == '') {
//		tips.css('color' ,'red');
//		tips.text('不能为空！');
//		legalOfName = false;
//		return;
//	}
//	$.post(url,
//			{departmentName : departmentName},
//			function(data){
//				var responseType = data.responseType;
//				var responseMessage = data.responseMessage;
//				if (responseType == 'e') {
//					alert(responseMessage);
//					return;
//				}
//				if (responseType != 'N') {
//					tips.css('color' ,'red');
//					legalOfCode = false;
//				} else {
//					tips.css('color', 'blue');
//					legalOfName = true;
//				}
//				
//				tips.text(responseMessage); 
//			});
//}
//
//function checkDepartmentCode(currentElement) {
//	var url = 'department/checkDepartmentCode';
//	var tips = $(currentElement).next();
//	var departmentCode = $.trim($(currentElement).val());
//	if (departmentCode == '') {
//		tips.css('color' ,'red');
//		tips.text('不能为空！');
//		legalOfCode = false;
//		return;
//	}
//	
//	$.post(url,
//			{departmentCode : departmentCode},
//			function(data){
//				var responseType = data.responseType;						
//				if (responseType != 'N') {
//					tips.css('color', 'red');
//					legalOfCode = false;
//				} else {
//					tips.css('color', 'blue');
//					legalOfCode = true;
//				}
//				tips.text(data.responseMessage);
//			});
//}
//
//function checkModifiedDepartmentName (currentElement, metaDepartmentName) {
//	var departmentName = $(currentElement).val().trim();
//	if (metaDepartmentName != departmentName) {
//		checkDepartmentName(currentElement);
//	}
//}
//
//function checkModifiedDepartmentCode (currentElement, metaDepartmentCode) {
//	var departmentCode = $(currentElement).val().trim();
//	if (metaDepartmentCode != departmentCode) {
//		checkDepartmentCode(currentElement);
//	}
//}