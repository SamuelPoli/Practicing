public class Play2 {
    public static void main(String[] args) {
        KeyboardReader kb = new KeyboardReader();
        WordGuess2 game = new WordGuess2(3);
        //hay que castear a game porque se instanció como ComputerGame
        game.addPlayer(new WordGuesser2(game, 0,Player.HUMAN));
        game.addPlayer(new WordGuesser2(game, 1,Player.COMPUTER));
        game.addPlayer(new WordGuesser2(game, 2,Player.COMPUTER));
        game.play(kb);

        /*hay que castear a game porque se instanció como ComputerGame
        ComputerGame game = new WordGuess2(3);
        game.addPlayer(new WordGuesser2((WordGuess2)game, 0,Player.HUMAN));
        game.addPlayer(new WordGuesser2((WordGuess2)game, 1,Player.COMPUTER));
        game.addPlayer(new WordGuesser2((WordGuess2)game, 2,Player.COMPUTER));
        ((CLUIPlayableGame)game).play(kb);
        */

    }

}
