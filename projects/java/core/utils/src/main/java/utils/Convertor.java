package utils;

import java.util.ArrayList;
import java.util.List;

public class Convertor{
	public List<Integer> stringToListOfIntegers(String dataString){
		String[] splitedArray = dataString.split(" ");
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<splitedArray.length;i++){
			list.add(Integer.parseInt(splitedArray[i]));
		}
		return list;
	}
}
