<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@include file="/WEB-INF/views/template/header.jsp"%> --%>

<div class="container-wrapper">
    <div class="container">
<div class="page-header">
<h2><a href="/">Home</a></h2>
    <h1>All students</h1>


    <p class="lead">List of Students </p>

    </div>
    <p>public class CourseOffering implements Identifiable<Long> {
	
<table class="table table-striped table-hover" border="1">

    <thead>
    <tr class="bg-success">
<!-- <th>Photo Thumb</th> -->
        <th>Course</th>
        <th>Period</th>
        <th>Start Date</th>
        <th>Enrollments</th>
         <th>Capacity</th>
         <th>Enrolled</th>
         <th>Active</th>
         <th>DE</th>
         <th>Faculty FirstName</th>
          <th>Faculty LastName</th>
         
         <th>Block</th>
         <!-- <th>On Campus</th> -->
         
       
    </tr>

    </thead>
    <c:forEach items="${courseOfferings}" var="courseOffering">

    <tr>
        <%-- <td><img src="<c:url value="/resources/images/${product.productId}.png"/>" alt="image" style="width:100%"/> </td> --%>
        <td>${courseOffering.course}</td>
         <td>${courseOffering.period}</td>
          <td>${courseOffering.startDate}</td>
           <td>${courseOffering.enrollments}</td>
            <td>${courseOffering.capacity}</td>
             <td>${courseOffering.enrolled}</td>
              <td>${courseOffering.active}</td>
               <td>${courseOffering.de}</td>
               <td>${courseOffering.faculty.firstName}</td>
               <td>${courseOffering.faculty.lastName}</td>
                <td>${courseOffering.block}</td>
                 <%-- <td>${courseOffering.oncampus}</td> --%>
             
       <%--  <td><a href="<spring:url value="//${student.studentId}"/>"><span class="glyphicon glyphicon-info-sign"></span></a> </td>
 --%>
    </tr>
    </c:forEach>
</table></div></div>
<%-- <%@include file="/WEB-INF/views/template/footer.jsp"%> --%>