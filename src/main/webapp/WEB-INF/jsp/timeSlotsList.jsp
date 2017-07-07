<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@include file="/WEB-INF/views/template/header.jsp"%> --%>

<div class="container-wrapper">
    <div class="container">
<div class="page-header">
<h2><a href="/">Home</a></h2>
    <h1>Courses Time Slots</h1>


    <p class="lead">List of TimeSlots </p>

    </div>
    
<table class="table table-striped table-hover" border="1">

    <thead>
    <tr class="bg-success">
<!-- <th>Photo Thumb</th> -->
        <th>title</th>
        <th>Begin Time</th>
        <th>End Time</th>
        
       
    </tr>

    </thead>
    <c:forEach items="${timeSlots}" var="timeSlot">

    <tr>
        <%-- <td><img src="<c:url value="/resources/images/${product.productId}.png"/>" alt="image" style="width:100%"/> </td> --%>
        <td>${timeSlot.title}</td>
        <td>${timeSlot.beginTime}</td>
             <td>${timeSlot.endTime}</td>
       <%--  <td><a href="<spring:url value="//${student.studentId}"/>"><span class="glyphicon glyphicon-info-sign"></span></a> </td>
 --%>
    </tr>
    </c:forEach>
</table></div></div>
<%-- <%@include file="/WEB-INF/views/template/footer.jsp"%> --%>