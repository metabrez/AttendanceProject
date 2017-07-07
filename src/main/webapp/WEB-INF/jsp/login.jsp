<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>You are in!</title>
</head>
<div class="container col-lg-6 col-lg-offset-3">
	<div class="row col-lg-6 col-lg-offset-3">
		<form action="/login" method="POST" class="form-signin">
			<h3 class="form-signin-heading">Welcome To Coffee Shop</h3>
			<br />
			<c:set var="err" value='<%=request.getParameter("error")%>' />
			<c:if test="${err==true}">
				<p>UserName or Password is not matched.
				<p>
			</c:if>

			<input type="text" id="email" name="email" placeholder="Email"
				class="form-control" /> <br /> <input type="password"
				placeholder="Password" id="password" name="password"
				class="form-control" /> <br />
			<button class="btn btn-lg btn-primary btn-block btn-danger"
				name="Submit" value="Login" type="Submit">Login</button>

		</form>
		<br /> <br /> <a href="/registration">Sign Up From Here</a>
	</div>
</div>


</body>
</html>