package searchers;

import java.util.List;
import utils.Out;
public class BruteForceSearcher{
	public Integer search(List<Integer> list, Integer targetValue){
		for(int i =0; i<list.size();i++){
			Integer currentValue = list.get(i);
			if(currentValue == (int)targetValue){
				return i;
			}
		}
		return -1;
	}
}
