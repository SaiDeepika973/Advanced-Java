function convertToCelsius()
{
	//read the input and set to variable
	const fahrenheit=document.getElementById('fahrenheit').value
	
	//convert into celsius
	const celsius=(parseFloat(fahrenheit-32))*5/9
	
	//set the output to celsius
	document.getElementById('celsius').value=celsius.toFixed(2)
}