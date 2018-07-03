package schaakspel;

import schaakspel.Schaakstukken.Toren;
import schaakspel.Schaakstukken.Pion;
import schaakspel.Schaakstukken.SchaakStuk;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import javax.swing.JPanel;
import schaakspel.Schaakstukken.Loper;
import schaakspel.Schaakstukken.Ridder;

public class Schaakboord extends JPanel {
    
    public static final int MAX_X = 8;
    public static final int MAX_Y = 8;
    
    private SchaakStuk activeSchaakstuk = null;
    
    List<Tile> tiles = new ArrayList<>();
    List<SchaakStuk> schaakstukken = new ArrayList<>();
    
    public Schaakboord(){
        super();
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                reageerOpClick(e);
            }
         });
        this.prepTiles();
        this.prepSchaakStukken();
    }
    
    public void reageerOpClick(MouseEvent e){
        try{
            Coordinaat clickedCoord = new Coordinaat(e.getX() / 100, e.getY() / 100);
            SchaakStuk mogelijkeSchaakstuk = Schaakboord.findSchaakstuk(schaakstukken, clickedCoord);
            if(activeSchaakstuk != null)
                zet(clickedCoord, mogelijkeSchaakstuk);
            else
                setAcviteStuk(mogelijkeSchaakstuk);
            if(this.activeSchaakstuk != null)
                this.activeSchaakstuk.updateMogelijkeZetten(schaakstukken);
            repaint();
        }catch(Exception ex){
            
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);   
        for(Tile tile: tiles)
            tile.draw(g);
        for(SchaakStuk schaakstuk: schaakstukken)
            schaakstuk.draw(g);
    }
    
    public void setAcviteStuk(SchaakStuk s){
        if(this.activeSchaakstuk != null)
            activeSchaakstuk.setActive(false);
        if(s != null)
            s.setActive(true);
        activeSchaakstuk = s;
    }
    
    public void zet(Coordinaat c, SchaakStuk s){
        if(activeSchaakstuk != null)
            for(MogelijkeZet z : activeSchaakstuk.getMogelijkeZetten())
                if(z.getCoordinaat().equals(c) && z.isMogelijk()){
                    activeSchaakstuk.move(c);
                    if(s != null && s.getCOLOR() != this.activeSchaakstuk.getCOLOR())
                        schaakstukken.remove(s);
                }
        activeSchaakstuk.setActive(false);
        activeSchaakstuk = null;
        
    }
    
    public static SchaakStuk findSchaakstuk(List<SchaakStuk> stukken, Coordinaat c){
        for(SchaakStuk stuk: stukken){
            if(stuk.getCoordinaat().equals(c))
                return stuk;
        }
        return null;
    }
    
    public void prepTiles(){
        boolean colored = true;
        for (int i = 0; i < this.MAX_Y; i++) {
            colored = !colored;
            for (int j = 0; j < this.MAX_X; j++){
                tiles.add(new Tile(new Coordinaat(i,j), colored));
                colored = !colored;
            }
        }
    }
    
    public void prepSchaakStukken(){
        //zwart
        for (int i = 0; i < this.MAX_X; i++)
            schaakstukken.add(new Pion(new Coordinaat(i,1), Color.black));
        
        schaakstukken.add(new Toren(new Coordinaat(0,0), Color.black));
        schaakstukken.add(new Toren(new Coordinaat(7,0), Color.black));
        
        schaakstukken.add(new Ridder(new Coordinaat(1,0), Color.black));
        schaakstukken.add(new Ridder(new Coordinaat(6,0), Color.black));
        
        schaakstukken.add(new Loper(new Coordinaat(2,0), Color.black));
        schaakstukken.add(new Loper(new Coordinaat(5,0), Color.black));
        
        
        
        //wit
        for (int i = 0; i < this.MAX_X; i++) 
            schaakstukken.add(new Pion(new Coordinaat(i,6), Color.red));
        
        schaakstukken.add(new Toren(new Coordinaat(0,7), Color.red));
        schaakstukken.add(new Toren(new Coordinaat(7,7), Color.red));
                
        schaakstukken.add(new Ridder(new Coordinaat(1,7), Color.red));
        schaakstukken.add(new Ridder(new Coordinaat(6,7), Color.red));
        
        schaakstukken.add(new Loper(new Coordinaat(2,7), Color.red));
        schaakstukken.add(new Loper(new Coordinaat(5,7), Color.red));
    }
    
}
