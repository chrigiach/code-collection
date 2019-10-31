package hungergames;

public class Food {

    /**
     * Default constructor
     */
    protected Food() {
    }

    /**
     * second constructor with arguments
     */
    
    protected Food(int id, int x, int y, int points) {
    	this.id = id;
    	this.x = x;
    	this.y = y;
    	this.points = points;	
    }
    
    /**
     * Third constructor with food object as argument
     */
    
    protected Food(Food a) {
    	this.id = a.getid();
    	this.x = a.getx();
    	this.y = a.gety();
    	this.points = a.getpoints();
    	
    }
    
    /**
     * variables
     */
    protected int id;

    protected int x;

    protected int y;

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

    public void setpoints(int points) {
    	this.points = points;
    }

}
