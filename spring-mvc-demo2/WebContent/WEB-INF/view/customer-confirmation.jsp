
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<HTML>
  <HEAD>
    <link rel="stylesheet" type="text/css" href="//feuersoft.com/feuersoft.css">
    <link rel="icon" type="image/x-icon" href="//feuersoft.com/favicon.ico">    
    <title>Customer Confirmation</title>
  </HEAD>
  <BODY> 
    <div class="center-text-nopad">
    
      <table class="listItemTable">
        <tr>
          <td>
            The customer is confirmed: ${customer.firstName} ${customer.lastName}

            <br> <br>          

            Free passes: ${customer.freePasses}
            
            <br> <br>          

            Postal Code: ${customer.postalCode}
            
            <br> <br>          

            Course Code: ${customer.courseCode}                             
          </td>
        </tr>  
      </table>    

    </div>
  </BODY>
 </HTML>