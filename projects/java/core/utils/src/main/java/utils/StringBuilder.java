package utils;

import java.util.List;

public class StringBuilder{
	public String buildByRowWidth(List<String> list, int width, String delimiter){

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
}
