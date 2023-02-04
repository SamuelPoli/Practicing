package Java.Archivos_Directorios;
import java.io.*;

public class Renombrando {
    public static void main(String[] args) {
        File ruta = new File("Java"+File.separator+"Archivos_Directorios"+File.separator+"Nuevo_archivo.txt");
        ruta.renameTo(new File("Java"+File.separator+"Archivos_Directorios"+File.separator+"Archivo_renombrado.txt"));
          
    }
}
