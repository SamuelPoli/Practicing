<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    

<?php
/*
$semana[]="Lunes";
$semana[]="Martes";
$semana[]="Miercoles";
*/
$semana=array("Lunes","Martes","Miercoles","Jueves");
echo $semana[0] . "<br>";

$datos=array("Nombre"=>"Juancho", "Apellido"=>"Polo","Edad"=>21);
echo $datos["Nombre"]. "<br>";
//$datos="Fulano";

if(is_array($datos)){
    echo "es un array<br>";
}else{
    echo "eso es otra monda<br>";
}

foreach($datos as $clave=>$valor){

    echo "A $clave le corresponde $valor <br>";

}

sort($semana);
for($i=0; $i<count($semana);$i++){
    echo $semana[$i]."<br>";
}

$alimentos=array("fruta"=>array("tropical"=>"kiwi",
                                "citrico"=>"mandarina",
                                "otros"=>"manzana"),
                 "leche"=>array("animal"=>"vaca",
                                "vegetal"=>"coco"),
                 "carne"=>array("vacuno"=>"lomo",
                                "porcino"=>"pata"));
echo $alimentos["carne"]["vacuno"];
/*foreach($alimentos as $clave_alimentos=>$alim){
    echo"$clave_alimentos:<br>";
    while(list($clave,$valor)=each($alim)){
        echo"$clave=$valor <br>";
    }
}
*/

echo var_dump($alimentos);
?>
</body>
</html>