<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    

<?php

    $nombre="Samuel";//Declarar variable e inicializarla
    $edad=18;

    //Se concatena con el punto
    print "El nombre del usuario es " . $nombre;
    //Otra forma de concatenar sin utilizar el punto
    print "El nombre del usuario es $nombre";
    /*La expresion ECHO es la mas utilizada para imprimir
    en pantalla porque es mas rápida y funciona igual*/
    echo "El nombre es $nombre " . "y tiene " . $edad;

?>
</body>
</html>