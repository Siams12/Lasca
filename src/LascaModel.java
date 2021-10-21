import java.util.ArrayList;

public class LascaModel {
private int width;
private int height;
private Queue<Character> [][] Board = new Queue[7][7];//the board is 7 by 7
		
		
		public LascaModel() {
			 createBoard();
		}
		public String Peek(int peekRow, int peekCol) {
			return (("Top ") + Board[peekRow][peekCol].peekAll() 
					+ (" Bottom"));
		}
		//Creates odd rows of the board
		private void Odd (char Character, int row) {
			for (int col = 1; col < 7; col+=2) {
				Board[row][col].add(Character);
			}
		}
		//Creates even rows of the board
		private void Even (char Character, int row) {
			for(int col = 0; col < 7; col+=2) {
				Board[row][col].add(Character);
			}
		}
	//create an instance without angle bracket part. When creating the individual array elements use 
			//angle brackets part.
		//Calls methods odd and even and makes the board not null
		private void createBoard() {
			for (int row = 0; row < 7; row++) {
				for (int col = 0; col < 7; col++) {
					Board[row][col] = new QueueImplementation<Character>();
				}
			}
			Even('R', 0);
			Odd('R', 1);
			Even('R', 2);
			Even('B', 4);
			Odd('B', 5);
			Even('B', 6);	
			}
		public char getTopPiece(int Row, int Col) {
			if (Board[Row][Col].isEmpty() == true) {
				return '-';
			}
			return Board[Row][Col].Peek();
		}
		
