package resourcesCreator;
import utils.Out;
import utils.In;
import utils.StringModeficator;
import factories.RandomLettersFactory;
public class FilesWithRandomLettersCreator{
	public void create(){
		RandomLettersFactory rlf = new RandomLettersFactory();
		String resultString = rlf.generate(10000);
		Out out = new Out();
		out.toFile("../resources/randomLetters.md", resultString);
	}
	public void shift(){
		In in = new In();
		String readString = in.fromFile("../resources/randomLetters.md");
		StringModeficator sm = new StringModeficator();
		String shiftedString = sm.shiftString(readString);
		Out out = new Out();
		out.toFile("../resources/randomLettersShifted.md", shiftedString);

	}
}
