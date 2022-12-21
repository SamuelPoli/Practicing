package Hilos;

public class Contenedor {
    private int dato;
    private boolean hayDato=false;

    public synchronized int get(){
        while(hayDato == false){
            try{
                wait();
            } catch(InterruptedException e){}
        }
        hayDato=false;
        notifyAll();
        return dato;
    }

    public synchronized void put (int valor){
        while(hayDato==true){
            try {
                wait();
            } catch (InterruptedException e) {
                
            }
        }
        dato=valor;
        hayDato=true;
        notifyAll();
    }
}
