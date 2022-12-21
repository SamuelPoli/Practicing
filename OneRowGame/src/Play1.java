import java.util.Scanner;

public class Play1{
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Choose one of the following games \n"+
        "OneRowNim - press 1 \n"+ "WordGuesser - press 2 ");
        int choice = entrada.nextInt();
       
        if(choice == 1)
            playOneRowNim();
        else
            playWordGuesser();
        entrada.close();
    }

    public static void playOneRowNim(){
        KeyboardReader kb = new KeyboardReader();
        OneRowNim game = new OneRowNim();

        kb.prompt("How many computers are playing, 0, 1, or 2?");
        int m = kb.getKeyboardInteger();

        for (int k=0; k<m; k++){
            kb.prompt("What type of player, "+
            "NimPlayerBad = 1, or NimPlayer = 2 ? ");
            int choice = kb.getKeyboardInteger();
            if(choice == 1){
                IPlayer computer = new NimPlayerBad(game);
                game.addComputerPlayer(computer);
            } else{
                IPlayer computer = new NimPlayerGood(game);
                game.addComputerPlayer(computer);
            }
        }
        game.play(kb);
    }

    public static void playWordGuesser(){
        KeyboardReader kb = new KeyboardReader();
        WordGuess game = new WordGuess();

        kb.prompt("How many computers are playing, 0, 1, or 2?");
        int m = kb.getKeyboardInteger();

        for (int k=0; k<m; k++){
            IPlayer computer = new WordGuesser(game);
            game.addComputerPlayer(computer);
        }

        game.play(kb);
    }
}