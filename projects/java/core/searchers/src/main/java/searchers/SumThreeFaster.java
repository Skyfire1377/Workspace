package searchers;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import interfaces.*;
import utils.Out;
import utils.Timer;
public class SumThreeFaster implements ObservableCustomInterface{
	public String name="Sum of three faster";
	List<ObserverInterface> subscribers = new ArrayList<>();
	public long cycles=0;
	Out out = new Out();
	Timer timer = new Timer();
	public long count(List<Integer> list){
		long count =0;
		int l = 0;
		int r=list.size()-1;
		int firstValue=0;
		int secondValue;
		int thirdValue;
		int secondIndex=0;
		int increment=0;
		Collections.sort(list);

		int signChangeIndex=0;
		for(int s=0;s<list.size();s++){
			if(list.get(s)>=0){
				signChangeIndex=s;
				break;
			}
			
		}
		int partLength = list.size()/10;
		int innerPart = 0;
		int outerPart = 0;
		for(int e=0;e<list.size();e++){
			if(l==r){
				break;
			}
			if(innerPart<partLength){
				innerPart++;
			}else{
				innerPart=0;
				outerPart++;
				for(ObserverInterface o:subscribers){
					Object[] ob = {outerPart};
					o.notififyEvent("arrived next", ob);
				}
			}
			
			int lv = list.get(l);
			int rv = list.get(r);
			firstValue=0;
			//out.println("i="+i+" j="+j+" count=" +count);
			if(-lv>rv){
				//out.println("left");
				firstValue = lv;
				secondIndex=r;
				increment=-1;
				
			}else{
				//out.println("right");
				firstValue = rv;
				secondIndex=l;
				increment=1;
			}
			int thirdIndex=signChangeIndex;
			int fvi = firstValue*increment;
			int diff = list.size()-signChangeIndex;
			int length=0;
			if(increment>0){
				length=signChangeIndex;
			}else{
				length=diff;
			}
			int sumi=0;
			for(int t=0;t<length;t++){
				if(secondIndex==thirdIndex){
					if(increment>0){
						r--;
					}else{
						l++;
					}
					break;
				}
				secondValue=list.get(secondIndex);
				thirdValue=list.get(thirdIndex);
				sumi = (secondValue+thirdValue)*-increment;
				
				if(fvi<sumi){
					secondIndex+=increment;
				}else if(fvi>sumi){
					thirdIndex-=increment;
				}else{
					thirdIndex-=increment;
					count++;
					//break;
				}
			}
		}
		return count;
	}
	public void subscribe(ObserverInterface o){
		subscribers.add(o);
	}
	public List<Integer> getList(){
		List<Integer> list = new ArrayList<>();
		return list;
	}
}

