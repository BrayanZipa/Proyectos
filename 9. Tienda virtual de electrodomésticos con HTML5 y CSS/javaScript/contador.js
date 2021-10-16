var numArticulos = 0; 
var valorArticulos = 0;

function contador(valor) {
 
	numArticulos += 1;
	valorArticulos += parseInt(valor);

	document.getElementById("na").innerHTML = numArticulos;
	document.getElementById("va").innerHTML = "$  "+valorArticulos;
}






