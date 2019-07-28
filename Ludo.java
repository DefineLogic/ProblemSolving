

import java.util.Random;

public class Ludo {
	static int taskassigner=0;
	Random rand = new Random();
	int count=0;
	int count2=0;
	private boolean finished;
	public static void main(String[] args) {
			 final Ludo ludo=new Ludo();
			
			
		Thread t1=new Thread(){
			public void run(){
				try {
					ludo.p1Move();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}};
		Thread t2=new Thread(new Runnable(){
			public void run(){
				try {
					ludo.p2Move();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
			
	}

	public  synchronized void p1Move() throws InterruptedException{
		while(true){
			if(taskassigner==1)
			{wait();}
			if(finished)
				break;
			int ran=rand.nextInt(7);
			System.out.println("p1 "+ran);
			count=count+ran;
			System.out.println("p1count:"+count);
			Thread.sleep(500);
			taskassigner=1;
			if(count>=25)
			{
				finished=true;
				System.out.println("Player 1 wins.");
				notify();
			break;}
			notify();
			
		}
		
	}
	public synchronized void p2Move() throws InterruptedException{
		while(true){
			if(taskassigner==0)
			{wait();}
			if(finished)
				break;
			int ran=rand.nextInt(7);
			System.out.println("p2 "+ran);
			count2=count2+ran;
			System.out.println("p2count:"+count2);
			Thread.sleep(500);
			taskassigner=0;
			if(count2>=25)
			{
				finished=true;
				System.out.println("Player 2 wins.");
				notify();
			break;}
			notify();
			
		}
	}
}
