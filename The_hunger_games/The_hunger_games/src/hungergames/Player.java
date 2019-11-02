package hungergames;

public class Player {

	/*
	 * default constructor
	 */
	Player(){
		
	}
	
	
	/*
	 * Second constructor with arguments
	 */
	Player(int id, String name, Board board, int score, int x, int y, Weapon bow, Weapon pistol, Weapon sword){
		this.id = id;
		this.board = board;
		this.score = score;
		this.x = x;
		this.y = y;
		this.bow = bow;
		this.pistol = pistol;
		this.sword = sword;
	}
	
	
	
	/*
	 * variables
	 */
	
	int id;
	
	String name;
	
	Board board;
	
	int score;
	
	int x;
	
	int y;
	
	Weapon bow;
	
	Weapon pistol;
	
	Weapon sword;
	
	/*
	 * getters
	 */
	
	int getid(){
		return id;
	}
	
	String getname() {
		return name;
	}

	Board getboard() {
		return board;
	}
	
	int getscore() {
		return score;
	}
	
	int getx() {
		return x;
	}
	
	int gety() {
		return y;
	}
	
	Weapon getbow() {
		return bow;
	}
	
	Weapon getpistol() {
		return pistol;
	}
	
	Weapon getsword() {
		return sword;
	}
	
	
	/*
	 * setters
	 */
	
	void setid(int id) {
		this.id = id;
	}
	
	void setname(String name) {
		this.name = name;
	}
	
	void setboard(Board board) {
		this.board = board;
	}
	
	void setscore(int score) {
		this.score = score;
	}
	
	void setx(int x) {
		this.x = x;
	}
	
	void sety(int y) {
		this.y = y;
	}
	
	void setbow(Weapon bow) {
		this.bow = bow;
	}
	
	void setpistol(Weapon pistol) {
		this.pistol = pistol;
	}
	
	void setsword(Weapon sword) {
		this.sword = sword;
	}


	/*
	 * function getRandomMove for choosing the random available movements
	 */

	int[] getRandomMove(){
		if() {
			return;
		}
		else if() {
			return;
		}
		else if() {
			return;
		}
		else if() {
			return;
		}
		else if() {
			return;
		}
		else if() {
			return;
		}
		else if() {
			return;
		}
		else if() {
			return;
		}
		else {
			return;
		}
	}
	
	/*
	 * function move for executing the player's movement
	 */

	int[] move() {
		getRandomMove();
		setx();
		sety();
	}



}
