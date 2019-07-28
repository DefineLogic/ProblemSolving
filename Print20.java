

import java.util.Random;

public class Print20 {
	int count=1;
	public static void main(String[] args) {
		final long startTime = System.nanoTime();
			 final Print20 p=new Print20();
			
			
		Thread t1=new Thread(){
			public void run(){
				try {
					p.printOdd();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		
	}};
		Thread t2=new Thread(new Runnable(){
			public void run(){
				try {
					p.printEven();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
		final long duration = System.nanoTime() - startTime;
		System.out.println(duration);
			
	}

	public  synchronized void printOdd() throws InterruptedException{
		while(true){
			if(count>=20)
				break;
			if(count%2==0)
				wait();
				
			System.out.println("Print from odd method:"+count);
			count++;
			//Thread.sleep(500);
			notify();		
		}
	}
	
	public  void printEven() throws InterruptedException{
		while(true){
				if(count>=20)
					break;
				if(count%2==1)
					wait();
					
				System.out.println("Print from even method:"+count);
				count++;								
				//Thread.sleep(500);
				notify();			
			}
	}
	
}	

