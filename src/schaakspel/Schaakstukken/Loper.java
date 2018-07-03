
package schaakspel.Schaakstukken;

import java.awt.Color;
import schaakspel.Coordinaat;
import schaakspel.Movement.LoperMovement;

public class Loper extends SchaakStuk{
        
    public Loper(Coordinaat c, Color col) {
        super("L", c, col);
        movement = new LoperMovement();
    }
}
