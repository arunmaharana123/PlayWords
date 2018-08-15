<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>PlayGound</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/layout.css"></link>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar3">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/home">Play Word</a>
			</div>
			<div id="navbar3" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="/home">Home</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">Paragraph
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu dropdown-menu-left" role="menu">
							<li><a href="/paragraph/view">View</a></li>
							<li><a href="/paragraph/add">Train</a></li>
							<li><a href="/paragraph/getnews">Get News</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">Word
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu dropdown-menu-left" role="menu">
							<li><a href="/word/stats">Stats</a></li>
							<li><a href="/word/train">Train</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">Tag
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu  dropdown-menu-left" role="menu">
							<li><a href="/tag/stats">Stats</a></li>
							<li><a href="/tag/train">Train</a></li>
						</ul></li>
					<li><a href="#">Contact</a></li>
					<li><a href="#">About</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		<!--/.container-fluid -->
	</nav>
	<section id="site-content">
		<tiles:insertAttribute name="body" />
	</section>
	<footer class="footer">
		<div class="container">
			<div class="copyright" align="right">&copy;PlayGround By Arun
				Maharana</div>
		</div>
	</footer>
	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>