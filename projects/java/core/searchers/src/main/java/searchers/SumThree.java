package searchers;

import java.util.List;

public class SumThree{
	public String name="Sum of three";
	public int cycles=0;
	public int count(List<Integer> list){
		int count = 0;
		for(int i=0;i<list.size(); i++){
			for(int j =i+1; j<list.size();j++){
				for(int k =j+1; k<list.size();k++){
					cycles++;
					if((list.get(i)+list.get(j)+list.get(k))==0){
						count++;
					}
				}
			}
		}
		return count;
	}
}
