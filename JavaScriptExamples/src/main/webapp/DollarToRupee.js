function DollarToRupee()
{
	//read the data and set to variable
	const dollar=document.getElementById('dollar').value
	
	//covert into INR
	const inr=parseFloat(dollar*82.90)
	
	//set the output
	document.getElementById('inr').value=inr.toFixed(2)
}