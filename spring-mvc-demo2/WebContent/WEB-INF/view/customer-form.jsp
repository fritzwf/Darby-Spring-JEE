<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<HTML>
  <HEAD>
    <link rel="stylesheet" type="text/css" href="//feuersoft.com/feuersoft.css">
    <link rel="icon" type="image/x-icon" href="//feuersoft.com/favicon.ico">    
  	<title>Customer Registration</title>
  </HEAD>
  <BODY> 
    <div class="center-text-nopad">
    
      <table class="listItemTable">
        <tr>
          <td>
        	<form:form action="processForm" modelAttribute="customer">
        		<br><br>
        		First name: <form:input path="firstName" />

        		<br><br>
        		Last name (*): <form:input path="lastName" />
        		<form:errors path="lastName" class="error" />
        	    <br> <br>
        		<i>(*) Last Name is required</i>
            
                <br> <br>
                Free Passes: <form:input path="freePasses" />
                 <form:errors path="freePasses" class="error" />
                 
                <br> <br>
                Postal Code: <form:input path="postalCode" />
                 <form:errors path="postalCode" class="error" />

                <br> <br>
                Course Code: <form:input path="courseCode" />
                 <form:errors path="courseCode" class="error" />                                     
        	
        		<br><br><br>
        
        		<input class="button" type="submit" value="Submit" />  
        	</form:form>
          
          </td>
        </tr>  
      </table>

    </div>
  </BODY>
 </HTML>