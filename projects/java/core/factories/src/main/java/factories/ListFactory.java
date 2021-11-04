package factories;

import java.util.ArrayList;
import java.util.List;

//import java.lang.reflect.ParameterizedType;

public class ListFactory<T>{
	private Class<T> t;
	public ListFactory(Class<T> type){
		this.t = type;
		//t = ((Class)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
	}
	public Class<T> get(){
		return t;
	}
	public  List<T> create(int quantity){
		List<T> list = new ArrayList<>();
		try{
			for(int i =0; i<quantity; i++){

				T instance = t.newInstance();
				list.add(instance);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return list;
		//List<T> list = new ArrayList<>();
		//double x = 0;
		//double y = 0;
		//for(int i = 0; i < quantity; i++){
			//T t = 
			//list.add(p);
	}
		//return list;
	//}
}
