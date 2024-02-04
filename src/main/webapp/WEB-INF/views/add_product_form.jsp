<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp" %>
</head>
<body>
	<div class="container">
		<div class="row">
		
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-3">Fill the product details</h1>
				<form action="handle-product" method="post">
					<div class="form-group">
						<label for="name">Product Name</label>
						<input type="text" class="form-control" id="name" aria-describedby="nameHelp"
						name="name" placeholder="Enter the product name here">
					</div>
					<div class="form-group">
						<label for="description">Product Description</label>
						<textarea  class="form-control" id="description" aria-describedby="descHelp"
						rows="5" name="description" placeholder="Enter the product description"></textarea>
					</div>
					<div class="form-group">
						<label for="price">Product Name</label>
						<input type="text" class="form-control" id="price"
						name="price" placeholder="Enter the product Price">
					</div>
					<div class="container text-center">
						<a href="${pageContext.request.contextPath }/" class="btn btn-outline-danger">Back</a>
						<button type="submit" class="btn btn-primary">Update</button>
					</div>
				
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>