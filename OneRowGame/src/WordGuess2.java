public class WordGuess2 extends ComputerGame implements CLUIPlayableGame{
    private String secretWord;
    private StringBuffer currentWord;
    private StringBuffer previousGuesses;
    private int unguessedLetters;

    public WordGuess2(){
        super();
        init();
    }

    public WordGuess2(int m){
        super(m);
        init();
    }
     
    public void init(){
        secretWord=getSecretWord();
        currentWord=new StringBuffer(secretWord);
        previousGuesses = new StringBuffer();
        for(int k=0; k<secretWord.length(); k++)
            currentWord.setCharAt(k, '?');
        unguessedLetters = secretWord.length();
    }

    @Override
    public String getGamePrompt() {
       
        return "\n Guess a letter that you think is in the secret word: ";
    }

    
    @Override
    public String reportGameState() {
        if (!gameOver())
            return "\nCurrent word "+ currentWord.toString() +
            " Previous guesses "+previousGuesses.toString() +
            "\nPlayer "+getPlayer()+ " guesses next ";
        else return "The game is now over! The secret word is: "+
            secretWord +"\n" + getWinner() + " has won! \n";
    }

    @Override
    public void play(UserInterface ui) {
        ui.report(getRules());
        ui.report(listPlayers());
        ui.report(reportGameState());
        
        while(!gameOver()){
            WordGuesser2 p = (WordGuesser2)player[whoseTurn];
            if (p.isComputer()){
                ui.report(submitUserMove(p.makeAMove(getGamePrompt())));
            }
            else{
                ui.prompt(getGamePrompt());
                ui.report(submitUserMove(ui.getUserInput()));
            }
        ui.report(reportGameState());
        }
        
        
    }

    @Override
    public boolean gameOver() {
        return (unguessedLetters <= 0);
    }

    @Override
    public String getWinner() {
        if(gameOver())
            return "Player "+getPlayer();
        else
            return "The game is not over. ";
    }
    public String getSecretWord() {
        int num =(int)(Math.random()*10);
        switch(num){
            case 0: return "SOFTWARE";
            case 1: return "SOLUTION";
            case 2: return "CONSTANT";
            case 3: return "COMPILER";
            case 4: return "ABSTRACT";
            case 5: return "ABNORMAL";
            case 6: return "ARGUMENT";
            case 7: return "QUESTION";
            case 8: return "UTILIZES";
            case 9: return "VARIABLE";
            default: return "MISTAKES";

        }
    }
    public StringBuffer getCurrentWord() {
        return currentWord;
    }
    public StringBuffer getPreviousGuesses() {
        return previousGuesses;
    }

    private boolean guessLetter(char letter){
        previousGuesses.append(letter);
        if(secretWord.indexOf(letter) == -1)
            return false;
        else{
            for (int k=0; k<secretWord.length();k++){
                if (secretWord.charAt(k)==letter){
                    if(currentWord.charAt(k) == letter){
                        return false;
                    }
                    currentWord.setCharAt(k, letter);
                    unguessedLetters--;
                }
            }
            return true;
        }   
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

    public String submitUserMove(String s){
        char letter = s.toUpperCase().charAt(0);
        if(guessLetter(letter)){
            return "Yes, the letter "+ letter+
                " IS in the secret word \n";
        } else{
            changePlayer();
            return "Sorry, " + letter + " is NOT a "+
            "new letter in the secret word \n";
        }
    }
}
