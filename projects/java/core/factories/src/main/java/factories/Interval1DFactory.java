package factories;

import geom.Interval1D;

public class Interval1DFactory{
	public Interval1D create(double min, double max){

		double l = min + Math.random()*(max - min);
		double r = l+(max - l)*Math.random();
		return new Interval1D(l, r);
	}

}
