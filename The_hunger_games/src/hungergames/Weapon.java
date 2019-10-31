package hungergames;
class Weapon {

    /**
     * Default constructor
     */
    protected Weapon() {
    }
    
    /**
     * second constructor with arguments
     */
    protected Weapon(int id, int x, int y, int playerId, String type) {
    	this.id = id;
    	this.x = x;
    	this.y = y;
    	this.playerId = playerId;
    	this.type = type;
    }
    
    /**
     * third constructor with weapon object as argument
     */
    
    protected Weapon(Weapon a) {
    	this.id = a.getid();
    	this.x = a.getx();
    	this.y = a.gety();
    	this.playerId = a.getplayerId();
    	this.type = a.gettype();
    }

    /**
     * variables
     */
    protected int id;

    protected int x;

    protected int y;

    protected int playerId;

    protected String type;

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

    public int getplayerId() {
        return playerId;
    }

    public String gettype() {
        return type;
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

    public void setplayerId(int playerId) {
        this.playerId = playerId;
    }

    public void settype(String type) {
        this.type = type;
    }

}