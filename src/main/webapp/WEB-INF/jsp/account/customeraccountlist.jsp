<%@ include file="../common/header.jspf" %>
<%@ include file="../common/sidenav.jspf" %>
<div id="main-div" class="div-body">
	<c:choose>
		<c:when test="${accountList.size() > 0}">
			<div>
				<h3>Customer: ${customer.getFirstName()} ${customer.getLastName()}</h3>
			</div>
			<div>
				<table>
					<thead>
						<tr>
							<th>Account Number</th>
							<th>Balance</th>
							<th>Account Type</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${accountList}" var="account">
							<tr>
								<td>${account.getId()}</td>
								<td>${account.getAmount()}</td>
								<td>${account.getAccountType().getName()}</td>
								<td>
									<a href="/account/edit/id/${account.getId()}">Deposit</a> ||
									<a href="/account/edit/id/${account.getId()}">Withdraw</a>
								</td>
							</tr>
						</c:forEach>	
					</tbody>
				</table>
			</div>
		</c:when>
		<c:otherwise><div>No Accounts found for this Customer</div></c:otherwise>
	</c:choose>
	<br/>
	<div><a href="/customer/list/all">Return to Customer List</a></div>
</div>
<%@ include file="../common/footer.jspf" %>