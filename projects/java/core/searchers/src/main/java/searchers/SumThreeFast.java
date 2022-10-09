package searchers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import interfaces.*;
import interfaces.ObservableCustomInterface;
import interfaces.ObserverInterface;
import utils.Out;
public class SumThreeFast implements ObservableCustomInterface{
	List<ObserverInterface> subscribers = new ArrayList<>();
	public String name = "Sum of three fast";
	public long cycles =0;
	BinarySearcher bs= new BinarySearcher();
	Out out = new Out();
	public int count(List<Integer> list){
		int count=0;
		long size = (long)list.size();
		long part = (long)(size*size)/20;
		int innerPart=0;
		int outerPart=0;
		Collections.sort(list);
		for(int i = 0; i< list.size(); i++){
			for(int j=i+1;j<list.size();j++){
				if(innerPart<part){
					innerPart++;
				}else{
					innerPart=0;
					outerPart++;
					for(ObserverInterface o:subscribers){
						Object[] ob = {outerPart,  part, size};
						o.notififyEvent("arrived next", ob);

					}
				}
				cycles++;
				int startIndex = j<list.size()-1?j+1:list.size()-1;
				int targetValue=-(list.get(i)+list.get(j));
				int index = bs.search(list, targetValue, startIndex, list.size()-1);
				if(index!=-1){
					count++;
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
