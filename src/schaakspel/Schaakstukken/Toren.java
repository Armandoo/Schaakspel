package schaakspel.Schaakstukken;

import java.awt.Color;
import schaakspel.Coordinaat;
import schaakspel.Movement.TorenMovement;

public class Toren extends SchaakStuk {
    

    public Toren(Coordinaat c, Color col) {
        super("T", c, col);
        movement = new TorenMovement();
    }

}

