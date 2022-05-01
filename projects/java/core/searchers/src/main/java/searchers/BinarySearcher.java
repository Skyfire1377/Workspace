package searchers;

import java.util.List;
public class BinarySearcher{
	public Integer search(List<Integer> list, Integer targetValue, Integer startIndex, Integer endIndex){
		Integer newStartIndex;
		Integer newEndIndex;

		Integer halfIndex = startIndex + ((endIndex - startIndex) / 2);
		if(targetValue<list.get(halfIndex)){
			newStartIndex = startIndex;
			newEndIndex = halfIndex;
		}else if(targetValue>list.get(halfIndex)){
			newStartIndex = halfIndex;
			newEndIndex = endIndex;
		}else{
			return halfIndex;
		}
		if(newStartIndex==startIndex&&newEndIndex==endIndex){
			return -1;
		}
		return search(list, targetValue, newStartIndex, newEndIndex);

		
	}
}
