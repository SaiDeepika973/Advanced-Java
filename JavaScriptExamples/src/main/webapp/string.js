function reverse()
{
	//read the input and set to variable
	let string=document.getElementById('string').value
	
	//reverse the string
	let rev=string.split('').reverse().join('')
	
	//set the output
	document.getElementById('rev').value=rev
}