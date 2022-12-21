public class OneRowNim extends TwoPlayerGame implements CLUIPlayableGame {

    
    public static final int MAX_PICKUP=3;
    public static final int MAX_STICKS=11;
    private int nSticks = MAX_STICKS;
    

    public OneRowNim(){

    }

    public OneRowNim(int nSticks){
        this.nSticks=nSticks;

    }

    public OneRowNim(int nSticks, int starter){
        this.nSticks=nSticks;
        setplayer(starter);
    }

    public boolean takeSticks(int n){
        if(n<1 || n>MAX_PICKUP || n>nSticks)
        return false;
        else {
            nSticks=nSticks-n;
            return true;
        }
    }

    public int getnSticks(){
        return nSticks;
    }

    public String getRules(){
        return "\n*** The Rules of One Row Nim ***\n" +
        "( 1 ) A number of sticks between 7 and " + MAX_STICKS +
        "is chosen. \n" +
        "( 2 ) Two players alternate making moves . \n" +
        "( 3 ) A move consists of subtracting between 1 and \n\t " +
        MAX_PICKUP + " sticks from the current number of sticks . \n" +
        " ( 4 ) A player who cannot l eave a positive \n\t " +
        " number of sticks for the other player loses . \n";
    }

    public boolean gameOver(){
        return (nSticks<=0);
    }

    public String getWinner(){
        if(gameOver())
        return ""+getplayer()+" Nice game. ";
        else
        return "This game is not over yet";
    }
    
    @Override
    public String getGamePrompt() {
        
        return "\n You can pick up between 1 and " +
        Math.min(MAX_PICKUP, nSticks) + " : ";
    }
 

    @Override
    public String reportGameState() {
        if (!gameOver())
            return ("\n Sticks left : " + getnSticks()+
            " Who's turn : Player " + getplayer()) ;
        else
            return ( "\n Sticks left: " +getnSticks() +
            " Game over! Winner is Player " + getWinner() + "\n") ;
    }

    @Override
    public void play(UserInterface ui) {
        int sticks = 0;
        ui.report(getRules());
        if (computer1 != null)
            ui.report("\n Player 1 is a "+computer1.toString());
        if (computer2 != null)
            ui.report("\n Player 2 is a "+computer2.toString());
        while(!gameOver()){
            IPlayer computer = null;
            ui.report(reportGameState());
            /*El siguiente codigo valida si el jugador que tiene el turno es un computador
             * o una persona, ya que previamente en el main si se eligió que iban a jugar 
             * computadores, mediante el metodo addcomputer se asignó un objeto a la variable
             * computer1 o computer2, luego, lo que debemos hacer es si computer1 o computer2 no
             * son nulos se asignan a computer para que luego el if llame al metodo makeamove,
             * si son nulos simplemente se pasa al else y se pide a la persona que ingrese 
             * la jugada
             */
            switch(getplayer()){
                case PLAYER_ONE:
                    computer = computer1;
                    break;
                case PLAYER_TWO:
                    computer = computer2;
                    break;
            }
            if (computer != null){
                sticks = Integer.parseInt(computer.makeAMove(""));
                ui.report(computer.toString()+" takes "+ sticks + " sticks. \n");
            }
            else{
                ui.prompt(getGamePrompt());
                sticks=Integer.parseInt(ui.getUserInput());
            }
            if(takeSticks(sticks))
                changePlayer();
        }
        ui.report(reportGameState());
    }
}
