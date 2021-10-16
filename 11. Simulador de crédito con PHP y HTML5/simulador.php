<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/php.css">
    <title>Simulación crédito</title>
</head>

<body>

    <div class="Logo">
            <img src="Image/Salex.png" alt="">
            <label class="salex" for="">Salex.com</label>
    </div> 
        <label class="l1" for="">Plan de pagos</label>
        <label class="l2" for="">Resultado de la simulación de crédito</label>

    <?php

    #Variables que cambian en la tabla
    $abonoCapital = 0;
    $abonoIntereses = 0;
    $saldo = 0;

    $nombre = $_POST['name'];
    $apellido = $_POST['lastName'];
    $identificacion = $_POST['identification'];
    $telefono = $_POST['phone'];
    $tasa = $_POST['tasa'];
    $ingresos = floatval($_POST['earnings']);
    $meses = $_POST['months'];
    $prestamo = floatval($_POST['value']);

    if($prestamo>=1000000){
        if(($ingresos>=3000000) or ($ingresos<3000000 and $prestamo<=5000000)){
            simulacionCredito($tasa, $prestamo, $meses, $nombre, $apellido);

        }else{
            echo '<script>alert("Error, sus ingresos mensuales no son suficientes para adquirir este crédito"); </script>';
            echo '<script>location.href = "formularioParcial.html"; </script>';
        }
    }else{
        echo '<script> alert("Error, el credito tiene que ser de al menos un $1.000.000"); </script>';
        echo '<script>location.href = "formularioParcial.html"; </script>';
    }

    function simulacionCredito($tasa, $prestamo, $meses, $nombre, $apellido){
        
        if($tasa == "Fija"){
            $tasaAnual = 0.143;
            $tasaMesVencida = 0.0112;
            $seguroVida = 1200.00;
            
            $tasaMensual = pow((1+$tasaAnual),(1/12))-1;
            $cuotaMensual = ($prestamo * ($tasaMensual * pow((1+$tasaMensual),$meses)))/(pow((1+$tasaMensual),$meses)-1);
    
            $cuotaMensualMasSeguro = $cuotaMensual + $seguroVida;
    
            $tabla1 = array(($tasaAnual*100)."%", ($tasaMesVencida*100)."%", $cuotaMensual, $seguroVida, $cuotaMensualMasSeguro, $meses." meses"); 
            
            $saldo = $prestamo; ?>

            <h2><?php echo "Estimado cliente ".$nombre." ".$apellido." a continuación se presenta la simulación del crédito solicitado"; ?></h2> 

            <div class="tabla1" >
                <table>
                    <thead class="t1">
                        <tr>
                            <td>Tasa efectiva anual utilizada en la simulación</td>
                            
                            <td><?php echo $tabla1[0]; ?></td>
                        </tr>
                        <tr>
                            <td>Tasa mes vencida utilizada en la simulación</td>
                            <td><?php echo $tabla1[1]; ?></td>
                        </tr>
                        <tr>
                            <td>Cuota mensual</td>
                            <td><?php echo "$".number_format($tabla1[2], 2,".",","); ?></td>
                        </tr>
                        <tr>
                            <td>Seguro de vida asociado a la deuda por cuota</td>
                            <td><?php echo "$".number_format($tabla1[3], 2,".",","); ?></td>
                        </tr>
                        <tr>
                            <td>Cuota mensual más seguro(s)</td>
                            <td><?php echo "$".number_format($tabla1[4], 2,".",","); ?></td>
                        </tr>
                        <tr>
                            <td>Plazo</td>
                            <td><?php echo $tabla1[5]; ?></td>
                        </tr>
                    </thead>
                </table>
            </div>
            
            <div class="tabla2">
                <table>
                    <thead class="tablac">
                        <tr>
                            <th>Cuota #</th>
                            <th>Abono a intereses</th>
                            <th>Abono a capital</th>
                            <th>Cuota mensual sin seguros</th>
                            <th>Valor del seguro de vida asociado a la deuda</th>
                            <th>Cuota mensual mas seguros</th>
                            <th>Saldo</th>
                        </tr>
                    </thead>
                    <tbody>
                            <tr>
                                <td>0</td>
                                <td>$0.00</td>
                                <td>$0.00</td>
                                <td>$0.00</td>
                                <td>$0.00</td>
                                <td>$0.00</td>
                                <td><?php echo "$".number_format($saldo, 2, ".", ",") ?></td>
                            </tr>
                        <?php for ($i = 1; $i <= $meses; $i++) { ?>
                            <tr>
                                <td><?php echo $i ?></td>
                                <td><?php echo "$".number_format(($abonoIntereses = $saldo*$tasaMensual), 2, ".", ",");?></td>
                                <td><?php echo "$".number_format(($abonoCapital = $cuotaMensual-$abonoIntereses), 2, ".", ",");?></td>
                                <td><?php echo "$".number_format($cuotaMensual, 2, ".", ",") ?></td>
                                <td><?php echo "$".number_format($seguroVida, 2, ".", ",") ?></td>
                                <td><?php echo "$".number_format($cuotaMensualMasSeguro, 2, ".", ",") ?></td>
                                <td><?php echo "$".number_format(($saldo -= $abonoCapital), 2, ".", ",")?></td>
                            </tr>
                        <?php } ?>
                    </tbody>
                </table>
            </div>  

        <?php
        }else if($tasa == "Variable"){
            $tasaAnual = 0.1043;
            $tasaMesVencida = 0.0083;
            $seguroVida = 1200.00;

            $tasaMensual = pow((1+$tasaAnual),(1/12))-1;
            $abonoCapital = $prestamo/$meses;
            $abonoIntereses = $prestamo * $tasaMensual;           
            $cuotaMensual = $abonoCapital + $abonoIntereses;
            $cuotaMensualMasSeguro = $cuotaMensual + $seguroVida;

            $tabla1 = array(($tasaAnual*100)."%", ($tasaMesVencida*100)."%", $cuotaMensual, $seguroVida , $cuotaMensualMasSeguro, $meses." meses"); 

            $saldo = $prestamo; ?>

            <h2><?php echo "Estimado cliente ".$nombre." ".$apellido." a continuación se presenta la simulación del crédito solicitado"; ?></h2>

            <div class="tabla1">
                <table>
                    <thead class="t1">
                        <tr>
                            <td>Tasa efectiva anual utilizada en la simulación</td>
                            <td><?php echo $tabla1[0]; ?></td>
                        </tr>
                        <tr>
                            <td>Tasa mes vencida utilizada en la simulación</td>
                            <td><?php echo $tabla1[1]; ?></td>
                        </tr>
                        <tr>
                            <td>Cuota mensual</td>
                            <td><?php echo "$".number_format($tabla1[2], 2,".",","); ?></td>                      
                        </tr>
                        <tr>
                            <td>Seguro de vida asociado a la deuda por cuota</td>
                            <td><?php echo "$".number_format($tabla1[3], 2,".",","); ?></td>     
                        </tr>
                        <tr>
                            <td>Cuota mensual más seguro(s)</td>
                            <td><?php echo "$".number_format($tabla1[4], 2,".",","); ?></td>
                        </tr>
                        <tr>
                            <td>Plazo</td>
                            <td><?php echo $tabla1[5]; ?></td>
                        </tr>
                    </thead>
                </table>
            </div>

            <div class="tabla2">
                <table>
                    <thead class="tablac">
                        <tr>
                            <th>Cuota #</th>
                            <th>Abono a intereses</th>
                            <th>Abono a capital</th>
                            <th>Cuota mensual sin seguros</th>
                            <th>Valor del seguro de vida asociado a la deuda</th>
                            <th>Cuota mensual mas seguros</th>
                            <th>Saldo</th>
                        </tr>
                    </thead>
                    <tbody>
                            <tr>
                                <td>0</td>
                                <td>$0.00</td>
                                <td>$0.00</td>
                                <td>$0.00</td>
                                <td>$0.00</td>
                                <td>$0.00</td>
                                <td><?php echo "$".number_format($saldo, 2, ".", ",") ?></td>
                                
                            </tr>
                        <?php for ($i = 1; $i <= $meses; $i++) { ?>
                            <tr>
                                <td><?php echo $i ?></td>
                                <td><?php echo "$".number_format(($abonoIntereses = $saldo*$tasaMensual), 2, ".", ",");?></td>
                                <td><?php echo "$".number_format($abonoCapital, 2, ".", ",");?></td>
                                <td><?php echo "$".number_format(($cuotaMensual = $abonoCapital + $abonoIntereses), 2, ".", ",");?></td>
                                <td><?php echo "$".number_format($seguroVida, 2, ".", ",") ?></td>
                                <td><?php echo "$".number_format(($cuotaMensual + $seguroVida), 2, ".", ",")?></td>
                                <td><?php echo "$".number_format(($saldo -= $abonoCapital), 2, ".", ",")?></td>
                            </tr>
                        <?php } ?>
                    </tbody>
                </table>
            </div>
        <?php } 
    } ?>

</body>    

</html>