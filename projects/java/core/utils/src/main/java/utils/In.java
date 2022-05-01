package utils;

import java.util.List;

public class In{
	private List<Integer> list;
	public String fromFile(String path){
		IOFiles iof = new IOFiles(path);
		String resultString = iof.read();
		return resultString;
	}
	public List<Integer> getListOfInteger(String path){
		String s = fromFile(path);
		Convertor conv = new Convertor();
		List<Integer> list = conv.stringToListOfIntegers(s);
		return list;
	}
	
}
