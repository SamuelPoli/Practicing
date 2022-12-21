public class NimPlayerBad implements IPlayer {

    private OneRowNim game;
    
    public NimPlayerBad (OneRowNim game){
        this.game=game;
    }

    @Override
    public String makeAMove(String prompt) {
        return "" + randomMove();
    }

    private int randomMove(){
        int sticksleft = game.getnSticks();
        return 1 + (int)(Math.random()*Math.min(sticksleft, OneRowNim.MAX_PICKUP));
    }

    public String toString(){
        String className=this.getClass().toString();
        return className.substring(5);
    }
    
}
