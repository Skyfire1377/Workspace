package searchers;

import java.util.Collections;
import java.util.List;

public class SumTwoFaster{
	public String name = "Sum of two faster";
	public int count(List<Integer> list){
		int count=0;
		Collections.sort(list);
		int l = 0;
		int r = list.size()-1;
		int lval;
		int rval;
		while(l!=r){
			lval = list.get(l);
			rval = list.get(r);
			if(lval>0||rval<0){
				break;
			}
			if(-lval==rval){
				count++;
				l++;
			}else if(-lval>rval){
				l++;
			}else{
				r--;
			}
				
		}
		return count;
	}
}
