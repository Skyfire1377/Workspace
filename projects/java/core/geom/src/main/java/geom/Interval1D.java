package geom;

public class Interval1D{
	private double l = 0;
	private double r = 0;
	public Interval1D(double _l, double _r){
		l = _l;
		r = _r;
	}
	public double getL(){
		return l;
	}
	public double getR(){
		return r;
	}
	public static boolean intersect(Interval1D a, Interval1D b){
		
		if((a.getL() > b.getR()) || (a.getR() < b.getL())){
			return false;
		}
		return true;
	}
	public static boolean containsInFirst(Interval1D a, Interval1D b){
		
		if((a.getL()<b.getL())&&(a.getR()>b.getR())){
			return true;
		}

		return false;
	}
	public static boolean contain(Interval1D a, Interval1D b){
		if(containsInFirst(a, b)||containsInFirst(b, a)){
			return true;
		}
		return false;
	}
	public String toString(){
		return "{"+ getL() +", "+ getR() +"} ";
	}
}
