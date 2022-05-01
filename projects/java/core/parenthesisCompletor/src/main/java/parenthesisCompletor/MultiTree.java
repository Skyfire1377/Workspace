package parenthesisCompletor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import utils.Out;
class MultiTree implements Iterable<Structurable>{
	protected Structurable result;
	protected Structurable current;
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
	private class StructurableIterator implements Iterator<Structurable>{
		Node currentNode = new Node(current);
		Out out = new Out();
		public Structurable next(){
			return currentNode.getSentence();
		}
		public boolean hasNext(){
			return hasNextExtended(currentNode);
		}
		public boolean hasNextExtended(Node last){
			if(!last.getSentence().isEmpty()){
				out.log("!isEmpty");
				if(last.getIndex()<last.getSentence().getSentences().size()){
					Node newNode = new Node(last.getSentence().getSentences().get(last.getIndex()));
					out.log("in range, addNode, increase");
					out.log("size is " + last.getSentence().getSentences().size());
					out.log("last.i = " + last.getIndex());
					last.addNode(newNode);
					last.increaseIndex();
					currentNode = newNode;
					return true;
				}
			}else{
				if(last.hasParent()){

					out.log("isEmpty, go to parent");
					return hasNextExtended(last.getParent());
				}else{
					out.log("no parent");
					return false;
				}
			}
			return false;
		}
	private class Node{
		public Node(Structurable _s){sentence=_s;}
			Structurable sentence;
			Node parent;
			List<Node> nodes = new ArrayList<>();
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
		}
	}
}
