<?php
    include 'conexion.php';

    $id = $_GET['id'];
    $sqlConsulta = "DELETE from usuarios WHERE id='".$id."'";
    mysqli_query($con,$sqlConsulta);
    $_SESSION['message']='Registro eliminado';
    $_SESSION['color']='danger';
    header("location:index.php");
?>