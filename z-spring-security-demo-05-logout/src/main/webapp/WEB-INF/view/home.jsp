<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<HTML>
  <HEAD>
    <link rel="stylesheet" type="text/css" href="//feuersoft.com/feuersoft.css">
    <link rel="icon" type="image/x-icon" href="//feuersoft.com/favicon.ico" />
    <title>FeuerSoft</title>
  </HEAD>
  <BODY> 
    <div class="text-align-center">
      <h1>Welcome to the FeuerSoft</h1>
    </div>
    
    <!-- add logout button -->
    <div class="text-align-center">
      <form:form action="${pageContext.request.contextPath}/logout" method="POST">
        <div>
          <input class="button" type="submit" value="Logout" />
        </div>
      </form:form>  
    </div>
        
  </BODY>
</HTML>
