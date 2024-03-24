<%@page import="com.sathya.product.*" import="java.util.Base64"%>
<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>

<title>Product List</title>
<!-- BootStract CDN link to Get the Support of BootStrap-->

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>
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
		
	</tr>
</thead>

<tbody>
	<c:forEach var="product" items="<%=new ProductDao().findAll()%>">
	
		<tr>
			<td>${product.proId}</td>
			<td>${product.proName}</td>
			<td>${product.proPrice}</td>
			<td>${product.proBrand}</td>
			<td>${product.promadeIn}</td>
			<td>${product.promDate}</td>
			<td>${product.promeDate}</td>
			<td><img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(product.proImage)}" alt="ProductImage" style="max-width: 100px; max-height:100px;"></td>
       </tr>
	
	
	</c:forEach>
</tbody>


</table>

</body>
</html>