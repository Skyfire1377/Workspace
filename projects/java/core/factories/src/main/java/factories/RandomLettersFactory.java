package factories;

import java.util.List;
import generators.RandomGenerator;
import utils.Out;
import utils.StringBuilder;
public class RandomLettersFactory{
	private Out out = new Out();
	public String generate(int quantity){
		ListStringFactory sf = new ListStringFactory();
		List<String> list = sf.create(quantity);
		StringBuilder sb = new StringBuilder();
		String resultString = sb.byStrings(list, 28, "");
		return resultString;
	}
}
