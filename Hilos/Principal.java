package Hilos;

public class Principal {
    
    public static void main(String[] args) {
        Contenedor c = new Contenedor();
        Generador genera =  new Generador(c);
        Consumidor consume = new Consumidor(c);

        genera.start();
        consume.start();
    }
}
