<?php

if(isset($_POST["enviando"])){
    //$edad=$_POST["edad_usuario"];
    $nombre=$_POST["nombre_usuario"];
    $contraseña=$_POST["contra_usuario"];
}

/*
switch ($nombre) {
    case 'Juan':
        echo "Usuario autorizado. Bienvenido Juan";
        break;
    case 'Maria':
        echo "Usuario autorizado. Bienvenida María";
        break;
    case 'Pepe':
        echo "Usuario autorizado. Bienvenido Pepe";
        break;
    default:
        echo "Usuario no autorizado";
}
*/

switch (true) {
    case $nombre=='Juan'&&$contraseña=="1234":
        echo "Usuario autorizado. Bienvenido Juan";
        break;
    case $nombre=='Maria'&&$contraseña=="5555":
        echo "Usuario autorizado. Bienvenida María";
        break;
    case $nombre=='Pepe'&&$contraseña=="1111":
        echo "Usuario autorizado. Bienvenido Pepe";
        break;
    default:
        echo "Usuario no autorizado";
}

/**
 * Estructura condicionales
 * if (condicion){
 * } else{
 * }
 * 
 * If anidados
 * if (condicion){
 * }else if(condicion){
 * }else{
 * }
 */


/**Operador ternario
 * Condicion ? Valor verdadero:Valor false
 
$resultado=$edad<18 ? "<br>Eres menor de edad. No puedes acceder":"<br>Puedes acceder";
echo  $resultado;
*/

/**
 * Evaluando usuario y contraseña
 * $resultado=$usuario=="Juan" && contraseña=="1234" ? "Puedes acceder":"No puedes acceder";
 * echo  $resultado;
 */


?>