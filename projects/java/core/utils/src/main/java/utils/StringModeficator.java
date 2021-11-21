package utils;
public class StringModeficator{
	public String shiftString(String s){
		int quantity = (int)(Math.random()*s.length());
		String shiftedFirstPart = s.substring(0, quantity);
		String shiftedSecondPart = s.substring(quantity, s.length());
		String resultString = shiftedSecondPart + shiftedFirstPart;
		return resultString;
	}
}
