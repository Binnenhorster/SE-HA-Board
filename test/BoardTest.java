import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class BoardTest {

	Board b;
	
	@Before
	public void initialize(){
		b = new Board();
	}
	
	@Test
	public void emptyBoard() {
		assertEquals(false,b.hasWinner());
	}
	
	@Test
	public void markOkWinnerNO(){
		b.setMark("X",0,0);
		b.setMark("X",2,0);
		b.setMark("X",0,1);
		b.setMark("X",1,2);
		b.setMark("X",2,2);
		b.setMark("O",1,0);
		b.setMark("O",1,1);
		b.setMark("O",2,1);
		b.setMark("O",0,2);
		assertEquals(false,b.hasWinner());
	}
	
	@Test
	public void markOkWinnerYES(){
		b.setMark("X",0,0);
		b.setMark("O",2,0);
		b.setMark("X",0,1);
		b.setMark("X",1,2);
		b.setMark("X",2,2);
		b.setMark("O",1,0);
		b.setMark("O",1,1);
		b.setMark("X",2,1);
		b.setMark("O",0,2);
		assertEquals(true,b.hasWinner());
	}
	
	@Test (expected = InvalidPositionException.class)
	public void invalidPosition(){
		b.setMark("X",3,4);
	}

}
