<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<HTML>
  <HEAD>
    <link rel="stylesheet" type="text/css" href="//feuersoft.com/feuersoft.css">
    <link rel="icon" type="image/x-icon" href="//feuersoft.com/favicon.ico">    
  	<title>Registration Confirmation</title>
  </HEAD>
  <BODY> 
    <div class="center-text-nopad">

	  <table class="listItemTable">
  	  	<tr>
		  <td>
		    The student is confirmed: ${student.firstName} ${student.lastName}
		  
		    <br><br><br>
		  
		    Country: ${student.country}
		  
		  	<br><br>
		    
		    Favorite Language: ${student.favoriteLanguage}
	  		
	  		<br><br>
	  
	        Operating Systems:
	   
			<ul>
		      <c:forEach var="hasOS" items="${student.operatingSystems}">
				<li> ${hasOS} </li>
		  	  </c:forEach>
			 </ul>
		  </td>
		</tr>  
	  </table>
	 	      
    </div> 
  </BODY>
 </HTML>