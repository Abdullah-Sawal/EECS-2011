package model;

import tests.Node;

public class ListUtilities<E>{


	public Node<String> getNodeAt(Node<String> head, int i){

		int index = 0;

		int size = getSize(head);

		Node<String> current = head;

		while( index < i  && i<size) {

			index ++;

			current = current.getNext();


		}

		return current;


	}


	public int getSize(Node<String> head) {

		Node<String> current = head;

		int size = 0;

		while(current != null) {

			size ++;

			current = current.getNext();
		}

		return size;
	}


	public Node<String> task(Node<String> n, String remove) {


		int size = getSize(n);


		for (int i=0; i<size; i++) {

			Node<String> check = null;

			check = getNodeAt(n,i);			

			if (check.getElement().equals(remove)) {

				if (i == 0) {

					n = n.getNext();

				}

				else {	

					Node<String> before = getNodeAt(n,i-1);

					before.setNext(check.getNext());

					check.setNext(null);

				}
			}
		}


		return n;
	}




}
