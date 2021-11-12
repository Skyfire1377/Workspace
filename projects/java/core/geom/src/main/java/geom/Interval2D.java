package geom;

public class Interval2D{
	private Interval1D horisontalInterval;
	private Interval1D verticalInterval;
	public Interval2D(Interval1D _horisontalInterval, Interval1D _verticalInterval){
		horisontalInterval = _horisontalInterval;
		verticalInterval = _verticalInterval;
	}
	public Interval1D getHorisontalInterval(){
		return horisontalInterval;
	}
	public Interval1D getVerticalInterval(){
		return verticalInterval;
	}
	public static boolean intersect(Interval2D iv1, Interval2D iv2){
		if (Interval1D.intersect(iv1.getHorisontalInterval(), iv2.getHorisontalInterval())||Interval1D.intersect(iv1.getVerticalInterval(), iv2.getVerticalInterval())){
			return true;
		}
		return false;
	}
	public static boolean contain(Interval2D iv1, Interval2D iv2){
		if(!Interval1D.contain(iv1.getHorisontalInterval(), iv2.getHorisontalInterval())||!Interval1D.contain(iv1.getVerticalInterval(), iv2.getVerticalInterval())){
			return false;
		}
		return true;

	}
	public String toString(){
		return "Horisontal: {" + getHorisontalInterval().getL() + " " + getHorisontalInterval().getR() + "}, Vertical: {" + getVerticalInterval().getL() + " " + getVerticalInterval().getR() + "} ";
	}
}
