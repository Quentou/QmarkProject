<%@ page import= "loginproject.Student" %>
<%@ page import="loginproject.Answer" %>
<%
    def answer  = grailsApplication.classLoader.loadClass('loginproject.Answer').newInstance()
%>
<%@ page import= "loginproject.User" %>
<!DOCTYPE html>
<html lang="fr"><!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

	<title>testI</title>
	<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'uistyle.css')}" />
	<!--[if lt IE 7]><link rel="stylesheet" href="css/font-awesome-ie7.min.css"><![endif]-->


</head>
<body class="jquery-ui page page-id-19 page-template-default page-slug-demos single-author singular">

<!--[if lt IE 7]>
<p class="chromeframe">You are using an outdated browser. <a href="http://browsehappy.com/">Upgrade your browser today</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to better experience this site.</p>
<![endif]-->

<header>

	<section id="global-nav">
		<nav>

            <div class="userdef">Hello, ${userInstance?.firstName}  <g:link action="logout"><img src="${resource(dir: 'images', file: 'logout.png')}"/></g:link></div>
		</nav>
	</section>
</header>
<div class="loogo"><img src="${resource(dir: 'images', file: 'logo.jpg')}"/>
</div>
<div id="container">



	<div id="content-wrapper" class="clearfix row">


<div class="content-right twelve columns">
	<div id="content">
				<h1 class="entry-title">Bienvenue sur votre interface Teacher</h1>
		<hr>


<g:form action="creerGroup" id="${userInstance?.id}" controller="Teacher">
	
	<div class="formgroup">
		<label>Nom du group:</label>
		<input type="text" name="groupName" class="rototo" /> 
		<label>&nbsp;</label>
		<input type="submit" value="Creer un Groupe"/>
		
	</div>

</g:form>



<g:form id="${userInstance?.id}" params="[ nomCreateur : "${userInstance?.firstName} ${userInstance?.lastName}"]" action="ajouterQuestion" controller="Teacher">
	
	<div class="formquestion">
		<label>Nom du groupe:</label>
		<input type="text" name="groupName" class="rototo"/>
		</br> 
		<label>Question:</label>
		<input type="text" name="question" class="rototo"/>
		</br>  
		<label>Type:(QCM ou Libre)</label>
		<input type="text" name="typeq" class="rototo"/>
		</br>  
		<label>Reponse</label>
		<input type="text" name="vraiereponse" class="rototo"/>
		</br> 
		
		<label>&nbsp;</label>
		<input type="submit" value="Ajouter la Question à un groupe"/>
		
	</div>

</g:form>


<g:each var="q" in="${questionInstanceList}">
	
	<div class="question">${q.question}</div>
	<g:each var="r" in="${reponseInstanceList}">
	<g:if test= "${r.question.question == q.question}"> 
	<div class="reponse">${r.student.firstName} ${r.student.lastName} a répondu ${r.reponse}</div>
	
	</g:if>
	</g:each>
	
	
	<g:if test= "${q.createur == userInstance?.firstName +" " + userInstance?.lastName}">
	</g:if>
</g:each>
</div>

</div>

	</div>
</div>
</div>
<footer class="clearfix simple">
	<div class="constrain">
		<div class="row">
            <div class="teacher">

<img src="${resource(dir: 'images', file: 'teacher.jpg')}"/>

		</div>
	</div>
</footer>




<div id="cboxOverlay" style="display: none;"></div><div id="colorbox" class="" style="display: none;"><div id="cboxWrapper"><div><div id="cboxTopLeft" style="float: left;"></div><div id="cboxTopCenter" style="float: left;"></div><div id="cboxTopRight" style="float: left;"></div></div><div style="clear: left;"><div id="cboxMiddleLeft" style="float: left;"></div><div id="cboxContent" style="float: left;"><div id="cboxLoadedContent" style="width: 0px; height: 0px; overflow: hidden; float: left;"></div><div id="cboxTitle" style="float: left;"></div><div id="cboxCurrent" style="float: left;"></div><div id="cboxNext" style="float: left;"></div><div id="cboxPrevious" style="float: left;"></div><div id="cboxSlideshow" style="float: left;"></div><div id="cboxClose" style="float: left;"></div></div><div id="cboxMiddleRight" style="float: left;"></div></div><div style="clear: left;"><div id="cboxBottomLeft" style="float: left;"></div><div id="cboxBottomCenter" style="float: left;"></div><div id="cboxBottomRight" style="float: left;"></div></div></div><div style="position: absolute; width: 9999px; visibility: hidden; display: none;"></div></div></body></html>

