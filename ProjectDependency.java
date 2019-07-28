

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class ProjectDependency {

	public static void main(String[] args) {
		String result="";
		//System.out.println("Enter the input:");
		Scanner sc= new Scanner(System.in);
		HashMap<Integer,ArrayList<Integer>> hm= new HashMap<Integer,ArrayList<Integer>>();
		int tasks=0,dependencies=0;
		tasks=sc.nextInt();
		dependencies=sc.nextInt();
		while (dependencies>0) {
			int key = sc.nextInt();
			 //System.out.println("key:"+key);
			int noOfValues = sc.nextInt();
			 //System.out.println("noOfvalues:"+noOfValues);
			ArrayList<Integer> each = new ArrayList<Integer>();
			for (int i = 0; i < noOfValues; i++) {
				int value = sc.nextInt();
				each.add(value);
				 //System.out.println("value:"+value);
			}
			hm.put(key, each);
			dependencies--;
		}
		//System.out.println(hm);
		int var=0;
		for(int i=1;i<=tasks;i++)
		{
			if(hm.get(i)==null&&var==0)
			{
				result=result+i;
				var=i;
			}
			else if(hm.get(i)==null)
			{
				ArrayList<Integer> each2 = new ArrayList<Integer>();	
				hm.put(i,each2);
			}
			
		}
		
			for(Entry<Integer,ArrayList<Integer>> entry:hm.entrySet())
			{
				entry.getValue().remove(new Integer(var));	
			}
		
		while(hm.size()!=0){
			int abc=removingMethod(hm, var);
			if(abc==-1)
			{
				System.out.println("Tasks deadlocked." +hm);
				break;
			}
			var=abc;
			result=result+" "+abc;
		}
		System.out.println(result);
		}
		
	public static int removingMethod(HashMap<Integer,ArrayList<Integer>> hm,Integer var){
				ArrayList<Integer> toRemove= new ArrayList<Integer>();
				for(Entry<Integer,ArrayList<Integer>> entry:hm.entrySet())
				{
					entry.getValue().remove(var);
					if(entry.getValue().size()==0)
					{
						toRemove.add(entry.getKey());
					}
				}
				
				if(!toRemove.isEmpty()){
				int chota=toRemove.get(0);
				for(Integer aa:toRemove)
				{
					if(aa<chota){
						chota=aa;
					} 
				}
				hm.remove(chota);
				return chota;
				}
		
		return -1;
	} 

}
