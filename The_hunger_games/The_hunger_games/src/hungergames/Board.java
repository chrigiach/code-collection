package hungergames;
import hungergames.Weapon;
import hungergames.Food;
import hungergames.Trap;


public class Board {
	
	int x;
	
	//default constructor
	protected Board() {
	}
	
	//second constructor with the variables
	protected Board(int N, int M, int W, int F, int T) {
		this.N = N;
		this.M = M;
		this.W = W;
		this.F = F;
		this.T = T;
	}
	
	//third constructor with board object as argument
	protected Board(Board b) {
		this.N = b.getN();
		this.M = b.getM();
		this.W = b.getW();
		this.F = b.getF();
		this.T = b.getT();
	}
	
	//variables
	int N, M, W, F, T;
	
	/*
	 * AreaLimits of weapons	
	 */
	
	int [][]weaponAreaLimits = new int[4][2];

	int [][]foodAreaLimits = new int[4][2];

	int [][]trapAreaLimits = new int[4][2];

	//board for weapon items
	Weapon[] weapons = new Weapon[W];
	
	//board for food items
	Food[] food = new Food[F];
		
	//board for trap items
	Trap[] traps = new Trap[T];
		
	/*
	 *getters 
	 */
	public int getN() {
		return N;
	}
	
	public int getM() {
		return M;
	}

	public int getW() {
		return W;
	}

	public int getF() {
		return F;
	}

	public int getT() {
		return T;
	}
	
	public Weapon[] getWeapon() {
		return weapons;
	}

	public Food[] getFood() {
		return food;
	}
	
	public Trap[] getTrap() {
		return traps;
	}
	
	public int[][] getweaponsAreaLimits(){
		return weaponAreaLimits;
	}
	
	public int[][] getfoodAreaLimits(){
		return foodAreaLimits;
	}
	
	public int[][] gettrapsAreaLimits(){
		return trapAreaLimits;
	}
	
	/*
	 * setters
	 */
	
	public void setN(int N) {
		 this.N = N;
	}
	
	public void setM(int M) {
		 this.M = M;
	}
	
	public void setW(int W) {
		 this.W = W;
	}

	public void setF(int F) {
		 this.F = F;
	}

	public void setT(int T) {
		 this.T = T;
		}
	
	public void setWeaponAreaLimits() {
		weaponAreaLimits[0][0] = -x;
		weaponAreaLimits[0][1] = -x;
		weaponAreaLimits[1][0] = -x;
		weaponAreaLimits[1][1] = x;
		weaponAreaLimits[2][0] = x;
		weaponAreaLimits[2][1] = x;
		weaponAreaLimits[3][0] = x;
		weaponAreaLimits[3][1] = -x;
	}
	
	public void setFoodAreaLimits() {
		weaponAreaLimits[0][0] = -(x+1);
		weaponAreaLimits[0][1] = -(x+1);
		weaponAreaLimits[1][0] = -(x+1);
		weaponAreaLimits[1][1] = (x+1);
		weaponAreaLimits[2][0] = (x+1);
		weaponAreaLimits[2][1] = (x+1);
		weaponAreaLimits[3][0] = (x+1);
		weaponAreaLimits[3][1] = -(x+1);
	}
	
	public void setTrapAreaLimits() {
		weaponAreaLimits[0][0] = -(x+2);
		weaponAreaLimits[0][1] = -(x+2);
		weaponAreaLimits[1][0] = -(x+2);
		weaponAreaLimits[1][1] = (x+2);
		weaponAreaLimits[2][0] = (x+2);
		weaponAreaLimits[2][1] = (x+2);
		weaponAreaLimits[3][0] = (x+2);
		weaponAreaLimits[3][1] = -(x+2);
	}
	
	public void setWeaponsArray(int i, Weapon a) {
		weapons[i] = a;
	}
	
	public void setFoodsArray(int i, Food b) {
		food[i] = b;
	}
	
	public void setTrapsArray(int i, Trap c) {
		traps[i] = c;
	}

