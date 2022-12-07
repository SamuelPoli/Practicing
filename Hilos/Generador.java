package Hilos;

public class Generador extends Thread {
    private Contenedor contenedor;

    public Generador (Contenedor c){
        this.contenedor=c;
    }

    public void run(){
        for(int i=0; i<10; i++){
            contenedor.put(i);
            System.out.println("Generador. put: "+ i);
            try {
                sleep((int)(Math.random()*100));
            } catch (InterruptedException e) {
                // TODO: handle exception
            }       
        }
    }
}
