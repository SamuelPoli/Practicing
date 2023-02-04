package Java.Archivos_Directorios;

import java.io.*;

public class Acceso_archivos {
    
    public static void main(String[] args) {
        
        File ruta = new File("C:/Users/SamuelG/Documents/GitHub/PracticingJava/Archivos_Directorios");
        System.out.println(ruta.getAbsolutePath());
        String[] nombres_archivos = ruta.list();
        for (String e : nombres_archivos) {
            System.out.println(e);
        }

    }
}
