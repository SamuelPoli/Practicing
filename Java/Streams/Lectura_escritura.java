package Java.Streams;

import java.io.*;

public class Lectura_escritura {
    public static void main(String[] args) {
        try {
        
            String ruta ="Streams/Imagen.png";
            FileInputStream archivo_lectura = new FileInputStream(ruta);
            boolean final_ar = false;
            int contador = 0;
            int datos_entrada[] = new int[148835];
            while(!final_ar){
                int byte_lectura = archivo_lectura.read();
                if(byte_lectura!=-1)
                    datos_entrada[contador]=byte_lectura;
                else
                    final_ar=true;
                contador++;
            }
            System.out.println(contador);
            archivo_lectura.close();
            crea_archivo(datos_entrada);
        } catch (Exception e) {
            System.out.println("No se encuentra el archivo");
        }
    }

    static void crea_archivo (int datos[]){
        try {
            String ruta ="Streams/Imagen2.png";
            FileOutputStream archivo_escritura = new FileOutputStream(ruta);
            for (int i : datos) {
                archivo_escritura.write(i);
            }
            archivo_escritura.close();
        } catch (Exception e) {
            
        }
    }
    
}
