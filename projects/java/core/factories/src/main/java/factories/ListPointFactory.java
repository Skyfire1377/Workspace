package factories;
import java.util.ArrayList;
import java.util.List;

import geom.Point;
public class ListPointFactory implements ListFactoryInterface<Point> {
	@Override
	public List<Point> create(int quantity){
		List<Point> lp = new ArrayList<>();
		double x;
		double y;
		for (int i = 0; i < quantity; i++){
			x = Math.random();
			y = Math.random();
			Point p = new Point(x, y);
			lp.add(p);
		}
		return lp;
	}
}
