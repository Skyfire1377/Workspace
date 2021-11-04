package pointsLessDistance;

import java.util.List;
import geom.Point;

public class PointsNearestDistanceFinder{

	public double findNearest(List<Point> list){
		double nearestDistance = Point.distance(list.get(0), list.get(1));
		for(int i = 0; i < list.size(); i++){
			Point aPoint = list.get(i);	
			for(int j = i+1; j<list.size(); j++){
				Point bPoint = list.get(j);
				double currentDistance = Point.distance(bPoint, aPoint);
				if(currentDistance<nearestDistance){
					nearestDistance = currentDistance;
					
				}
			}	
		}
		return nearestDistance;
	}
}
