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
						autocomplete="off" value="${SEARCH }" placeholder="Search..."
						aria-describedby="sizing-addon1"><span
						class="input-group-addon" id="sizing-addon1"><span
						class="glyphicon glyphicon-search"></span></span>
				</div>
			</form>
		</div>
	</div>
</div>

<div class="container" style="margin-top: 10px;">
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<!-- Default panel contents -->
				<div class="panel-heading">
					<em>Related Tags for:</em> &quot;<b>${SEARCH }</b>&quot;
				</div>
				<div class="panel-body">
					<c:if test="${MESSAGE ne null }">
						<div class="alert alert-success">${MESSAGE }</div>
					</c:if>
					<ul class="list-group">
						<c:forEach items="${TAGLIST }" var="loop">
							<li class="list-group-item col-sm-3">${loop}</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>