package parenthesisCompletor;
public class SentenceMultiTree extends MultiTree{
	public SentenceMultiTree(){
		current = new Sentence();
		currentNode = new Node(current);
	}

	public void currentLevelUp(){
		if(current.hasParent()){
			current = current.getParent();
		}else{
			Sentence parent = new Sentence();
			parent.add(current);
			current.setParent(parent);
			current = parent;
		}
	}
	public void currentLevelDown(){
		Sentence child = new Sentence();
		current.add(child);
		child.setParent(current);
		current = child;
	}
}
