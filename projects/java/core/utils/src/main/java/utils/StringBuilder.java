package utils;

import java.util.ArrayList;
import java.util.List;

import interfaces.*;
public class StringBuilder implements ObservableCustomInterface{
	public List<ObserverInterface> subscribers = new ArrayList<>();
	public String byStrings(List<String> list, int width, String delimiter){

		String resultString = "";
		int currentWidth = 0;
		for(int i = 0; i < list.size()-1; i++){

			currentWidth++;
			resultString += list.get(i) + delimiter;
			if(currentWidth>width-1){
				//resultString += "\n";
				currentWidth = 0;
			}
		}	
		resultString+=list.get(list.size()-1);
		return resultString;
	}
	public String byInts(List<Integer> list, int width, String delimiter){
		Integer part=list.size()/10;
		Integer innerPart=0;
		Integer outerPart=0;
		String resultString = "";
		int currentWidth = 0;
		for(int i = 0; i < list.size()-1; i++){
			if(innerPart<part){
				innerPart++;
			}else{
				outerPart++;
				innerPart=0;
				for(ObserverInterface o:subscribers){
					Object[] ob = {outerPart};
					o.notififyEvent("string generating", ob);
				}
			}
			//currentWidth++;
			resultString += list.get(i) + delimiter;
			//if(currentWidth>width-1){
				////resultString += "\n";
				//currentWidth = 0;
			//}
		}	
		resultString+=list.get(list.size()-1);
		return resultString;
	}
	public void subscribe(ObserverInterface o){
		subscribers.add(o);
	}
	public List<Integer> getList(){
		List<Integer> l = new ArrayList<>();
		return l;
	}
}
