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
	 * Third constructor
	 */
	Player(Player player){
		this.id = player.id;
		this.board = player.board;
		this.score = player.score;
		this.x = player.x;
		this.y = player.y;
		this.bow = player.bow;
		this.pistol = player.pistol;
		this.sword = player.sword;
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
	 * function getRandomMove for choosing from the random available movements
	 */

	int[] getRandomMove(){
		
		
		//create the new place that will be returned
		int[] newplace = new int[2];
		
		
		//c is the number that presents the random movement
		int c;
		
		
		//k and l are the new coordinates that will be set
		int k = x;
		int l = y;
		
		
		// if the player is at the up and left corner of the board
		if((k == -board.getN()) && (l == -board.getM())) {
			c = (int)Math.random()*2 + 3;
			switch(c) {
			case 3:
				if(k == -1) {
					k = (k + 2);
				}
				else {
					k = (k + 1);
				}
				break;
				
			case 4:
				if((k == -1) && (l == -1)) {
					k = (1);
					l = (1);
				}
				else if((k == -1) && (l != -1)) {
					k =(k + 2);
					l = (l + 1);
				}
				else if((k != -1) && (l == -1)) {
					k = (k + 1);
					l = (l + 2);
				}
				else {
					k = k + 1;
					l = l + 1;
				}
				break;
				
			case 5:
				if(l == -1) {
					l = (l + 2);
				}
				else {
					l = (l + 1);
				}
				break;	
			}
		}
		
		
		
		// if the player is at the up and right corner of the board
		else if((k == board.getN()) && (l == -board.getM())) {
			c = (int)Math.random()*2 + 5;
			switch(c) {
			case 5:
				if(l == -1) {
					l = (l + 2);
				}
				else {
					l = (l + 1);
				}
				break;
			case 6:
				if((k == 1) && (l == -1)) {
					k = -1;
					l = 1;
				}
				else if((k != 1) && (l == -1)) {
					k = (k - 1);
					l = (l + 2);
				}
				else if((k == 1) && (l != -1)) {
					k = (k - 2);
					l = (l + 1);
				}
				else {
					k = (k - 1);
					l = (l + 1);
				}
				break;
			case 7:
				if(k == 1) {
					k = (k - 2);
				}
				else {
					k = (k - 1);
				}
				break;	
			}
		}
		
		
		
		// if the player is at the down and right corner of the board
		else if((k == board.getN()) && (l == board.getM())) {
			c = (int)Math.random()*2 + 5;
			switch(c) {
			case 1:
				if(l != 1) {
					l = (l-1);
				}
				else {
					l = (l - 2);
				}
				break;
			case 7:
				if(k == 1) {
					k = (k - 2);
				}
				else {
					k = (k - 1);
				}
				break;
			case 8:
				if((k == 1) && (l == 1)) {
					k = -1;
					l = -1;
				}
				else if((k == 1) && (l != 1)) {
					k = (k - 2);
					l = (l - 1);
				}
				else if((k != 1) && (l == 1)) {
					k = (k - 1);
					l = (l - 2);
				}
				else {
					k = (k - 1);
					l = (l - 1);
				}
				break;
			}
		}
		
		
		
		// if the player is at the down and left corner of the board
		else if((k == -board.getN()) && (l == board.getM())) {
			c = (int)Math.random()*2 + 1;
			switch(c) {
			case 1:
				if(l != 1) {
					l = (l-1);
				}
				else {
					l = (l - 2);
				}
				break;
			case 2:
				if((k == -1) && (l == 1)) {
					k = (k+2);
					l = (l-2);
				}
				else if((k == -1) && (l != 1)) {
					k = (k + 2);
					l = (l - 1);
				}
				else if((k != -1) && (l == 1)) {
					k =(k + 1);
					l = (l - 2);
				}
				else {
					k = (k + 1);
					l = (l - 1);
				}
				break;
			case 3:
				if(k == -1) {
					k= (k + 2);
				}
				else {
					k = (k + 1);
				}
				break;
			}
		}
		
		
		
		//if the player is at the up side of the board
		else if(l == -board.getM()) {
			c = (int)Math.random()*4 + 3;
			switch(c) {
				case 3:
					if(k == -1) {
						k= (k + 2);
					}
					else {
						k = (k + 1);
					}
					break;
				case 4:
					if((k == -1) && (l == -1)) {
						k = 1;
						l = 1;
					}
					else if((k == -1) && (l != -1)) {
						k = (k + 2);
						l = (l + 1);
					}
					else if((k != -1) && (l == -1)) {
						k = (k + 1);
						l = (l + 2);
					}
					else {
						k = (k + 1);
						l = (l + 1);
					}
					break;
				case 5:
					if(l == -1) {
						l = (l + 2);
					}
					else {
						l = (l + 1);
					}
					break;
				case 6:
					if((k == 1) && (l == -1)) {
						k = -1;
						l = 1;
					}
					else if((k != 1) && (l == -1)) {
						k = (k - 1);
						l = (l + 2);
					}
					else if((k == 1) && (l != -1)) {
						k = (k - 2);
						l = (l + 1);
					}
					else {
						k = (k - 1);
						l = (l + 1);
					}
					break;
				case 7:
					if(k == 1) {
						k = (k - 2);
					}
					else {
						k = (k - 1);
					}
					break;
			}
		}
		
		
		
		
		//if the player is at the right side of the board
		else if(k == board.getN()) {
			c = (int)Math.random()*8 + 1;			
			switch(c){
				case 1:
					if(l != 1) {
						l = (l-1);
					}
					else {
						l = (l - 2);
					}
					break;
				case 5:
					if(l == -1) {
						l = (l + 2);
					}
					else {
						l = (l + 1);
					}
					break;
				case 6:
					if((k == 1) && (l == -1)) {
						k = -1;
						l = 1;
					}
					else if((k != 1) && (l == -1)) {
						k = (k - 1);
						l = (l + 2);
					}
					else if((k == 1) && (l != -1)) {
						k = (k - 2);
						l = (l + 1);
					}
					else {
						k = (k - 1);
						l = (l + 1);
					}
					break;
				case 7:
					if(k == 1) {
						k = (k - 2);
					}
					else {
						k = (k - 1);
					}
					break;
				case 8:
					if((k == 1) && (l == 1)) {
						k = -1;
						l = -1;
					}
					else if((k == 1) && (l != 1)) {
						k = (k - 2);
						l = (l - 1);
					}
					else if((k != 1) && (l == 1)) {
						k = (k - 1);
						l = (l - 2);
					}
					else {
						k = (k - 1);
						l = (l - 1);
					}
					break;
			}
		}
		
		
		//if the player is at the down side of the board
		else if(l == board.getM()) {
			c = (int)Math.random()*8 + 1;			
			switch(c){
				case 1:
					if(l != 1) {
						l = (l-1);
					}
					else {
						l = (l - 2);
					}
					break;
				case 2:
					if((k == -1) && (l == 1)) {
						k = (k+2);
						l = (l-2);
					}
					else if((k == -1) && (l != 1)) {
						k = (k + 2);
						l = (l - 1);
					}
					else if((k != -1) && (l == 1)) {
						k =(k + 1);
						l = (l - 2);
					}
					else {
						k = (k + 1);
						l = (l - 1);
					}
					break;
				case 3:
					if(k == -1) {
						k= (k + 2);
					}
					else {
						k = (k + 1);
					}
					break;
				case 7:
					if(k == 1) {
						k = (k - 2);
					}
					else {
						k = (k - 1);
					}
					break;
	
				case 8:
					if((k == 1) && (l == 1)) {
						k = -1;
						l = -1;
					}
					else if((k == 1) && (l != 1)) {
						k = (k - 2);
						l = (l - 1);
					}
					else if((k != 1) && (l == 1)) {
						k = (k - 1);
						l = (l - 2);
					}
					else {
						k = (k - 1);
						l = (l - 1);
					}
					break;
				}
		}
		
		//if the player is at the left side of the board
		else if(k == -board.getN()) {
			c = (int)Math.random()*8 + 1;			
			switch(c){
			case 1:
				if(l != 1) {
					l = (l-1);
				}
				else {
					l = (l - 2);
				}
				break;
			case 2:
				if((k == -1) && (l == 1)) {
					k = (k+2);
					l = (l-2);
				}
				else if((k == -1) && (l != 1)) {
					k = (k + 2);
					l = (l - 1);
				}
				else if((k != -1) && (l == 1)) {
					k =(k + 1);
					l = (l - 2);
				}
				else {
					k = (k + 1);
					l = (l - 1);
				}
				break;
			case 3:
				if(k == -1) {
					k= (k + 2);
				}
				else {
					k = (k + 1);
				}
				break;
			case 4:
				if((k == -1) && (l == -1)) {
					k = 1;
					l = 1;
				}
				else if((k == -1) && (l != -1)) {
					k = (k + 2);
					l = (l + 1);
				}
				else if((k != -1) && (l == -1)) {
					k = (k + 1);
					l = (l + 2);
				}
				else {
					k = (k + 1);
					l = (l + 1);
				}
				break;
			case 5:
				if(l == -1) {
					l = (l + 2);
				}
				else {
					l = (l + 1);
				}
				break;
			}
		}
		
		
		//if the player is anywhere else
		else {
			c = (int)Math.random()*8 + 1;			
			switch(c){
			case 1:
				if(l != 1) {
					l = (l-1);
				}
				else {
					l = (l - 2);
				}
				break;
			case 2:
				if((k == -1) && (l == 1)) {
					k = (k+2);
					l = (l-2);
				}
				else if((k == -1) && (l != 1)) {
					k = (k + 2);
					l = (l - 1);
				}
				else if((k != -1) && (l == 1)) {
					k =(k + 1);
					l = (l - 2);
				}
				else {
					k = (k + 1);
					l = (l - 1);
				}
				break;
			case 3:
				if(k == -1) {
					k= (k + 2);
				}
				else {
					k = (k + 1);
				}
				break;
			case 4:
				if((k == -1) && (l == -1)) {
					k = 1;
					l = 1;
				}
				else if((k == -1) && (l != -1)) {
					k = (k + 2);
					l = (l + 1);
				}
				else if((k != -1) && (l == -1)) {
					k = (k + 1);
					l = (l + 2);
				}
				else {
					k = (k + 1);
					l = (l + 1);
				}
				break;
			case 5:
				if(l == -1) {
					l = (l + 2);
				}
				else {
					l = (l + 1);
				}
				break;
			case 6:
				if((k == 1) && (l == -1)) {
					k = -1;
					l = 1;
				}
				else if((k != 1) && (l == -1)) {
					k = (k - 1);
					l = (l + 2);
				}
				else if((k == 1) && (l != -1)) {
					k = (k - 2);
					l = (l + 1);
				}
				else {
					k = (k - 1);
					l = (l + 1);
				}
				break;
			case 7:
				if(k == 1) {
					k = (k - 2);
				}
				else {
					k = (k - 1);
				}
				break;
			case 8:
				if((k == 1) && (l == 1)) {
					k = -1;
					l = -1;
				}
				else if((k == 1) && (l != 1)) {
					k = (k - 2);
					l = (l - 1);
				}
				else if((k != 1) && (l == 1)) {
					k = (k - 1);
					l = (l - 2);
				}
				else {
					k = (k - 1);
					l = (l - 1);
				}
				break;
			}
		}
		
		//prepare and return the new player's position
		newplace[0] = k;
		newplace[1] = l;
		return newplace;
	}
	
	
	
	/*
	 * function move for executing the player's movement
	 */

	int[] move() {
		//players turn to roll the dice
		int[] newposition = getRandomMove();
		
		//number of new weapons
		int numbnewweap = 0;
		
		//number of new foods
		int numbnewfood = 0;
		
		//number of new weapons
		int numbnewtrap = 0;
		
		
		
		
		//making the movement
		setx(newposition[0]);
		sety(newposition[1]);
		
		//create the board that will be returned
		int[] movementresults = new int[5];
		movementresults[0] = newposition[0];
		movementresults[1] = newposition[1];
		movementresults[2] = numbnewweap;
		movementresults[3] = numbnewfood;
		movementresults[4] = numbnewtrap;
		return movementresults;
	}



}
