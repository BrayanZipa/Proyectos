<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Actualización</title>
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
    <h3>Actualización de datos</h3>
    <?php
        include 'conexion.php';

        $id = $_GET['id'];
        $sqlConsulta = "SELECT * from usuarios WHERE id='".$id."'";
        $resultado = mysqli_query($con,$sqlConsulta);

        while($fila=mysqli_fetch_assoc($resultado)){ ?>

    <div>
        <form action="editar.php" method="POST">
            <input type="hidden" name="idusuario" value="<?php echo $fila['id']?>">

            <div class="form-group">
                <input class="form-control" type="text" name="nombre" value="<?php echo $fila['nombre']?>" placeholder="Nombre" requerid="" pattern="[a-z A-Z]+">			
            </div>

            <div class="form-group">
                <input class="form-control" type="text" name="apellido" value="<?php echo $fila['apellido']?>" placeholder="Apellido" requerid="" pattern="[a-z A-Z]+">			
            </div>

            <div class="form-group">
                <input class="form-control" type="email" name="email" value="<?php echo $fila['email']?>" placeholder="E-mail" requerid="">			
            </div>

            <div class="form-group">
                <input class="form-control" type="text" name="telefono" value="<?php echo $fila['telefono']?>" placeholder="Teléfono" requerid="" pattern="[0-9]+" maxlength="10" minlength="10">			
            </div>

            <div class="form-group">
                <input class="form-control" type="text" name="direccion" value="<?php echo $fila['direccion']?>" placeholder="Dirección" requerid="">			
            </div>

            <div id="boton" class="form-group">
                <input class="btn btn-dark" type="submit" value="Actualizar">
                <a class="btn btn-dark" href="index.php">Regresar</a>
            </div>
        </form>      
    <?php } ?>
    </div>

    <?php 

        if(isset($_POST['idusuario'])){

            $id2 = $_POST['idusuario'];
            $nombre = $_POST['nombre'];
            $apellido = $_POST['apellido'];
            $email = $_POST['email'];
            $telefono = $_POST['telefono'];
            $direccion = $_POST['direccion'];

            if(empty($nombre) || empty($apellido)|| empty($email) || empty($telefono) || empty($direccion)){
                echo "Error, debe llenar todos los campos";
                # con java eventr 
            }else{
                $actualizar = "UPDATE usuarios SET nombre='".$nombre."', apellido='".$apellido."', email='".$email."', telefono='".$telefono."', direccion='".$direccion."' WHERE id='".$id2."'";
                $ejecutar = mysqli_query($con,$actualizar);
            
                if (!$ejecutar) {
                    echo "Error al ingresar los datos del usuario ".mysqli_error($con);
                } else {
                    if($nombre=1){
                        $_SESSION['message']='Registro actualizado correctamente';
                        $_SESSION['color']='success';
                        header("location:index.php");
                    }
                }
            } 
        }       
    ?>
</body>
</html>