package Juego_triki;

public class game {
    private player jugador1;
    private player jugador2;
    

    public game(String jugador1, String jugador2){
        this.jugador1=new player(jugador1);
        this.jugador2=new player(jugador2);

    }
}
