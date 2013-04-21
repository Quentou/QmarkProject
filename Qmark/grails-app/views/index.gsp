<!DOCTYPE html>
<html>
<head>
<%--<meta name="layout" content="main" /> --%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login Form</title>

<!--STYLESHEETS-->
<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'style.css')}" />

<!--SCRIPTS-->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
<!--Slider-in icons-->
<script type="text/javascript">
$(document).ready(function() {
	$(".username").focus(function() {
		$(".user-icon").css("left","-48px");
	});
	$(".username").blur(function() {
		$(".user-icon").css("left","0px");
	});
	
	$(".password").focus(function() {
		$(".pass-icon").css("left","-48px");
	});
	$(".password").blur(function() {
		$(".pass-icon").css("left","0px");
	});
});
</script>
<%-- <style type="text/css" media="screen">
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
/*<g:resource dir="css" file="style.css" absolute="true" />*/
</style>


--%>
</head>
<body>
<%--
${flash.message}
	<g:form action="login" controller="user" style="padding-left:200px">
	
	<div style="width: 220px">
		<label>Name:</label>
		<input type="text" name="username"/> 
		<label>Password:</label>
		<input type="password" name="password"/> 
		<label>&nbsp;</label>
		<input type="submit" value="login"/>
	</div>

	</g:form>
	
	</br>
	
	<g:form action="create" controller="Student" style="padding-left:200px">
	
	<div style="width: 220px">
		<label>&nbsp;</label>
		<input type="submit" value="create Student"/>
	</div>
	</g:form>
	</br>
	
	<g:form action="create" controller="Teacher" style="padding-left:200px">
	
	<div style="width: 220px">
		<label>&nbsp;</label>
		<input type="submit" value="create Teacher"/>
	</div>
	

	

	</g:form>
	
	</br>
	
	<g:form action="create" controller="Stugroup" style="padding-left:200px">
	
	<div style="width: 220px">
		<label>&nbsp;</label>
		<input type="submit" value="create Stugroup"/>
	</div>
	

	

	</g:form>
	
		</br>
	
	<g:form action="create" controller="Question" style="padding-left:200px">
	
	<div style="width: 220px">
		<label>&nbsp;</label>
		<input type="submit" value="create Question"/>
	</div>
	</g:form>
	
	<g:form action="indexCreerStudent" controller="Student" style="padding-left:200px">
	
	<div style="width: 220px">
		<label>&nbsp;</label>
		<input type="submit" value="creer Student"/>
	</div>
	</g:form>
	
	
	--%>
	<!--WRAPPER-->
<div id="wrapper">

	<!--SLIDE-IN ICONS-->
    <div class="user-icon"></div>
    <div class="pass-icon"></div>
    <!--END SLIDE-IN ICONS-->

<!--LOGIN FORM-->
<g:form name ="login-form" class="login-form" controller="user" action="login">



	<!--HEADER-->
    <div class="header">
        <div id="app-logo">
            <img src="${resource(dir: 'images', file: 'app-logo-square.png')}" alt="QMARK" width="72" height="72"/>
        </div>
    </div>
    <!--END HEADER-->
	
	<!--CONTENT-->
    <div class="content">
	<!--USERNAME--><input name="username" type="text" class="input username" value="Username" onfocus="this.value=''" /><!--END USERNAME-->
    <!--PASSWORD--><input name="password" type="password" class="input password" value="Password" onfocus="this.value=''" /><!--END PASSWORD-->
    </div>
    <!--END CONTENT-->
    
    <!--FOOTER-->
    <div class="footer">
    <!--LOGIN BUTTON--><input type="submit" name="submit" value="login" class="button" /><!--END LOGIN BUTTON-->
    </div>
    <!--END FOOTER-->

</g:form>
<!--END LOGIN FORM-->

</div>
<!--END WRAPPER-->
<g:form action="indexCreerStudent" controller="Student" style="padding-left:200px">
	
	<div class="buttonsplus">
		<label>&nbsp;</label>
		<input type="submit" value="creer Student" class="button"/>
	</div>
	</g:form>
	</br>
	
	<g:form action="createTeacher" controller="Teacher" style="padding-left:200px">
	
	<div style="width: 220px">
		<label>&nbsp;</label>
		<input type="submit" value="creer Teacher" class="button"/>
	</div>
	

	

	</g:form>
	
<!--GRADIENT--><div class="gradient"></div><!--END GRADIENT-->
	
	
</body>
</html>
