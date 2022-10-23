<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Employees</title>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/r/ju-1.11.4/jqc-1.11.3,dt-1.10.8/datatables.min.css">
<script
	src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/select/1.4.0/js/dataTables.select.min.js"></script>	
<script
	src="https://cdn.datatables.net/buttons/2.2.3/js/dataTables.buttons.min.js"></script>		
	
<script type="text/javascript">
	$(document).ready(function() {
		var table = $('#employeeList').DataTable({
			dom: 'Bfrtip',
			pageLength : 20,
			select: true,
			ajax : {
				url : '${pageContext.request.contextPath}/employee/findAll',
				dataSrc : ''
			},
			columnDefs : [ {
				"targets" : '_all',
				"defaultContent" : ""
			} ],
			columns : [ {
				title : 'Id',
				data : 'id'
			}, {
				title : 'First Name',
				data : 'firstName'
			}, {
				title : 'Last Name',
				data : 'lastName'
			}, {
				title : 'DOB',
				data : 'dob'
			}, {
				title : 'Department',
				data : 'department'
			}, {
				title : 'Salary',
				data : 'salary'
			}, {
				title : 'Manager',
				data : 'manager.firstName'
			} ],
			buttons: [
	            {
	                text: 'Update',
	                action: function () {
	                    $("#employeeId").val(table.rows( { selected: true } ).data()[0].id);
	                    $( "#showUpdateForm" ).submit();
	                }
	            }
	        ]
		});
	});
</script>
</head>
<body>
	<h3>List Employee</h3>
	<div>
		<table id="employeeList" class="display" style="width: 100%"></table>
	</div>
	<form:form id="showUpdateForm"
		action="${pageContext.request.contextPath}/employee/update" modelAttribute="employee" method="get">
	<form:input id="employeeId" path="id" type="hidden" />
	</form:form>
</body>
</html>