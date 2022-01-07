package thread;

public class ExtendedThread extends Thread
{
private boolean flag=false;
	public 	ExtendedThread()
{
	
}
public void stopThread()
{
flag=true;	
}

private long sleep;
public ExtendedThread(long sleep)
{
	this.sleep=sleep;
}


public void run()
{
	while(!flag) //while(ExtendedThread.interrupted())
	{
		System.out.println("Thread Name:"+this.getName());
		System.out.println("Thread Priority: "+this.getPriority());
		System.out.println("Thread State: "+this.getState());
		try 
		{
			System.out.println("Before Going to sleep "+this.getName());
			Thread.sleep(sleep);
			System.out.println("After Going to sleep "+this.getName());
		} catch (InterruptedException e) {}
	}
	System.out.println("Thread stopped");
}
}