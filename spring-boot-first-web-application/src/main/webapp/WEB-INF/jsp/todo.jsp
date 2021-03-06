<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class = "container">
<h3>login user: ${name} </h3>

<h1>ADD ToDo Page </h1>

<form:form method="POST"  modelAttribute="todo">
	<form:hidden path="id"/>
	<fieldset class="form-group">
		<form:label path="desc">Description</form:label>
		<form:input path="desc" type="text" class="form-control" required="required"/>
		<form:errors path="desc" cssClass="text-warning"></form:errors>
	</fieldset>
	<fieldset class="form-group">
		<form:label path="targetDate">Target Date</form:label>
		<form:input path="targetDate" type="text" class="form-control" required="required"/>
		<form:errors path="targetDate" cssClass="text-warning"></form:errors>
	</fieldset>

	<button type = "submit" class = "btn btn-success">Add</button>
</form:form>
</div>

<%@ include file="common/footer.jspf" %>