package schaakspel.Schaakstukken;

import java.awt.Color;
import schaakspel.Coordinaat;
import schaakspel.Movement.RidderMovement;

public class Ridder extends SchaakStuk {
    
    public Ridder(Coordinaat c, Color col) {
        super("R", c, col);
        movement = new RidderMovement();
    }
    
}
