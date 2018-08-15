<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container chartbox">
	<div class="row">
		<div class="col-sm-3">
			<div class="chartbox">
				<h2 class="count">
					<fmt:formatNumber type="number" groupingUsed="true"
						value="${CATEGORYCOUNT }" />
				</h2>
				<div class="title">categories</div>
			</div>
		</div>
		<div class="col-sm-3">
			<div class="chartbox">
				<h2 class="count">
					<fmt:formatNumber type="number" groupingUsed="true"
						value="${WORDCOUNT }" />
				</h2>
				<div class="title">words</div>
			</div>
		</div>
		<div class="col-sm-3">
			<div class="chartbox">
				<h2 class="count">
					<fmt:formatNumber type="number" groupingUsed="true"
						value="${TAGCOUNT }" />
				</h2>
				<div class="title">tags</div>
			</div>
		</div>
		<div class="col-sm-3">
			<div class="chartbox">
				<h2 class="count">
					<fmt:formatNumber type="number" groupingUsed="true"
						value="${RELATEDTAGCOUNT }" />
				</h2>
				<div class="title">relations</div>
			</div>
		</div>
	</div>
</div>
<div class="container chartbox" style="margin-top: 20px;">
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

<div class="container chartbox" style="margin-top: 20px;">
	<div class="row">
		<div class="col-sm-12">
			<h2>Latest Tags</h2>
			<hr>
			<div class="chartbox">
				<c:forEach items="${TAG100 }" var="loop">
					<span class="tag-word">${loop.tag }</span>
				</c:forEach>
			</div>
		</div>
	</div>
</div>
