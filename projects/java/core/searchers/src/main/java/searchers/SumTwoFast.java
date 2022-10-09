package searchers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.Out;
public class SumTwoFast{
	public String name = "Sum of two fast";
	public int cycles =0;
	public int count(List<Integer> list){
		int count=0;
		Out out = new Out();
		Collections.sort(list);
		BinarySearcher bs = new BinarySearcher();
		for(int i=0;i<list.size();i++){
			cycles++;
			int value = -(list.get(i));
			int si=i<list.size()-1?i+1:list.size()-1;
			int index = bs.search(list, value, si, list.size()-1);
			if(index!=-1){
				count++;
				//boolean left = true;
				//boolean right = true;
				//for(int j=1;true;j++){

					//if(left){
						//int k = index-j;
						//if(k>=0&&(list.get(k)==list.get(index))){
							//count++;
						//}else{left=false;}
					//}
					//if(right){
						//int h=index+j;
						
						//if(h<=(list.size()-1)&&(list.get(h)==list.get(index))){

							//count++;
						//}else{
							//right=false;
						//}
						
						
					//}
					//if(!left&&!right){
						//break;
					//}
				//}
			}
		}
		return count;
	}
}
