<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <style>
        .resaltar{
            color:#F00;
            font-weight:bold;
        }
            
    </style>
</head>
<body>

<?php

/*
Se tienen que utilizar comillas diferentes en los
casos como el siguiente, o el simbolo \
*/
echo "<p class='resaltar'> esto es un ejemplo de parrafo</p><br>";
echo "<p class=\"resaltar\"> esto es un ejemplo de parrafo</p>";

//Comparar Strings
$variable1="Casa";
$variable2= "CASA";

$resultado1=strcmp($variable1, $variable2);
$resultado2=strcasecmp($variable1, $variable2);

echo "El resultado es $resultado1<br>";
echo "El resultado es $resultado2<br>";

if($resultado1){
    echo "No coinciden";
}else{
    echo "Coinciden";
}

?>
</body>
</html>