package collectionsss;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

public class SortByValue {

	public static void main(String[] args) {
			HashMap<String,String> hm= new HashMap<String,String>();
			hm.put("abc","e");
			hm.put("abcd","a");
			hm.put("ab","b");
			
			LinkedList<Entry<String,String>> ll= new LinkedList<Entry<String,String>>(hm.entrySet());
			Collections.sort(ll,new Comparator<Entry<String,String>>(){

				@Override
				public int compare(Entry<String, String> o1,
						Entry<String, String> o2) {
					return o1.getValue().compareTo(o2.getValue());
				}
				
			});
			LinkedHashMap<String,String> lhm= new LinkedHashMap<String,String>();

			for(Entry<String,String> ent:ll){
				lhm.put(ent.getKey(), ent.getValue());
				
			}
		System.out.println(lhm);
		
		for(Entry<String,String> ent:lhm.entrySet()){
			System.out.println("key:"+ent.getKey()+" value:"+ent.getValue());
		}
			
			
	}
	
		
		
		

}
