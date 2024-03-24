//Ternary operators
function AdultorChild()
{
	let age=document.getElementById('age').value
	let ans=(age<18)?"child":"adult"
	document.getElementById('adorch').value=ans
}

function DrinkorNot()
{
	let age=document.getElementById('age1').value
	let ans=(age<18)?"water":"wine"
	document.getElementById('whattodrink').value=ans
}

function StringToNumber()
{
	let num=document.getElementById('number').value
	document.getElementById('numberstring').value=Number(num)
	document.getElementById('numstr').value=parseFloat(num)
	document.getElementById('ns').value=parseInt(num)
}
function NumberToString()
{
	let num=String(document.getElementById('number1'))
	let num2=String(document.getElementById('number2'))
	document.getElementById('stringvalue').valueOf=num+num2
}
function BooleanData()
{
	let a=Boolean(document.getElementById('b')).valueOf
	document.getElementById('booleanvalue').valueOf=a
}
function compare()
{
	let one=document.getElementById('one')
	let two=document.getElementById('two')
	document.getElementById('compare').value=one
	document.getElementById('compare2').value=two
}
function logical()
{
	let a=document.getElementById('a')
	let b=document.getElementById('b')
	
	document.getElementById('a').value=a&&b
	document.getElementById('b').value=a||b
}
	
	