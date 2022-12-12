package Hilos_2;

public class Consumidor extends Thread {
    private Contenedor contenedor;

    public Consumidor (Contenedor c){
        this.contenedor=c;
    }

    public void run(){
        boolean value = true;
        for (int i=0; i<10; i++){
            value = contenedor.get();
            System.out.println("Consumidor. get: "+ value);
        }
    }
}