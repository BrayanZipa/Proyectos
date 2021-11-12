<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Formulario</title>
    <style>
        body{
            background-color: rgba(188, 241, 63, 0.815);
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        h3 {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            text-align: center;
            margin: 50px;
        }

        form{
            margin-left: 28%;
            margin-right: 28%;
        }

        .form-group{
            margin-top:  30px;
        }

        #boton {
            text-align: center;
            margin-top: 30px;
        }

        input[type="submit"],a{
            width: 100px;
            margin-left: 10px;
            margin-right: 10px;
            margin-top: 10px;
        }
    </style>
</head>

<body>
    <h3>Formulario de ingreso</h3>
    <form action="ingresar.php" method="POST">
        <div class="form-group">
            <input class="form-control" type="text"  name="nombre" placeholder="Nombre" requerid="" pattern="[a-z A-Z]+">			
        </div>

        <div class="form-group">
            <input class="form-control" type="text"  name="apellido" placeholder="Apellido" requerid="" pattern="[a-z A-Z]+">			
        </div>

        <div class="form-group">
            <input class="form-control" type="email"  name="email" placeholder="E-mail" requerid="">			
        </div>

        <div class="form-group">
            <input class="form-control" type="text"  name="telefono" placeholder="Teléfono" requerid="" pattern="[0-9]+" maxlength="10" minlength="10">			
        </div>

        <div class="form-group">
            <input class="form-control" type="text"  name="direccion" placeholder="Dirección" requerid="">			
        </div>

        <div id="boton" class="form-group">
            <input class="btn btn-dark" type="submit" name="enviar" value="Enviar">
            <a class="btn btn-dark" href="index.php">Regresar</a>
        </div>
    </form>

    <?php
    include 'conexion.php';

    if(isset($_POST['enviar'])){

        $nombre = $_POST['nombre'];
        $apellido = $_POST['apellido'];
        $email = $_POST['email'];
        $telefono = $_POST['telefono'];
        $direccion = $_POST['direccion'];

        if(empty($nombre) || empty($apellido)|| empty($email) || empty($telefono) || empty($direccion)){
            echo "Error, debe llenar todos los campos";
            # con java eventr 
        }else{    
            $insertar = "INSERT INTO usuarios(nombre,apellido,email,telefono,direccion) VALUES('".$nombre."','".$apellido."','".$email."','".$telefono."','".$direccion."')";
            $ejecutar = mysqli_query($con,$insertar);

            if (!$ejecutar) {
                echo "Error al ingresar los datos del usuario ".mysqli_error($con);
            } else {
                if($nombre=1){
                    $_SESSION['message']='Registro almacenado correctamente';
                    $_SESSION['color']='success';
                    header("location:index.php");
                }
            }
        }
    }   
?>
</body>
</html>