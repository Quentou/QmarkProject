<%@ page import= "loginproject.Student" %>
<%@ page import="loginproject.Answer" %>
<%
    def answer  = grailsApplication.classLoader.loadClass('loginproject.Answer').newInstance()
%>
<%@ page import= "loginproject.User" %>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
<title>Login</title>
<style type="text/css" media="screen">
#status {
	background-color: #eee;
	border: .2em solid #fff;
	margin: 2em 2em 1em;
	padding: 1em;
	width: 12em;
	float: left;
	-moz-box-shadow: 0px 0px 1.25em #ccc;
	-webkit-box-shadow: 0px 0px 1.25em #ccc;
	box-shadow: 0px 0px 1.25em #ccc;
	-moz-border-radius: 0.6em;
	-webkit-border-radius: 0.6em;
	border-radius: 0.6em;
}

.ie6 #status {
	display: inline;
	/* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
}

#status ul {
	font-size: 0.9em;
	list-style-type: none;
	margin-bottom: 0.6em;
	padding: 0;
}

#status li {
	line-height: 1.3;
}

#status h1 {
	text-transform: uppercase;
	font-size: 1.1em;
	margin: 0 0 0.3em;
}

#page-body {
	margin: 2em 1em 1.25em 18em;
}

h2 {
	margin-top: 1em;
	margin-bottom: 0.3em;
	font-size: 1em;
}

p {
	line-height: 1.5;
	margin: 0.25em 0;
}

#controller-list ul {
	list-style-position: inside;
}

#controller-list li {
	line-height: 1.3;
	list-style-position: inside;
	margin: 0.25em 0;
}

@media screen and (max-width: 480px) {
	#status {
		display: none;
	}
	#page-body {
		margin: 0 1em 1em;
	}
	#page-body h1 {
		margin-top: 0;
	}
}
</style>
</head>
<body>
<div class="message">
${flash.message}
</div>

<g:if test="${session.user}">
<br/>
login as: ${session.user} | <g:link action="logout">Logout</g:link>
</g:if>




<g:else>


</g:else>
<br/>


<br/>

${userInstance?.firstName}

${userInstance?.lastName}

${userInstance?.email}

${userInstance?.password}

${userInstance?.group.nom }


<g:each var="q" in="${userInstance?.group.questions}">
	<p>${q.question}</p>
	<p> Question posée par ${q.createur} </p>
	
	<g:set var="proposeQuestion" value="true"/>
	<g:each var="r" in="${userInstance?.reponses}">
	
	<g:if test= "${r.question.question == q.question}">
		<p>${r.reponse} </p>
		<g:if test= "${r.question.reponse == r.reponse }">
		
			<p>VRAI!</p>
		</g:if>
		<g:else>
			<p>FAUX!</p>
		</g:else>
		
		
		<g:set var="proposeQuestion" value="false"/>
	</g:if> 
	
	</g:each>
	<g:if test= "${proposeQuestion == "true"}">
	<g:form action="ajouterReponse" id="${userInstance?.id}" params="[ iduser : "${userInstance?.id}", idquestion : "${q?.id}"]" controller="Student" style="padding-left:200px">
	
		<div style="width: 220px">
		
			<label>reponse:</label>
			<input type="text" name="reponse"/> 
			<label>&nbsp;</label>
			<input type="submit" value="ajouter reponse"/>
		</div>
	
	</g:form>
	</g:if>
	
	
	
	
    
</g:each>

	
</body>
</html>
