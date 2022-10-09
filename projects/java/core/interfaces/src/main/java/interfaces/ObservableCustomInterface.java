package interfaces;

import java.util.List;

public interface ObservableCustomInterface{
	void subscribe(ObserverInterface o);
	List<Integer> getList();
}

