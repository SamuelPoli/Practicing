import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SlidingGUI extends JFrame implements ActionListener{
    
    private JButton tile[] = new JButton[7];
    private JButton reset = new JButton("Reset");
    private SlidingTilePuzzle sliding;
    private String puzzleState;
    private Label label;
    private String prompt = "Goal: [LLL RRR]. "+
        "click on the tile you want to move. "+
        "Ilegal moves are ignored. ";
    

    public SlidingGUI(String title){
        sliding = new SlidingTilePuzzle();
        buildGUI();
        setTitle(title);
        pack();
        setVisible(true);
    }

    public void buildGUI(){
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        JPanel buttons = new JPanel();
        puzzleState = sliding.reportGameState();
        for(int k=0; k<tile.length;k++){
            tile[k] = new JButton(""+puzzleState.charAt(k));
            tile[k].addActionListener(this);
            buttons.add(tile[k]);
        }
        reset.addActionListener(this);
        label = new Label(prompt);
        buttons.add(reset);
        contentPane.add("Center", buttons);
        contentPane.add("South", label); 
    }

    private void labelButtons(String s){
        for(int k=0; k<tile.length; k++)
            tile[k].setText(""+s.charAt(k));
    }

    public void actionPerformed(ActionEvent e){
        String result = "";
        if(e.getSource()==reset){
            sliding = new SlidingTilePuzzle();
            label.setText(prompt);
        }
        for (int k=0;k<tile.length; k++){
            if(e.getSource()==tile[k])
                result = sliding.submitUserMove(""+k);
        }
        if (result.indexOf("¡Ilegal")!=-1)
            java.awt.Toolkit.getDefaultToolkit().beep();
        puzzleState = sliding.reportGameState();
        labelButtons(puzzleState);
        if (sliding.gameOver())
            label.setText("You did it!");

    }

    public static void main(String[] args) throws Exception {
        new SlidingGUI("Sliding Tile Puzzle");
    }
}
