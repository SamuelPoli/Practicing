public class SlidingTilePuzzle extends ComputerGame implements GUIPlayableGame {
    
    private char[] puzzle = {'R','R','R',' ','L','L','L',};
    private String solution = "LLL RRR";
    private int blankAt = 3;

    public SlidingTilePuzzle(){
        super();
    }
        
    private void swapTiles(int t1, int t2){
        char ch = puzzle[t1];
        puzzle[t1] = puzzle [t2];
        puzzle[t2] = ch;
        blankAt = t1;
    }

    @Override
    public String getGamePrompt() {
       
        return "To move a tile, click on it. ";
    }

    
    @Override
    public String reportGameState() {
       StringBuffer sb = new StringBuffer();
       sb.append(puzzle);
       return sb.toString();
    }

    @Override
    public boolean gameOver() {
        StringBuffer sb = new StringBuffer();
        sb.append(puzzle);
        return sb.toString().equals(solution);
    }

    @Override
    public String getWinner() {
        if(gameOver())
            return "You did it! Nice!\n";
        else
            return "\nGood try.Try again! \n ";
    }
    public String getRules(){
        return "\n*** The Rules of Word Guess ***\n" +
        "(1) The game gene rat e s a s e c r e t word \n" +
        "(2) Two players alternate making moves . \n" +
        "(3) A move consists of gues s ing a l e t t e r in the word \n " + 
        "(4) A player cont inue s gues s ing u n t i l a l e t t e r i s wrong. \n " +
        "(5) The game i s over when a l l l e t t e r s of the word are guessed \n" +
        "(6) The player gues s ing the l a s t l e t t e r of the word wins .\n";
    }

    public String submitUserMove(String usermove){
        int tile = Integer.parseInt(usermove);
        char ch = puzzle[tile];
        if(ch == 'L' && (blankAt==tile-1 || blankAt == tile-2))
            swapTiles(tile, blankAt);
        else if(ch == 'R' &&
                    (blankAt==tile+1 || blankAt == tile+2))
        swapTiles(tile, blankAt);
        else
            return "That's an illegal move. \n";
        return "That is a legal move. \n";
    }
}
