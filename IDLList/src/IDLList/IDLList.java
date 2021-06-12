package IDLList;

import java.util.ArrayList;

public class IDLList<E> {
	
		// This declares the inner class Node<E>
		private static class Node<E>{
		
		// These are the data fields of the private inner class Node<E>
		E data;
		Node<E> next;
		Node<E> prev;
		
		// A constructor that creates a node, also holding elem
		Node(E elem){
			this.data = elem;
		}
		
		// A constructor that creates a node holding elem. We have next as next, and prev as prev
		Node(E elem, Node<E> prev, Node<E> next){
			this.data = elem;
			this.prev = prev;
			this.next = next;
		}
		}
		
		// The class IDLList<E> includes the declaration of the inner private class Node<E>
		// 4 data fields are also created
		private Node<E> head;
		private Node<E> tail;
		private int size;
		private ArrayList<Node<E>> indices;

	
	// Creates a doubly-linked list that is empty
	public IDLList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
		this.indices = new ArrayList<Node<E>>();
	}
	
	// Here we add elem at position, index
	public boolean add(int index, E elem) throws IndexOutOfBoundsException {
		if(index<0 || index > size)
			throw new IndexOutOfBoundsException();
		if(index==0) 
			add(elem);
		else if(index == size)
			append(elem);
		else {
			Node<E> i = indices.get(index);
			Node<E> newnode = new Node<E>(elem,i.prev,i);
			i.prev.next = newnode;
			i.prev = newnode;
			indices.add(index,newnode);
			size++;			
		}
		return true;
			
	}

	// Add elem at head, and it becomes the first element in the list
	public boolean add(E elem) {
		if(size == 0) {
			Node<E> newnode = new Node<E>(elem);
			head = newnode;
			tail = newnode;
			indices.add(newnode);
		}
		else {
			Node<E> newnode = new Node<E>(elem, null, head);
			head.prev = newnode;
			head = newnode;
			indices.add(0, newnode);
		}
		size++;
		return true;
	}
	
	// Add elem as the "new" last element of the list, or at tail
	public boolean append(E elem) {
		if(size == 0) {
			Node<E> newnode = new Node<E>(elem);
			head = newnode;
			tail = newnode;
			indices.add(newnode);
		}
		else {
			Node<E> newnode = new Node<E>(elem,tail,null);
			tail.next = newnode;
			tail = newnode;
			indices.add(newnode);
		}
		size++;
		return true;
	}
	
	// Returns the object at position, index from the head
	// get(0) will return the head element in the list, as index starts at 0.
	public E get(int index) {
		return indices.get(index).data;
	}
	
	// Returns the object at the head
	
	public E getHead() {
		return head.data;
	}
	
	// Returns the object at the tail
	
	public E getLast() {
		return tail.data;
	}
	
	// Will return the size of the list
    public int size() {
    	return indices.size();
    }
    
    // Removes and returns the element located at the head
    
    public E remove() throws IndexOutOfBoundsException {
    	E elermv;
    	if(size ==0)
    		throw new IndexOutOfBoundsException("Empty list can't be removed!"); 
    	else if(size ==1) {
    		elermv = head.data;
			head = null;
			tail = null;
		}
		else {
			elermv = head.data;
			head.next.prev = null;
			head = head.next;
		}
		indices.remove(0);
		size--;
		return elermv;	
    }
    
    // Removes and returns the element located at the tail
	public E removeLast() throws IndexOutOfBoundsException{
		E elermvlst;
		if(size == 0)
			throw new IndexOutOfBoundsException("Empty list can't be removed!");
		else if(size == 1) {
			elermvlst = tail.data;
			head = null;
			tail = null;
		}
		else {
			elermvlst = tail.data;
			tail.prev.next = null;
			tail = tail.prev;
		}
		indices.remove(size - 1);
		size--;
		return elermvlst;
	}
	
	// Removes and returns the element at the index, index
	
	public E removeAt(int index) throws IndexOutOfBoundsException{
		E elemrmvAt;
		if(index < 0 || index >= size) 
			throw new IndexOutOfBoundsException();
		if(size == 1) {
			elemrmvAt = head.data;
			head = null;
			tail = null;
		}
		else if(index == 0) {
			elemrmvAt = head.data;
			head.next.prev = null;
			head = head.next;
		}
		
		else if(index == size - 1) {
			elemrmvAt = tail.data;
			tail.prev.next = null;
			tail = tail.prev;
		}
		else {
			Node<E> i = indices.get(index);
			elemrmvAt = i.data;
			i.prev.next = i.next;
			i.next.prev = i.prev;
		}
		indices.remove(index);
		size--;
		return elemrmvAt;	
	}
	
	// Removes the first occurrence of elem in the list, will return true if elem is found. 
	// Will return false if elem is not found in the list
	
	public boolean remove(E elem) {
		for (int i = 0; i < indices.size(); i++) {
			if(indices.get(i).data==elem) {
				removeAt(i);
				return true;
				}
			}
			return false;
	}
	
	// This presents the list in the String format
	
	public String toString() {
		String str = "";
		for(int i = 0; i < size; i++) {
			if(i != size - 1) 
				str = str + (indices.get(i).data + ", ");
			else
				str = str + (indices.get(i).data);
		}
		str += "";
		return str;
	}
	
	


		
	}
