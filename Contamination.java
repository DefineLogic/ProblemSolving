

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Contamination {
public static void main(String args[]){
	
	//String a="WWWRW CRRRR RWWRW WWWRR WRRWC";
	//String a="WWWRW RRWRR RWWCW WRWRR WRWWC";
	Scanner sc= new Scanner(System.in);
	int rows=sc.nextInt();
	int rowscount=rows;
	int column=sc.nextInt();
	String[] ar=new String[rows];
	int count =0;
	while(rowscount>0)
	{
		ar[count]=sc.next();
		count++;
		rowscount--;
	}
	char[][] ca= new char[5][5];
	for(int i=0;i<5;i++)
	{
		for(int j=0;j<5;j++)
		{
			ca[i][j]=ar[i].charAt(j);
		}
	}
	/*for(int i=0;i<5;i++)
	{
		for(int j=0;j<5;j++)
		{
			System.out.print(ca[i][j]);
		}
		System.out.println();
	}*/
	for(int i=0;i<5;i++)
	{
		for(int j=0;j<5;j++)
		{
			if(ca[i][j]=='C'){
				scan(ca,i,j);
			}
		}
	}
	System.out.println();

	for(int i=0;i<5;i++)
	{
		for(int j=0;j<5;j++)
		{
			System.out.print(ca[i][j]);
		}
		if(i<5-1)
		System.out.println();
	}
	
}
	public static void scan(char[][] ca,int a,int b){
		int left=b-1;
		int right=b+1;
		int up=a-1;
		int bottom=a+1;
		if(left>=0){
		if(ca[a][left]=='W')
		{
			ca[a][left]='C';
			scan(ca,a,left);

		}
		}
		if(right>=0 && right<5){
		if(ca[a][right]=='W')
		{
			ca[a][right]='C';
			scan(ca,a,right);
		}}
		if(up>=0){
		if(ca[up][b]=='W')
		{
			ca[up][b]='C';
			scan(ca,up,b);
		}}
		if(bottom>=0 && bottom<5){
		if(ca[bottom][b]=='W')
		{
			ca[bottom][b]='C';
			scan(ca,bottom,b);
		}}
		
	}
		}
		

	


