<%@ page import = "com.banking.entities.*"%>
<%@ page import="java.io.*,java.text.*,java.util.*"%>
<%@ page import = "java.time.LocalDateTime" %>
<%@ include file="../common/header.jspf" %>
<%@ include file="../common/sidenav.jspf" %>
	<div class="div-body" id="main-div">
		<h3>Customer List</h3>
		<table>
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Birth Date (Mon/Day/Year)</th>
					<th>SSN</th>
					<th>Sex</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${customerList}" var="customer">
					<tr>
						<td>${customer.getFirstName()}</td>
						<td>${customer.getLastName()}</td>
						<fmt:parseDate value="${customer.getBirthDate()}" pattern="yyyy-MM-dd" var="birthDate" type="date"/>
						<td><fmt:formatDate value="${birthDate}" pattern="MM/dd/yyyy" /></td>
						<td>${customer.getSsn()}</td>
						<td>${customer.getSex()}</td>
						<td>
							<a href="/account/customer/id/${customer.getId()}">View Accounts</a>||
							<a href="/transaction/customer/id/${customer.getId()}">View Transactions</a>||
							<a href="/customer/edit/id/${customer.getId()}">Edit</a> || 
							<a href="/customer/delete/id/${customer.getId()}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<!-- <tfoot style="colspan: 5">  -->
			</tfoot>
		</table>
		<div><a href="/customer/add/new">Add New Customer</a></div>
	</div>
<%@ include file="../common/footer.jspf" %>