import java.util.Scanner;

public class TwoPlayerController {
	public static void main(String[] args) {
		TwoPlayerController Controller = new TwoPlayerController();
		Controller.go();
	}
	//Gives up.
	public Boolean giveUp(String currentPlayer) {
		if (currentPlayer .equals("black")) {
			System.out.println("Red wins");
			return true;
		}
		if (currentPlayer.equals("red")) {
			System.out.println("Black wins");
			return true;
		}
		return null;
	}
	public void movement(LascaModel board, String currentPlayer) {
		Scanner scan = new Scanner(System.in);
		boolean goodMove = false;
		while (goodMove == false) {
		System.out.println("What row would you like to move?");
		int moveRow = scan.nextInt();
		System.out.println("What column would you like to move?");
		int moveCol = scan.nextInt();
		System.out.println("Would you like to move NE, NW, SE, or SW");
		String Direction = scan.next();
		Direction = Direction.toUpperCase(); 
		if (board.Movement(moveRow, moveCol, Direction, currentPlayer) == true)
			goodMove = true;
		}
	}
	
public void go() {
	Scanner scan = new Scanner(System.in);
	LascaModel board = new LascaModel();
	LascaView View = new LascaView(board);
	boolean gameOver = false;
	String currentPlayer = "black";
	while (gameOver == false) {
		View.View();
		System.out.println(currentPlayer + " do you wish to peek move or give up?");
		String action = scan.next();
		action = action.toLowerCase();
		if (action .equals("move")) {
			movement(board, currentPlayer);
			if (currentPlayer .equals("black")){
				currentPlayer = "red";
			}
			else {
				currentPlayer = "black";
			}
			}
		
		else if (action .equals("give up") || action.equals("giveup")) {
			gameOver = giveUp(currentPlayer);
		}
		else if (action .equals("peek")) {
			System.out.println("What row would you like to peek at?");
			int peekRow = scan.nextInt();
			System.out.println("What col would you like to peek at?");
			int peekCol = scan.nextInt();
			System.out.println(board.Peek(peekRow, peekCol));
		}
		String gameEnd = board.gameOver();
		if (gameEnd != null) {
			gameOver = true;
			System.out.println(gameEnd);
		}
		
	}
	//ControllerAlgorithm
	//While game is not over {
	//Ask a player to peek, move, or give up.
	//if player gives up {
	//other player wins }
	//if a player wishes to peek{
	//select the row and column of what they wish to peak at
	//HAS TO BE A PIECE.
	//Show the stack to the player}
	//if player wishes to move{
	//Select row and column of THEIR piece they wish to move
	//Select the row and column they wish to move to. Can be done with NW NE SW SE.}
	//} end of while game is not over.
	//Whoever made the last move wins. Or "Player placeholder cannot make a move. Player placeholder wins"
	
}
}
