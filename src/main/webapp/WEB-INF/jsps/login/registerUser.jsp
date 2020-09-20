<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<title>User Name</title>
</head>
<body>
	<h2 class="text-center">Login Page:</h2>
	<div class="container mt-5 p-3 mb-2 bg-dark text-white  ">
		<form action="registerUser" method="post">
			<div class="form-group">
				<label >First Name </label> <input
					type="text" class="form-control" name="firstname">
			</div>
			<div class="form-group">
				<label >Last Name</label> <input
					type="text" class="form-control" name="lastname">
			</div>
			<div class="form-group">
				<label >Email </label> <input
					type="email" class="form-control" name="email">
			</div>
			<div class="form-group">
				<label >password </label> <input
					type="password" class="form-control" name="password">
			</div>
			<div class="form-group">
				<label >Confirm Password</label> <input
					type="password" class="form-control" name="confirmPassword">
			</div>
			<div class="text-center ">
				<button type="submit"
					class="btn btn-primary  p-2 mb-1 bg-white text-dark">register</button>
			</div>
			
		</form>

	</div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>
</body>
</html>