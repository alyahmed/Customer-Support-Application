<%--@elvariable id="profiles" type="org.springframework.social.twitter.api.Twitter.friendOperations()"--%>
<spring:message code="title.twitter.friends" var="twitterFriends" />
<template:basic htmlTitle="${twitterFriends}"
	bodyTitle="${twitterFriends}">
	<c:choose>
		<c:when test="${fn:length(profiles) == 0}">
            NO FRIENDS PROFILES FOUND
        </c:when>
		<c:otherwise>
			<c:forEach items="${profiles}" var="profile">
				<li><c:if test=${profile.profileImageUrl == null}>
            		No Picture
            	</c:if> <a href="'http://twitter.com/' + ${profile.screenName}">${profile.screenName}</a>
				</p></li>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</template:basic>