	/*
	 * create random items
	 */
	// x is the corner coordinate of weapons
	void createRandomWeapon() {
		/*
		 * c is the x coordinate
		 * d is the y coordinate
		 */
		int c, d, weap;
		String weaptype;
		
		
		for(int i = 0 ; i < (W/2) ; i++) {
			
			do {
				 c = (int)(Math.random() * (2*x + 1)) - x;
				}
				while (c == 0);
			
			
			do {
				 d = (int)(Math.random() * (2*x + 1)) - x;
				}
				while (d == 0);
			
			weap = (int)(Math.random() * 2);
			
			/*
			 * First switch so that there is at least one weapon of each type (providing that the number of weapons is >=6)
			 */
			
				switch(i) {
				case 0:
					weaptype = "pistol";
					break;
				case 1:
					weaptype = "bow";
					break;
				case 2:
					weaptype = "sword";
					break;
				/*
				 * Creation of other Weapons now that we are sure that there is at least one weapon of each type 
				 */
				
				default:
					switch(weap) {
						case 0:
							weaptype = "pistol";
							break;
						case 1:
							weaptype = "bow";
							break;
						case 2:
							weaptype = "sword";
							break;
						default:
							weaptype = "bow";
					}
				}
			weapons[i] = new Weapon((i + 1), c, d, 1, weaptype);
			weapons[i + 1] = new Weapon((i + 1), c, d, 2, weaptype);
			}
		}
		
		
	void createRandomFood() {
		int points = 0;
		/*
		 * c is the x coordinate
		 * d is the y coordinate
		 */
		int c, d;
		int xory, j;
		for(int i = 0; i < F; i++) {
			xory = (int)Math.random()*2;
			if(xory == 0) {
				//we get x as fixed
				j = (int)Math.random()*2;
				if(j == 0) {
					c = (x + 1);
					do {
						 d = (int)(Math.random() * (2*(x + 1) + 1)) - (x + 1);
						}
						while (d == 0);
				}
				else {
					c = -(x + 1);
					do {
						 d = (int)(Math.random() * (2*(x + 1) + 1)) - (x + 1);
						}
						while (d == 0);
				}
			}
			else {
				//we get y as fixed
				j= (int)Math.random()*2;
				if(j == 0) {
					d = (x + 1);
					do {
						 c = (int)(Math.random() * (2*(x + 1) + 1)) - (x + 1);
						}
						while (c == 0);
				}
				else {
					d = -(x + 1);
					do {
						 c = (int)(Math.random() * (2*(x + 1) + 1)) - (x + 1);
						}
						while (c == 0);
			}
			
			
		}
			while(points == 0) {
				points = (int)(Math.random() * 10);
			}
			food[i] = new Food(i + 1, c, d, points);
		}
	}
	
	void createRandomTrap() {
		int points = 0;
		int c, d, q;
		String traptype;
		/*
		 * c is the x coordinate
		 * d is the y coordinate
		 */
		int xory, j;
		for(int i = 0; i < T; i++) {
			xory = (int)Math.random()*2;
			if(xory == 0) {
				//we get x as fixed
				j = (int)Math.random()*2;
				if(j == 0) {
					c = (x + 2);
					do {
						 d = (int)(Math.random() * (2*(x + 2) + 1)) - (x + 2);
						}
						while (d == 0);
				}
				else {
					c = -(x + 2);
					do {
						 d = (int)(Math.random() * (2*(x + 2) + 1)) - (x + 2);
						}
						while (d == 0);
				}
			}
			else {
				//we get y as fixed
				j= (int)Math.random()*2;
				if(j == 0) {
					d = (x + 2);
					do {
						 c = (int)(Math.random() * (2*(x + 2) + 1)) - (x + 2);
						}
						while (c == 0);
				}
				else {
					d = -(x + 2);
					do {
						 c = (int)(Math.random() * (2*(x + 2) + 1)) - (x + 2);
						}
						while (c == 0);
			}
			
			
		}
			while(points == 0) {
				points = (int)(Math.random() * 10);
			}
			/*
			 * First switch so that there is at least one trap of each type
			 */
			q = (int)(Math.random()*2);
				switch(q) {
				case 0:
					traptype = "animal";
					break;
				case 1:
					traptype = "rope";
					break;
				default:
					traptype = "animal";
				}
			traps[i] = new Trap(i + 1, c, d, traptype, -points);
		}
	}
	
	void createBoard() {
		createRandomWeapon();
		createRandomFood();
		createRandomTrap();
	}
	
	
	void resizeBoard(Player p1, Player p2) {
		if(((p1.getx() != N) && (p2.getx() != N)) || ((p1.gety() != N) && (p2.gety() != N)) || ((p1.getx() != N) && (p2.gety() != N)) || ((p1.gety() != N) && (p2.getx() != N)) || (p1.getx() != N) || (p1.gety() != N) || (p2.getx() != N) || (p2.gety() != N)) {
			setN(N - 1);
			setM(M - 1);
		}
	}
	
	String[][] getStringRepresentation(){
		String[][] board = new String[N][M];
		return board;
	}
	
}







