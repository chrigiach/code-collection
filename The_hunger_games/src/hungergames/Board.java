package hungergames;
import hungergames.Weapon;


public class Board {
	
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
	
	public Weapon[] getWeapons() {
		return Weapon;
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
		weaponAreaLimits[0][0] = -x;
		weaponAreaLimits[0][1] = -x;
		weaponAreaLimits[1][0] = -x;
		weaponAreaLimits[1][1] = x;
		weaponAreaLimits[2][0] = x;
		weaponAreaLimits[2][1] = x;
		weaponAreaLimits[3][0] = x;
		weaponAreaLimits[3][1] = -x;
	}
	
	public void setTrapAreaLimits(int x) {
		weaponAreaLimits[0][0] = -x;
		weaponAreaLimits[0][1] = -x;
		weaponAreaLimits[1][0] = -x;
		weaponAreaLimits[1][1] = x;
		weaponAreaLimits[2][0] = x;
		weaponAreaLimits[2][1] = x;
		weaponAreaLimits[3][0] = x;
		weaponAreaLimits[3][1] = -x;
	}

	/*
	 * create random items
	 */
	
	void createRandomWeapon() {
		int c, d, weap;
		String weaptype;
		
		
		for(int i = 0 ; i < (W/2) ; i++) {
			
			do {
				 c = (int)(Math.random() * 5) - 2;
				}
				while (c == 0);
			
			
			do {
				 d = (int)(Math.random() * 5) - 2;
				}
				while (d == 0);
			
			weap = (int)(Math.random() * 2);
			switch(weap) {
			case 0:
				weaptype = "pistol";
				break;
			case 1:
				weaptype = "bow";
				break;
			case 2:
				weaptype = "sword";
			}
			weapons[i] = Weapon((i + 1), c, d, 1, weaptype);
			weapons[i + 2] = Weapon((i + 1), c, d, 2, weaptype);
		}
		
	}
	void createRandomFood() {
		
	}
	
	void createRandomTrap() {
		
	}
	
	void createBoard() {
		createRandomWeapon();
		createRandomFood();
		createRandomTrap();
	}
	
	
	void resizeBoard(Player p1, Player p2) {
		
	}
	
	String[][] getStringRepresentation(){
	}
	
}









