package co.edureka.model;
/*
 * Asychronous Execution of thread
 * 
 * and 
 *  Synchronization
 */
class Table{
	//synchronized public void printTable(int num)
	 public void printTable(int num)
	{
		System.out.println("Table of the numbers");
		for(int i=1;i<=10;i++) {
			System.out.println(num+" "+ "'s are "+(num*i));
		}
		System.out.println("----------------------");
	}
	
	
	
	 public void fun() {
		System.out.println("fun");
	}
	
	
	public void show() {
		System.out.println("show");
	}
	
	
	
	
	
	
	
	
	
	
	
}


class MyThread extends Thread{
	Table tRef;
	public MyThread(Table t) {
		tRef=t;
	}
	public void run() {
		synchronized(tRef) {
			tRef.printTable(5);
			tRef.fun();
			tRef.show();
		}
		
	}
}


class YourThread extends Thread{
	Table tRef;
	public YourThread(Table t) {
		tRef=t;
	}
	//we get a lock acquired over the entire object
	public void run() {
		//lock is automatically acquired in the begining
		synchronized(tRef) {
			tRef.printTable(9);
			tRef.fun();
			tRef.show();
			//lock is automatically release in the end.
		}
}

}

public class SyncDemo {
	public static void main(String... arv)
	{
		Table tRef=new Table();
		//tRef.printTable(5);
		MyThread mRef=new MyThread(tRef);
		YourThread yRef=new YourThread(tRef);
		
		mRef.start();
		yRef.start();
		
	}

}
/*
 * Asynchronization 
 * class Table{
	public void printTable(int num)
	{
		System.out.println("Table of the numbers");
		for(int i=1;i<=10;i++) {
			System.out.println(num+" "+ "'s are "+(num*i));
		}
		System.out.println("----------------------");
	}
}


class MyThread extends Thread{
	Table tRef;
	public MyThread(Table t) {
		tRef=t;
	}
	public void run() {
		tRef.printTable(5);
	}
}


class YourThread extends Thread{
	Table tRef;
	public YourThread(Table t) {
		tRef=t;
	}
	public void run() {
		tRef.printTable(9);
	}
}



public class SyncDemo {
	public static void main(String... arv)
	{
		Table tRef=new Table();
		//tRef.printTable(5);
		MyThread mRef=new MyThread(tRef);
		YourThread yRef=new YourThread(tRef);
		
		mRef.start();
		yRef.start();
		
	}

}
 */
