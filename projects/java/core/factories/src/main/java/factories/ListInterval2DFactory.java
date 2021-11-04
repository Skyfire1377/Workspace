package factories;

import java.util.ArrayList;
import java.util.List;

import geom.Interval2D;

public class ListInterval2DFactory implements ListFactoryInterface<Interval2D>{
	@Override
	public List<Interval2D> create(int quantity){
		List<Interval2D> list = new ArrayList<>();
		Interval2DFactory ic = new Interval2DFactory();
		for(int i = 0; i<quantity;i++){
			Interval2D inv = ic.create(0.0, 1.0, 0.0, 1.0);
			list.add(inv);
		}
		return list;
	}
}
