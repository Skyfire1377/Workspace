package geom;

public class Point{
	private double x = 0;
	private double y = 0;
	public Point(){

	}
	public void setLocation(double _x, double _y){
		x = _x;
		y = _y;
	}
	public double getX(){
		return x;
	}	
	public double getY(){
		return y;
	}
	public void setX(double _x){
		x = _x;	
	}
	public void setY(double _y){
		y = _y;
	}
	public void greetings(){
		System.out.println("Hello from Point class");
	}
	public static double distance(Point a, Point b){
		return Math.sqrt(Math.pow(b.getX()-a.getX(), 2) + Math.pow(b.getY()-a.getY(), 2));
	}
	public Point(double _x, double _y){
		x = _x;
		y = _y;
	}
}
