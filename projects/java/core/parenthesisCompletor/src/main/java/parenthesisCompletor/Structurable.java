package parenthesisCompletor;

import java.util.List;

public interface Structurable{
	public void add(Structurable t);
	public void addOperation(String s);
	public boolean hasParent();
	public void setParent(Structurable t);
	public int getChildrenSize();
	public Structurable getChild(int i);
	public Structurable getParent();
	public boolean isEmpty();
	public List<Structurable> getSentences();
	public List<String> getOperations();
	public void fill(String s);
}
