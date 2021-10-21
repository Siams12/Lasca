import java.util.ArrayList;
import java.util.List;
public interface Queue<T>
{
    void add (T item);
	// Remove front item, if queue is empty return null
    T remove ();
    boolean isEmpty ();
    T Peek();
    List<T> peekAll();
}