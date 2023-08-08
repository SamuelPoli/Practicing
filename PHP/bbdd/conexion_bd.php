<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
<style>
    table{
        width: 50%;
        border: 1px dotted #FF0000;
        margin: auto;
    }
</style>


</head>
<body>
    

<?php

require("datos_conexion.php");

//$conexion=mysqli_connect($db_host,$db_usuario,$db_contra,$db_nombre);
$conexion=mysqli_connect($db_host,$db_usuario,$db_contra);

if(mysqli_connect_errno()){
    echo "Fallo al conectar con la BBDD";
    exit;
}

mysqli_select_db($conexion, $db_nombre) or die("No se encuentra la BBDD");

$consulta="SELECT * FROM DATOSPERSONALES";

$resultado=mysqli_query($conexion,$consulta);
/*
$fila=mysqli_fetch_row($resultado);


foreach ($fila as $key => $value) {
    echo $value. "<br>";
}

echo $fila[0] . "<br>";

echo $fila[1] . "<br>";
echo $fila[2] . "<br>";
echo $fila[3] . "<br>";
*/

/*
echo "<table>";
while(($fila=mysqli_fetch_row($resultado))==true){
    
    echo "<tr><td>";
    echo $fila[0] . "</td><td>";

    echo $fila[1] . "</td><td>";
    echo $fila[2] . "</td><td>";
    echo $fila[3] . "</td></tr>";
}
echo"</table>";
*/

echo "<table>";
//se puede prescindir del true en el while
while($fila=mysqli_fetch_array($resultado, MYSQLI_ASSOC)){
    
    echo "<tr><td>";
    echo $fila["nombre"] . "</td><td>";
    echo $fila["apellidos"] . "</td></tr>";
}
echo"</table>";
mysqli_close($conexion);

?>

</body>
</html>