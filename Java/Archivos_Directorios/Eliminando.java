package Java.Archivos_Directorios;

import java.io.File;

public class Eliminando {
    public static void main(String[] args) {
        File ruta = new File("Java"+File.separator+"Archivos_Directorios"+File.separator+"Nuevo_archivo.txt");
        ruta.delete();
    }
}
