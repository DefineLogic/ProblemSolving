

import java.util.ArrayList;
import java.util.Scanner;

public class LpsUsingDp {

	public static void main(String[] args) {
		
		ArrayList<ArrayList<Integer>> al1= new ArrayList<ArrayList<Integer>>();
	    Scanner sc= new Scanner(System.in);
	    int notes=sc.nextInt();
	    int noOfPairs=sc.nextInt();
	    int r =sc.nextInt();
	    System.out.println();
	    System.out.println(notes+" "+noOfPairs+" "+r);
	    int pairs=noOfPairs*r;
	    while(pairs>0)
	         {		
	    	   Integer in1=sc.nextInt();
	           ArrayList<Integer> eachal= new ArrayList<Integer>(); 
	           eachal.add(in1);
	           int in2=sc.nextInt();
	           System.out.println(in1+" "+in2);
	           eachal.add(in2);
	           al1.add(eachal);
	           pairs--;
	           pairs--;
	         }
	      int tuneLength=sc.nextInt();
	      System.out.println(tuneLength);
	      int[] car= new int[tuneLength]; 
	        for(int i=0;i<tuneLength;i++){
	            int in3=sc.nextInt();
	            System.out.println(in3);
	            car[i]=in3;
	                }
	       
	    System.out.println("hello");
	    
	    for(ArrayList<Integer> eachal:al1){
	    	for(int i=0;i<car.length;i++){
	    		if(car[i]==eachal.get(0))
	    			{
	    			car[i]=eachal.get(1);	
	    			}
	    	}
	    }
	    
	    for(int i=0;i<car.length;i++){
	    	System.out.print(car[i]);
	    }
	    System.out.println();
		/*String aa="BABCBCA";
		char[] car=aa.toCharArray();*/
		int len=car.length;
		int[][] ar=new int[len][len];
		int i=0,k=1,greater=0;
		while(i<len){
		ar[i][i]=1;
			
		i++;
		}
		while(k<len){
			int j=0;
			while(j<len && 0<=j && j+k<len){
				if(car[j]==car[j+k])
				  { if(k==1)
					  ar[j][j+k]=2;
				  else
					  ar[j][j+k]=2+ar[j+1][j+k-1];
				  }
				  else
				  {   
					  if(k==1)
						  ar[j][j+k]=1;
					  else
					  {
					  greater=(ar[j][j+k-1]<ar[j+1][j+k])?ar[j+1][j+k]:ar[j][j+k-1];
					  ar[j][j+k]=greater;
					  }
				  }	  
			   j++;
			}
			
			
			k++;
		}
		for(int m=0;m<len;m++){
			for(int n=0;n<len;n++){
				System.out.print(ar[m][n]);
			}
			System.out.println();
		}
		System.out.println("Length of Longest Palindrome Subsequence is:"+ar[0][len-1]);
	}

}
