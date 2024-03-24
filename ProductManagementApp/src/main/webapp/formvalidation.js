function validateForm()
{
	//read the form data
	var proId=document.getElementById("proId").value;
	var proName=document.getElementById("proName").value;
	var proPrice=document.getElementById("proPrice").value;
	var proBrand=document.getElementById("proBrand").value;
	var proMadeIn=document.getElementById("proMadeIn").value;
	
	if(proId.trim()==="" || proName.trim()==="" || proPrice.trim()==="" || proBrand.trim()==="" || proMadeIn.trim()==="")
	{
		alert("All fields must be filled out");
		return false;
	}

	if(parseFloat(proPrice)<0)
	{
		alert("Price must not be a negative value");
		return false;
	}
	
	if(proName.length>50 || proBrand.length>50)
	{
		alert("Product name and brand must not be longer than 50 characters");
		return false;
	}
	
	//read the mfd and exp dates
	
	var proManufactured=document.getElementById("proManufactured").value;
	var proExpiry=document.getElementById("proExpiry").value;

	//convert into date format
	
	var proManufacturedObj=new Date(proManufactured);
	var proExpiryObj=new Date(proExpiry);
	
	//check whether the expiry date is after mannufacturing date or not
	if(proManufacturedObj>proExpiryObj)
	{
		alert("Expiry date can't be before manufacturing date");
		return false;
	}
	
	return true;
}
