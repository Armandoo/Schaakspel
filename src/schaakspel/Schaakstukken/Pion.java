package schaakspel.Schaakstukken;

import schaakspel.Schaakstukken.SchaakStuk;
import java.awt.Color;
import java.util.List;
import schaakspel.Coordinaat;
import schaakspel.MogelijkeZet;
import schaakspel.Movement.PionMovement;
import schaakspel.Schaakboord;

public class Pion extends SchaakStuk {

    private boolean firstSet = true;

    public Pion(Coordinaat c, Color col) {
        super("P", c, col);
        movement = new PionMovement();
    }

    @Override
    public void move(Coordinaat c) {
        super.move(c);
        firstSet = false;
    }
    
    public boolean getFirstSet(){
        return this.firstSet;
    }

}
