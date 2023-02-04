package Java.Streams.Leer;

import java.io.*;

public class Leyendo_Buffer {

    public static void main(String[] args) {
        Leer_archivoB lectura = new Leer_archivoB();
        lectura.leer();
    }
}

class Leer_archivoB{
    public void leer(){
        try {
            String ruta = "Streams/Leer/archivo.txt";
            BufferedReader mibuffer = new BufferedReader(new FileReader(ruta));
            String linea = mibuffer.readLine();
            while(linea!=null){
                
                System.out.print(linea);
                linea = mibuffer.readLine();
                
            }
            mibuffer.close();
        } catch (Exception e) {
            System.out.println("No se encuentra el archivo");
        }
    }
}