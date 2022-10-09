package resourcesCreator;
import java.util.List;
import java.util.stream.Collectors;

import generators.RandomIntListGenerator;
import interfaces.ObservableCustomInterface;
import interfaces.ObserverInterface;
import utils.StringBuilder;
import utils.Out;
import utils.Timer;
public class FileSetRandomInt implements ObserverInterface{
	Out out;
	int N;
	RandomIntListGenerator rilg;
	Timer timer = new Timer();
	StringBuilder sb;
	public FileSetRandomInt(){
		out = new Out();
		N=200;
		sb = new StringBuilder();
		sb.subscribe(this);
		rilg  = new RandomIntListGenerator(10000000, N);
		rilg.subscribe(this);
		timer.start();
		rilg.generateSet();
	}
	public void notififyEvent(String event, Object[] ob){
		if(event=="arrived N"){
			ObservableCustomInterface o = ob[0];
			List<Integer> data = o.getList();
			//String intString = sb.byInts(data, 0, " ");
			String intString=data.stream().map(Object::toString).collect(Collectors.joining(" "));
			int N = ob[1];
			out.toFile("../resources/timeTest/"+N+".md", intString);
			timer.stop();
			out.println("File created:"+N+".md, time: "+timer.result());
			timer.start();
		}else if(event=="next part"){
			int perc = 50+5*ob[0];
			out.println("processed: "+perc);
		}else if(event=="string generating"){
			out.println("generated: " + ob[0]*10 + " %");
		}
	}
}
