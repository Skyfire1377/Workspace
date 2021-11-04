package factories;
import java.util.List;
import geom.Point;
public interface ListFactoryInterface<T>{
	List<T> create(int q);
}
