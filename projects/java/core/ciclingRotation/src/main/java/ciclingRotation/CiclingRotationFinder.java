package ciclingRotation;
import utils.Out;
public class CiclingRotationFinder{

	public Out out = new Out();
	public boolean checkSubString(String baseString, String testString){
		out.println("substring");
		for(int i =0; i<testString.length(); i++){
			String s = testString.substring(i, testString.length()) + testString.substring(0, i);
			if(baseString.equals(s)){
				out.println("Matched: " + baseString + " = " + s);
			}
		}
		return true;
	}	
	public boolean checkIndexOf(String baseString, String testString){
		out.println("indexOf");
		//for(int i = 0; i<pattern.length(); i++){
			
		//}
		String testingConcatenated = testString + testString;
		if(testingConcatenated.indexOf(baseString)!=-1){
			out.println("Matched in " + testingConcatenated + ": " + baseString);	
		}
		return true;
	}
	public boolean checkCursorControl(String  baseString, String testString){
		out.println("cursorControl");
		char baseChar[] = baseString.toCharArray();
		char testChar[] = testString.toCharArray();
		for(int i = 0; i<testChar.length; i++){
			int innerPos = 0;
			for(int j = 0; j<baseChar.length; j++){
				//int innerIndex = i + innerPos > testChar.length -1 ? i + innerPos - testChar.length : i + innerPos;
				int innerIndex = (i + innerPos) % (testChar.length);
				if(testChar[innerIndex] == baseChar[j]){
					//out.println(testChar[innerIndex] + "=" + baseChar[j] + " " + i + " " + innerIndex + " " + j);
					
					innerPos ++;
					if(innerPos > testChar.length-2){
						out.println("matched");
					}
				}else{
					//out.println("break " + i + ": " + testChar[innerIndex] + " != " + baseChar[j]);
					break;
				}
			}
	
		}
		return true;
	}
}
