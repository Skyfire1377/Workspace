package factories;


import geom.Interval2D;
import geom.Interval1D;

public class Interval2DFactory{

	public Interval1DFactory ic = new Interval1DFactory();
	public Interval2D create(double min1, double max1, double min2, double max2){
		Interval1D i1 = ic.create(min1, max1);
		Interval1D i2 = ic.create(min2, max2);
		return new Interval2D(i1, i2);
	}

}
