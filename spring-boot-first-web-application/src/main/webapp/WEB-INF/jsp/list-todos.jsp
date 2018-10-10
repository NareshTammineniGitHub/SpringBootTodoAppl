<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<Div class="Container">
<h1> Your Todo's </h1>

<table class="table table-striped">
	<caption>Your todo'S are...</caption>
	<thead>
		<tr>
			<th>Sr #</th>
			<th>Desc</th>
			<th>Target Date</th>
			<th>is Done</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${todos}" var="todo">
		<tr>
			<td>${todo.id}</td>
			<td>${todo.desc}</td>
			<td><fmt:formatDate value="${todo.targetDate}" pattern = "dd/MM/yyyy"/></td>
			<td>${todo.isDone}</td>
			<td><a type="button" class="btn btn-success" href="/update-todo?id=${todo.id}">Update</a></td>
			<td><a type="button" class="btn btn-danger" href="/delete-todo?id=${todo.id}">Delete</a></td>
		</tr>

		</c:forEach>
	</tbody>
<table>
<div><a class = "button" href = "/add-todo"> Add Todo </a> </div>


</Div>
<%@ include file="common/footer.jspf" %>
