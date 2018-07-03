package schaakspel;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JComponent;
import schaakspel.Schaakstukken.SchaakStuk;

public class MogelijkeZet extends JComponent {


    private final int MAX_WIDTH = 100;
    private final int MAX_HEIGHT = 100;

    private boolean isMogelijk;
    private Coordinaat coordinaat;

    public MogelijkeZet(Coordinaat c, boolean mogelijk) {
        this.coordinaat = c;
        this.isMogelijk = mogelijk;
    }

    public void draw(Graphics g) {
        g.setColor(getDrawColor());
        g.drawRect(this.coordinaat.getX() * this.MAX_WIDTH,
                this.coordinaat.getY() * this.MAX_HEIGHT,
                this.MAX_WIDTH,
                this.MAX_HEIGHT);
    }

    public Color getDrawColor() {
        return (isMogelijk) ? Color.green : Color.red;
    }
    
    public Coordinaat getCoordinaat(){
        return this.coordinaat;
    }
    
    public boolean isMogelijk(){
        return this.isMogelijk;
    }
    
    public static MogelijkeZet createZet(List<SchaakStuk> schaakstukken, SchaakStuk selectedStuk, int x, int y) throws Exception{
        
        Coordinaat c = new Coordinaat(x, y);
        SchaakStuk s = Schaakboord.findSchaakstuk(schaakstukken, c);
        boolean mogelijk = s == null || s.getCOLOR() != selectedStuk.getCOLOR();
        boolean enemyFound = s != null && s.getCOLOR() != selectedStuk.getCOLOR();
        if(enemyFound)
            throw new SecurityException();
        return new MogelijkeZet(c, mogelijk);
    }
}
