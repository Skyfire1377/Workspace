package searchers;

import java.util.List;
import utils.Out;
public class BinarySearcher{
	Out out = new Out();
	public Integer search(List<Integer> list, Integer targetValue, Integer startIndex, Integer endIndex){
		Integer newStartIndex;
		Integer newEndIndex;

		Integer halfIndex = startIndex + ((endIndex - startIndex) / 2);
		if(targetValue<list.get(halfIndex)){
			newStartIndex = startIndex;
			newEndIndex = halfIndex-1;
		}else if(targetValue>list.get(halfIndex)){
			newStartIndex = halfIndex+1;
			newEndIndex = endIndex;
		}else{
			return halfIndex;
		}
		if(newStartIndex>newEndIndex){
			return -1;
		}
		return search(list, targetValue, newStartIndex, newEndIndex);

		
	}
}
