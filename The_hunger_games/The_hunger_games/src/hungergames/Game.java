package hungergames;
import hungergames.Board;
import hungergames.Player;
import hungergames.Food;
import hungergames.Trap;


public class Game {

	//the round variable
	int round;
	
	/*
	 * default constructor
	 */
	
	protected Game(){
		
	}
	
	/*
	 * Second constructor with variable
	 */
	
	protected Game(int round) {
		this.round = round;
	}
	
	/*
	 * Third constructor with Game object as argument
	 */
	
	
	protected Game(Game a) {
		this.round = a.getRound();
	}
	
	/*
	 * getter
	 */
	
	public int getRound() {
		return round;
	}
	
	/*
	 * setter
	 */
	
	public void setRound(int round) {
		this.round = round;
	}
	
	
	
	/*
	 * this is main
	 */
	
	
	public static void main(String[] args) {

		Game game = new Game(0);
		int N = 20;
		int M = 20;
		int [] bp1 = new int[5];
		int [] bp2 = new int[5];
		String [][] boardpresentation = new String[N][M];
		String movement;
		
		
		Board board = new Board(N, M, 6, 10, 8, 2);
	
		Player P1 = new Player(1, "player1", board, 0, -N, -M);
		Player P2 = new Player(2, "player2", board, 0, N, M);
	
		while((board.getN() != 4) && (board.getM() != 4)) {
			bp1 = P1.move();
			bp2 = P2.move();
			System.out.println("Round " + game.getRound());
			boardpresentation = board.getStringRepresentation();
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					System.out.print(boardpresentation[i][j]);
				}
				System.out.println("\n");
			}
			switch(P1.getc()) {
			case 1:
				movement = "up";
				break;
			case 2:
				movement = "up and right";
				break;
			case 3:
				movement = "right";
				break;
			case 4:
				movement = "down and right";
				break;
			case 5:
				movement = "down";
				break;
			case 6:
				movement = "down and left";
				break;
			case 7:
				movement = "left";
				break;
			case 8:
				movement = "up and left";
				break;
			default:
				movement = "nowhere";
			}
			System.out.println("The player P1 moved " + movement + " and his new coordinates are x = " + bp1[0] + "and y = " + bp1[1]);
			
			
			
			
			switch(P2.getc()) {
			case 1:
				movement = "up";
				break;
			case 2:
				movement = "up and right";
				break;
			case 3:
				movement = "right";
				break;
			case 4:
				movement = "down and right";
				break;
			case 5:
				movement = "down";
				break;
			case 6:
				movement = "down and left";
				break;
			case 7:
				movement = "left";
				break;
			case 8:
				movement = "up and left";
				break;
			default:
				movement = "nowhere";
			}
			System.out.println("The player P2 moved " + movement + " and his new coordinates are x = " + bp2[0] + "and y = " + bp2[1]);
			
			
			if( (game.getRound() > 0) && (game.getRound() % 3 == 0)) {
		
				board.resizeBoard(P1, P2);
				System.out.println("Board has been resized!");
			}
		}
		System.out.println("Game is over");
		System.out.println("Player 1's score is: " + P1.getscore());
		System.out.println("Player 2's score is: " + P2.getscore());
	}

}
