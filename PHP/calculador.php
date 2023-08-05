<style>
    .resultado{
        color: #f00;
        font-weight: bold;
        font-size: 32px

    }
</style>


<?php

    function calcular($calculo, $numero1, $numero2){//funcion con parametro

       

        if(!strcmp("Suma",$calculo)){
            /*
            otra opcion para traer los numeros sin definirlos como parametros
            es colocar lo siguiente
            global $numero1;
            global $numero2;
            */
            $resultado = $numero1+$numero2;
            echo "<p class='resultado'> El resultado es $resultado</p>";
        }

        if(!strcmp("Resta",$calculo)){
            $resultado = $numero1-$numero2;
            echo "<p class='resultado'> El resultado es $resultado</p>";
        }

        if(!strcmp("Multiplicacion",$calculo)){
            $resultado = $numero1*$numero2;
            echo "<p class='resultado'> El resultado es $resultado</p>";
        }

        if(!strcmp("Division",$calculo)){
            $resultado = $numero1/$numero2;
            echo "<p class='resultado'> El resultado es $resultado</p>";
        }

        if(!strcmp("Mòdulo",$calculo)){
            $resultado = $numero1%$numero2;
            echo "<p class='resultado'> El resultado es $resultado</p>";
        }

        
        if(!strcmp("Incremento",$calculo)){
            $numero1++;
            $resultado = $numero1;
            echo "<p class='resultado'> El resultado es $resultado</p>";
        }

        
        if(!strcmp("Decremento",$calculo)){
            $numero1--;
            $resultado = $numero1;
            echo "<p class='resultado'> El resultado es $resultado</p>";
        }

    }

?>
