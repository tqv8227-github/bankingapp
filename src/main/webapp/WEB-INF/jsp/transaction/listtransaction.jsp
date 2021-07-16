<%@ include file="../common/header.jspf" %>
<%@ include file="../common/sidenav.jspf" %>
<div id="main-div" class="div-body">
	<c:choose>
		<c:when test="${transactionList.size() > 0}">
			<div>
				<h3>Customer: ${customer.getFirstName()} ${customer.getLastName()}</h3>
			</div>
			<div>
				<table>
					<thead>
						<tr>
							<th>Account Number</th>
							<th>Account Type</th>
							<th>Amount</th>
							<th>Transaction Type</th>
							<th>Banker</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${transactionList}" var="transaction">
							<tr>
								<td>${transaction.getAccount().getId()}</td>
								<td>${transaction.getAccount().getAccountType().getName()}</td>
								<td>${transaction.getAmount()}</td>
								<td>${transaction.getTransactionType().getName()}</td>
								<td>${transaction.getBanker().getFirstName()} ${transaction.getBanker().getLastName()}</td>
								<td>
									<a href="javascript:alert('not yet implemented')">Delete</a> 
								</td>
							</tr>
						</c:forEach>	
					</tbody>
				</table>
			</div>
		</c:when>
		<c:otherwise><div>No transactions found for this Customer</div></c:otherwise>
	</c:choose>
	<br/>
	<div><a href="/bankingapp/customer/list/all">Return to Customer List</a></div>
</div>
<%@ include file="../common/footer.jspf" %>