package model;
import tests.Node;
public class ListUtilities<E> {

	public Node<E> reverseOf(Node<E> n){

		Node<E> current = n;
		Node<E> next = null;
		Node<E> prev = null;
		
		Node<E> result = null;


		while ( current != null) {


			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;

		}
		
		result = copyOf(prev);

		return result;

	}

	public Node<E> copyOf(Node<E> n){

		Node<E> current = new Node<>(null,null);
		Node<E> head = null;
		
		Node<E> input = n;

		int counter = 0;

		while (n != null) {

			counter ++;

			current.setElement(n.getElement());
			current.setNext(new Node<>(null,null));

			if (counter == 1 ) {

				head = current;
			}
			current = current.getNext();
			n = n.getNext();

		}
		
		if (input != null) {
		
		getBeforeTail(head).setNext(null);
		
		}
		return head;


	}
	
	public Node<E> getBeforeTail(Node<E> head){
		
		Node<E> current = head;
		
		Node<E> tail = null;
		
		while (current.getNext() != null) {
			
			tail = current;
			
			current = current.getNext();
			
			
		}
		
		return tail;
	}
	
	
	public Node<E> removeNthFromEnd(Node<E> n, int index){
		
		int size = getSize(n);
		
		if (index == size) {
			
			n = n.getNext();
			
			
		}
		
		else {
		
		Node<E> before = getNode(n,size-index-1);
		
		Node<E> remove = getNode(n,size-index);
		
		before.setNext(remove.getNext());
		
		}
		
		return n;
		
		
		
		
	}
	
	
	public int getSize(Node<E> head) {
		
		Node<E> current = head;
		
		int size = 0;
		
		while(current != null) {
			
			size ++;
			
			current = current.getNext();
		}
			
			return size;
		
		
	}
	
	
	public Node<E> getNode(Node<E> head, int i){
		
		int index = 0;
		
		Node<E> current = head;
		
		while( index < i) {
			
			index ++;
			
			current = current.getNext();
			
			
		}
		
		return current;
	
		
	}



}
