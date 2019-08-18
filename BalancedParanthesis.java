

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class BalancedParanthesis {
	public static void main(String args[]){
		TreeSet<String> hs=new TreeSet(generate(3));
		System.out.println(hs);		
	}
	
	public static HashSet<String> generate(int in)
	{
		HashSet<String> hs= new HashSet<String>();	
			if(in ==1)
		{
			hs.add("()");
			return hs;
		}
		else{
			Set<String> ab=generate(in-1);
			for(String each:ab)
			{
				hs.add("("+each+")");
				hs.add("()"+each);
				hs.add(each+"()");
			}
			return hs;
		// testing git
		}		
	}
	
}
