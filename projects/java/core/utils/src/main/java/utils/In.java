package utils;
public class In{
	public String fromFile(String path){
		IOFiles iof = new IOFiles(path);
		String resultString = iof.read();
		return resultString;
	}	
}
