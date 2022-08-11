<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<HTML>
  <HEAD>
    <link rel="stylesheet" type="text/css" href="//feuersoft.com/feuersoft.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
    <link rel="icon" type="image/x-icon" href="//feuersoft.com/favicon.ico" />
    <title>Save Customer</title>
  </HEAD>
  <BODY> 
    
    <div id="wrapper">
      <div id="header">
        <div id="header" class="text-align-center">
          <h1 style="color:DarkSlateGrey">Customer Relationship Manager</h1>
        </div>
      </div>
    </div>
    
    <div id="container">
      <div class="text-align-center">
        <h2 style="color:MediumAquaMarine;font-size:18px;">Save Customer</h2>
      </div>
        
      <form:form action="saveCustomer" modelAttribute="customer" method="POST">
        
        <!-- need to associate this data with customer id -->
        <form:hidden path="id" />
        
        <table>
          <tbody>
          
          <tr>
            <td> <label>First Name:</label> </td>
            <td> <form:input path="firstName" /> </td>
          </tr>
          
          <tr>
            <td> <label>Last Name:</label> </td>
            <td> <form:input path="lastName" /> </td>
          </tr>
          
          <tr>
            <td> <label>Email:</label> </td>
            <td> <form:input path="email" /> </td>
          </tr>          
          
          <tr>
            <td> <label></label> </td>
            <td> <input class="save" type="submit" value="Save" /> </td>
          </tr>     
          
          <tr>
            <td> <label></label> </td>
            <td>
              <label>
                <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
              </label>
            </td>
          </tr>
          
          </tbody>
        
        </table>
        
        </form:form>
        
        <div style="clear; both;"></div>
    </div>
    
  </BODY>
  </HTML>

