<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>Edit Form</title>

<!--BootStrap CDN link to get the support of BootStrap-->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	
	<!--This is JavaScript validation code location-->
	<script src="formvalidation.js"></script>

</head>
<body>

	<div class="container mt-5 text-center">
		<h2 class="text-center font-italic mb-1">Edit Form</h2>
			<form method="post" action="./UpdateProductServlet" enctype="multipart/form-data" onsubmit="return validateForm()">
				<div class="form-group">
					<label class="font-italic font-weight bold" for="proId">Product ID:</label>
					<input type="text" class="form-control-sm" id="proId" name="proId" value="${existingProduct.proId}" required>
				</div>
				
				<div class="form-group">
					<label class="font-italic font-weight bold" for="proName">Product Name:</label>
					<input type="text" class="form-control-sm" id="proName" name="proName" value="${existingProduct.proName}" required>
				</div>
				
				<div class="form-group">
					<label class="font-italic font-weight bold" for="proPrice">Product Price:</label>
					<input type="text" class="form-control-sm" id="proPrice" name="proPrice" value="${existingProduct.proPrice}">
				</div>
				
				<div class="form-group">
					<label class="font-italic font-weight bold" for="proBrand">Product Brand:</label>
					<input type="text" class="form-control-sm" id="proBrand" name="proBrand" value="${existingProduct.proBrand}">
				</div>
				
				<div class="form-group">
					<label class="font-italic font-weight bold" for="proMadeIn">Made In:</label>
					<input type="text" class="form-control-sm" id="proMadeIn" name="proMadeIn" value="${existingProduct.proMadeIn}">
				</div>
				
				<div class="form-group">
					<label class="font-italic font-weight bold" for="proManufactured">Manufacturing Date:</label>
					<input type="date" class="form-control-sm" id="proManufactured" name="proManufactured" value="${existingProduct.proManufactured}">
				</div>
				
				<div class="form-group">
					<label class="font-italic font-weight bold" for="proExpiry">Expiry Date:</label>
					<input type="date" class="form-control-sm" id="proExpiry" name="proExpiry" value="${existingProduct.proExpiry}">
				</div>
				
				<!-- Display the current product image -->
				
				<div class="form-group">
					<label class="font-italic font-weight-bold" for="proImage">Current Product Image:</label>
					<img  id="currentImage" src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(existingProduct.proImage)}" alt="Current Product Image" style="max-width: 100px; max-height: 100px;">
					<input type="hidden" id="existingImage" name="existingImage" value="${Base64.getEncoder().encodeToString(existingProduct.proImage)}"/>
				</div>
				
				<!-- Allow the user to upload a new image -->
				<div class="form-group">
					<label class="font-italic font-weight-bold" for="newProImage">New Product Image:</label>
					<input type="file" class="form-control-file-sm" id="newProImage" name="newProImage" accept="image/*">
				</div>
				
				<div>
					<input type="submit" class="btn btn-success" value="Submit Product">
					<a href="productlist.jsp" class="btn btn-primary">List Of Products</a>
				</div>
			</form>
	</div>

</body>
</html>