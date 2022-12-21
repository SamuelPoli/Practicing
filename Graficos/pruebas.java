package Graficos;

import java.awt.GraphicsEnvironment;

public class pruebas {
    public static void main(String[] args) {
      String[] misfuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
      for (String s : misfuentes) {
        System.out.println(s);
      }
    }

}