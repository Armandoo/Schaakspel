package schaakspel.Movement;

import java.util.List;
import schaakspel.Coordinaat;
import schaakspel.MogelijkeZet;
import schaakspel.Schaakstukken.SchaakStuk;

public interface Movement {
    public List<MogelijkeZet> getStukMovement(List<SchaakStuk> schaakstukken, SchaakStuk selectedStuk);
    
}

