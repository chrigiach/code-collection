package hungergames;

public class Trap {

    /**
     * Default constructor
     */
    protected Trap() {
    }
    
    /**
     * second constructor with arguments
     */

    protected Trap(int id, int x, int y, String type, int points) {
    	this.id = id;
    	this.x = x;
    	this.y = y;
    	this.type = type;
    	this.points = points;
    }
    
    /**
     * third constructor with Trap object as argument
     */
    
    protected Trap(Trap a) {
    	this.id = a.id;
    	this.x = a.x;
    	this.y = a.y;
    	this.type = a.type;
    	this.points = a.points;
    	}
    
    /**
     * variables
     */
    protected int id;

    protected int x;

    protected int y;

    protected String type;

    protected int points;
    
    
    

    /**
     * getters
     */
    public int getid() {
        return id;
    }

    public int getx() {
    	return x;
    }

    public int gety() {
    	return y;
    }

    public String gettype() {
    	return type;
    }

    public int getpoints() {
    	return points;
    }

    
    /**
     * setters
     */
    public void setid(int id) {
        this.id = id;
    }

    public void setx(int x) {
    	this.x = x;
    }
    
    public void sety(int y) {
    	this.y = y;
    }

    public void settype(String type) {
    	this.type = type;
    }

    public void setpoints(int points) {
    	this.points = points;
    }

}