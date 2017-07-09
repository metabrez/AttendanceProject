<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div id="login-box">
        
        <div><a href="courseOfferingList">Course Offerings</a> </div>
            <h2>Students Course List by His Id</h2>
            
            <table class="table table-striped table-hover" border="1">

    <thead>
    <tr class="bg-success">
<!-- <th>Photo Thumb</th> -->

        <th>Course Number</th>
       
        <th>Course Name</th>
        <!--  <th>BarCode Id</th>
        <th>Offer Id</th>
         <th>Course Number</th>
         <th>Course Name</th>
         <th>Bar Code</th>
        -->
    </tr>

    </thead>
    <c:forEach items="${courseList}" var="course">

    <tr>
        <%-- <td><img src="<c:url value="/resources/images/${product.productId}.png"/>" alt="image" style="width:100%"/> </td> --%>
         <td>${course.number}</td>
          <td>${course.abbr}</td>
       <%--  <td>${student.enrollment.id}</td>
        <td>${student.enrolment.courseoffering.id}</td>
        <td>${student.emailaddress}</td>
        <td>${student.visaStatus}</td>
        <td>${student.status}</td>
        <td>${student.entryDate}</td>
        <td>${student.barcode}</td> --%>
       <%--  <td><a href="<spring:url value="//${student.studentId}"/>"><span class="glyphicon glyphicon-info-sign"></span></a> </td>
 --%>
    </tr>
    </c:forEach>
</table>

        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>