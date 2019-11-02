package co.edureka.model;
/*
 * Thread acquisition.
 * 
 * 
 * One Thread Interaction.
 */

class Message{
	String msg;
	public Message(){
		msg="no message available";
	}
	public void writeMessage(String m) {
		msg=m;
		System.out.println("message writen");
	}
	public void readMessge() {
		System.out.println("Message: "+msg);
	}
}

class ReaderThread extends Thread{
	Message mRef;
	public ReaderThread(Message m)
	{
		mRef=m;
	}
	
	public void run() {
		synchronized(mRef) {
			try {
				mRef.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mRef.readMessge();
		}
	}
}

class WriterThread extends Thread{
	Message mRef;
	public WriterThread(Message m)
	{
		mRef=m;
	}
	
	public void run() {
		synchronized(mRef) {
			mRef.writeMessage("Boss work finished");
			//mRef.notify();
			mRef.notifyAll();
		}
	}
}

public class WNDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Message mRef=new Message();
		ReaderThread rt=new ReaderThread(mRef);
		ReaderThread rt2=new ReaderThread(mRef);
		WriterThread wt=new WriterThread(mRef);
		
		rt.start();
		rt2.start();
		wt.start();
	}

}
