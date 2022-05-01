package parenthesisCompletor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import utils.Out;
class MultiTree implements Iterable<Structurable>{
	protected Structurable result;
	protected Structurable current;
	public Out out = new Out();
	public String resultString = "";
	public Node currentNode;
	public StructurableIterator iterator(){
		return new StructurableIterator();
	}
	public void add(Structurable v){
		current.add(v);
	}
	public void addToResult(Structurable v){
		result.add(v);
	}
	public void addToResultOperation(String s){
		result.addOperation(s);
	}
	public void addOperation(String s){
		current.addOperation(s);
	}
	public void setParent(Structurable v){
		current.setParent(v);
	}
	public Structurable getParent(){
		return current.getParent();
	}
	public boolean hasParent(){
		return current.hasParent();
	}
	public Structurable getCurrent(){
		return current;
	}
	public void setCurrent(Structurable v){
		current = v;
	}
	public void clearCurrent(){
		current = new Sentence();
	}
	public void show(){

	}
	public Node getCurrentNode(){
		return currentNode;
	}
	private class StructurableIterator implements Iterator<Structurable>{
		Out out = new Out();
		public StructurableIterator(){
		}
		public Structurable next(){
			return currentNode.getSentence();
		}
		public boolean hasNext(){
			return hasNextExtended(currentNode);
		}
		public boolean hasNextExtended(Node last){
			if(!last.getSentence().isEmpty()){
				//out.log("is not empty");
				if(last.getIndex()<last.getSentence().getSentences().size()){
					Node newNode = new Node(last.getSentence().getSentences().get(last.getIndex()));
					//out.log("in range, addNode, increase");
					//out.log("size is " + last.getSentence().getSentences().size());
					//out.log("last.i = " + last.getIndex());
					last.addNode(newNode);
					last.increaseIndex();
					currentNode = newNode;
					return true;
				}
				return hasParentExtended(last);
			}else{
				return hasParentExtended(last);
			}
		}
		public boolean hasParentExtended(Node last){

			if(last.hasParent()){

				//out.log("isEmpty, go to parent");
				return hasNextExtended(last.getParent());
			}else{
				//out.log("no parent");
				return false;
			}
		}
	}
	public class Node{
		public Node(Structurable _s){sentence=_s;}
			Structurable sentence;
			Node parent;
			List<Node> nodes = new ArrayList<>();
			List<String> resultList = new ArrayList<>();
			int i=0;
			public Structurable getSentence(){
				return sentence;
			}
			public void addNode(Node n){
				n.setParent(this);
				nodes.add(n);
			}
			public Node getNode(int i){
				return nodes.get(i);
			}
			public void setParent(Node p){
				parent = p;
			}
			public int getIndex(){
				return i;
			}
			public void increaseIndex(){
				i++;
			}
			public Node getParent(){
				return parent;
			}
			public boolean hasParent(){
				return parent!=null;
			}
			public boolean fill(String data){
				resultList.add(data);
				if(resultList.size()==getSentence().getSentences().size()){
					out.log("resultList size == sentences size");
					out.log(resultList);
					String result = listsToString();
					if(hasParent()){
						out.log("parent fill " + result);
						result = "("+result+")";
						parent.fill(result);
						return true;
					}else{
						resultString = result;
					}
				}
				return false;
			}
			public boolean visit(){
				if(getSentence().isEmpty()){
					out.log("is empty");
					if(hasParent()){
						out.log("has parent, fill " + getSentence().getValue());
						return parent.fill(getSentence().getValue());
					}
				}
				return false;
			}
			public String listsToString(){
				String result = "";
				for(int i =0; i<resultList.size(); i++){
					result += resultList.get(i);
					if(i<resultList.size()-1){
						result+=getSentence().getOperations().get(i);
					}
				}
				return result;
			}
		}
}
