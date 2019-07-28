

public class LeastHighestSum {
public static void main(String args[]){
	int[] arr={1,2,3,4,5};
	int sum=0;
	for(int i=0;i<arr.length;i++){
		sum=sum+arr[i];
	}
	int[] brr=new int[5];
	for(int i=0;i<arr.length;i++)
	{
		brr[i]=sum-arr[i];
	}
	int least=brr[0];
	int highest=brr[0];
	for(int i=0;i<brr.length;i++){
		if(brr[i]<least)
			least=brr[i];
		
		if(brr[i]>highest)
			highest=brr[i];
	}
	
	System.out.println(least+" "+highest);
}
}
