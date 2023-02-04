package Java.Archivos_Directorios;

import java.io.*;

public class Acceso_archivos {
    
    public static void main(String[] args) {
        
        
        /*Se puede copiar la ruta absoluta C:\Users\SamuelG\Documents\GitHub\Practicing\Java\Archivos_Directorios
        O utilizar el separador del sistema con la variable x
        String x = File.separator;
        "C:"+x+"Users"+x+"SamuelG"+x+"Documents"+x+"GitHub"+x+"Practicing"+x+"Java"+x+"Archivos_Directorios"
        En este caso utilizamos la ruta relativa con el separador que proporciona la clase File
        */
        File ruta = new File("Java"+File.separator+"Archivos_Directorios");
        System.out.println(ruta.getAbsolutePath());
        String[] nombres_archivos = ruta.list();
        for (String e : nombres_archivos) {
            System.out.println(e);
            File f = new File(ruta.getAbsolutePath(), e);
            if(f.isDirectory()){
                String[] subcarpeta = f.list();
                for (String s : subcarpeta) {
                    System.out.println(s);
                }
            }

        }

    }
}
