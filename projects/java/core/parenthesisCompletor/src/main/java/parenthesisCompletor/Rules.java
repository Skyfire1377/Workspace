package parenthesisCompletor;
import java.util.ArrayList;
import java.util.List;

import utils.Out;
	// 3 + 34 + 2 ) - 22 + 5 ) ) / 35 - 4 * 109
public class Rules{
	public Rules(MultiTree _tree, Marker _marker, String[] _dataArray){tree=_tree; marker=_marker; dataArray = _dataArray; responcer = new RightBracketResponcer(_tree, _marker);}
	private MultiTree tree;
	private Marker marker;
	private String[] dataArray;
	private RightBracketResponcer responcer;
	public Out out = new Out();
	public void responce(){
		List<String> markers = marker.getMarkers();
		for(int i = 0; i< dataArray.length; i++){
			String mark = markers.get(i);
			String data = dataArray[i];
			if(mark.equals("n")){
				tree.getCurrent().add(new Sentence(data));
			}else if(mark.equals("o")){
				tree.getCurrent().addOperation(data);
			}else if(mark.equals("b")){
				responcer.responce();
			}
		}
	}
	private class RightBracketResponcer{
		MultiTree tree;
		Marker marker;
		public RightBracketResponcer(MultiTree _tree, Marker _marker){tree=_tree; marker = _marker;}
		public void responce(){

			List<Structurable> sentences = tree.getCurrent().getSentences();
			List<String> operations = tree.getCurrent().getOperations();
			List<String> markers = marker.markComplexity(tree.getCurrent().getSentences());

			for(int i=markers.size()-1; i>=0; i--){
				Structurable s = sentences.get(i);
				if(i==1){
					if(!markers.get(i).equals(markers.get(i-1))){
						//out.log("i=1");
						//out.log(markers);
						groupFromIndex(sentences, operations, i);
						break;
					}
				}else if(i>1){

					if(!markers.get(i).equals(markers.get(i-1))){
						//out.log("i>1");
						//out.log(markers);
						groupFromIndex(sentences, operations, i+1);
						break;
					}
				}
				if(i==0){
					//out.log("i=0");
					//out.log(markers);
					groupFromIndex(sentences, operations, i);
					break;
				}
			}
			markers=marker.markComplexity(tree.getCurrent().getSentences());
			//out.log(markers);
			//marker.logComplexity();
		}
		public void groupFromIndex(List<Structurable> sentences, List<String> operations, int index){
			Sentence sen = new Sentence();
			for(int j = index; j < sentences.size();j+=0){
				sen.add(sentences.get(index));
				sentences.remove(index);
				//out.log("sentences size is: " + sentences.size());
			}
			for(int j = index; j<operations.size();j+=0){
				sen.addOperation(operations.get(index));
				operations.remove(index);
			}
			tree.getCurrent().add(sen);
		}
	}
}
