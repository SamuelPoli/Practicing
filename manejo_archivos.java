import java.io.IOException;
import java.nio.file.*;
import javax.swing.*;

public class manejo_archivos {

    public void Operaciones(String path, String operacion) throws IOException{
        Path pathOrigen = Paths.get(path);

        switch(operacion){
            case "crear":
                Files.createFile(pathOrigen);
                break;
            case "eliminar":
                Files.delete(pathOrigen);
                break;

        }
    }


    public static void main(String[] args) {
        String path = JOptionPane.showInputDialog(null, "Ingrese la ruta completa del archivo");
        String operacion = JOptionPane.showInputDialog(null, "Ingrese la operacion a realizar: crear - eliminar");
        manejo_archivos app = new manejo_archivos();
        try {
            app.Operaciones(path, operacion);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
