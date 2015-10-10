import static org.junit.Assert.*;

import org.junit.Test;

public class CitySim9000Test {

	/*Test main method when giving zero arguments
	 * 
	 */
	@Test
	public void testMainNotEnoughArgs() {
		CitySim9000 citySim = new CitySim9000();
		String args[] = new String[0];
		int result = citySim.main(args);
		assertEquals(result,-2);
	}
	
	/*Test main method when giving more than one arguments
	 * 
	 */
	@Test
	public void testMainTooManyArgs() {
		CitySim9000 citySim = new CitySim9000();
		String args[] = new String[3];
		int result = citySim.main(args);
		assertEquals(result,-2);
	}
	
	/*Test main method when the seed is not a number
	 * 
	 */
	@Test
	public void testMainWrongSeedFormat() {
		CitySim9000 citySim = new CitySim9000();
		String args[] = new String[1];
		args[0] = "aaa";
		int result = citySim.main(args);
		assertEquals(result,-1);
	}
	
	/*Test main method when giving the right argument and seed format
	 * 
	 */
	@Test
	public void testMainCorrectInput() {
		CitySim9000 citySim = new CitySim9000();
		String args[] = new String[1];
		args[0] = "123";
		int result = citySim.main(args);
		assertEquals(result,0);
	}

}
