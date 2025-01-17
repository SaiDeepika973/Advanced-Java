<%@page import="com.sathya.servlet.*" import="java.util.Base64"%>
<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>

<title>Product List</title>
<!-- BootStract CDN link to Get the Support of BootStrap-->

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>

<h1 class="text-success text-center">Product List</h1>

<div>
<input type="text" placeholder="search">
</div>

<div>
<input type="submit" class="btn btn-success" value="Search">
</div>

<div>
	<c:if test="${saveResult==1}">
		<h3 class="text-success text-center">Data inserted successfully....</h3>
		</c:if>
</div>

<div>
	<c:if test="${deleteResult==1}">
		<h3 class="text-danger text-center">Data deleted successfully....</h3>
		</c:if>
</div>

<div>
	<c:if test="${deleteResult==0}">
		<h3 class="text-danger text-center">Data deletion failed.....</h3>
		</c:if>
</div>

<table class="table table-bordered table-striped">
	
<thead class="thead-dark">
	<tr>
	
		<th>Product ID</th>
		<th>Product Name</th>
		<th>Product Cost</th>
		<th>Brand</th>
		<th>Made In</th>
		<th>Manufacture Date</th>
		<th>Expire Date</th>
		<th>Image</th>
		<th>Actions</th>
		
	</tr>
</thead>

<tbody>
	<c:forEach var="product" items="<%=new ProductDao().findAll()%>">
	
		<tr>
			<td>${product.proId}</td>
			<td>${product.proName}</td>
			<td>${product.proPrice}</td>
			<td>${product.proBrand}</td>
			<td>${product.proMadeIn}</td>
			<td>${product.proManufactured}</td>
			<td>${product.proExpiry}</td>
			<td><img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(product.proImage)}" alt="ProductImage" style="max-width: 100px; max-height:100px;"></td>
			<td><audio controls><source src="data:audio/jpeg;base64,${Base64.getEncoder().encodeToString(product.proAudio)}" type="audio/mpeg"></audio></td>
			<td><video controls width="320" height="240"><source src="data:video/jpeg;base64,${Base64.getEncoder().encodeToString(product.proVideo)}" type="video/mp4"></video></td>
			<td>
				<a class="btn btn-primary" href="./DeleteProductServlet?proId=${product.proId}">Delete</a>
				<a class="btn btn-primary" href="./EditProductServlet?proId=${product.proId}">Edit</a>
			</td>
       </tr>
	
	
	</c:forEach>
</tbody>


</table>

</body>
</html>