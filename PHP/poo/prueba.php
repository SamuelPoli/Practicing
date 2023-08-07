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
class Coche {

    private int $ruedas;
    private String $color;
    private int $motor;

    function __construct(){

        $this->ruedas=4;
        $this->color="";
        $this->motor=1600;
        

    }

    public function arrancar(){
        echo "El auto ha arrancado <br>";
    }

    public function frenar(){
        echo "El auto ha frenado <br>";
    }

    public function girar(){
        echo "El auto ha girado <br>";
    }

    public function cambiar_color($color_coche){

        $this->color=$color_coche;

        echo "El color de este coche es " . $this->color;


    }

    public function getRuedas(){
        return $this->ruedas;
    }


}


$renault = new Coche();
$mazda = new Coche();
$seat = new Coche();

echo $mazda->getRuedas();
$mazda->girar();
*/
include ("auto.php");
$otroauto= new Auto("Mazda",1990,"Negro","10000");
$otroauto->arrancar();
$otroauto->cambiar_color("Mazda","Rojo");
$uncamion= new Camion("Chengen",2000,"Azul","123000");
$uncamion->frenar();
$uncamion->establecerCapacidad(20000);

?>
</body>
</html> 