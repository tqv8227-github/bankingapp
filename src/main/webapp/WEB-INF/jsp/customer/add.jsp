<%@ include file="../common/header.jspf" %>
<%@ include file="../common/sidenav.jspf" %>

<div class="div-body" id="main-div">
	<h3>Add New Customer</h3>
	<form action="/bankingapp/customer/add" method="post">
		<fieldset>
			<label>First Name:</label>
			<input type="text" name="firstName" required><br/>
			<label>Last Name:</label>
			<input type="text" name="lastName" required><br/>
			<label>Middle Name:</label>
			<input type="text" name="middleName"><br/>
			<label>SSN:</label>
			<input type="text" name="ssn" required minlength="11" maxlength="11" pattern="\d{3}-?\d{2}-?\d{4}" placeholder="xxx-xx-xxxx"><br/>
			<label>Sex:</label>
			<input type="text" name="sex" required maxlength="1"><br/>
			<label>Birth Date:</label>
			<input type="datetime-local" id="birthDate" name="birthDate" required><br/>
			<!-- <input type="hidden" name="id" value=0><br/> -->
			<input type="submit" value="Add" />
		</fieldset>
	</form>
	<div><a href="/bankingapp/customer/list/all">go back to customer list</a></div>
		
</div>
<%@ include file="../common/footer.jspf" %>