package overlappingIntervals;

import java.util.List;

import factories.ListInterval1DFactory;
import geom.Interval1D;

class OverlappingIntervals1D{
	public void initAndTest(){

	ListInterval1DFactory li = new ListInterval1DFactory();
	List<Interval1D> list = li.create(100);
	for(int i = 0;i<list.size(); i++){
		Interval1D inv = list.get(i);
		
		for(int j = i;j<list.size();j++){
			Interval1D inv2 = list.get(j);
			if(Interval1D.intersect(inv, inv2)){
				System.out.println(i + " " + inv.toString() + " " + j + " " + inv2.toString());
			}
		}	
		//Out out = new Out();
		//out.log("Hello");
	};
	}
}
