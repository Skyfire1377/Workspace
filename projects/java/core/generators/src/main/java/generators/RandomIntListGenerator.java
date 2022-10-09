package generators;

import java.util.ArrayList;
import java.util.List;

import interfaces.ObservableCustomInterface;
import interfaces.ObserverInterface;
public class RandomIntListGenerator implements ObservableCustomInterface{
	int N;
	int max;
	List<Integer> data = new ArrayList<>();
	List<ObserverInterface> subscribers = new ArrayList<>();
	public RandomIntListGenerator(int _max, int _N){
		max=_max;
		N=_N;

	}
	public void generateSet(){
		int up = 424_242;
		int half = up / 2;
		int part=0;
		int partInnerIndex=0;
		int partOuterIndex=0;
		boolean initialased=false;
		for(int i=0; i<max; i++){
			int v = - half + (int)(Math.random()*up);
			data.add(v);
			if(i<N-1){
				if(!initialased){
					part = (N-i)/10;
					partInnerIndex=0;
					partOuterIndex=0;
					initialased=true;
				}else{
					if(partInnerIndex<part){
						partInnerIndex++;
					}else{
						partInnerIndex=0;
						partOuterIndex++;

						for(ObserverInterface item :subscribers){
							Object[] ob = {this, N};
							item.notififyEvent("next part", ob);
						}
					}
				}
			}else{
				for(ObserverInterface item :subscribers){
					Object[] ob = {N};
					item.notififyEvent("arrived N", ob);
					doubleSize();
					initialased=false;
				}
			}
		}
	}
	void doubleSize(){
		N*=2;
	}
	public void subscribe(ObserverInterface oi){
		subscribers.add(oi);
	}
	public List<Integer> getList(){
		return data;
	}
}
