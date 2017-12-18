/**
 * LinkedListADT.java
 * interface for NodeChains.java
 * @author clarence
 * @param <E>
 */

public interface LinkedListADT<T> {
    
    /** add a new item to the list **/
    void add(T item);
    
    /** add an item at position p **/
    void add(T item, int pos);
    
    /** check if the list contains item T **/
    boolean contains(T item);
	
    /** get the number of items in the list **/
    int size();
	
    /** check if the list is empty **/
    boolean isEmpty();
	
    /** get the item at position pos **/
    T get(int pos);
	
    /** remove an item at position pos **/
    T remove(int pos);
    
}
