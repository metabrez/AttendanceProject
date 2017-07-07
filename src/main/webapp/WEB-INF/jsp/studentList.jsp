<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@include file="/WEB-INF/views/template/header.jsp"%> --%>
<html>
<head>
    <title>Spring Security Example</title>
<link href="/bootstrap.min.css" rel="stylesheet">
    <script src="/jquery-2.2.1.min.js"></script>
    <script src="/bootstrap.min.js"></script>
</head>
<body>

<div class="container-wrapper">
    <div class="container">
<div class="page-header">
<h2><a href="/">Home</a></h2>
    <h1>All students</h1>


    <p class="lead">List of Students </p>

    </div>
    
    
<table class="table table-striped table-hover" border="1">

    <thead>
    <tr class="bg-success">
<!-- <th>Photo Thumb</th> -->
<th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email Address</th>
        <th>Visa Status</th>
         <th>Status</th>
         <th>Entry Date</th>
         <th>Bar Code</th>
       
    </tr>

    </thead>
    <c:forEach items="${students}" var="student">

    <tr>
        <%-- <td><img src="<c:url value="/resources/images/${product.productId}.png"/>" alt="image" style="width:100%"/> </td> --%>
         <td>${student.studentId}</td>
        <td>${student.firstName}</td>
        <td>${student.lastName}</td>
        <td>${student.emailaddress}</td>
        <td>${student.visaStatus}</td>
        <td>${student.status}</td>
        <td>${student.entryDate}</td>
        <td>${student.barcode}</td>
       <%--  <td><a href="<spring:url value="//${student.studentId}"/>"><span class="glyphicon glyphicon-info-sign"></span></a> </td>
 --%>
    </tr>
    </c:forEach>
</table></div></div>
</body>
<%-- <%@include file="/WEB-INF/views/template/footer.jsp"%> --%>