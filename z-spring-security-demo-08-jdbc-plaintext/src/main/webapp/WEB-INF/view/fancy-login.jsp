<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">

<head>
	
	<title>Login Page</title>

    <!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!-- Reference 3 Bootstrap files -->
	<link rel="stylesheet"
		 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
    <!-- Reference 5 Bootstrap files -->
    <!-- 
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
     -->
</head>

<body>

  <div>
		
    <div id="loginbox" style="margin-top: 50px;" class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">
  	
      <div class="panel panel-info">
  
        <div class="panel-heading">
        	<div class="panel-title">Sign In</div>
        </div>
  
        <div style="padding-top: 30px" class="panel-body">
  
          <!-- Login Form -->
          <form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST" class="form-horizontal">
  
            <!-- Place for messages: error, alert etc ... -->
            <div class="form-group">
              <div class="col-xs-15">
                  <div>
  
                    <!-- check for login error -->
                    
                    <c:if test="${null != param.error}">
                      <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                      	Invalid username or password.
                      </div>
                    </c:if>   
  
	            
                    <c:if test="${null != param.logout}">
                      <div class="alert alert-success col-xs-offset-1 col-xs-10">
                      	You have been logged out.
                      </div>
                    </c:if>

  
                  </div>
                </div>
              </div>
  
  			<!-- User name -->
  			<div style="margin-bottom: 25px" class="input-group">
  				<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
  				
  				<input type="text" name="username" placeholder="username" class="form-control">
  			</div>
  
  			<!-- Password -->
  			<div style="margin-bottom: 25px" class="input-group">
  				<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
  				
  				<input type="password" name="password" placeholder="password" class="form-control" >
  			</div>
  
  			<!-- Login/Submit Button -->
  			<div style="margin-top: 10px" class="form-group">						
  				<div class="col-sm-6 controls">
  					<button type="submit" class="btn btn-success">Login</button>
  				</div>
  			</div>
        
            <!-- Manually add tokens instead of using form:form -->
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }">
            
          </form:form>
        </div>
      </div>
    </div>
  </div>

</body>
</html>