<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<HTML>
  <HEAD>
    <link rel="stylesheet" type="text/css" href="//feuersoft.com/feuersoft.css">
    <link rel="icon" type="image/x-icon" href="//feuersoft.com/favicon.ico">    
  	<title>Student Registration</title>
  </HEAD>
  <BODY> 
    <div class="center-text-nopad">

	<form:form action="processForm" modelAttribute="student">
		<br><br>
		First name: <form:input path="firstName" />
		<br><br>
		Last name: <form:input path="lastName" />
	
		<br><br>
		
		Country:
		
		<form:select path="country">
		  <form:options items="${student.countryOptions}" />
		</form:select>
		
		<br><br>
		
		Favorite Programming Language <br>
		
		<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}" />	
		
		<br><br>
		
		Favorite Operating Systems <br>
		
		<form:checkbox path="operatingSystems" value="Linux" /> Linux		
		<form:checkbox path="operatingSystems" value="Mac OS" /> Mac OS
		<form:checkbox path="operatingSystems" value="MS Windows" /> MS Windows
		
	    <br><br>
		
		<input class="button" type="submit" value="Submit" />  
	</form:form>
    
    </div>
  </BODY>
 </HTML>