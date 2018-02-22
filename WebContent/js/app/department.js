function listEntireDepartments(){
	var keywords = $('#keywords').val();
	$.post('department/listEntireByPage',
			{
				keywords : keywords
			},
		function(data){
			$('#mainArea').html(data);
		}
	);
}

function listUpdateDepartments(){
	var keywords = $('#keywords').val();
	$.post('department/listUpdateByPage',
			{
				keywords : keywords
			},
		function(data){
			$('#mainArea').html(data);
		}
	);
}

function listDeleteDepartments(){
	var keywords = $('#keywords').val();
	$.post('department/listDeleteByPage',
			{
				keywords : keywords
			},
		function(data){
			$('#mainArea').html(data);
		}
	);
}
		

//调用后台方法显示详情
function showDetail(departmentId) {
	$.post('department/toShowDetail',
		{departmentId:departmentId},
		function(data){
			$('#detailModalBody').html(data);
			$('#detailModal').modal('toggle');
		}
	);
}

function toRegister() {
	legalOfName = false;
	legalOfCode = false;
	$.post('department/toRegister',
			function(data){
				$('#registerModalBody').html(data);
				$('#registerModal').modal('show');
			});
}

function register(){
	if ($("#departmentCode").val() == "") {
		alertTips('部门编号不能为空，请进行填写');
		$("#departmentCode").focus();
		return;
	}
	if ($("#departmentName").val() == "") {
		alertTips('部门名称不能为空，请进行填写');
		$("#departmentName").focus();
		return;
	}
	
	var registerForm = $('#department_register_form');
	sendAsynRequest(registerForm.attr('action'), 
			registerForm.serialize(),
			function (data){
				alertTips(data.responseMessage);
				if ('N' == data.responseType) {
					$.post('department/toRegister',
							function (data) {
								$('#content').html(data);
							}
					);
				}
			});
}

function toModify(departmentId) {
   
	legalOfName = true;
	legalOfCode = true;
	$.post('department/toModify',
			{departmentId : departmentId},
			function(data){
				$('#modifyModalBody').html(data);
				$('#modifyModal').modal('toggle');
			});

}
function modify(){
	if ($("#departmentCode").val() == "") {
		alertTips('部门编号不能为空，请进行填写');
		$("#departmentCode").focus();
		return;
	}
	if ($("#departmentName").val() == "") {
		alertTips('部门名称不能为空，请进行填写');
		$("#departmentName").focus();
		return;
	}
	
	var modifyForm = $('#department_modify_form');
	$.post(modifyForm.attr('action'),
			modifyForm.serialize(),
		function (data){
			var responseType = data.responseType;
			var responseMessage = data.responseMessage;
			if ('N' == responseType) {
				alertTips(responseMessage);
				$('#modifyModal').modal('toggle');
				listUpdateDepartments();
			} else {
					alertTips(responseMessage);
			}
		}
	);
}

function deleteById(departmentId) {
	var flag = confirm("确认删除所选部门吗？");
	if(flag){
	$.post('department/delete',
			{
				departmentId : departmentId
			},
			function(data){
				alertTips(data.responseMessage);
				if ('N' == data.responseType) {
					listDeleteDepartments();
				} 
			}
	);
	}
}

var legalOfName = false;
var legalOfCode = false;
function checkDepartmentName(currentElement) {
	var url = 'department/checkDepartmentName';
	var tips = $(currentElement).next();
	var departmentName = $.trim($(currentElement).val());
	if (departmentName == '') {
		tips.css('color' ,'red');
		tips.text('不能为空！');
		legalOfName = false;
		return;
	}
	$.post(url,
			{departmentName : departmentName},
			function(data){
				var responseType = data.responseType;
				var responseMessage = data.responseMessage;
				if (responseType == 'e') {
					alertTips(responseMessage);
					return;
				}
				if (responseType != 'N') {
					tips.css('color' ,'red');
					legalOfCode = false;
				} else {
					tips.css('color', 'blue');
					legalOfName = true;
				}
				
				tips.text(responseMessage); 
			});
}

function checkDepartmentCode(currentElement) {
	var url = 'department/checkDepartmentCode';
	var tips = $(currentElement).next();
	var departmentCode = $.trim($(currentElement).val());
	if (departmentCode == '') {
		tips.css('color' ,'red');
		tips.text('不能为空！');
		legalOfCode = false;
		return;
	}
	
	$.post(url,
			{departmentCode : departmentCode},
			function(data){
				var responseType = data.responseType;						
				if (responseType != 'N') {
					tips.css('color', 'red');
					legalOfCode = false;
				} else {
					tips.css('color', 'blue');
					legalOfCode = true;
				}
				tips.text(data.responseMessage);
			});
}

function checkModifiedDepartmentName (currentElement, metaDepartmentName) {
	var departmentName = $(currentElement).val().trim();
	if (metaDepartmentName != departmentName) {
		checkDepartmentName(currentElement);
	}
}

function checkModifiedDepartmentCode (currentElement, metaDepartmentCode) {
	var departmentCode = $(currentElement).val().trim();
	if (metaDepartmentCode != departmentCode) {
		checkDepartmentCode(currentElement);
	}
}