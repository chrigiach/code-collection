package hungergames;
import hungergames.Weapon;
import hungergames.Food;
import hungergames.Trap;


public class Board {
	
	
	//default constructor
	protected Board() {
	}
	
	//second constructor with the variables
	protected Board(int N, int M, int W, int F, int T, int x) {
		this.N = N;
		this.M = M;
		this.W = W;
		this.F = F;
		this.T = T;
		setWeaponAreaLimits(x);
		setFoodAreaLimits(x);
		setTrapAreaLimits(x);
		createBoard(x);
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
	
	public void setWeaponAreaLimits(int x) {
		weaponAreaLimits[0][0] = -x;
		weaponAreaLimits[0][1] = -x;
		weaponAreaLimits[1][0] = -x;
		weaponAreaLimits[1][1] = x;
		weaponAreaLimits[2][0] = x;
		weaponAreaLimits[2][1] = x;
		weaponAreaLimits[3][0] = x;
		weaponAreaLimits[3][1] = -x;
	}
	
	public void setFoodAreaLimits(int x) {
		weaponAreaLimits[0][0] = -(x+1);
		weaponAreaLimits[0][1] = -(x+1);
		weaponAreaLimits[1][0] = -(x+1);
		weaponAreaLimits[1][1] = (x+1);
		weaponAreaLimits[2][0] = (x+1);
		weaponAreaLimits[2][1] = (x+1);
		weaponAreaLimits[3][0] = (x+1);
		weaponAreaLimits[3][1] = -(x+1);
	}
	
	public void setTrapAreaLimits(int x) {
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
	public void createRandomWeapon(int x) {
		/*
		 * c is the x coordinate
		 * d is the y coordinate
		 */
		int c, d, weap;
		String weaptype;
		
		
		for(int i = 0 ; i < (W/2) ; i+=2) {
			
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
		
		
	void createRandomFood(int x) {
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
	
	void createRandomTrap(int x) {
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
	
	void createBoard(int x) {
		createRandomWeapon(x);
		createRandomFood(x);
		createRandomTrap(x);
	}
	
	
	void resizeBoard(Player P1, Player P2) {
		if((P1.getx() != N) && (P1.getx() != -N) && (P1.gety() != M) && (P1.gety() != -M) && (P2.getx() != N) && (P2.getx() != -N) && (P2.gety() != M) && (P2.gety() != -M)) {
			setN(N - 2);
			setM(M - 2);
		}
	}
	
	
	/*
	 * creating the board of the game
	 */
	
	String[][] getStringRepresentation(){
		
		int i, j, k;
		
		//create the board
		String[][] board = new String[N][M];
		
		//fill the board with low cases
		for(i = 0 ; i < N ; i++) {
			for(j = 0 ; j < N ; j++) {
				board[i][j] = " ___ ";
			}
		}
		
		//place the weapons
		for(k = 0 ; k < W ; k++) {
			board[weapons[k].getx()][weapons[k].gety()] = "W" + weapons[k].getplayerId() + weapons[k].getid();
		}
		
		//place the foods
		for(k = 0 ; k < F ; k++) {
			board[food[k].getx()][food[k].gety()] = "F" + food[k].getid();
		}
		
		//place the traps
		for(k = 0 ; k < F ; k++) {
			board[traps[k].getx()][traps[k].gety()] = "T" + traps[k].getid();
		}
		
		
		return board;
	}
	
}







