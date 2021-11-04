package pointsLessDistance;
import geom.Point;
import java.util.ArrayList;
import java.util.List;
import utils.ListInitilizerPoints;

public class PointsLessDistance{

	private PointsNearestDistanceFinder pf = new PointsNearestDistanceFinder();
	public static void main(String[] args){
	
		ListInitilizerPoints li = new ListInitilizerPoints();
		List<Point> list = li.generate(100);
		PointsNearestDistanceFinder pf = new PointsNearestDistanceFinder();
		double result = pf.findNearest(list);
		System.out.println(result);
	}
	public void findNearest(){


	}
}
