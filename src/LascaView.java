
public class LascaView {
	private LascaModel board;
	
	public LascaView(LascaModel board) {
		this.board = board;
	}
	//The beginning of this makes it easier to read the board for players.
	public void View() {
		System.out.println("    COLUMN");
		System.out.println("    0123456");
	for (int row = 0; row < 7; row++) {
		switch(row) {
		case 0:
			System.out.print("  ");
			break;
		case 1: 
			System.out.print("  ");
			break;
		case 2:
			System.out.print("R ");
			break;
		case 3: 
			System.out.print("O ");
			break;
		case 4: 
			System.out.print("W ");
			break;
		case 5:
			System.out.print("  ");
			break;
		case 6: 
			System.out.print("  ");
		}
	System.out.print(row + " ");
	for (int column = 0; column < 7; column++) {
		 System.out.print(board.getTopPiece(row, column));
		
		}
	System.out.println("");
	}
	}
}

