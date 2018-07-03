package schaakspel;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class Tile extends JComponent {
    
    private final int WIDTH = 100;
    private final int HEIGHT = 100;    
    private final Coordinaat COORDINAAT;
    
    private final boolean COLORED;
    
    public Tile(Coordinaat coord, boolean colored){
        this.COORDINAAT = coord;
        this.COLORED = colored;
    }
    
    public void draw(Graphics g) {
        
        g.setColor(this.getFillColor());        
        g.fillRect(this.COORDINAAT.getX() * this.WIDTH, 
                this.COORDINAAT.getY() * this.HEIGHT,
                this.WIDTH,
                this.HEIGHT);
        g.setColor(Color.black);    
        g.drawRect(this.COORDINAAT.getX() * this.WIDTH, 
                this.COORDINAAT.getY() * this.HEIGHT,
                this.WIDTH,
                this.HEIGHT);
    }
    
    public Color getFillColor(){
        return (this.COLORED)? Color.lightGray : Color.white;
    }
    
}
