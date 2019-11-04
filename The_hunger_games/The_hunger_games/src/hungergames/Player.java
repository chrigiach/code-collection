package hungergames;

import java.util.concurrent.ThreadLocalRandom;
import hungergames.Board;


public class Player {

	/*
	 * default constructor
	 */
	Player(){
		
	}
	
	
	/*
	 * Second constructor with arguments
	 */
	Player(int id, String name, Board board, int score, int x, int y){
		this.id = id;
		this.board = board;
		this.score = score;
		this.x = x;
		this.y = y;
		this.bow = null;
		this.pistol = null;
		this.sword = null;
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
	
	Board board = new Board();
	
	int score;
	
	int x;
	
	int y;
	
	Weapon bow = null;
	
	Weapon pistol = null;
	
	Weapon sword = null;
	
	//c is the number that presents the random movement(number of dice)
	int c;
	
	/*
	 * getters
	 */
	
	//we need to return the number c so that we can print what movement player did in class game
	int getc() {
		return c;
	}
	
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
		
		
		
		
		
		//k and l are the new coordinates that will be set
		int k = x;
		int l = y;
		
		
		// if the player is at the up and left corner of the board
		if((k == -board.getN()) && (l == -board.getM())) {
			c = (int)Math.random()*3 + 3;
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
			c = (int)Math.random()*3 + 5;
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
			c = (int)Math.random()*3 + 1;
			switch(c) {
			case 1:
				c = 1;
				break;
			case 2:
				c = 7;
				break;
			case 3:
				c = 8;
			}
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
			c = (int)Math.random()*3 + 1;
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
			c = (int)Math.random()*5 + 3;
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
			
	        int[] arr = {1, 5, 6, 7, 8};
	            c = ThreadLocalRandom.current().nextInt(0, arr.length);			
			
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
			 int[] arr = {1, 2, 3, 7, 8};
	            c = ThreadLocalRandom.current().nextInt(0, arr.length);	
	            
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
			c = (int)Math.random()*5 + 1;			
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
		
		
		//checking for possible items on the new position
		
		
		Weapon [] weapon = board.getWeapon();
		Food [] food = board.getFood();
		Trap [] trap = board.getTrap();
		
		
		int i;
		for(i = 0 ; i < board.getW() ; i++) {
			if((weapon[i].getx() == this.x) && (weapon[i].gety() == this.x)) {
				if(weapon[i].getplayerId() == this.id) {
					numbnewweap +=1;
					weapon[i].setx(0);
					weapon[i].sety(0);
					System.out.println("You got a " + weapon[i].gettype());
				}
			}
		}
		
		for(i = 0 ; i < board.getF() ; i++) {
			if((food[i].getx() == this.x) && (food[i].gety() == this.x)) {
				numbnewfood +=1;
				score += food[i].getpoints();
				food[i].setx(0);
				food[i].sety(0);
				System.out.println("You got a food");
			}
		}
		
		for(i = 0 ; i < board.getT() ; i++) {
			if((trap[i].getx() == this.x) && (trap[i].gety() == this.x)) {
				
				numbnewtrap +=1;
				System.out.println("You got a " + trap[i].gettype());
				if((trap[i].gettype() == "animal") && (bow != null)) {
					System.out.println("You escaped the trap");
				}
				else if((trap[i].gettype() == "animal") && (bow == null)) {
					score -= trap[i].getpoints();
					System.out.println("You didn't escape the trap");
				}
				else if((trap[i].gettype() == "rope") && (sword != null)) {
					System.out.println("You escaped the trap");				
				}
				else if((trap[i].gettype() == "rope") && (sword == null)) {
					score -= trap[i].getpoints();
					System.out.println("You didn't escape the trap");
				}
			}
		}
		
		
		
		//create the board that will be returned
		int[] movementresults = new int[5];
		movementresults[0] = x;
		movementresults[1] = y;
		movementresults[2] = numbnewweap;
		movementresults[3] = numbnewfood;
		movementresults[4] = numbnewtrap;
		return movementresults;
	}



}
