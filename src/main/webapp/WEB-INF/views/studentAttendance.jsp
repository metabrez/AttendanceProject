<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div id="login-box">
        
        <div><a href="courseOfferingList">Course Offerings</a> </div>
            <h2>Students Meditaton Attendance Report</h2>
            
            <table class="table table-striped table-hover" border="1">

    <thead>
    <tr class="bg-success">
<!-- <th>Photo Thumb</th> -->

        <th>Student Id</th>
       
        <th>First Name</th>
         <th>Last Name</th>
        <th>Course Name</th>
         <th>Attendance</th>
         
         <th>Bar Code</th>
       
    </tr>

    </thead>
    <%-- <c:forEach items="${students}" var="student">

    <tr>
        <td><img src="<c:url value="/resources/images/${product.productId}.png"/>" alt="image" style="width:100%"/> </td>
         <td>${student.studentId}</td>
        <td>${student.firstName}</td>
        <td>${student.lastName}</td>
        <td>${student.course.abbr}</td>
        <td>${student.enrolment.attendance}</td>
        <td>${student.barcode}</td>
       
        <td><a href="<spring:url value="//${student.studentId}"/>"><span class="glyphicon glyphicon-info-sign"></span></a> </td>

    </tr>
    </c:forEach> --%>
</table>

        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>