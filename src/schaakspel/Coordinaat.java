package schaakspel;

public class Coordinaat {
    private final int X;
    private final int Y;
    
    public Coordinaat(int x, int y) throws IndexOutOfBoundsException{
        if(x >= Schaakboord.MAX_X || y >= Schaakboord.MAX_Y || x < 0 || y < 0)
            throw new IndexOutOfBoundsException("Coordinaat Out of Bounds");
        this.X = x;
        this.Y = y;
    }
    
    public int getX(){
        return this.X;
    }
    
    public int getY(){
        return this.Y;
    }
    
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Coordinaat))
            return false;
        Coordinaat other = (Coordinaat) o;
        return this.X == other.getX() && this.Y == other.getY();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.X;
        hash = 47 * hash + this.Y;
        return hash;
    }
    
    public String toString(){
        return this.X + ":" + this.Y;
    }
    
}
