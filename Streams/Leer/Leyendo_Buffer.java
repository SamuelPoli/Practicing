package Streams.Leer;

import java.io.*;

public class Leyendo_Buffer {

    public static void main(String[] args) {
        Leer_archivo lectura = new Leer_archivo();
        lectura.leer();
    }
}

class Leer_archivo{
    public void leer(){
        try {
            FileReader archivo = new FileReader("Streams/Leer/archivo.txt");
            BufferedReader mibuffer = new BufferedReader(archivo);
            String linea = mibuffer.readLine();
            while(linea!=null){
                
                System.out.print(linea);
                linea = mibuffer.readLine();
                
            }
            archivo.close();
        } catch (Exception e) {
            System.out.println("No se encuentra el archivo");
        }
    }
}