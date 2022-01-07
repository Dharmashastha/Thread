package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import thread.ExtendedThread;
import thread.RunnableThread;


public class Spawn
{
	RunnableThread runCall=new RunnableThread();
	ExtendedThread threadCall=new ExtendedThread();
	Scanner scan=new Scanner(System.in);
	
private void currentThread()
{
		System.out.println(Thread.currentThread().getName()+" "+ Thread.currentThread().getPriority()+" "+Thread.currentThread().getState());
}
	
synchronized public void threadName() 
{
	currentThread();	
	//ExtendedThread threadCall1=new ExtendedThread();	
	threadCall.start();
	currentThread();
	//threadCall.start();
	//threadCall1.start();
}
public void implementThread()
{
	currentThread();
	Thread threadCall2=new Thread(runCall);
	//Thread threadCall3=new Thread(runCall);
	threadCall2.start();
	//threadCall3.start();
	currentThread();
	
}
public void setName(String stringName,String stringName1)
{
	currentThread();
	threadCall.setName(stringName);
	threadCall.start();
	currentThread();
	Thread runThreadCall=new Thread(runCall);
	currentThread();
	runThreadCall.setName(stringName1);
	runThreadCall.start();
	currentThread();
}
public void sleepExtended()
{
	System.out.println("How many thread you want");
	int length=Integer.parseInt(scan.nextLine());
	for(int iter=0;iter<length;iter++)
	{
		Thread objThread=new ExtendedThread();
		System.out.println("Enter Thread name");
		String name=scan.nextLine();
		objThread.setName(name);
		objThread.start();
	}
}

public void sleepRunnable()
{
	System.out.println("How many thread you want");
	int length=Integer.parseInt(scan.nextLine());
	for(int iter=0;iter<length;iter++)
	{
		Thread objThread=new Thread(runCall);
		System.out.println("Enter Thread name");
		String name=scan.nextLine();
		objThread.setName(name);
		objThread.start();
	}
}
public  void argExtended()
{
	System.out.println("How many thread you want");
	int length=Integer.parseInt(scan.nextLine());
	for(int iter=0;iter<length;iter++)
	{
		System.out.println("Enter the sleep time");
		long sleep=scan.nextLong();
		scan.nextLine();
		Thread objThread=new ExtendedThread(sleep);
		System.out.println("Enter Thread name");
		String name=scan.nextLine();
		objThread.setName(name);
		objThread.start();
	}
}
public  void argRunnable()
{
	System.out.println("How many thread you want");
	int length=Integer.parseInt(scan.nextLine());
	for(int iter=0;iter<length;iter++)
	{
		RunnableThread runCall=new RunnableThread(8000);
		Thread objThread=new Thread(runCall);
		objThread.start();
	}
}
public  void dumpExtended()
{
	System.out.println("How many thread you want");
	int length=Integer.parseInt(scan.nextLine());
	for(int iter=0;iter<length;iter++)
	{
		Thread objThread=new ExtendedThread(8000);
		objThread.start();
	}
}
public  void dumpRunnable()
{
	System.out.println("How many thread you want");
	int length=Integer.parseInt(scan.nextLine());
	for(int iter=0;iter<length;iter++)
	{
		System.out.println("Enter the sleep time");
		long sleep=scan.nextLong();
		scan.nextLine();
		RunnableThread runCall=new RunnableThread(sleep);
		Thread objThread=new Thread(runCall);
		System.out.println("Enter Thread name");
		String name=scan.nextLine();
		objThread.setName(name);
		objThread.start();
	}
}

public  void dumpMulExtended()
{
	System.out.println("How many thread you want");
	int length=Integer.parseInt(scan.nextLine());
	List<ExtendedThread> threadCall=new ArrayList<ExtendedThread>(length);
	for(int iter=0;iter<length;iter++)
	{
		threadCall.add(iter,new ExtendedThread(10000));
		threadCall.get(iter).setName("ExtendedThread "+iter);
		threadCall.get(iter).start();
	}
	try {
		Thread.sleep(8000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
	
	}
	for(int iter=0;iter<length;iter++)
	{
		threadCall.get(iter).stopThread();
	}
}
public  void dumpMulRunnable()
{
	System.out.println("How many thread you want");
	int length=Integer.parseInt(scan.nextLine());
	
	List<RunnableThread> arrayCall=new ArrayList<RunnableThread>(length);
	
	List<Thread> threadCall=new ArrayList<Thread>(length);
	
	for(int iter=0;iter<length;iter++)
	{
		arrayCall.add(iter,new RunnableThread(10000));
		threadCall.add(iter,new Thread(arrayCall.get(iter),"RunnableThread "+iter));
		threadCall.get(iter).start();
	}
	try {
		Thread.sleep(8000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
	
	}
	for(int iter=0;iter<length;iter++)
	{
		arrayCall.get(iter).stopThread();
	}
}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		Spawn spawnCall=new Spawn();
		System.out.println("Enter the case ");
		int number=0;
		try 
		{   

			number=Integer.parseInt(scan.nextLine());
		}
		catch(Exception e)
		{
			System.out.println("Enter the number only");
			e.printStackTrace();
		}
		
switch(number)
{
case 1:
		spawnCall.threadName();
		break;
case 2:
		spawnCall.implementThread();
		break;
case 3:
		System.out.println("Enter the ExtendedThread setName:");
		String stringName=scan.nextLine();
		System.out.println("Enter the RunnableThread setName:");
		String stringName1=scan.nextLine();
		spawnCall.setName(stringName, stringName1);
		break;

case 4:
		spawnCall.sleepExtended();
		spawnCall.sleepRunnable();
		break;

case 5:
		spawnCall.argExtended();
		spawnCall.argRunnable();    
		break;

case 6:
		spawnCall.dumpExtended();
		break;

case 7:
		spawnCall.dumpRunnable();
		break;
case 8:
		spawnCall.dumpMulExtended();
		break;
case 9:
		spawnCall.dumpMulRunnable();
		break;
}
scan.close();
}
}
	
