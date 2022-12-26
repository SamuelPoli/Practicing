package Juego_triki;

public class player {
    private static int consecutivo=0;
    private String nombre;

    public player(String nombre){
        consecutivo++;
        this.nombre=nombre;
    }

    public static int getConsecutivo() {
        return consecutivo;
    }

    public String getNombre() {
        return nombre;
    }

    
}
