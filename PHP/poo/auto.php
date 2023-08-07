<?php

class Auto {

    private String $marca;
    private int $modelo;
    private String $color;
    private String $kilometraje;

    public function __construct(String $mca, int $modlo, String $clr, String $km){

        $this->marca=$mca;
        $this->modelo=$modlo;
        $this->color=$clr;
        $this->kilometraje=$km;

    }

    function arrancar(){
        echo "El auto ha arrancado <br>";
    }

    function frenar(){
        echo "El auto ha frenado <br>";
    }

    function cambiar_color($marca, $clr){

        $this->color=$clr;

        echo "El auto de marca " . $marca . " ahora es de color " . $this->color;


    }


}

//------------------------------------------------------------------------------

class Camion extends Auto{

    private int $capacidad;

    
    function establecerCapacidad($capacidad){
        $this->capacidad=$capacidad;
        echo "La capacidad del camion es de: ".$this->capacidad." litros<br>";
    }

    function frenar(){

        parent::frenar();
        echo "Camion arrancado";

    }
}

?>