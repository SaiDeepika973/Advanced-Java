function palindromeCheck()
{
	//read the data and assign to variable
	let name=document.getElementById('name').value
	
	//reverse the string
	let rev=name.split('').reverse().join('')
	
	//check the condition and yield the output
	if(rev==name)
		alert("It is a palindrome")
	else
		alert("It is not a palindrome")
}