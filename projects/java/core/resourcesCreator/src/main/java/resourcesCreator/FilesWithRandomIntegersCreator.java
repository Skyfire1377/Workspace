package resourcesCreator;
import generators.RandomGenerator;
import utils.Out;
public class FilesWithRandomIntegersCreator{
	public void create(){
		RandomGenerator rg = new RandomGenerator();
		String readString = rg.getRandomIntegersString(100000, 100000, " ");
		Out out = new Out();
		out.toFile("../resources/randomIntegers.md", readString);
	}
}
