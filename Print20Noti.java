

public class Print20Noti {
	int count=1;
	public static void main(String[] args) {
			 final Print20Noti p=new Print20Noti();
			
			
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
			
	}

	public  synchronized void printOdd() throws InterruptedException{
		while(true){
			if(count>=20)
				break;
			if(count%2==1)
				notify();
				
			System.out.println("Print from odd method:"+count);
			count++;
			Thread.sleep(500);
			wait();		
		}
	}
	
	public synchronized void printEven() throws InterruptedException{
		while(true){
				if(count>=20)
					break;
				if(count%2==0)
					 notify();
					
				System.out.println("Print from even method:"+count);
				count++;								
				Thread.sleep(500);
				wait();			
			}
	}
	
	
}
