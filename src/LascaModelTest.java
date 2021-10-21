import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LascaModelTest {

	void Movementtest() {
		LascaModel Board = new LascaModel();
		fail("Not yet implemented");
	}
	@Test
	void getTopPiece() {
		LascaModel Board = new LascaModel();
		//checks to see if it gets a character
		if (Board.getTopPiece(4, 0) != 'B') {
			fail("Expected the top piece to be B got " + Board.getTopPiece(4, 0));
		}
		//Checks movement
		Board.Movement(4, 0, "NE", "black");
		if (Board.getTopPiece(3, 1) != 'B') {
			fail("Expected the top piece to be B got " + Board.getTopPiece(3, 1));
		}
		if (Board.getTopPiece(4, 0) != '-') {
			fail("Expected top piece to not exist be - " + Board.getTopPiece(4, 0));
		}
		if (Board.getTopPiece(2, 0) != 'R') {
			fail("Expected the top piece to be R got " + Board.getTopPiece(2, 0));
		}
		//checks to see what happens when there is no character on board there.
		if (Board.getTopPiece(4, 1) != '-') {
			fail("Expected the top piece to be - got " + Board.getTopPiece(4, 1));
		}
	}
	void setTest() {
		LascaModel Board = new LascaModel();
		
	}

}
