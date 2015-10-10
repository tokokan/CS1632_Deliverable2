import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.util.*;
import org.junit.Test;
import org.mockito.stubbing.OngoingStubbing;

import static org.mockito.Mockito.*;

public class LocationTest {

	//test the constructor with simple base case name
	@Test
	public void testLocationBaseCase() {
		Location location = null;
		location = new Location("Posvar");
		assertEquals(location.name,"Posvar");
	}
	
	//test the constructor with simple null name
		@Test
		public void testLocationNull() {
			Location location = null;
			location = new Location(null);
			assertNull(location.name);
		}
		
		//test the constructor with long name
		@Test
		public void testLocationLongName() {
			Location location = null;
			location = new Location("(*Y)(&*@%)(*@&$%)@(*&%@)*(&%@*(_&%_)@*(%)_($*(@)_+M*$()_+@*$N() @*$ ()@*$ ()@*&$N ()@*$ B(@)*$ NM@)* $)(@*$ MV(_ @$ @% @$% @$ ");
			assertEquals(location.name,"(*Y)(&*@%)(*@&$%)@(*&%@)*(&%@*(_&%_)@*(%)_($*(@)_+M*$()_+@*$N() @*$ ()@*$ ()@*&$N ()@*$ B(@)*$ NM@)* $)(@*$ MV(_ @$ @% @$% @$ ");
		}

	/*Test setConnection method with simple base case
	 * The method takes 2 strings and 2 Locations -> mock 2 loctions to test
		*/ 
	@Test
	public void testSetConnectionsBaseCase() {
		Location location = new Location("Bellfield");
		Location mockLoc1 = mock(Location.class);
		Location mockLoc2 = mock(Location.class);
		location.setConnections("North Craig", mockLoc1, "South Craig",mockLoc2);
		
		//if I combine all the conditions on one line, it shows missing branches warning
		//and thus lower down the coverage percentage
		boolean result = location.street1.equals("North Craig");
		result &= location.street2.equals("South Craig"); 
		result &= location.location1.equals(mockLoc1);
		result &= location.location2.equals(mockLoc2);
		assertTrue(result);
	}

	/*Test getName, with simple base case
	 * 
	 */
	@Test
	public void testGetName() {
		Location location = new Location("Sennot Square");
		assertEquals(location.getName(),"Sennot Square");
	}
	
	/*Test getName, with null name
	 * 
	 */
	@Test
	public void testGetNameNull() {
		Location location = new Location(null);
		assertNull(location.getName());
	}
	
	/*Test getName, with very long name
	 * 
	 */
	@Test
	public void testGetNameLongName() {
		Location location = new Location("(*Y)(&*@%)(*@&$%)@(*&%@)*(&%@*(_&%_)@*(%)_($*(@)_+M*$()_+@*$N() @*$ ()@*$ ()@*&$N ()@*$ B(@)*$ NM@)* $)(@*$ MV(_ @$ @% @$% @$ ");
		assertEquals(location.getName(),"(*Y)(&*@%)(*@&$%)@(*&%@)*(&%@*(_&%_)@*(%)_($*(@)_+M*$()_+@*$N() @*$ ()@*$ ()@*&$N ()@*$ B(@)*$ NM@)* $)(@*$ MV(_ @$ @% @$% @$ ");
	}

	/* test NextLocation method with simple base case, and testing the first branch
	 * This is done by stubbing the random generator so that it will always return the value I want
	 * There is also a mock driver and it's stubbed methods as well since we don't test driver class here
	 */
	@Test
	public void testNextLocationBaseCaseFirstBranch() {
		Location location = new Location("Towers");
		Location location2 = new Location("WPU");
		location.setConnections("Forbes", location2, null, null);
		
		Random rnd = mock(Random.class);
		when(rnd.nextInt(2)).thenReturn(0);
		
		Driver d = mock(Driver.class);
		when(d.getName()).thenReturn("Test Driver");
		when(d.getCurrentLocation()).thenReturn(location);
		
		int result = location.nextLocation(d,rnd);
		
		assertEquals(result,0);
	}
	
	/* test NextLocation method with simple base case, and testing the second branch
	 * This is done by stubbing the random generator so that it will always return the value I want
	 * There is also a mock driver and it's stubbed methods as well since we don't test driver class here
	 */
	@Test
	public void testNextLocationBaseCaseSecondBranch() {
		Location location = new Location("Towers");
		Location location2 = new Location("WPU");
		location.setConnections(null,null,"Forbes", location2);
		
		Random rnd = mock(Random.class);
		when(rnd.nextInt(2)).thenReturn(1);
		
		Driver d = mock(Driver.class);
		when(d.getName()).thenReturn("Test Driver");
		when(d.getCurrentLocation()).thenReturn(location);
		
		int result = location.nextLocation(d,rnd);
		
		assertEquals(result,1);
	}
	
}
