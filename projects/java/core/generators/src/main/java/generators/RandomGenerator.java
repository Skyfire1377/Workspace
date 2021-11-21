package generators;
public class RandomGenerator{

	public char getRandomChar(){
		int random = (int)(Math.random()*52);
		char base = (random < 26) ? 'A':'a';
		char letter = (char)(base + random % 26);
		return letter;

	}
}
