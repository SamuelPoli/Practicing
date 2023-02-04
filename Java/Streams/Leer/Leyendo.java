package Java.Streams.Leer;

import java.io.*;

public class Leyendo {

    public static void main(String[] args) {
        Leer_archivo lectura = new Leer_archivo();
        lectura.leer();
    }
}

class Leer_archivo{
    public void leer(){
        try {
            FileReader archivo = new FileReader("Streams/Leer/archivo.txt");
            int c = archivo.read();
            while(c!=-1){
                char letra = (char)c;
                System.out.print(letra);
                c=archivo.read();
                
            }
            archivo.close();
        } catch (Exception e) {
            System.out.println("No se encuentra el archivo");
        }
    }
}