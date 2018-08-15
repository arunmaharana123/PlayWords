<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container chartbox" style="margin-top: 20px;">
	<div class="row">
		<div class="col-sm-12">
			<h2>Update Paragraph</h2>
			<hr>
			<div class="" style="max-width: 100%;">
				<form action="update" method="post">
					<div>
						<input type="text" class="form-control" name="words"
							autofocus="autofocus" required="required"
							placeholder="type words separated by ,"
							value="${PARAGRAPH.words }" /> <input type="hidden" name="id"
							value="${PARAGRAPH.paragraphId }" />
					</div>
					<div style="margin-top: 10px" align="right">
						<input type="submit" value="Update" class="btn btn-success" />

					</div>

					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>

			</div>
		</div>
	</div>
</div>
