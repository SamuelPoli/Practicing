package Java.Archivos_Directorios;

import java.io.*;

public class Creando {
    public static void main(String[] args) {
        File ruta = new File("Java"+File.separator+"Archivos_Directorios"+File.separator+"Nuevo_archivo.txt");
        //ruta.mkdir();
        String archivo_destino = ruta.getAbsolutePath();
        try {
            ruta.createNewFile();
            
        } catch (IOException e) {
            
            e.printStackTrace();
        }

        Escribiendo escribir_archivo = new Escribiendo();
        escribir_archivo.escribir(archivo_destino);
    }
}

class Escribiendo {

    public void escribir(String archivo){
        String frase = "Ota vez Estamos escribiendo en java";
        try {
            
            BufferedWriter mibuffer = new BufferedWriter(new FileWriter(archivo));
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
