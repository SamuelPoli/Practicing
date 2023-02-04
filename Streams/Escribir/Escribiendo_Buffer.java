package Streams.Escribir;

import java.io.*;


public class Escribiendo_Buffer {
    public static void main(String[] args) {
        Escribir_archivoB escritura = new Escribir_archivoB();
        escritura.escribir();
    }
}
class Escribir_archivoB {

    public void escribir(){
        String frase = "Ota vez Estamos escribiendo en java";
        try {
            String ruta = "Streams/Escribir/archivo.txt";
            BufferedWriter mibuffer = new BufferedWriter(new FileWriter(ruta));
            int i = 0;
            while(i<frase.length()){
                mibuffer.write(frase.charAt(i));
                i++;
            }
            mibuffer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
