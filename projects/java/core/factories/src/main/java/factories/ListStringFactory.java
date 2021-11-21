package factories;

import java.util.ArrayList;
import java.util.List;
import generators.RandomGenerator;
public class ListStringFactory implements ListFactoryInterface<String>{

	public List<String> create(int quantity){
		List<String> list = new ArrayList<>();
		RandomGenerator rg = new RandomGenerator();
		String resultString = "";
		for(int i =0; i<quantity; i++){
			Character c = rg.getRandomChar();
			list.add(c.toString());
		}
		return list;
	}
}
