import static org.junit.Assert.*;

import org.junit.Test;
import static org.mockito.Mockito.*;
public class DriverTest {

	/*Test the constructor, with very simple base case
	 * assertNotNull is used to validate this, nothing fancy
	 */
	@Test
	public void testDriver() {
		Location mockLocation = mock(Location.class);
		Driver c = new Driver("Driver 2",mockLocation);
		assertNotNull(c);
	}

	/*Test getName of the driver with simple base case
	 */
	@Test
	public void testGetNameBaseCase() {
		Driver d = new Driver("Driver 0",null);
		assertEquals(d.getName(),"Driver 0");
	}
	
	/*Test getName of the driver with null name
	 */
	@Test
	public void testGetNameNullName() {
		Driver d = new Driver(null,null);
		assertNull(d.getName());
	}
	
	/*Test getName of the driver with very long name
	 */
	@Test
	public void testGetNameLongName() {
		Driver d = new Driver("aqlkfjoipfja28p9ojr9824yu908h2175un1 8732b5098v721mn3084v9082465h0974231yv56hy378265bn378y 098u n32891u097823un5 v0978ynv50798213ynbv9785vy098175v9-8027`19-0v7210957908b&B()*^ )(&*%)(@!&$)(@*#%)(@*#%(@#)_*&$N(_)!*@&()_!@$@!_)($VN_)(&N !$UN_*(M!&#$V*(!@&NB@MU_*( !@&NB_*(V)@!&N%B*(@&NUY%_(*V!&",null);
		assertEquals(d.getName(),"aqlkfjoipfja28p9ojr9824yu908h2175un1 8732b5098v721mn3084v9082465h0974231yv56hy378265bn378y 098u n32891u097823un5 v0978ynv50798213ynbv9785vy098175v9-8027`19-0v7210957908b&B()*^ )(&*%)(@!&$)(@*#%)(@*#%(@#)_*&$N(_)!*@&()_!@$@!_)($VN_)(&N !$UN_*(M!&#$V*(!@&NB@MU_*( !@&NB_*(V)@!&N%B*(@&NUY%_(*V!&");
	}

	/*Test get current location of the driver, with simple base case
	 * by first create a mock Location, then create a driver with it
	 * the stubbing method getName is used to validate the result
	 */
	@Test
	public void testGetCurrentLocationBaseCase() {
		Location mockLocation = mock(Location.class);
		when(mockLocation.getName()).thenReturn("Cathedral of Learning");
		Driver d = new Driver(null,mockLocation);
		assertEquals(d.getCurrentLocation().getName(),"Cathedral of Learning");
	}

	/*Test get current location of the driver, with null location case
	 * 
	 */
	@Test
	public void testGetCurrentLocationNull() {
		Driver d = new Driver(null,null);
		assertNull(d.getCurrentLocation());
	}

	
	/*Test SetLocation method, with simple base case
	 * by first create a mock Location, then set it to the driver
	 * the stubbing method getName is used to validate the result*/
	@Test
	public void testSetLocationBaseCase() {
		Location mockLocation = mock(Location.class);
		when(mockLocation.getName()).thenReturn("University");
		Driver d = new Driver(null,null);
		d.setLocation(mockLocation);
		assertEquals(d.getCurrentLocation().getName(),"University");
	}
	
	/*Test SetLocation method, with a null location*/
	@Test
	public void testSetLocationNull() {
		Driver c = new Driver(null,null);
		c.setLocation(null);
		assertNull(c.getCurrentLocation());
	}
	
	

}
