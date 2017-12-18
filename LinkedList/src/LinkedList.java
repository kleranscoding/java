/**
 * LinkedList.java
 * a simple singly LinkedList implementation
 * @author clarence
 */

import java.util.*;

public class LinkedList<T> implements LinkedListADT<T> {

    /** fields **/
    private Node<T> head, tail;
    private int numItems;
	
    /** constructor **/
    public LinkedList() {
        head= new Node<T>(null);
        tail= head;
        numItems= 0;
	}
	
    /** methods **/
	
    /** check if LinkedList isEmpty **/
    public boolean isEmpty() { return numItems== 0; }
	
    /** add an item at the end of tail **/
    public void add(T item) {
		Node<T> newNode= new Node<T>(item, tail.getNext());
		tail.setNext(newNode);
		tail= tail.getNext();
		numItems++;
    }
	
	/** add an item at a given position **/
    public void add(T item, int pos) { 
        if (pos < 0 || pos > numItems) throw new IndexOutOfBoundsException();
        if (pos== numItems) { add(item); return; }
        Node<T> tmp= traverseTo(pos);
        tmp.setNext(new Node<T>(item, tmp.getNext()));
        numItems++;
    }
	
    /** get number of items in LinkedList **/
    public int size() { return numItems; }
	
    /** remove an item at a given position **/
    public T remove(int pos) {
        if (pos < 0 || pos >= numItems) throw new IndexOutOfBoundsException();
        Node<T> toRemove = traverseTo(pos);
        Node<T> tmp = toRemove.getNext();
        toRemove.setNext(tmp.getNext());
        if (pos== numItems-1) tail= toRemove;
        numItems--;
        return tmp.getData();
    }
	
    /** get data at a given position **/
    public T get(int pos) {
        if (pos < 0 || pos >= numItems) throw new IndexOutOfBoundsException();
        Node<T> node= traverseTo(pos);
        Node<T> toGet= node.getNext();
        return toGet.getData();
    }
	
    /** get node at a given position **/
    public Node<T> getNode(int pos) {
        if (pos < 0 || pos >= numItems) throw new IndexOutOfBoundsException();
        Node<T> node= traverseTo(pos);
        Node<T> toGet= node.getNext();
        return toGet;
    }
	
    /** if list contains an item **/
    public boolean contains(T item) {
        Node<T> tmp= head.getNext();
        while (tmp != null) {
            if (tmp.getData().equals(item)) return true;
            tmp= tmp.getNext();
        }
        return false;
    }
	
    /** private method that traverses to specific position **/
    private Node<T> traverseTo(int pos) {
        if (pos < 0 || pos >= numItems) throw new IndexOutOfBoundsException();
        Node<T> tmp= head;
        for (int i= 0; i< pos; i++) { tmp = tmp.getNext(); }
        return tmp;
    }
	
    /** additional method to facilitate debugging **/
    public void print() {
        Node<T> tmp= head.getNext();
        while (tmp != null) {
            System.out.print(tmp.getData()+", ");
            tmp= tmp.getNext();
        }
        System.out.println();
    }

    /** pairwise swap nodes **/
    public void pairSwap() {
        if (head==null || head.getNext()==null || head.getNext().getNext()==null) return;
        Node<T> prev= head.getNext();
        Node<T> cur= head.getNext().getNext();
        Node<T> back= head;
        
        while (prev!=null) {
            cur= prev.getNext();
            if (cur==null) return;
            Node<T> next= cur.getNext();
            
            back.setNext(cur);
            cur.setNext(prev);
            prev.setNext(next);
            back= prev;
            prev= next;
        }
        tail= back;
    }

}
