

public class FibonacciUsingDP {
	public static void main(String[] args) {
			System.out.println("fibonacci number is:"+fib(4));
	}

	private static int fib(int num) {
			int[] ar=new int[num+2];
			ar[0]=0;
			ar[1]=1;
			for(int i=2;i<=num;i++)
			{
				ar[i]=ar[i-1]+ar[i-2];
			}
			return ar[num];
		}

}
