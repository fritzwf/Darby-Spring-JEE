<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<HTML lang="en">
  <HEAD>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- <link rel="stylesheet" type="text/css" href="//feuersoft.com/feuersoft.css"> -->
    <link rel="icon" type="image/x-icon" href="//feuersoft.com/favicon.ico" />
    <!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script> -->
    <title>FeuerSoft</title>
  </HEAD>
  <BODY>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script> 
    <div class="text-align-center">
      <h1>Welcome to FeuerSoft</h1>
    </div>
    
    <div class="text-align-center">
      <h2>
        User: <security:authentication property="principal.username" />
      </h2>
      <h2>
        Role(s): <security:authentication property="principal.authorities" />
      </h2>
    </div>
    
    <security:authorize access="hasRole('MANAGER')">
       <p><a href="${pageContext.request.contextPath}/leaders"> Leadership Meeting Notice</a></p>
    </security:authorize>

    <security:authorize access="hasRole('ADMIN')">
      <p><a href="${pageContext.request.contextPath}/systems"> IT Systems Meeting Notice</a></p>    
    </security:authorize>
    
    <!-- add logout button -->
    <div>
      <form:form action="${pageContext.request.contextPath}/logout" method="POST">
        <div>
          <input class="button" type="submit" value="Logout" />
        </div>
      </form:form>  
    </div>
        
  </BODY>
</HTML>
