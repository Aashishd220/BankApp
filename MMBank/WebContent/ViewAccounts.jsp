<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
table thead tr th {
	color:rgb(30,144,255);
}
</style>
<body>

<div>
<div>
<jstl:if test="${sessionScope.viewcust.size() != 0 }">
<header  style="background-color:rgba(50,50,50,0.8);">
	<h3 style="text-align: center; color:white;">All Available Account</h3>
</header>
<table  style="background-color: rgba(50,50,50,0.8);">
  <thead>
    <tr>
      <th scope="col">Account Number</th>
      <th scope="col">Customer ID</th>
      <th scope="col">Account Type</th>
      <th scope="col">Account Balance</th>
      <th scope="col">Overdraft Limit</th>
      <th scope="col">Salary Account ? </th>

    </tr>
  </thead>
  <tbody>
   <jstl:forEach var="viewaccount" items="${sessionScope.viewaccount}">
    <tr>
      <td>${viewaccount.accountNumber}</td>
      <td>${viewaccount.accountHolder.customerId}</td>
      <td>${viewaccount.accountType}</td>
      <td>${viewaccount.accountBalance}</td> 
      <td>${viewaccount.odLimit}</td>
     <td>${viewaccount.salary}</td>
      
    </tr></jstl:forEach>
  </tbody>
</table></jstl:if> </div></div>
<jstl:if test="${sessionScope.viewcust.size() == 0 }">
<div >
<header  style="background-color:rgba(50,50,50,0.8);">
	<h5 style="color:red;text-align: center;">OOPS!!! Accounts not available yet</h5>
</header></div>
</jstl:if>
</body></html>