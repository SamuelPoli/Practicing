package Java.Archivos_Directorios;

import java.io.*;

public class Pruebas_rutas {
    
    public static void main(String[] args) {
        
        File archivo = new File("Java/Archivos_Directorios/001-DEP-184.pdf");
        System.out.println(archivo.getAbsolutePath());
        System.out.println(archivo.exists());
    }
}
