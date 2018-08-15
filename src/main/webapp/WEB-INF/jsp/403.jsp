<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.footer {
	background-color: #009688;
	color: white;
	clear: both;
	height: 3em;
	position: absolute;
	bottom: 0;
	width: 100%;
}
</style>
<div class="container">
	<div class="row">
		<div class="alert alert-danger">You don't have permission to
			access this page.</div>
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
			<h2 align="center">Login to Play Word</h2>
			<hr>
			<form action="/login" method="post">
				<div class="form-group">
					<div class="input-group">
						<span class="input-group-addon " id="basic-addon1"><span
							class="glyphicon glyphicon-user"></span></span> <input type="text"
							class="form-control" name="username" autofocus="autofocus"
							autocomplete="off" value="arun" placeholder="User ID" />
					</div>
				</div>
				<div class="form-group">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1"><span
							class="glyphicon glyphicon-lock"></span></span> <input type="password"
							class="form-control" name="password" autocomplete="off"
							value="arun" placeholder="Password" />
					</div>
				</div>
				<div class="form-group" align="right">
					<button type="submit" class="btn btn-success">Login</button>
				</div>
				<c:if test="${param.error ne null}">
					<div class="alert-danger">Invalid user id and password.</div>
				</c:if>
				<c:if test="${param.logout ne null}">
					<div class="alert-normal">You have been logged out.</div>
				</c:if>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
		</div>
		<div class="col-sm-4"></div>
	</div>

</div>