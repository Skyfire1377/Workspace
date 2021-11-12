package ciclingRotation;
import utils.Out;
public class CiclingRotationFinder{

	public Out out = new Out();
	public boolean checkSubString(String baseString, String testString){

		for(int i =0; i<testString.length(); i++){
			String s = testString.substring(i, testString.length()) + testString.substring(0, i);
			if(baseString.equals(s)){
				out.println("Matched: " + baseString + " = " + s);
			}
		}
		return true;
	}	
	public boolean checkIndexOf(String baseString, String testString){
		//for(int i = 0; i<pattern.length(); i++){
			
		//}
		String testingConcatenated = testString + testString;
		if(testingConcatenated.indexOf(baseString)!=-1){
			out.println("Matched in " + testingConcatenated + ": " + baseString);	
		}
		return true;
	}
	public boolean checkCursorControl(String  baseString, String testString){
		int testStringPosition;
		int lastEnterPosition = 0;
		String currentLetter = "";
		for(int i = 0; i < baseString.length(); i++){
			currentLetter = baseString.substring(i, i+1);	
			testStringPosition = testString.indexOf(s, lastEnterPosition);
		}
		return true;
	}
}
