<%--@elvariable id="loginFailed" type="java.lang.Boolean"--%>
<%--@elvariable id="loginForm" type="com.wrox.site.AuthenticationController.Form"--%>
<%--@elvariable id="validationErrors" type="java.util.Set<javax.validation.ConstraintViolation>"--%>
<spring:message code="title.login" var="loginTitle" />
<template:loggedOut htmlTitle="${loginTitle}" bodyTitle="${loginTitle}">
    <c:if test="${param.containsKey('loginFailed')}">
        <b class="errors"><spring:message code="error.login.failed" /></b><br />
    </c:if><c:if test="${param.containsKey('loggedOut')}">
        <i><spring:message code="message.login.loggedOut" /></i><br /><br />
    </c:if>
    <spring:message code="message.login.instruction" /><br /><br />
    <form:form method="post" modelAttribute="loginForm" autocomplete="off">
        <form:label path="username"><spring:message code="field.login.username" /></form:label><br />
        <form:input path="username" autocomplete="off" /><br />
        <form:label path="password"><spring:message code="field.login.password" /></form:label><br />
        <form:password path="password" autocomplete="off" /><br />
        <input type="submit" value="<spring:message code="field.login.submit" />" />
    </form:form>
    
    <div>
    	<a href="<c:url value="/user/register" />" >
    		<spring:message code="field.signUp.submit" />
    	</a>
    </div>
</template:loggedOut>
