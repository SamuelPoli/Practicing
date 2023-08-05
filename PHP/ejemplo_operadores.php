<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    
<p>&nbsp;</p>
<!--<form name ="form1" method="post" action="calculador.php">
    opcion para llamar al archivo calculador y hacer las operaciones
    en dicho archivo-->
<!--se debe quitar el action para que funcione directamente
con el codigo php de abajo-->     
<form name ="form1" method="post" action="">
    <p>
        <label for="num1"></label>
        <input type="text" name="numro1" id="num1">
        <label for="num2"></label>
        <input type="text" name="numro2" id="num2">
        <label for="operacion"></label>
        <select name="operacion" id="op">
            <option>Suma</option>
            <option>Resta</option>
            <option>Multiplicacion</option>
            <option>Division</option>
            <option>Mòdulo</option>
            <option>Incremento</option>
            <option>Decremento</option>
        </select>
    </p>
    <p>
        <input type="submit" name="boton" id="button" value="Enviar" onClick="prueba">
    </p>
</form>
<p>&nbsp;</p>

<?php

include("calculador.php");

if(isset($_POST["boton"])){

    $numero1=$_POST["numro1"];
    $numero2=$_POST["numro2"];
    $operacion=$_POST["operacion"];

    calcular($operacion,$numero1,$numero2);

}
?>

</body>
</html>
