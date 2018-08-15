<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container chartbox">
	<div class="row">
		<div class="col-sm-12">
			<c:if test="${MESSAGE ne '' }">
				<div class="alert alert-success">${MESSAGE }</div>
			</c:if>
			<h3>Train Word</h3>
			<hr>
			<form action="train" method="post">
				<div>
					<textarea class="form-control" name="wordtext" required="required"
						rows="6" placeholder="type words separated by ,"></textarea>
				</div>
				<div style="margin-top: 10px" align="right">
					<input type="submit" value="Train" class="btn btn-success" />
				</div>

				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>

		</div>
	</div>
</div>
