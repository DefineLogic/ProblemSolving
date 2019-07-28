

import java.util.HashSet;
import java.util.Set;

public class StringPermutations {

	public static void main(String[] args) {
		System.out.println(findPerm("ABC"));
	}

	private static Set<String> findPerm(String str) {
		Set<String> res=new HashSet<String>();		
		if(str==null){
			return null;
		}
		else if(str.length()==0)
		{
			res.add("");
			return res;
		}
		
		char init=str.charAt(0);
		String rem=str.substring(1);
		Set<String> words=findPerm(rem);
		for(String word:words){
			for(int i=0;i<=word.length();i++)
			{
				res.add(generateNumber(init,word,i));
			}
		}
		return res;
		
		
		
	}

	private static String generateNumber(char init, String word, int i) {
		String begin=word.substring(0,i);
		String end=word.substring(i);
		String a=begin+init+end;
		return a;
	}

}
