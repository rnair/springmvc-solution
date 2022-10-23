<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Update Employee</title>
</head>
<h3>Update Employee</h3>
<body>
	<div id="dialog-message" title="Update Employee"></div>

	<form:form id="updateForm"
		action="${pageContext.request.contextPath}/employee/update"
		modelAttribute="employee">
		<div>
			<form:input type="hidden" id="id" path="id" />
		</div>
		<div>First name:</div>
		<div>
			<form:input id="firstName" path="firstName" />
		</div>
		<br>
		<div>Last name:</div>
		<div>
			<form:input id="lastName" path="lastName" />
		</div>
		<br>
		<div>DOB:</div>
		<div>
			<form:input id="datepicker" name="date" itemLabel="date" path="dob" />
		</div>
		<br>
		<div>Department:</div>
		<div>
			<form:select path="department">
				<form:option value="Department1" label="Department1" />
				<form:option value="Department2" label="Department2" />
				<form:option value="Department3" label="Department3" />
			</form:select>
		</div>
		<br>
		<div>Salary:</div>
		<div>
			<form:input path="salary" />
		</div>
		<br>
		<div>Manager:</div>
		<div>
			<form:select id="manager" path="manager.id">
				<form:option value="">Select One</form:option>
				<c:forEach var="manager" items="${managers}">
					<form:option value="${manager.id}">${manager.firstName}</form:option>
				</c:forEach>
			</form:select>
		</div>
		<br>
		<input type="submit" value="Update Employee" />
	</form:form>
</body>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>

<script>
$(document).ready(function() {
	$("#datepicker").datepicker({ dateFormat: 'dd/mm/yy' });
	const urlParams = new URLSearchParams(window.location.search);
	const respMsg = urlParams.get('responseMessage');
	if (respMsg) {
		$("#dialog-message").html(respMsg).dialog({
			modal : true,
			buttons : {
				Ok : function() {
					$(this).dialog("close");
				}
			}
		});
	}
	
	$('#updateForm').validate({
		rules : {
			firstName : 'required',
			lastName : 'required',
			department : 'required',
			dob : 'required',
			salary : {
				required : true,
				number : true
			}
		},
		messages : {
			firstName : 'This field is required',
			lastName : 'This field is required',
			department : 'This field is required',
			dob : 'This field is required'
		}
	});
});
</script>
</html>
