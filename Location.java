import java.util.*;
public class Location {
	String name;
	Location location1;
	Location location2;
	String street1;
	String street2;
	
	public Location(String name)
	{
		this.name = name;
	}
	
	public void setConnections(String street1, Location location1,String street2, Location location2)
	{
		this.street1 = street1;
		this.street2 = street2;
		this.location1 = location1;
		this.location2 = location2;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int nextLocation(Driver driver,Random rnd)
	{
		String street = new String();
		Location location;
		int result;
		int next = rnd.nextInt(2);
		if (next ==0)
		{
			street = street1;
			location = location1;
			result = 0;
		}
		else
		{
			street = street2;
			location = location2;
			result = 1;
		}
		
		System.out.println(driver.getName()+" heading from "+ driver.getCurrentLocation().getName()+" to "+location.getName()+ " via "+street);
		driver.setLocation(location);
		return result;
	}
}
