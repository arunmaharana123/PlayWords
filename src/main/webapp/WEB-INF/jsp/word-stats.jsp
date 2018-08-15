<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container chartbox">
	<div class="row">
		<div class="col-sm-12">
			<h2>Latest Words</h2>
			<hr>
			<div class="chartbox">
				<c:forEach items="${WORD100 }" var="loop">
					<span class="tag-word">${loop.word }</span>
				</c:forEach>
			</div>
		</div>
	</div>
</div>
