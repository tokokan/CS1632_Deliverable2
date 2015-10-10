import java.util.*;

public class CitySim9000 {
	private int NUM_LOCATION = 5;
	private int NUM_DRIVERS = 5;
	private Location locationList[];
	
	
	private void initialize()
	{
		locationList = new Location[NUM_LOCATION];
		locationList[0] = new Location("Outside City");
		locationList[1] = new Location("Mall");
		locationList[2] = new Location("Book Store");
		locationList[3] = new Location("Coffee Shop");
		locationList[4] = new Location("University");
		
		locationList[0].setConnections("Fourth Ave.",locationList[1],"Fifth Ave.",locationList[4]);
		locationList[1].setConnections("Meow St.",locationList[3],"Fourth Ave.",locationList[2]);
		locationList[2].setConnections("Chirp St.",locationList[4],"Fourth Ave.",locationList[0]);
		locationList[3].setConnections("Meow St.",locationList[1],"Fifth Ave.",locationList[0]);
		locationList[4].setConnections("Chirp St.",locationList[2],"Fifth Ave.",locationList[3]);	
	}

	private void playCitySim9000(int seed)
	{
		Random rnd = new Random();
		rnd.setSeed(seed);
		for (int i = 0; i < NUM_DRIVERS; i++)
		{
			
			Location startLocation = locationList[rnd.nextInt(NUM_LOCATION)];
			Driver driver = new Driver("Driver "+ i,startLocation);
			do
			{
				driver.getCurrentLocation().nextLocation(driver,rnd);
			} while (driver.getCurrentLocation() != locationList[0]);
			System.out.println(driver.getName()+ " has left the city!"+"\n-----");
		}
	}
	
	public static int main(String args[])
	{
		if (args.length == 1)
		{
			int seed=0;
			try
			{
				seed = Integer.parseInt(args[0]);
			}
			catch (NumberFormatException e)
			{
				System.out.println("please enter an integer for seed!");
				return -1;
			}
			CitySim9000 citySim = new CitySim9000();
			citySim.initialize();
			citySim.playCitySim9000(seed);
			return 0;
		}
		else
		{
			System.out.println("Usage: CitiSim9000 [seed number]");
			return -2;
		}
		
	}
}
