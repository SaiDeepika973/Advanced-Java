//storing the values inside varibles
let massRatan=parseInt(prompt("Enter the mass of Ratan"))
let massAnu=parseInt(prompt("Enter the mass of Anu"))
let heightRatan=parseFloat(prompt("Enter the height of Ratan"))
let heightAnu=parseFloat(prompt("Enter the height of Anu"))

//calculating their BMI's and storing them into variables
let BMIRatan=massRatan/(heightRatan+heightRatan)
let BMIAnu=massAnu/(heightAnu+heightAnu)

//writing onto console
console.log(`Ratan BMI:${BMIRatan} Anu BMI:${BMIAnu}`)

//writing onto browser
document.write(`Ratan BMI:${BMIRatan} Anu BMI:${BMIAnu}`)

//check whether Ratan has higher BMI and print it on console and browser
let RatanHigherBMI=BMIRatan>BMIAnu;
console.log(`Ratan has Higher BMI? ${RatanHigherBMI}`)
document.write(`Ratan has Higher BMI? ${RatanHigherBMI}`)



