package model;

import sll.SinglyLinkedList;

/*
 * Strategy 1: List head is treated as the top of stack.
 */

public class LinkedStack<E> implements Stack<E> {
	private SinglyLinkedList<E> data;
	
	public LinkedStack() {
		data = new SinglyLinkedList<>(); 
	} 
	
	public int size() { 
		return data.size(); 
	} 
	
	public boolean isEmpty() { 
		return size() == 0; 
	} 
	
	public E top() {
		if (isEmpty()) { 
			throw new IllegalArgumentException("Empty Stack"); 
		}
		else { 
			return data.getFirst(); 
		} 
	}
	
	public void push(E e) {
		data.addFirst(e); 
	}
	
	public E pop() {
		if (isEmpty()) { 
			throw new IllegalArgumentException("Empty Stack"); 
		}
		else { 
			E result;
			result = top(); 
			data.removeFirst();
			return result;
		}
	}
}