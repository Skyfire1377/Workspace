package timeTester;
import java.util.List;
import searchers.*;
import utils.In;
import utils.Out;
import utils.Timer;
import interfaces.*;
class TimeTesterDoubleSize implements ObserverInterface{
	In in = new In();
	Out out = new Out();
	int N = 200;
	Timer timer = new Timer();
	void test(){
		boolean firstLoop = true;
		long previousTime=0;	
		double ratio;

		SumThreeFaster st = new SumThreeFaster();
		st.subscribe(this);
		out.println(st.name);
		while(true){
			List<Integer> list = in.getListOfInteger("../resources/timeTest/"+N+".md");

			timer.start();
			long count = st.count(list);
			timer.stop();
			if(firstLoop){ratio = 0;firstLoop=false;}else{ratio = (double)timer.result()/(double)previousTime;};
			Object[] ob = {"N =", N, ", Time =", timer.result(), ", Count =", count, ", \n","Ratio =", String.format("%.3f", ratio)};
			out.printArray(ob);

			N*=2;
			previousTime = timer.result();
		}
	}
	public void notififyEvent(String e, Object[] ob){
		if(e=="arrived next"){
			int outerPart = (int)ob[0];
			int p=outerPart*10;
			out.println("testing: "+p+"%, time: "+timer.currentTime());
		}
	}
}
