package schaakspel.Schaakstukken;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.*;
import javax.swing.JComponent;
import schaakspel.Coordinaat;
import schaakspel.MogelijkeZet;
import schaakspel.Movement.Movement;

public abstract class SchaakStuk extends JComponent {
    
    private final int MAX_WIDTH = 100;
    private final int MAX_HEIGHT = 100;
    private final int FONT_SIZE = 30;
    
    private final Color COLOR;  
    private final String SYMBOOL;  
    
    protected Coordinaat coordinaat; 
    protected Boolean active = false;
    
    protected Movement movement;
    
    protected List<MogelijkeZet> mogelijkeZetten = new ArrayList<>();
    
    SchaakStuk(String s, Coordinaat c, Color col){
        this.SYMBOOL = s;
        this.coordinaat = c;
        this.COLOR = col;
    }
    
    public void updateMogelijkeZetten(List<SchaakStuk> schaakstukken){
        this.clearMogelijkeZetten();
        mogelijkeZetten.addAll(movement.getStukMovement(schaakstukken, this));
    }
    
    public void move(Coordinaat c){
        this.coordinaat = c;
    }    

    public void move(int x, int y){
        this.coordinaat = new Coordinaat(x, y);
    }
    
    public void draw(Graphics g) {
        
        g.setColor(COLOR);  
        g.setFont(new Font("TimesRoman", Font.PLAIN, this.FONT_SIZE)); 
        g.drawString(SYMBOOL, 
                this.coordinaat.getX() * this.MAX_WIDTH + this.MAX_WIDTH / 2 - this.FONT_SIZE / 2, 
                this.coordinaat.getY() * this.MAX_HEIGHT + this.MAX_HEIGHT / 2 + this.FONT_SIZE / 2);
        
        if(active){
            g.setColor(Color.blue);
            
            g.drawRect(this.coordinaat.getX() * this.MAX_WIDTH, 
                    this.coordinaat.getY() * this.MAX_HEIGHT,
                    this.MAX_WIDTH,
                    this.MAX_HEIGHT);
            
            g.setColor(Color.green);
            
            for(MogelijkeZet mogelijkeZet : mogelijkeZetten)
                mogelijkeZet.draw(g);
            
        }
        g.setColor(Color.black);
    }
    
    @Override
    public boolean equals(Object o){
        if(!(o instanceof SchaakStuk))
            return false;
        SchaakStuk other = (SchaakStuk) o;
        System.out.println(this.coordinaat);
        return this.COLOR == other.getCOLOR() && this.coordinaat.equals(other.getCoordinaat()) && this.SYMBOOL.equals(other.getSYMBOOL()) ;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.COLOR);
        hash = 59 * hash + Objects.hashCode(this.SYMBOOL);
        hash = 59 * hash + Objects.hashCode(this.coordinaat);
        hash = 59 * hash + Objects.hashCode(this.active);
        return hash;
    }
    
    public void clearMogelijkeZetten(){
        mogelijkeZetten.clear();
    }
    
    public void addMogelijkeZet(MogelijkeZet z){
        mogelijkeZetten.add(z);
    }
    public void addMogelijkeZet(List<MogelijkeZet> z){
        mogelijkeZetten.addAll(z);
    }
    
    public Color getCOLOR() {
        return COLOR;
    }

    public String getSYMBOOL() {
        return SYMBOOL;
    }

    public Coordinaat getCoordinaat() {
        return coordinaat;
    }

    public Boolean getActive() {
        return active;
    }
    
    public void setActive(boolean active) {
        this.active = active;
    }
    
    public List<MogelijkeZet> getMogelijkeZetten(){
        return this.mogelijkeZetten;
    }
    
}
