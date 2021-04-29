<%@ include file="../common/header.jspf" %>
<%@ include file="../common/sidenav.jspf" %>

<div class="div-body" id="main-div">
	<h3>Add New Customer</h3>
	<form action="/customer/add" method="post">
		<fieldset>
			<label>First Name:</label>
			<input type="text" name="firstName"><br/>
			<label>Last Name:</label>
			<input type="text" name="lastName" ><br/>
			<label>Middle Name:</label>
			<input type="text" name="middleName"><br/>
			<label>SSN:</label>
			<input type="text" name="ssn"><br/>
			<label>Sex:</label>
			<input type="text" name="sex"><br/>
			<label>Birth Date:</label>
			<input type="datetime-local" id="birthDate" name="birthDate"><br/>
			<input type="number" name="id" value=1><br/>
			<input type="submit" value="Add" />
		</fieldset>
	</form>
	<div><a href="/customer/list/all">go back to customer list</a></div>
		
</div>
<%@ include file="../common/footer.jspf" %>