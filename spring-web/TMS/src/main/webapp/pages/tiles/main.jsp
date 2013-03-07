<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title"/></title>
<link rel="stylesheet" href="/TMS/css/master.css" type="text/css" />
<script type="text/javascript" src="/TMS/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="/TMS/js/tms.js"></script>
<style type="text/css">

</style>

</head>
	<body>
	
		<div id="mask">
			<div id="header">
				<tiles:insertAttribute name="header-content"/>
			</div>
			<div id="content-wrapper">
				<div id="leftcol-wrapper">
					<div id="menu"><tiles:insertAttribute name="menu-content"/></div>
					<div id="content">
						<tiles:insertAttribute name="body-content"/>
					</div>
				</div>
			</div>
			<div id=clearfooter"></div>
		</div>
		<div id="footer" align="center">
			<tiles:insertAttribute name="footer-content"/>
		</div>
	
	</body>
</html>