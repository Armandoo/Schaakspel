package schaakspel.Movement;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import schaakspel.Coordinaat;
import schaakspel.MogelijkeZet;
import schaakspel.Schaakboord;
import schaakspel.Schaakstukken.Pion;
import schaakspel.Schaakstukken.SchaakStuk;

public class PionMovement implements Movement {


    @Override
    public List<MogelijkeZet> getStukMovement(List<SchaakStuk> schaakstukken, SchaakStuk selectedStuk) {
        Pion selected = (Pion) selectedStuk;
        List<MogelijkeZet> mogelijkeZetten = new ArrayList<MogelijkeZet>();
        try {
            Coordinaat coord = new Coordinaat(
                                    selected.getCoordinaat().getX(), 
                                    (selected.getCOLOR() == Color.black) ? selected.getCoordinaat().getY() + 1 : selected.getCoordinaat().getY() - 1);
            SchaakStuk s = Schaakboord.findSchaakstuk(schaakstukken, coord);
            
            boolean mogelijk = s == null || s.getCOLOR() != selected.getCOLOR();
            
            mogelijkeZetten.add(new MogelijkeZet(coord, mogelijk));
            
            if (selected.getFirstSet()) {
                coord = new Coordinaat(
                                selected.getCoordinaat().getX(), 
                                (selected.getCOLOR() == Color.black) ? selected.getCoordinaat().getY() + 2 : selected.getCoordinaat().getY() - 2);
                s = Schaakboord.findSchaakstuk(schaakstukken, coord);        
                mogelijkeZetten.add(new MogelijkeZet(coord, mogelijk && (s == null || s.getCOLOR() != selected.getCOLOR())));
            }

        } catch (Exception e) {
            //change schaakstuk soort
        }
        return mogelijkeZetten;
    }
    
}
