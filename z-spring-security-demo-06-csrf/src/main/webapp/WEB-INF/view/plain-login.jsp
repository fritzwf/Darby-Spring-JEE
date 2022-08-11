<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<HTML>
  <HEAD>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="//feuersoft.com/feuersoft.css">
    <link rel="icon" type="image/x-icon" href="//feuersoft.com/favicon.ico" />
    <title>Spring Auth</title>
  </HEAD>
  <BODY> 
    <div class="text-align-center">
      <h1>Hello Spring Authenticate</h1>
    </div>
    <div class="center">
    
      <table class="mainItemTable">
        <tr>
          <td>
            <form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
            
              <!-- check for login error -->
              <c:if test="${null != param.error}">
                <p class="error-dark">Incorrect credentials, try again.</p>
              </c:if>               
              
              <p class="text-align-center">
                User name: <input type="text" name="username" />
              </p>
              
              <p class="text-align-center">
                Password:&nbsp;&nbsp; <input type="password" name="password" />
              </p>      
              
              <div>
                <input class="button" type="submit" value="Login" />
              </div>
                      
            </form:form>                             
          </td>
        </tr>  
      </table>        
    </div>    
  </BODY>
</HTML>