package tests;
import static org.junit.Assert.*;

import org.junit.Test;

import model.*;

public class TestStackApplications {	
	
	@Test
	public void testReverseViaStack() {
		String[] names = {"Alan", "Mark", "Tom"};
		String[] expectedReverseOfNames = {"Tom", "Mark", "Alan"}; 
		StackUtilities.reverse(names);
		assertArrayEquals(expectedReverseOfNames, names);
		
		Integer[] numbers = {46, 23, 68};
		Integer[] expectedReverseOfNumbers= {68, 23, 46};
		StackUtilities.reverse(numbers);
		assertArrayEquals(expectedReverseOfNumbers, numbers);
	}
	
	@Test
	public void testMatchingDelimiters() {
		assertTrue(StackUtilities.isMatched(""));
		assertTrue(StackUtilities.isMatched("{[()]}"));
		assertTrue(StackUtilities.isMatched("{[()]}({[]})"));
		
		assertFalse(StackUtilities.isMatched("{[]})"));
		assertFalse(StackUtilities.isMatched("[]}"));
		assertFalse(StackUtilities.isMatched("{[])"));
		assertFalse(StackUtilities.isMatched("{[]"));
		assertFalse(StackUtilities.isMatched("{()]}({[]})"));
		assertFalse(StackUtilities.isMatched("{[()}({[]})"));
		assertFalse(StackUtilities.isMatched("{[()]}([]})"));
		assertFalse(StackUtilities.isMatched("{[()]}({[])"));
		assertFalse(StackUtilities.isMatched("{[()]}({[]})]"));
	}
}
