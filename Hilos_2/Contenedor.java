package Hilos_2;

public class Contenedor {
    private boolean dato = true;
    private boolean hayDato=false;

    public synchronized boolean get(){
        while(hayDato == false){
            try{
                wait();
            } catch(InterruptedException e){}
        }
        hayDato=false;
        notifyAll();
        return dato;
    }

    public synchronized void put (Boolean valor){
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
