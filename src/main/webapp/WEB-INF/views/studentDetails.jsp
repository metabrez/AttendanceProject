<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div id="login-box">
            <h2>Studnt Details Information</h2>

           <%--  <c:if test="${not empty msg}">
                <div class="msg">${msg}</div>
            </c:if>

            <form name="loginForm" action="<c:url value="/login"/> " method="post">
                <c:if test="${not empty error}">
                    <div class="error" style="color:#ff0000;">${error}</div>
                </c:if>
                <div class="form-group">
                    <label for="username">User:</label>
                    <input type="text" id="username" name="username" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" class="form-control"/>
                </div>

                <input type="submit" value="Submit" class="btn btn-default"/>

                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form> --%>
            
           <div><a href="students">StudentList</a></div>
<div><a href="courseOfferings">Course Offerings</a></div>
<div><a href="timeSlots">Time Slots</a></div>
<div><a href="courses">Course List</a></div>
<div><a href="locations">Locations</a></div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>