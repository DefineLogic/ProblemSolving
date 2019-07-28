package asdfasf;

import java.util.ArrayList;
import java.util.Collections;

public class LargestProductOfThree {

	public static void main(String[] args) {
		int[] ar= {0,-5,-7,3,7,-1,-8,2};
		ArrayList<Integer> pos= new ArrayList<Integer>();
		ArrayList<Integer> neg= new ArrayList<Integer>();
		ArrayList<Integer> res= new ArrayList<Integer>();
		for(int i=0;i<ar.length;i++){
			if(ar[i]<0)
				neg.add(ar[i]);
			else pos.add(ar[i]);
		}
		Collections.sort(pos,Collections.reverseOrder());
		Collections.sort(neg);
		
		res.add(pos.get(0));
		if(pos.get(1)*pos.get(2)>=neg.get(0)*neg.get(1))
			{
			res.add(pos.get(1));
			res.add(pos.get(2));
			}
		else{
			res.add(neg.get(0));
			res.add(neg.get(1));
		}
		System.out.println(res);
	}

}
