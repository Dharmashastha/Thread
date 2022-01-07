package thread;

public class RunnableThread implements Runnable
{
	private boolean flag=false;
	public RunnableThread()
	{
		
	}
	public void stopThread()
	{
		flag=true;
	}
	
	private long sleep;
	public RunnableThread(long sleep)
	{
		this.sleep=sleep;
	}
	public void run()
	{
		while(!flag) //while(Thread.interrupted())
		{
		System.out.println("Thread RunnableThread Name: "+Thread.currentThread().getName());
		System.out.println("Thread RunnableThread Priority: "+Thread.currentThread().getPriority());
		System.out.println("Thread RunnableThread State: "+Thread.currentThread().getState());
		try 
		{
		System.out.println("Before Going to sleep "+Thread.currentThread().getName());
		Thread.sleep(sleep);
		System.out.println("After Going to sleep "+Thread.currentThread().getName());
		}
		catch(InterruptedException e)
		{
		
		}
		}
		System.out.println("Thread stopped");
		
}
}
