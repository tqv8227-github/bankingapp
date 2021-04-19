<%@ page import = "com.banking.entities.*"%>
<%@ page import="java.io.*,java.text.*,java.util.*"%>
<%@ page import = "java.time.LocalDateTime" %>
<%@ include file="../common/header.jspf" %>
<%@ include file="../common/sidenav.jspf" %>
	<div class="div-body" id="main-div">
	<h3>this is customer list page</h3>
	<table>
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Birth Date (Mon/Day/Year)</th>
				<th>SSN</th>
				<th>Sex</th>
				<th>Action</th>
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
					<td><a href="/customer/edit/id/${customer.getId()}">Edit</a> || <a href="/customer/delete/id/${customer.getId()}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
		<!-- <tfoot style="colspan: 5">  -->
		</tfoot>
	</table>
	</div>
	<script type="text/javascript">
	$(function(){
		$('#nav a').click(function(e) { 
			alert("onclick");
			
			  $('#main-div').clear().hide().load( $(this).attr('href') , function(){
					 $('#main-div').show();
			  });
			  
			  //return false;
		})
	})
</script>
<%@ include file="../common/footer.jspf" %>