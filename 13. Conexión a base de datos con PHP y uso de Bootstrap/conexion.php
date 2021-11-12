<?php
    session_start();
    
    $servidor = "localhost";
    $usuario = "root";
    $clave = "";
    $base = "registros";

    $con = mysqli_connect($servidor,$usuario,$clave,$base) or die("Error al conectar a la base de datos");
    // mysqli_select_db($con,$base); 
?>