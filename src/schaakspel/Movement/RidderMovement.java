package schaakspel.Movement;

import java.util.ArrayList;
import java.util.List;
import schaakspel.Coordinaat;
import schaakspel.MogelijkeZet;
import schaakspel.Schaakstukken.SchaakStuk;

public class RidderMovement implements Movement {

    @Override
    public List<MogelijkeZet> getStukMovement(List<SchaakStuk> schaakstukken, SchaakStuk selectedStuk) {        
        List<MogelijkeZet> movement = new ArrayList<>();
        
        try{movement.add(MogelijkeZet.createZet(schaakstukken, selectedStuk, selectedStuk.getCoordinaat().getX() - 1, selectedStuk.getCoordinaat().getY() - 2));}
        catch(SecurityException e){movement.add(new MogelijkeZet(new Coordinaat(selectedStuk.getCoordinaat().getX() - 1, selectedStuk.getCoordinaat().getY() - 2), true));}catch (Exception e){}
        try{movement.add(MogelijkeZet.createZet(schaakstukken, selectedStuk, selectedStuk.getCoordinaat().getX() - 2, selectedStuk.getCoordinaat().getY() - 1));}
        catch(SecurityException e){movement.add(new MogelijkeZet(new Coordinaat(selectedStuk.getCoordinaat().getX() - 2, selectedStuk.getCoordinaat().getY() - 1), true));}catch (Exception e){}
        try{movement.add(MogelijkeZet.createZet(schaakstukken, selectedStuk, selectedStuk.getCoordinaat().getX() + 1, selectedStuk.getCoordinaat().getY() + 2));}
        catch(SecurityException e){movement.add(new MogelijkeZet(new Coordinaat(selectedStuk.getCoordinaat().getX() + 1, selectedStuk.getCoordinaat().getY() + 2), true));}catch (Exception e){}
        try{movement.add(MogelijkeZet.createZet(schaakstukken, selectedStuk, selectedStuk.getCoordinaat().getX() + 2, selectedStuk.getCoordinaat().getY() + 1));}
        catch(SecurityException e){movement.add(new MogelijkeZet(new Coordinaat(selectedStuk.getCoordinaat().getX() + 2, selectedStuk.getCoordinaat().getY() + 1), true));}catch (Exception e){}
        try{movement.add(MogelijkeZet.createZet(schaakstukken, selectedStuk, selectedStuk.getCoordinaat().getX() + 1, selectedStuk.getCoordinaat().getY() - 2));}
        catch(SecurityException e){movement.add(new MogelijkeZet(new Coordinaat(selectedStuk.getCoordinaat().getX() + 1, selectedStuk.getCoordinaat().getY() - 2), true));}catch (Exception e){}
        try{movement.add(MogelijkeZet.createZet(schaakstukken, selectedStuk, selectedStuk.getCoordinaat().getX() + 2, selectedStuk.getCoordinaat().getY() - 1));}
        catch(SecurityException e){movement.add(new MogelijkeZet(new Coordinaat(selectedStuk.getCoordinaat().getX() + 2, selectedStuk.getCoordinaat().getY() - 1), true));}catch (Exception e){}
        try{movement.add(MogelijkeZet.createZet(schaakstukken, selectedStuk, selectedStuk.getCoordinaat().getX() - 1, selectedStuk.getCoordinaat().getY() + 2));}
        catch(SecurityException e){movement.add(new MogelijkeZet(new Coordinaat(selectedStuk.getCoordinaat().getX() - 1, selectedStuk.getCoordinaat().getY() + 2), true));}catch (Exception e){}
        try{movement.add(MogelijkeZet.createZet(schaakstukken, selectedStuk, selectedStuk.getCoordinaat().getX() - 2, selectedStuk.getCoordinaat().getY() + 1));}
        catch(SecurityException e){movement.add(new MogelijkeZet(new Coordinaat(selectedStuk.getCoordinaat().getX() - 2, selectedStuk.getCoordinaat().getY() + 1), true));}catch (Exception e){}
 
        return movement;
    }
    
}
