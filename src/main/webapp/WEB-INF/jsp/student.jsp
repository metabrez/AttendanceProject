<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>You are in!</title>
</head>
<body>
	<h1>Welcome To Our Student Registration Page</h1>
	<h2>Please Enter students details</h2>
	<div class="container">
	<form method="post" action="/">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<form autocomplete="off" action="#" action="registration"
					method="post" class="form-horizontal" role="form">
					<h2>Registration Form</h2>
					<div class="form-group">
						<div class="col-sm-9">
							<input type="text" name="firstName" placeholder="First Name"
								class="form-control" />
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-9">
							<input type="text" name="lastName" placeholder="Last Name"
								class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-9">
							<input type="email" name="emailaddress" placeholder="Email"
								class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-9">
							<input type="text" name="visaStatus" placeholder="Visa Status"
								class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-9">
							<input type="text" name="status" placeholder="Status"
								class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-9">
							<input type="text" name="barcode" placeholder="Bar code"
								class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-9">
							<input type="date" name="entryDate" placeholder="Bar code"
								class="form-control" />
						</div>
					</div>
					
					<!-- <div class="form-group">
						<div class="col-sm-9">
							<select name="type" class="form-control">
								<option value="USER">User</option>
								<option value="ADMIN">Admin</option>
							</select>
						</div>
					</div> -->

					<div class="form-group">
						<div class="col-sm-9">
							<button type="submit" class="btn btn-primary btn-block">Register
								Student</button>
							<a href="/home" class="btn btn-success">Home</a>
						</div>
					</div>
					<h3></h3>
				</form>
			</div>
		</div>
	</form>
	
	</div>


</body>
</html>