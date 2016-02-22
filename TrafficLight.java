
public class TrafficLight extends Thread{
	
	TrafficLight(){
		Synch.timeSim.threadStart();
	}
	
	public static int Q = 100;
	public static int T = 200;
	
	public void run ()
	{
		while (Synch.num_cars > 0)
		{
		    System.out.println("\nEastbound turning green.");
		    Synch.east_light = true;
		    Synch.west_light = false;
			for (int i = 0; i < Synch.eastbound_waiting; i++)
			{
				Synch.eastSem.release();
			}
			Synch.timeSim.doSleep(T);
			
			System.out.println("\nBoth lights turning red.");
			Synch.east_light = false;
			Synch.west_light = false;
			Synch.timeSim.doSleep(Q);
			
			System.out.println("\nWestbound turning green.");
			Synch.east_light = false;
			Synch.west_light = true;
			for (int i = 0; i < Synch.westbound_waiting; i++)
			{
				Synch.westSem.release();
			}
			Synch.timeSim.doSleep(T);

            System.out.println("\nBoth lights turning red.");
			Synch.east_light = false;
			Synch.west_light = false;
			Synch.timeSim.doSleep(Q);
		}
		Synch.timeSim.threadEnd();
	}
	

}
