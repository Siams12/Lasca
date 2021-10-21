import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TwoPlayerControllerTest {

	@Test
	void testGiveUp() {
		TwoPlayerController giveup = new TwoPlayerController();
		if(giveup.giveUp("black") != true) {
		fail("Should return true. The game is over" + giveup.giveUp("black"));
	}
		if(giveup.giveUp("red") != true) {
			fail("Should return true. The game is over" + giveup.giveUp("red"));
		}
		if(giveup.giveUp(" ")!= null) {
			fail("Should return null. Invalid" + giveup.giveUp(" "));
		}
	}
	void testMovement() {
		
	}
	@Test
	void testPeek() {
		TwoPlayerController Peek = new TwoPlayerController();
		LascaModel model = new LascaModel();
		String test1 = Peek.Peek(model, 0, 0);
	}
}
