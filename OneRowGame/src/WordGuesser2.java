public class WordGuesser2 extends Player {
    private WordGuess2 game;

    public WordGuesser2(WordGuess2 game){
        this.game=game;
    }

    public WordGuesser2(WordGuess2 game, int id, int kind){
        super(id, kind);
        this.game=game;
    }
    @Override
    public String makeAMove(String prompt) {
        String usedLetters = game.getPreviousGuesses().toString();
        char letter;
        do{
            letter = (char)('A' + (int)(Math.random() * 26));
        }while (usedLetters.indexOf(letter) != -1);
        return ""+ letter;
    }/*Busca una letra al azar
     mientras no sea una letra que ya haya sido escogida*/

    public String toString(){
        String className=this.getClass().toString();
        return className.substring(5);
    }
}
