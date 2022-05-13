package tests;
import static org.junit.Assert.*;

import org.junit.Test;

import model.ArrayStack;
import model.LinkedStack;
import model.Stack;

@SuppressWarnings("unused")
public class TestStacks {
	
	@Test
	public void testArrayStack() {
		ArrayStack<String> s = new ArrayStack<>();
		assertTrue(s.size() == 0 && s.isEmpty());
		
		try {
			String top = s.top();
			fail("Empty stack should have caused an exception.");
		}
		catch(IllegalArgumentException e) { }
		
		s.push("Alan");
		s.push("Mark");
		s.push("Tom");
		assertTrue(s.size() == 3 && !s.isEmpty());
		assertEquals("Tom", s.top());
		
		String oldTop = s.pop();
		assertEquals("Tom", oldTop);
		String newTop = s.top();
		assertEquals("Mark", newTop);
		
		oldTop = s.pop();
		assertEquals("Mark", oldTop);
		newTop = s.top();
		assertEquals("Alan", newTop);
	}

	@Test
	public void testPolymorphicStacks() {
		Stack<String> s = new ArrayStack<>(); 
		s.push("Alan"); /* dynamic binding */
		s.push("Mark"); /* dynamic binding */
		s.push("Tom"); /* dynamic binding */
		assertTrue(s.size() == 3 && !s.isEmpty()); 
		assertEquals("Tom", s.top()); 

		s = new LinkedStack<>(); 
		s.push("Alan"); /* dynamic binding */ 
		s.push("Mark"); /* dynamic binding */ 
		s.push("Tom"); /* dynamic binding */ 
		assertTrue(s.size() == 3 && !s.isEmpty()); 
		assertEquals("Tom", s.top()); 
	}

}
