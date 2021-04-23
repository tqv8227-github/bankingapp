<%@ include file="../common/header.jspf" %>
<%@ include file="../common/sidenav.jspf" %>

<div class="div-body" id="main-div">
	<h3>edit ${customer.getFirstName()}</h3>
	<form action="/customer/update" method="post">
		<fieldset>
			<label>First Name:</label>
			<input type="text" name="firstName" value="${customer.getFirstName()}"><br/>
			<label>Last Name:</label>
			<input type="text" name="lastName" value="${customer.getLastName()}"><br/>
			<label>Middle Name:</label>
			<input type="text" name="middleName" value="${customer.getMiddleName()}"><br/>
			<label>SSN:</label>
			<input type="text" name="ssn" value="${customer.getSsn()}"><br/>
			<label>Sex:</label>
			<input type="text" name="sex" value="${customer.getSex()}"><br/>
			<label>Birth Date:</label>
			<input type="datetime-local" id="birthDate" name="birthDate" value="${customer.getBirthDate()}"><br/>
			<input type="hidden" name="id" value="${customer.getId()}"><br/>
			<input type="submit" value="Save Changes" />
		</fieldset>
	</form>
	<div><a href="/customer/list/all">go back to customer list</a></div>
		
</div>
<%@ include file="../common/footer.jspf" %>