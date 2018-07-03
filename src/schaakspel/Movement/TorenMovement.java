package schaakspel.Movement;

import java.util.ArrayList;
import java.util.List;
import schaakspel.Coordinaat;
import schaakspel.MogelijkeZet;
import schaakspel.Schaakboord;
import schaakspel.Schaakstukken.SchaakStuk;

public class TorenMovement implements Movement {
    private final int NOORD = 0;
    private final int OOST = 1;
    private final int ZUID = 2;
    private final int WEST = 3;
    
    @Override
    public List<MogelijkeZet> getStukMovement(List<SchaakStuk> schaakstukken, SchaakStuk selectedStuk) {
        List<MogelijkeZet> movement = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            switch(i){
                case NOORD:
                    movement.addAll(mogelijkeZettenNoord(schaakstukken, selectedStuk));
                    break;
                case OOST:
                    movement.addAll(mogelijkeZettenOost(schaakstukken, selectedStuk));
                    break;
                case ZUID:
                    movement.addAll(mogelijkeZettenZuid(schaakstukken, selectedStuk));
                    break;
                case WEST:
                    movement.addAll(mogelijkeZettenWest(schaakstukken, selectedStuk));
                    break;
            }
            
        }
        return movement;
    }
    
    public List<MogelijkeZet> mogelijkeZettenZuid(List<SchaakStuk> schaakstukken, SchaakStuk selectedStuk) {
        List<MogelijkeZet> mogelijkeZettenZuid = new ArrayList<>();
        for (int i = selectedStuk.getCoordinaat().getY(); i < Schaakboord.MAX_Y; i++) {
            try {
                Coordinaat coord = new Coordinaat(
                        selectedStuk.getCoordinaat().getX(),
                        i + 1 );
                SchaakStuk s = Schaakboord.findSchaakstuk(schaakstukken, coord);

                boolean mogelijk = s == null || s.getCOLOR() != selectedStuk.getCOLOR();
                boolean enemyFound = s != null && s.getCOLOR() != selectedStuk.getCOLOR();

                selectedStuk.addMogelijkeZet(new MogelijkeZet(coord, mogelijk));
                if(enemyFound || !mogelijk)
                    break;

            } catch (Exception e) {
                break;
            }
        }
        return mogelijkeZettenZuid;
    }
    
    
    public List<MogelijkeZet> mogelijkeZettenNoord(List<SchaakStuk> schaakstukken, SchaakStuk selectedStuk) {
        List<MogelijkeZet> mogelijkeZettenZuid = new ArrayList<>();
        for (int i = selectedStuk.getCoordinaat().getY(); i > 0; i--) {
            try {
                Coordinaat coord = new Coordinaat(
                        selectedStuk.getCoordinaat().getX(),
                        i - 1 );
                SchaakStuk s = Schaakboord.findSchaakstuk(schaakstukken, coord);

                boolean mogelijk = s == null || s.getCOLOR() != selectedStuk.getCOLOR();
                boolean enemyFound = s != null && s.getCOLOR() != selectedStuk.getCOLOR();

                selectedStuk.addMogelijkeZet(new MogelijkeZet(coord, mogelijk));
                if(enemyFound || !mogelijk)
                    break;

            } catch (Exception e) {
                break;
            }
        }
        return mogelijkeZettenZuid;
    }
    
        public List<MogelijkeZet> mogelijkeZettenOost(List<SchaakStuk> schaakstukken, SchaakStuk selectedStuk) {
        List<MogelijkeZet> mogelijkeZettenZuid = new ArrayList<>();
        for (int i = selectedStuk.getCoordinaat().getX(); i < Schaakboord.MAX_X; i++) {
            try {
                Coordinaat coord = new Coordinaat(
                        i + 1,
                        selectedStuk.getCoordinaat().getY());
                SchaakStuk s = Schaakboord.findSchaakstuk(schaakstukken, coord);

                boolean mogelijk = s == null || s.getCOLOR() != selectedStuk.getCOLOR();
                boolean enemyFound = s != null && s.getCOLOR() != selectedStuk.getCOLOR();

                selectedStuk.addMogelijkeZet(new MogelijkeZet(coord, mogelijk));
                if(enemyFound || !mogelijk)
                    break;

            } catch (Exception e) {
                break;
            }
        }
        return mogelijkeZettenZuid;
    }
        
    public List<MogelijkeZet> mogelijkeZettenWest(List<SchaakStuk> schaakstukken, SchaakStuk selectedStuk) {
        List<MogelijkeZet> mogelijkeZettenZuid = new ArrayList<>();
        for (int i = selectedStuk.getCoordinaat().getX(); i >= 0; i--) {
            try {
                Coordinaat coord = new Coordinaat(
                        i - 1,
                        selectedStuk.getCoordinaat().getY());
                SchaakStuk s = Schaakboord.findSchaakstuk(schaakstukken, coord);

                boolean mogelijk = s == null || s.getCOLOR() != selectedStuk.getCOLOR();
                boolean enemyFound = s != null && s.getCOLOR() != selectedStuk.getCOLOR();

                selectedStuk.addMogelijkeZet(new MogelijkeZet(coord, mogelijk));
                if(enemyFound || !mogelijk)
                    break;

            } catch (Exception e) {
                break;
            }
        }
        return mogelijkeZettenZuid;
    }
    
}
