<%@ page import="com.sathya.servlet.*" import="java.util.Base64" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<title>Edit Form</title>

<!--BootStrap CDN link to get the support of BootStrap-->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css">
	
	<!--This is JavaScript validation code location-->
	<script src="formvalidation.js"></script>

</head>
<body>

	<div class="container mt-5 text-center">
		<h2 class="text-center font-italic mb-1">Edit Form</h2>
			<form method="post" action="./UpdateProductServlet" enctype="multipart/form-data" onsubmit="return validateForm()">
				<div class="form-group">
					<label class="font-italic font-weight bold" for="proId">Product ID:</label>
					<input type="number" class="form-control-sm" id="proId" name="proId" value="${existingProduct.proId}" required>
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
					<label class="font-italic font-weight-bold" for="currentImage">Current Product Image:</label>
					<img  id="currentImage" src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(existingProduct.getProImage())}" alt="Current Product Image" style="max-width: 100px; max-height: 100px;">
					<input type="hidden" id="existingImage" name="existingImage" value="${Base64.getEncoder().encodeToString(existingProduct.proImage)}"/>
				</div>
				
				<!-- Allow the user to upload a new image -->
				<div class="form-group">
					<label class="font-italic font-weight-bold" for="newProImage">New Product Image:</label>
					<input type="file" class="form-control-file-sm" id="newProImage" name="newProImage" accept="image/*">
				</div>

				<!-- Display the current audio -->
				
				<div class="form-group">
					<label class="font-italic font-weight-bold" for="existingAudio">Current Product Audio:</label>
					<audio controls><source src="data:audio/mpeg;base64,${Base64.getEncoder().encodeToString(existingProduct.getProAudio())}" type="audio/mpeg"></audio>
					<input type="hidden" id="existingAudio" name="existingAudio" value="${Base64.getEncoder().encodeToString(existingProduct.proAudio)}"/>
				</div>
				
				<!-- Allow the user to upload a new audio -->
				<div class="form-group">
					<label class="font-italic font-weight-bold" for="newProAudio">New Product Audio:</label>
					<input type="file" class="form-control-file-sm" id="newProAudio" name="newProAudio" accept="audio/*">
				</div>
				
				<!-- Display the current video -->
				
				<div class="form-group">
					<label class="font-italic font-weight-bold" for="existingVideo">Current Product Video:</label>
					<video controls width="320" height="240"><source src="data:video/mp4;base64,${Base64.getEncoder().encodeToString(existingProduct.getProVideo())}" type="video/mp4"></video>
					<input type="hidden" id="existingVideo" name="existingVideo" value="${Base64.getEncoder().encodeToString(existingProduct.proVideo)}"/>
				</div>
				
				<!-- Allow the user to upload a new video -->
				<div class="form-group">
					<label class="font-italic font-weight-bold" for="newProVideo">New Product Video:</label>
					<input type="file" class="form-control-file-sm" id="newProVideo" name="newProVideo" accept="video/*">
				</div>
				
				<div>
					<input type="submit" class="btn btn-success" value="Submit Product">
					<a href="productlist.jsp" class="btn btn-primary">List Of Products</a>
				</div>
			</form>
	</div>

</body>
</html>
