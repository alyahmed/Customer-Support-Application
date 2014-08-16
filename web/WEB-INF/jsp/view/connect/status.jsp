<spring:message code="title.ticketList" var="listTitle" />

<template:basic htmlTitle="${listTitle}" bodyTitle="${listTitle}">
		<h3>Your Connections</h3>

		<div class="accountConnection">

			<c:forEach items="${providerIds}" var="providerId">
		${providerId}
	</c:forEach>

</template:basic>