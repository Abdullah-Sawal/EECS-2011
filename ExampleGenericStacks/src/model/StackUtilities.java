package model;

public class StackUtilities {

	public static <E> void reverse(E[] a) { 
		Stack<E> buffer = new ArrayStack<>(); 
		for (int i = 0; i < a.length; i ++) {
			buffer.push(a[i]);
		}
		for (int i = 0; i < a.length; i ++) {
			a[i] = buffer.pop();
		}
	}

	public static boolean isMatched(String expression) { 
		final String opening = "([{"; 
		final String closing = ")]}"; 
		Stack<Character> openings = new ArrayStack<Character>();
		int i = 0; 
		boolean foundError = false;
		while (!foundError && i < expression.length()) {
			char c = expression.charAt(i);
			if(opening.indexOf(c) != -1) { openings.push(c); }
			else if (closing.indexOf(c) != -1) { 
				if(openings.isEmpty()) { foundError = true; }
				else { 
					if (opening.indexOf(openings.top()) == closing.indexOf(c)) { 
						openings.pop(); 
					}
					else { foundError = true; } 
				} 
			} 
			i ++; 
		}
		return !foundError && openings.isEmpty(); 
	}
}
