package parenthesisCompletor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import utils.Out;
public class Marker{
	public Out out = new Out();
	private List<String> markers  = new ArrayList<>();
	private List<String> complexityMarkers = new ArrayList<>();
	private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
	public Marker(){}
	public void mark(String[] dataArray){

		for(int i =0; i<dataArray.length; i++){
			String v = dataArray[i];
			String result = "";
			if(isNumeric(v)){
				result = "n";
			}else if(isOperation(v)){
				result = "o";
			}else if(isRightBracket(v)){
				result = "b";
			}
			markers.add(result);
		}
	}
	public List<String> markComplexity(List<Structurable> sentences){
		List<String> marks = new ArrayList<>();
		String result = "";
		for(int i =0; i<sentences.size();i++){
			if(sentences.get(i).isEmpty()){
				result = "s ";
			}else{
				result = "c ";
			}
			marks.add(result);
		}
		return marks;
	}
	public void markComplexityAndAdd(Structurable s){
		String mark;
		if(s.isEmpty()){mark="s";}else{mark="c";}
		complexityMarkers.add(mark);
	}
	public void clearComplexity(){
		complexityMarkers = new ArrayList<>();
	}
	public boolean isOperation(String v){
		return v.equals("+")||v.equals("-")||v.equals("*")||v.equals("/");
	}
	public boolean isRightBracket(String v){
		return v.equals(")");
	}
	public boolean isNumeric(String v){
		return pattern.matcher(v).matches();
	}
	public String getComplexity(int i){
		return complexityMarkers.get(i);
	}
	public List<String> getComplexityMarkers(){
		return complexityMarkers;
	}
	public Integer getComplexityLastIndex(){
		return complexityMarkers.size()-1;
	}
	public List<String> getMarkers(){
		return markers;
	}
	public void log(){
		out.log(markers.toString());
	}
	public void logComplexity(List<Structurable> sentences){
		List<String> marks = markComplexity(sentences);
		
		out.log(marks);
	}

}
