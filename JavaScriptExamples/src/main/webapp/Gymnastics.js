let dolphin1=parseInt(prompt("Enter dolphin first score"))
let dolphin2=parseInt(prompt("Enter dolphin second score"))
let dolphin3=parseInt(prompt("Enter dolphin third score"))

let koala1=parseInt(prompt("Enter koala first score"))
let koala2=parseInt(prompt("Enter koala second score"))
let koala3=parseInt(prompt("Enter koala third score"))

let scoreDolphins=(dolphin1+dolphin2+dolphin3)/3
let scoreKoala=(koala1+koala2+koala3)/3

let result;

if(scoreDolphins>scoreKoala)
	result="Dolphins win the trophy"
	
else if(scoreKoala>scoreDolphins)
	result="Koalas win the trophy"
	
else
	result="Both win the trophy"
	
document.write(result)