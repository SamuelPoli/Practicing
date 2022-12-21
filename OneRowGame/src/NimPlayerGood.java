public class NimPlayerGood implements IPlayer{

    private OneRowNim game;

    public NimPlayerGood(OneRowNim game){
        this.game=game;
    }
    
    @Override
    public String makeAMove(String prompt) {
        
        return ""+goodMove();
    }

    public int goodMove(){
        int sticksleft=game.getnSticks();
        if(sticksleft%(OneRowNim.MAX_PICKUP +1)!=1)
            return (sticksleft-1)%(OneRowNim.MAX_PICKUP+1);
        else{
            int max_pickup= Math.min(OneRowNim.MAX_PICKUP, sticksleft);
            return (int) (1 + Math.random() * max_pickup);
        }

    }
    
    public String toString(){
        String className=this.getClass().toString();
        return className.substring(5);
    }
    
}
