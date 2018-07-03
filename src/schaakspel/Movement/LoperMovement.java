
package schaakspel.Movement;

import java.util.ArrayList;
import java.util.List;
import schaakspel.Coordinaat;
import schaakspel.MogelijkeZet;
import schaakspel.Schaakboord;
import schaakspel.Schaakstukken.SchaakStuk;


public class LoperMovement implements Movement {
    
    private final int NOORDOOST = 0;
    private final int ZUIDOOST = 1;
    private final int ZUIDWEST = 2;
    private final int NOORDWEST = 3;

    @Override
    public List<MogelijkeZet> getStukMovement(List<SchaakStuk> schaakstukken, SchaakStuk selectedStuk) {
        List<MogelijkeZet> movement = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            switch(i){
                case NOORDOOST:
                    movement.addAll(mogelijkeZettenNO(schaakstukken, selectedStuk));
                    break;
                case ZUIDOOST:
                    movement.addAll(mogelijkeZettenZO(schaakstukken, selectedStuk));
                    break;
                case ZUIDWEST:
                    movement.addAll(mogelijkeZettenZW(schaakstukken, selectedStuk));
                    break;
                case NOORDWEST:
                    movement.addAll(mogelijkeZettenNW(schaakstukken, selectedStuk));
                    break;
            }   
        }
        return movement;
    }
    
    public List<MogelijkeZet> mogelijkeZettenNO(List<SchaakStuk> schaakstukken, SchaakStuk selectedStuk){
        List<MogelijkeZet> zetten = new ArrayList<>();
        for (int i = selectedStuk.getCoordinaat().getY() - 1,  j = selectedStuk.getCoordinaat().getX() + 1; i >= 0 && j < Schaakboord.MAX_X; i--, j++) {
            try{zetten.add(MogelijkeZet.createZet(schaakstukken, selectedStuk, j, i));}
            catch(SecurityException e){zetten.add(new MogelijkeZet(new Coordinaat(j, i), true)); break;}catch (Exception e){break;}
        }
        return zetten;
    }
    
    
    public List<MogelijkeZet> mogelijkeZettenZO(List<SchaakStuk> schaakstukken, SchaakStuk selectedStuk){
        List<MogelijkeZet> zetten = new ArrayList<>();
        for (int i = selectedStuk.getCoordinaat().getY() + 1,  j = selectedStuk.getCoordinaat().getX() + 1; i < Schaakboord.MAX_Y && j < Schaakboord.MAX_X; i++, j++) {
            try{zetten.add(MogelijkeZet.createZet(schaakstukken, selectedStuk, j, i));}
            catch(SecurityException e){zetten.add(new MogelijkeZet(new Coordinaat(j, i), true)); break;}catch (Exception e){break;}
        }
        return zetten;
    }
    
    
    public List<MogelijkeZet> mogelijkeZettenZW(List<SchaakStuk> schaakstukken, SchaakStuk selectedStuk){
        List<MogelijkeZet> zetten = new ArrayList<>();
        for (int i = selectedStuk.getCoordinaat().getY() + 1,  j = selectedStuk.getCoordinaat().getX() - 1; i < Schaakboord.MAX_Y && j >= 0; i++, j--) {
            try{zetten.add(MogelijkeZet.createZet(schaakstukken, selectedStuk, j, i));}
            catch(SecurityException e){zetten.add(new MogelijkeZet(new Coordinaat(j, i), true)); break;}catch (Exception e){break;}
        }
        return zetten;
    }
    
    public List<MogelijkeZet> mogelijkeZettenNW(List<SchaakStuk> schaakstukken, SchaakStuk selectedStuk){
        List<MogelijkeZet> zetten = new ArrayList<>();
        for (int i = selectedStuk.getCoordinaat().getY() - 1,  j = selectedStuk.getCoordinaat().getX() - 1; i >= 0 && j >= 0; i--, j--) {
            try{zetten.add(MogelijkeZet.createZet(schaakstukken, selectedStuk, j, i));}
            catch(SecurityException e){zetten.add(new MogelijkeZet(new Coordinaat(j, i), true)); break;}catch (Exception e){break;}
        }
        return zetten;
    }
    
}
