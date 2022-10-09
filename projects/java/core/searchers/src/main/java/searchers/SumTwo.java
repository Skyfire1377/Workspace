package searchers;

import java.util.Collections;
import java.util.List;

import utils.Out;
public class SumTwo{
	public String name="Sum of two";
	Out out = new Out();
	public int count(List<Integer> list){
		Collections.sort(list);
		int count = 0;
		for(int i = 0; i<list.size(); i++){
			for(int j = i + 1; j < list.size(); j++){
				if(list.get(i)==-list.get(j)){
					//if(list.size()==12800){

						//out.println(list.get(i)+ " " +list.get(j));
					//}
					count ++;
					break;
				}
			}
		}
		return count;
	}
}
