package overlappingIntervals;

import java.util.List;
import utils.Out;
import factories.ListInterval2DFactory;
import geom.Interval2D;

class OverlappingIntervals2D{
	private Out out = new Out();
	public void initAndTest(){
	ListInterval2DFactory li = new ListInterval2DFactory();
	List<Interval2D> list = li.create(100);
	for(int i = 0;i<list.size(); i++){
		Interval2D inv = list.get(i);
		
		for(int j = i+1;j<list.size();j++){
			Interval2D inv2 = list.get(j);
			//if(Interval2D.intersect(inv, inv2)){

				if(Interval2D.contain(inv, inv2)){
					out.println("An interval contains an another: " + inv.toString() + " " + inv2.toString());
				}
			//}
		}	
		//Out out = new Out();
		//out.log("Hello");
	};
	}
}
