package resourcesCreator;

import generators.RandomGenerator;
import utils.Out;

public class FilesWithRandomDoublesCreator{
	public void create(){
		RandomGenerator rg = new RandomGenerator();
		String readString = rg.getRandomDoublesString(1000, 10.0, " ");
		Out out = new Out();
		out.toFile("../resources/randomDoubles.md", readString);

	}
}
