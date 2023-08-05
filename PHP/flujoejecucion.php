<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    

<?php

echo "Mensaje 1 <br>";

include ("proporciona_datos.php");
require ("proporciona_datos.php");

dameDatos();

echo "Mensaje 2";

?>
</body>
</html>