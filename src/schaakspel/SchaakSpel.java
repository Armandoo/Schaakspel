package schaakspel;

import java.awt.*;
import javax.swing.JFrame;

public class SchaakSpel extends JFrame {
    private final int HEIGHT = 801;
    private final int WIDTH = 801;
    private final String NAME = "SchaakSpel V1";
    
    private Schaakboord schaakboord;
    
    public SchaakSpel(){
        schaakboord = new Schaakboord();    
        schaakboord.setPreferredSize(new Dimension(WIDTH,HEIGHT));

        Container cp = this.getContentPane();
        cp.add(schaakboord);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);   
        this.pack();
        this.setTitle(NAME);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new SchaakSpel();
    }
    
    
    
    
    
}
