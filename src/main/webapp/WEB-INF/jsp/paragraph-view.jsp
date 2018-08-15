<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container chartbox" style="margin-top: 20px;">
	<div class="row">
		<div class="col-sm-12">
			<h2>Latest Paragraph</h2>
			<hr>
			<div class="chartbox" style="max-width: 100%;">
				<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th>Sentence</th>
							<th>Words</th>
							<th>Train</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${PARAGRAPH }" var="para" varStatus="loop">
							<tr>
								<td>${loop.count }</td>
								<td>${para.sentence }</td>
								<td>${para.words }</td>
								<td><a class="btn btn-success" href="#">Train</a></td>
								<td><button type="button" class="btn btn-success"
										onclick="paragraph/delete?id=${para.paragraphId }">Delete</button></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>


			</div>
		</div>
	</div>
</div>
