<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container" style="margin-top: 20px;">
	<div class="row">
		<div class="col-sm-12">
			<form action="/search/related" method="get">
				<div class="input-group input-group-lg">
					<input type="text" name="search" class="form-control"
						placeholder="Search..." aria-describedby="sizing-addon1"><span
						class="input-group-addon" id="sizing-addon1"><span
						class="glyphicon glyphicon-search"></span></span>
				</div>
			</form>
		</div>
	</div>
</div>
<div class="container" style="margin-top: 20px;">
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<!-- Default panel contents -->
				<div class="panel-heading">Statistics</div>
				<div class="panel-body">
					<div class="col-sm-3 col-xs-6">
						<div class="chartbox">
							<h2 class="count">
								<fmt:formatNumber type="number" groupingUsed="true"
									value="${CATEGORYCOUNT }" />
							</h2>
							<div class="title">categories</div>
						</div>
					</div>
					<div class="col-sm-3 col-xs-6">
						<div class="chartbox">
							<h2 class="count">
								<fmt:formatNumber type="number" groupingUsed="true"
									value="${WORDCOUNT }" />
							</h2>
							<div class="title">words</div>
						</div>
					</div>
					<div class="col-sm-3 col-xs-6">
						<div class="chartbox">
							<h2 class="count">
								<fmt:formatNumber type="number" groupingUsed="true"
									value="${TAGCOUNT }" />
							</h2>
							<div class="title">tags</div>
						</div>
					</div>
					<div class="col-sm-3 col-xs-6">
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
		</div>
	</div>
</div>
<div class="container" style="margin-top: 20px;">
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<!-- Default panel contents -->
				<div class="panel-heading">Latest Words</div>
				<div class="panel-body">
					<c:forEach items="${WORD100 }" var="loop">
						<span class="label label-default">${loop.word }</span>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="container" style="margin-top: 20px;">
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<!-- Default panel contents -->
				<div class="panel-heading">Latest Tags</div>
				<div class="panel-body">
					<c:forEach items="${TAG100 }" var="loop">
						<span class="label label-default">${loop.tag }</span>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</div>