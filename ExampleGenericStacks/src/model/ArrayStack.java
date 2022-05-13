package model;
public class ArrayStack<E> implements Stack<E> { 
	private final int MAX_CAPACITY = 1000; 
	private E[] data; 
	private int t; /* index of top */ 
	
	@SuppressWarnings("unchecked")
	public ArrayStack() {
		data = (E[]) new Object[MAX_CAPACITY]; 
		t = -1; 
	} 
	
	public int size() { 
		return (t + 1); 
	} 
	
	public boolean isEmpty() { 
		return (t == -1); 
	} 
	
	public E top() {
		if (isEmpty()) { /* precondition: non-empty stack */
			throw new IllegalArgumentException("Empty Stack");
		}
		else { 
			return data[t]; 
		} 
	}  
	
	public void push(E e) {
		if (size() == MAX_CAPACITY) { /* precondition: non-full stack */
			throw new IllegalArgumentException("Full Stack");
		}
		else { 
			t ++; 
			data[t] = e; 
		} 
	} 
	
	public E pop() {
		if (isEmpty()) { /* precondition: non-empty stack */
			throw new IllegalArgumentException("Empty Stack");
		}
		else { 
			E result;
			result = data[t]; 
			data[t] = null; 
			t --;
			return result;
		}
	}
}