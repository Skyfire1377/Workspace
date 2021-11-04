package factories;

import java.util.List;
import java.util.ArrayList;
import geom.Interval1D;

public class ListInterval1DFactory implements ListFactoryInterface<Interval1D>{
	@Override
	public List<Interval1D> create(int quantity){
		List<Interval1D> list = new ArrayList<>();
		Interval1DFactory ic = new Interval1DFactory();
		for(int i = 0; i<quantity;i++){
			Interval1D inv = ic.create(0.0, 1.0);
			list.add(inv);
		}
		return list;
	}
}
