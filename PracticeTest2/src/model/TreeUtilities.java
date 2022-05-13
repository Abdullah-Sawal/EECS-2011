package model;

import tests.SLLNode;
import tests.TreeNode;

public class TreeUtilities<E> {

	public TreeNode<String> copyOf(TreeNode<String> n) {

		TreeNode<String> root = new TreeNode<>(n.getElement()); 


		if (n.getChildren() != null) {


			SLLNode<TreeNode<String>> children = n.getChildren();

			while (children != null) {

				TreeNode<String> newChild = copyOf(children.getElement());
				root.addChild(newChild);
				newChild.setParent(root);
				children = children.getNext();

			}

		}

		return root;
	}

	public SLLNode<TreeNode<String>> getPreOrderSeq(TreeNode<String> root) {


		SLLNode<TreeNode<String>> head = new SLLNode<>(root,null);
		
		if (root.getChildren() != null) {
			
			SLLNode<TreeNode<String>> children = root.getChildren();
			
			while (children != null) {
				
				
				getTail(head).setNext((getPreOrderSeq(children.getElement())));
				
				children = children.getNext();
				
			}
			
		}
          return head;


	}

	public SLLNode<TreeNode<String>> getTail(SLLNode<TreeNode<String>>  head){

		SLLNode<TreeNode<String>>  current = head;

		SLLNode<TreeNode<String>>  tail = null;

		while (current != null) {

			tail = current;

			current = current.getNext();


		}

		return tail;
	}



}
