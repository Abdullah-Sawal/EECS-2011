package model;


import tests.SLLNode;
import tests.TreeNode;

public class TreeUtilities<E> {

	public TreeNode<E> task2(TreeNode<E> n) {
		
		TreeNode<E> root = new TreeNode<>(n.getElement());
		
		SLLNode<TreeNode<E>> reverse = null;
		
		if(n.getChildren() != null) {
			
			
			SLLNode<TreeNode<E>> children = n.getChildren();
			
			reverse = reverseOf(children);
			
			while(reverse != null) {
				
				TreeNode<E> child = task2(reverse.getElement());
				root.addChild(child);
				child.setParent(root);
				reverse = reverse.getNext();
					
			}	
		}
		
		
		
		return root;
	}
	
	
	public SLLNode<TreeNode<E>> reverseOf(SLLNode<TreeNode<E>> n){

		SLLNode<TreeNode<E>> current = n;
		SLLNode<TreeNode<E>>  next = null;
		SLLNode<TreeNode<E>> prev = null;
		
		SLLNode<TreeNode<E>> result = null;


		while ( current != null) {


			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;

		}

		return prev;

	}
	
	}
	
	
