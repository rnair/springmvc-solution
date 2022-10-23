<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>

<body>
	<div>
		<div>
			<tiles:insertAttribute name="header" />
		</div>
		<div style="float: left; padding: 10px; width: 15%;">
			<tiles:insertAttribute name="menu" />
		</div>
		<div
			style="float: left; padding: 10px; width: 80%; ; height: 90%;">
			<tiles:insertAttribute name="body" />
		</div>
		<div>
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>
