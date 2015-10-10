
public class Driver {
	String name;
	Location location;
	
	public Driver(String name, Location location)
	{
		this.name = name;
		this.location = location;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public Location getCurrentLocation()
	{
		return location;
	}
	
	public void setLocation(Location location)
	{
		this.location = location;
	}
}
