public abstract class TwoPlayerGame {
    public static final int PLAYER_ONE=1;
    public static final int PLAYER_TWO=2;

    protected boolean onePlaysNext = true;
    protected int nComputers = 0;
    protected IPlayer computer1, computer2;

    public void setplayer(int starter){
        if(starter == PLAYER_TWO)
        onePlaysNext=false;
        else
        onePlaysNext=true;
    } 

    public int getplayer(){
        if(onePlaysNext)
        return PLAYER_ONE;
        else
        return PLAYER_TWO;
    } 

    public void changePlayer(){
        onePlaysNext = !onePlaysNext;
    }

    public int getNComputers(){
        return nComputers;
    }

    public String getRules(){
        return "The rules of the game are: ";
    }

    public void addComputerPlayer(IPlayer player){
        if(nComputers==0)
            computer2=player;
        else if(nComputers==1)
            computer1=player;
        else
            return;
        ++nComputers;
    }

    public abstract boolean gameOver();
    public abstract String getWinner();

}
