package model;
import tests.Node;

public class ListUtilities {
	
	// comment.


	public Node<String> getAllPrefixes(Node<Integer> n , int a , int b ) {


		int x = b - a;

		Node<String> result = new Node<>(null,null);

		Node<String> current2 = new Node<>(null,null);


		int counter = a;


		for ( int i=0; i <= x; i++) {

			Node<Integer> current = n;

			String s = "";

			s += "[";
			for (int j =0; j<counter; j++) {

				s += current.getElement().toString();
				current = current.getNext();

				if (j < counter - 1) {

					s += ", ";

				}
			}



			counter ++;

			current2.setElement(s + "]");

			if (i == 0) {

				result = current2;

			}

			if (i < x) {
				current2.setNext(new Node<String>(null,null));
				current2 = current2.getNext();
			}

			else {
				current2.setNext(null);

			}



		}



		return result;

	}

	public Node<Integer> getMergedChain(Node<Integer> leftChain, Node<Integer> rightChain) {

		Node<Integer> current = null;
		Node<Integer> merged = null;

		while (leftChain != null || rightChain != null ) {

			Node<Integer> n = null;

			if (rightChain == null) {

				n = new Node<>(leftChain.getElement(),null);
				leftChain = leftChain.getNext();

			}

			else if (leftChain == null) {

				n = new Node<>(rightChain.getElement(),null);
				rightChain = rightChain.getNext();

			}

			else if (leftChain != null && rightChain != null) {

				if ( rightChain.getElement() < leftChain.getElement()) {


					n = new Node<>(rightChain.getElement(),null);
					rightChain = rightChain.getNext();
				}

				else {

					n = new Node<>(leftChain.getElement(),null);
					leftChain = leftChain.getNext();

				}
			}

			if ( merged == null) {

				merged = n;
				current = merged;


			}

			else {

				current.setNext(n);
				current = n;

			}

		}

		return merged;

	}

	public Node<Integer> getInterleavedArithmeticFibonacciSequences(int start, int diff, int size_a, int size_f){

		Node<Integer> current = new Node<>(null,null);

		Node<Integer> head = new Node<>(null,null);

		int x = size_a + size_f;

		int counter = 0;

		int sum = 0;

		int fib_num = 0;

		int fib_counter = 1;

		int Ari_counter = 0;

		if ( x == 0) {

			return null;
		}

		if (size_a == 0 && size_f != 0 ) {

			Node<Integer> special = new Node<>(null,null);

			if (size_f == 1) {

				fib_num = fibSeq(fib_counter);
				current.setElement(fib_num);
				current.setNext(null);

				return current;

			}

			for (int i =0; i < size_f; i++) {

				if (i < size_f -1) {
					fib_num = fibSeq(fib_counter);
					fib_counter ++;
					current.setElement(fib_num);

					if (i == 0) {

						special = current;

					}
					current.setNext(new Node<>(null,null));
					current = current.getNext();
				}

				else {

					fib_num = fibSeq(fib_counter);
					fib_counter ++;
					current.setElement(fib_num);
					current.setNext(null);
				}

			}
			return special;

		}

		for (int i = 0; i < x; i++) {

			if (counter % 2 != 0 && fib_counter <= size_f){

				fib_num = fibSeq(fib_counter);

				fib_counter ++;
				counter ++;

				current.setElement(fib_num);
				current.setNext(new Node<>(null,null));
				current = current.getNext();

			}

			else if (Ari_counter < size_a){

				if (i == 0 && i < x-1 ) {

					sum = start;
					current.setElement(sum);
					current.setNext(new Node<>(null,null));
					head = current;
					current = current.getNext();
					counter ++;
					Ari_counter ++;

				}
				else if ( i < x-1 && Ari_counter < size_a ){

					sum += diff;
					current.setElement(sum);
					current.setNext(new Node<>(null,null));
					current = current.getNext();
					counter ++;
					Ari_counter ++;

				}

				else if (Ari_counter < size_a){

					sum += diff;
					current.setElement(sum);
					current.setNext(null);
					Ari_counter ++;



				}

			}

			else if (i < x-1){

				fib_num = fibSeq(fib_counter);

				fib_counter ++;
				counter ++;

				current.setElement(fib_num);
				current.setNext(new Node<>(null,null));
				current = current.getNext();

			}

			else {

				fib_num = fibSeq(fib_counter);

				fib_counter ++;
				counter ++;

				current.setElement(fib_num);
				current.setNext(null);

			}

		}


		return head;

	}

	public int fibSeq(int n) {

		int result;

		if (n == 1) {  

			result = 1; 

		}
		else if (n == 2) { 

			result = 1;

		}

		else { 

			result = fibSeq (n - 1) + fibSeq (n - 2);
		}
		return result;
	}






	public Node<String> getGroupedStrings(Node<String> input, int m, int n){

		Node<String> current = new Node<>(null,null);

		Node<String> current2 = new Node<>(null,null);

		Node<String> current3 = new Node<>(null,null);

		Node<String> current_in = input;

		Node<String> head = new Node<>(null,null);

		Node<String> mid_head = new Node<>(null,null);

		Node<String> end_head = new Node<>(null,null);

		int count = 0;
		int count2 = 0;
		int count3 = 0;

		if (input == null) {

			return null;

		}

		while (current_in != null) {



			if (current_in.getElement().length() < m) {

				count ++;

				current.setElement(current_in.getElement());
				current.setNext(new Node<>(null,null));

				if (count == 1) {
					head = current;
				}

				current = current.getNext();
				current_in = current_in.getNext();



			}

			else if (current_in.getElement().length() >= m && current_in.getElement().length() < n) {

				count2 ++;
				current2.setElement(current_in.getElement());
				current2.setNext(new Node<>(null,null));

				if (count2 == 1) {

					mid_head = current2;
				}

				current2 = current2.getNext();
				current_in = current_in.getNext();


			}

			else if (current_in.getElement().length() >= n) {

				count3 ++;

				current3.setElement(current_in.getElement());
				current3.setNext(new Node<>(null,null));

				if (count3 == 1) {

					end_head = current3;
				}

				current3 = current3.getNext();
				current_in = current_in.getNext();




			}

		}

		getTail(head).setNext(mid_head);

		System.out.println(getTail(head).getElement());
		getTail(mid_head).setNext(end_head);
		getTail(end_head).setNext(null);


		return head;
	}	

	public Node<String> getTail(Node<String> head){

		Node<String> current = head;

		Node<String> tail = null;

		while (current.getNext() != null) {

			tail = current;
			current = current.getNext();
		}

		return tail;
	}

}








