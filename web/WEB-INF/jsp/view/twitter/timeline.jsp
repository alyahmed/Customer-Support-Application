<spring:message code="title.twitter.timeline" var="twitterTimeline" />
<template:basic htmlTitle="${twitterTimeline}"
	bodyTitle="${twitterTimeline}">
	<div id="content" layout:fragment="content">

		<h3>
			Your Twitter <span> ${timelineName }</span>
		</h3>

		<h4>Post a tweet</h4>
		<form action="<c:url value="/twitter/tweet" />" method="POST">
			<input type="hidden" name="_csrf" value="${_csrf.token}" />
			<textarea name="message" rows="2" cols="80"></textarea>
			<br /> <input type="submit" value="Post Tweet" />
		</form>

		<form action="<c:url value="/twitter/search" />" method="GET">
			<input type='text' name='query' value='${param.query}' />
		</form>


		<ul class="choices">
			<li><a href="<c:url value="/twitter/timeline/Home" />">Home
					Timeline</a></li>
			<li><a href="<c:url value="/twitter/timeline/User" />">User
					Timeline</a></li>
			<li><a href="<c:url value="/twitter/timeline/Mentions" />">Mentions</a></li>
			<li><a href="<c:url value="/twitter/timeline/Favorites" />">Favorites</a></li>
		</ul>


		<div class="feed">
			<ul class="imagedList">
				<c:forEach items="${timeline}" var="tweet">
					<li class="imagedItem"><img src="${tweet.profileImageUrl}"
						align="left" /></li>
					<div class="content">
						<strong><a
							href="'http://twitter.com/' + ${tweet.fromUser}">
								${tweet.fromUser} </a></strong><br /> <span> ${tweet.text} </span><br /> <span
							class="postTime"> ${tweet.createdAt}</span>
					</div>
				</c:forEach>
			</ul>
		</div>




	</div>
</template:basic>
