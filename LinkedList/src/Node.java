/**
 * Node.java
 * used for NodeChains.java (singly LinkedList)
 * @author clarence
 * @param T
 */


public class Node<T> {

    /** fields **/
    private T data;
    private Node<T> next;
	
	/** constructors **/
	public Node(T obj) {
		this(obj, null);
	}
    
    public Node(T obj, Node<T> ptr) {
        data = obj;
        next = ptr;
    }
	
    /*** methods ***/
    
	/**modify/set data **/
    public void setData(T obj) { data = obj; }
	
	/** get data **/
    public T getData() { return data; }
	
	/** set next node **/
    public void setNext(Node<T> n) { next = n; }
	
    /** get next node **/
    public Node<T> getNext() { return next; }
	
}
