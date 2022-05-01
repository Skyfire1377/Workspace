package parenthesisCompletor;

import java.util.List;

import utils.Out;

public class TreeBuilder{
	public TreeBuilder(String[] _dataArray){dataArray = _dataArray; rules = new Rules(tree, marker, dataArray);}
	private String[] dataArray;
	private SentenceMultiTree tree = new SentenceMultiTree();
	private Marker marker = new Marker();
	public Rules rules;
	public void build(){
		marker.mark(dataArray);
		rules.responce();
		Out out = new Out();
		for(Structurable c: tree){
			out.log(c);
		}
		marker.logComplexity(tree.getCurrent().getSentences());
		marker.log();
	}
}
