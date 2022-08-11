<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.feuersoft.springdemo.util.SortUtils" %>
<!DOCTYPE html>
<HTML>
  <HEAD>
    <link rel="stylesheet" type="text/css" href="//feuersoft.com/feuersoft.css">
    <!-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" /> -->
    <link rel="icon" type="image/x-icon" href="//feuersoft.com/favicon.ico" />
    <title>CRM</title>
  </HEAD>
  <BODY> 
    <div id="wrapper">
      <div id="header">
        <div id="header" class="text-align-center">
          <h1>Customer List</h1>
        </div>
      </div>
    </div>
    
    <div id="container">
      <div id="content">
        <br/>      
        <div class="text-align-center">
  
          <!--  add a search box -->
          <form:form action="search" method="GET">
            Search customer: <input type="text" name="theSearchName" />
            &nbsp;
            <input class="button" type="submit" value="Search" />
          </form:form>
        </div>
        <br/>
        <br/>
  
        <div class="text-align-center">
          <!-- put new button: add customer -->
          <input class="button" type="button" value="Add Customer"
            onclick="window.location.href='showFormForAdd'; return false;" />
        </div>
        <br/>
        
        <TABLE class="mainItemTable">            
          <!-- setup header links for sorting -->
          
          <!-- construct a sort link for first name -->
          <c:url var="sortLinkFirstName" value="/customer/list">
          	<c:param name="sort" value="<%= Integer.toString(SortUtils.FIRST_NAME) %>" />
          </c:url>					
          
          <!-- construct a sort link for last name -->
          <c:url var="sortLinkLastName" value="/customer/list">
          	<c:param name="sort" value="<%= Integer.toString(SortUtils.LAST_NAME) %>" />
          </c:url>					
          
          <!-- construct a sort link for email -->
          <c:url var="sortLinkEmail" value="/customer/list">
          	<c:param name="sort" value="<%= Integer.toString(SortUtils.EMAIL) %>" />
          </c:url>					
          
          <tr>
          	<th><a href="${sortLinkFirstName}">First Name</a></th>
          	<th><a href="${sortLinkLastName}">Last Name</a></th>
          	<th><a href="${sortLinkEmail}">Email</a></th>
            <th style="font-size: 13px;">Action</th>
          </tr>
  				        
          <!-- loop over and print our customers -->
          <c:forEach var="tempCustomer" items="${customers}" >
          
            <!-- construct an "update" link with customer id -->
            <c:url var="updateLink" value="/customer/showFormForUpdate">
              <c:param name="customerId" value="${tempCustomer.id}" />                          
            </c:url>
            
            <!-- construct a "delete" link with customer id -->
            <c:url var="deleteLink" value="/customer/delete">
              <c:param name="customerId" value="${tempCustomer.id}" />                          
            </c:url>
  
            <tr>
              <td> ${tempCustomer.firstName} </td>
              <td> ${tempCustomer.lastName} </td>
              <td> ${tempCustomer.email} </td>
              
              <td>
               <!-- display the update link -->
               <a href="${updateLink}">Update</a> |
               <!-- display the delete link -->
               <a href="${deleteLink}" 
                onclick="if (!(confirm('Really delete this customer?'))) return false">
                Delete
               </a>
              </td>              
            </tr>
          </c:forEach>
        </TABLE>        
      </div>
    </div>
  </BODY>
  </HTML>

