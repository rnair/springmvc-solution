

<link href="${pageContext.request.contextPath}/static/jquery-ui/jquery-ui.css" rel="stylesheet">

<body>
	<h3>Menu</h3>
	<ul style="width: 100%; height: 80%;" id="menu">
		<li><div><a href="${pageContext.request.contextPath}/employee/add">Add Employee</a></div></li>
		<li><div><a href="${pageContext.request.contextPath}/employee/list">List Employee</a></div></li>
	</ul>
</body>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-ui/external/jquery/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-ui/jquery-ui.js"></script>
<script>

	$("#menu").menu();

	$("#menu").on('menuselect', function (event, ui) {
		var item = $("#menu").val();
	});

</script>