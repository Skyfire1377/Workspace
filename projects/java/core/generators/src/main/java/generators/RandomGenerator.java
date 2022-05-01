package generators;
public class RandomGenerator{

	public char getRandomChar(){
		int random = (int)(Math.random()*52);
		char base = (random < 26) ? 'A':'a';
		char letter = (char)(base + random % 26);
		return letter;

	}
	public String getRandomDoublesString(Integer quantity, Double range, String delimiter){
		String resultString="";
		for(int i =0; i<quantity-1; i++){
			double d = Math.random()*range;
			resultString += String.format("%.4f", d) + delimiter;
		}
		double d = Math.random()*range;
		resultString +=d;
		return resultString;
	}
	public String getRandomIntegersString(Integer quantity, Integer range, String delimiter){
		String resultString="";
		for(int i =0; i<quantity-1; i++){
			Integer d = (int)(Math.random()*range);
			resultString += d + delimiter;
		}
		Integer d = (int)(Math.random()*range);
		resultString +=d;
		return resultString;
	}
}
