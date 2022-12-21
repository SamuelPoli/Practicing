import java.io.*;

public class KeyboardReader implements UserInterface {
    private BufferedReader reader;

    public KeyboardReader(){
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public int getKeyboardInteger(){
        return Integer.parseInt(readKeyboard());
    }

    public double getKeyboardDouble(){
        return Double.parseDouble(readKeyboard());
    }

    
    public String readKeyboard(){
        String line = "";
        try {
            line=reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    @Override
    public String getUserInput() {
        return readKeyboard();
    }

    @Override
    public void report(String s) {
        System.out.print(s);
    }
    
    @Override
    public void prompt(String s){
        System.out.print(s);
    }
}
