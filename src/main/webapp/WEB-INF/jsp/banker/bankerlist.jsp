<%@ page import="com.banking.entities.Banker" %>
<%@ include file="../common/header.jspf" %>
<%@ include file="../common/sidenav.jspf" %>

<div class="div-body" id="main-div">
	<h3>Banker List</h3>
	<table>
		<thead>
			<tr>
				<th>Employee Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>MI</th>
				<th>Title</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${bankerList}" var="banker">
				<tr>
					<td>${banker.getId()}</td>
					<td>${banker.getFirstName()}</td>
					<td>${banker.getLastName()}</td>
					<td>${banker.getMi()}</td>
					<td>${banker.getBankerType().getName()}</td>
					<td><a href="/bankingapp/banker/edit/id/${banker.getId()}">Edit</a> || <a href="/bankingapp/banker/delete/id/${banker.getId()}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<%@ include file="../common/footer.jspf" %>