		//Sets a boardspace
		public void set(Queue<Character> queue, int row, int column)
		{ 
		   Board[row][column] = queue;
			  
		}
		//Checks if a jump can be made
		private boolean checkJump(int Row, int Col, String Direction) {
			switch(Direction) {
			case"NW":
				if (getTopPiece(Row - 1, Col - 1) != '-' && Row - 2 >= 0 && Col -2 >= 0) {
					return true;
				}
				break;
			case"NE":
				if (getTopPiece(Row - 1, Col + 1) != '-' && Row - 2 >= 0 && Col + 2 <= 6) {
				return true;
				}
				break;
			case"SE":
				if (getTopPiece(Row + 1, Col + 1) != '-' && Row + 2 <= 6 && Col + 2 <= 6)
				return true;
				break;
			case"SW":
				if(getTopPiece(Row+1, Col - 1) != '-' && Row + 2 <= 6 && Col - 2  >= 0) 
				
				return true;
				
			}
			return false;
		}
		private void Queuealter(int Row, int Col, Queue<Character> JumpedPiece) {
			while(JumpedPiece.isEmpty() == false){
				char removedPiece = JumpedPiece.remove();
				Board[Row][Col].add(removedPiece);
			}
			//Remove from old spot
			//Add those to the new queue spot.
		}
		//Tells if the game is over
		public String gameOver() {
			int B = 0;
			int R = 0;
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 7; j++) {
					if (getTopPiece(i, j) == 'B') {
						 B = 1;
					}
					if (getTopPiece(i, j) == 'R') {
						 R = 1; 
					}
				}
			}
			if (R == 0) {
			    return "Black wins";
			}
			if (B == 0) {
				return "Red wins";
			}
			return null;
		}
		//Moves each piece and queue.
		public boolean Movement(int Row, int Col, String Direction, String CurrentPlayer) {
		
			if (IllegalMove(Row, Col, Direction, CurrentPlayer) == true) {
				return false;
			}
			else if (checkJump(Row, Col, Direction) == true) {
				switch(Direction) {
				case"NW":
					Queue<Character> NWJump = Board[Row-2][Col-2];
					Queue<Character> NWJumped = Board[Row-1][Col-1];
					set(Board[Row][Col], Row - 2, Col - 2);
					set(NWJump, Row, Col);
					Queuealter(Row - 2, Col - 2, NWJumped);
				break;
				case"NE":
					Queue<Character> NEJump = Board[Row-2][Col+2];
					Queue<Character> NEJumped = Board[Row-1][Col+1];
					set(Board[Row][Col], Row - 2, Col + 2);
					set(NEJump, Row, Col);
					Queuealter(Row - 2, Col + 2, NEJumped);
				break;
				case"SE":
					Queue<Character> SEJump = Board[Row+2][Col+2];
					Queue<Character> SEJumped = Board[Row+1][Col+1];
					set(Board[Row][Col], Row + 2, Col + 2);
					set(SEJump, Row, Col);
					Queuealter(Row + 2, Col + 2, SEJumped);
				break;
				case"SW":
					Queue<Character> SWJump = Board[Row+2][Col-2];
					Queue<Character> SWJumped = Board[Row+1][Col-1];
					set(Board[Row][Col], Row + 2, Col - 2);
					set(SWJump, Row, Col);
					Queuealter(Row + 2, Col - 2, SWJumped);
			}
				return true;
			}
			else {
			switch(Direction) {
			case"NW":
				Queue<Character> NW = Board[Row-1][Col-1];
				set(Board[Row][Col], Row-1, Col-1);
				set(NW, Row, Col);
				break;
			case"NE":
				Queue<Character> NE = Board[Row-1][Col+1];
				set(Board[Row][Col], Row - 1, Col + 1);
				set(NE, Row, Col);
				break;
			case"SE":
				Queue<Character> SE = Board[Row+1][Col+1];
				set(Board[Row][Col], Row + 1, Col + 1);
				set(SE, Row, Col);
				break;
			case"SW":
				Queue<Character> SW = Board[Row+1][Col-1];
				set(Board[Row][Col], Row + 1, Col - 1);
				set(SW, Row, Col);
				break;
					}
			return true;
			
				}
			}
		
		//Checks if the move is legal.
		private boolean IllegalMove(int Row, int  Col, String Direction, String CurrentPlayer) 
		{ //Changes the string of currentPlayer into a char
			char curPlayer = 'B';
			if (CurrentPlayer .equals("red")){
				 curPlayer = 'R';
			}
			else {
				 curPlayer = 'B';
			}
			//Cant move a piece that is off the board
			if (Row > 6 || Row < 0 || Col > 6 || Col < 0) {
				return true;
			}
			//Makes it so you can't move somebody else's pieces.
			if (getTopPiece(Row, Col) == 'B' && curPlayer != 'B')
				return true;
			else if (getTopPiece(Row, Col) == 'R' && curPlayer != 'R'){
				return true;
			}
				else if (getTopPiece(Row,Col) == '-') {
					return true;
			}
			
			//Checks to see if there is a piece of the current player there.
			switch(Direction) {
			case "NW":
				//Makes it so you cannot move off of the board.
				if (Row - 1 < 0 || Col - 1 < 0) {
					return true;
				}
				//Makes it so you can't move into one of your pieces
				if (getTopPiece(Row - 1, Col - 1) == curPlayer) {
					return true;
				}
				//Makes it so you cant move into a piece with 2 pieces there
				else if ((getTopPiece(Row - 1, Col - 1) != curPlayer &&
						getTopPiece(Row - 1, Col - 1) != '-')
						&& 
						(getTopPiece(Row - 2, Col - 2) != '-')) {
					return true;
				}
				break;
			case "NE":
				if (Row - 1 < 0 || Col + 1 > 6) {
					return true;
				}
				if (getTopPiece(Row - 1, Col + 1) == curPlayer) {

						return true;
				}
				if ((getTopPiece(Row - 1, Col + 1) != curPlayer &&
						getTopPiece(Row - 1, Col + 1) != '-' )
						&& 
						
						(getTopPiece(Row - 2, Col + 2) != '-')) {
					return true;
				}
				break;
			case "SE":
				if (Row + 1 > 6 || Col + 1 > 6) {
					return true;
				}
				if (getTopPiece(Row + 1, Col + 1) == curPlayer){
					return true;
				}
				if ((getTopPiece(Row + 1, Col + 1) != curPlayer &&
						getTopPiece(Row + 1, Col + 1) != '-')
						&& 
						(getTopPiece(Row + 2, Col + 2) != '-')) {
					return true;
				}
				
				break;
			case "SW":
				if (Row + 1 > 6 || Col - 1 < 0) {
					return true;
				}
				
				if (getTopPiece(Row + 1, Col - 1) == curPlayer){
					return true;
				}
				if ((getTopPiece(Row + 1, Col - 1) != curPlayer &&
						getTopPiece(Row + 1, Col - 1) != '-')
						&& 
						(getTopPiece(Row + 2, Col - 2) != '-')) {
					return true;
				}
		}
			return false;
		}
}


//
