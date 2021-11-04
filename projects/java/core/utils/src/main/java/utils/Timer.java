package utils;
public class Timer{
	private long startTime;
	private long endTime;
	public void start(){
		startTime = System.currentTimeMillis();
	}
	public void end(){
		endTime = System.currentTimeMillis();
	}
	public long result(){
		return endTime - startTime;
	}
	public String toString(){
		return "Time is: " + String.valueOf((double)(result())/1000) + " seconds";
	}
}	
