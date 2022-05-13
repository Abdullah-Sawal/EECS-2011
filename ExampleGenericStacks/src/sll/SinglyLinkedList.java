package sll;

@SuppressWarnings("unused")
public class SinglyLinkedList<E> {
	private Node<E> head;
	private Node<E> tail;
	private int size;

	public void addFirst (E e) { 
		head = new Node<E>(e, head); 
		if (size == 0) { 
			tail = head; 
		} 
		size ++;
	}
	
	public void removeFirst () { 
		if (size == 1) { 
			head = null;
			tail = null;
		} 
		else {
			Node<E> second = head.getNext();
			head.setNext(null);
			head = second;
		}
		size --;
	}
	
	public E getFirst() {
		if(size() == 0) {
			throw new IllegalArgumentException("Empty list");
		}
		else {
			return head.getElement();
		}
	}

	public Node<E> getNodeAt (int i) { 
		if (i < 0 || i >= size) { 
			throw new IllegalArgumentException("Invalid Index"); } 
		else {
			int index = 0; 
			Node<E> current = head; 
			while (index < i) { 
				index ++;  
				current = current.getNext(); 
			} 
			return current; 
		} 
	}
	
	public int size() {
		return size;
	}
}