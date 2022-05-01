package parenthesisCompletor;


import java.util.ArrayList;
import java.util.List;

public class Sentence implements Structurable{
	private List<Structurable> sentences = new ArrayList<>();
	private List<String> operations = new ArrayList<>();
	private String value = "";
	private Structurable parent = null;
	private Integer nextToLastSentencePose = 0;
	public Sentence(String _value){
		value = _value;
	}
	public Sentence(){
	} public void add(Structurable s){ sentences.add(s);
	}
	public void addOperation(String o){
		operations.add(o);
	}
	public void visit(){
		if(sentences.size()==0){
			parent.fill(value);
		}

	}
	public void fill(String data){

	}
	public void setParent(Structurable _parent){
		parent = _parent;	
	}
	public boolean hasParent(){
		return parent != null;
	}
	public Structurable getParent(){
		return parent;
	}
	public int getChildrenSize(){
		return sentences.size();
	}
	public Structurable getChild(int i){
		return sentences.get(i);
	}
	public void setNextToLastPose(){
		nextToLastSentencePose = sentences.size();
	}
	public int getNextToLastPose(){
		return nextToLastSentencePose;
	}
	public List<Structurable> getSentences(){
		return sentences;
	}
	public List<String> getOperations(){
		return operations;
	}
	public boolean isEmpty(){
		return sentences.size()==0;
	}
}
	
