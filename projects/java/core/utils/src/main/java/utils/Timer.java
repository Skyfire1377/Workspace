package utils;
public class Timer{
	private long startTime;
	private long endTime;
	public void start(){
		startTime = System.currentTimeMillis();
	}
	public void stop(){
		endTime = System.currentTimeMillis();
	}
	public long currentTime(){
		return System.currentTimeMillis()-startTime;
	}
	public long result(){
		return endTime - startTime;
	}
	public String toString(){
		String res = String.valueOf((double)result());
		return res;
	}
}	
