package co.edureka.model;

class MyTask extends Thread
{
	public void run(){
		
		//Runnable when the method is in exection.
		System.out.println("State of myTAsk 1 "+Thread.currentThread().getState());
		for(int i=0;i<=10;i++){
			try {
				Thread.sleep(1000);
				//1 sec
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("##MyTask## "+i);
			
		}
	}
}

class A{
	
}

class YourTask extends A implements Runnable{
	public void run() {

		for(int i=0;i<=10;i++) {
			try {
				Thread.sleep(1000);
				//1 sec
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("YourTask "+i);
		}
	}
}

public class ThreadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("==main started==");
		//creating the object is new thread hence it's called New
		//starting the thread is executing the thread and hence it's called Runnable
		MyTask mRef=new MyTask();
		
		Runnable r=new YourTask();//polymorphic statment
		
		Thread yRef=new Thread(r);
		
		mRef.setPriority(Thread.MAX_PRIORITY);
		yRef.setPriority(Thread.MIN_PRIORITY);
		Thread.currentThread().setPriority(Thread.NORM_PRIORITY);
		
		
		mRef.setName("MyThread");
		yRef.setName("YourThread");
		Thread.currentThread().setName("MainThread");
		
		System.out.println("State of myTAsk 2 "+mRef.getState());

		
		mRef.start();
		try {
			mRef.join();//till time my task has not finished his task all other get waited
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		yRef.start();
		yRef.yield();
		//execute other i will wait (just a request)
		
		for(int i=0;i<=10;i++)
		{
			try {
				Thread.sleep(1000);
				//1 sec
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("**main Thread** "+i);
		}
		
		System.out.println("MyTask name "+mRef.getName()+" Priority "+mRef.getPriority());
		System.out.println("YourTask name "+yRef.getName()+" Priority "+yRef.getPriority());
		System.out.println("main name "+Thread.currentThread().getName()+" Priority "+Thread.currentThread().getPriority());
		
		System.out.println("==main Finish==");
		System.out.println("State of myTAsk 3 "+mRef.getState());
		//when run method is finish state is terminated, hence it's called Terminated.

	}

}
