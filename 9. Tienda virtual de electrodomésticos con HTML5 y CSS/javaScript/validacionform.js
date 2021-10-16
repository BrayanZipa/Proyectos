function validar() {

	var nombre, apellido, fechaNacimiento, documento, telefono, ciudad, 
	direccion, correo, usuario, llave;

	nombre = document.getElementById("nombres").value;
	apellido = document.getElementById("apellidos").value;
	fechaNacimiento = document.getElementById("fecha").value;
	documento = document.getElementById("documento").value;
	telefono = document.getElementById("telefono").value;
	ciudad = document.getElementById("ciudad").value;
	direccion = document.getElementById("direccion").value;
	correo = document.getElementById("correo").value;
	usuario = document.getElementById("usuario").value;
	llave = document.getElementById("llave").value;

	var fechaIngresada = new Date(fechaNacimiento);
	var fechaActual = new Date();
	var edad = fechaActual.getFullYear() - fechaIngresada.getFullYear();
	
	
	if(nombre === "" || apellido === "" || fecha === "" || documento === "" || telefono === "" || 
	ciudad === "" || direccion === "" || correo === "" || usuario === "" || llave === "" ){
		alert("Todos los campos son obligatorios");
		return false;
	}
	else if (nombre.length > 35){
		alert("El nombre es muy largo");
		return false;
	}
	else if (apellido.length > 35){
		alert("Los apellidos son muy largos");
		return false;
	}
	else if (edad < 18){
		alert("El usuario tiene que ser mayor de edad");
		return false;
	}
	if (telefono.length < 10){
		alert("El numero de telefono debe contener 10 dígitos");
		return false;
	}
	else if (ciudad.length > 20){
		alert("El nombre de la ciudad es muy largo");
		return false;
	}
	else if (direccion.length > 35){
		alert("El nombre de la dirección es muy largo");
		return false;
	}
	else if (usuario.length < 7 || usuario.length > 20){
		alert("El usuario debe contener de 7 a 20 caracteres");
		return false;
	}
}