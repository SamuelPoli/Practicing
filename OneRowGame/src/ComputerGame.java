public abstract class ComputerGame {
    protected int nPlayers;
    protected int addedPlayers = 0;
    protected int whoseTurn;
    protected Player player[];

    public ComputerGame(){
        this.nPlayers=1;
        this.player=new Player[1];
    }

    public ComputerGame(int nPlayers){
        this.nPlayers = nPlayers;
        this.player = new Player[nPlayers];
    }

    public int getPlayer(){
        return whoseTurn;
    }

    public void setPlayer(int starter){
        whoseTurn=starter;
    }

    public void changePlayer(){
        whoseTurn = (whoseTurn+1)%nPlayers;
    }

    public void addPlayer(Player p){
        player[addedPlayers] = p;
        ++addedPlayers;
    }

    public String getRules(){
        return "The rules of the game are: ";
    }

    public String listPlayers(){
        StringBuffer result = new StringBuffer("\nThe players are:\n");
        for (int i=0; i<nPlayers; i++)
            result.append(" Player "+i+" "+player[i].toString()+"\n");
        result.append("\n");
        return result.toString();
    }

    public abstract boolean gameOver();
    public abstract String getWinner();
}
