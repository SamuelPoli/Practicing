package Streams.Escribir;

import java.io.*;

public class Escribiendo {

    public static void main(String[] args) {
        Escribir_archivo escritura = new Escribir_archivo();
        escritura.escribir();
    }
}

class Escribir_archivo {

    public void escribir(){
        String frase = "Estamos escribiendo en java";
        try {
            //true al final permite seguir escribiendo sobre el archivo
            //sin el true sobreescribe el archivo
            FileWriter archivo = new FileWriter("Streams/Escribir/archivo.txt", true);
            int i = 0;
            while(i<frase.length()){
                archivo.write(frase.charAt(i));
                i++;
            }
            archivo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
