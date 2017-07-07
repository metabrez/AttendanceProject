<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@include file="/WEB-INF/views/template/header.jsp"%> --%>

<div class="container-wrapper">
    <div class="container">
<div class="page-header">
<h2><a href="/">Home</a></h2>
    <h1>List Of Courses</h1>


    <p class="lead">Complete List of courses </p>

    </div>
<table class="table table-striped table-hover" border="1">

    <thead>
    <tr class="bg-success">
<!-- <th>Photo Thumb</th> -->
        <th>Abbr</th>
        <th>Name</th>
        <th>Description</th>
        
       
    </tr>

    </thead>
    <c:forEach items="${courses}" var="course">

    <tr>
        <%-- <td><img src="<c:url value="/resources/images/${product.productId}.png"/>" alt="image" style="width:100%"/> </td> --%>
        <td>${course.abbr}</td>
          <td>${course.name}</td>
            <td>${course.description}</td>
       <%--  <td><a href="<spring:url value="//${student.studentId}"/>"><span class="glyphicon glyphicon-info-sign"></span></a> </td>
 --%>
    </tr>
    </c:forEach>
</table></div></div>
<%-- <%@include file="/WEB-INF/views/template/footer.jsp"%> --%>