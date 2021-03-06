<spring:message code="title.twitter.connect" var="twitterConnectTitle" />
<template:basic htmlTitle="${twitterConnectTitle}" bodyTitle="${twitterConnectTitle}">
	<div id="content" layout:fragment="content">
		<h3>Connect to Twitter</h3>
		<c:url value="/connect/twitter" var="connectTwitterUrl" />

		<form:form action="${connectTwitterUrl}" method="POST">
			<input type="hidden" name="_csrf" value="${_csrf.token}" />
			<div class="formInfo">
				<p>You haven't created any connections with Twitter yet. Click
					the button to connect Spring Social Showcase with your Twitter
					account. (You'll be redirected to Twitter where you'll be asked to
					authorize the connection.)</p>
			</div>

			<button type="submit">Connect to Twitter</button>

			<label for="postTweet"><input id="postTweet" type="checkbox"
				name="postTweet" /> Post a tweet about connecting with Spring
				Social Showcase</label>
		</form:form>
	</div>
</template:basic>