package model;


import tests.SLLNode;
import tests.TreeNode;

public class TreeUtilities {
	
	 

	public SLLNode<Integer> getElementsOfRanks(TreeNode<Integer> root, int a, int b) {
		
		 SLLNode<Integer> head= new SLLNode<Integer>(null,null); 
		
		SLLNode<Integer>  newhead = new SLLNode<>(null,null);
		
		SLLNode<Integer>  current = newhead;
	 	
		head = getList(head,root);
		
		head = head.getNext();
		
		print(head);
		
		System.out.println("\n");
		
		orderList(head);
		
		print(head);
		
		
		for (int i=a; i<=b;i++ ) {
			
			current.setElement(getNode(head,i).getElement());
			current.setNext(new SLLNode<>(null,null));
			current = current.getNext();	
			
		
			
		}
		
		getBeforeTail(newhead).setNext(null);
		
		
		return newhead;
	}
	
	public void orderList(SLLNode<Integer> head){
		
		
		
		SLLNode<Integer> current = head;
		
		SLLNode<Integer> current2 = null;
		
		int temp;
		
		
		
		while (current != null) {
			
			current2 = current.getNext();
			
		     while (current2 != null ) {
		    	 
		    		if (current.getElement() > current2.getElement()) {
						
						temp = current.getElement();
						current.setElement(current2.getElement());;
						current2.setElement(temp);;
							
						
					}
		    		
		    		current2 = current2.getNext();
		    	 
		    	 
		     }
			
			
			current = current.getNext();
			
			
		}
	}
	
	
	public void print(SLLNode<Integer> head) {
		
		SLLNode<Integer> current = head;
		
		while ( current != null) {
			
		System.out.println(current.getElement());
			
			current = current.getNext();
			
		}
		
		
	}
	
	
	
	
	public SLLNode<Integer> getList(SLLNode<Integer> current,TreeNode<Integer> root){
		
		int size = 0;
	
		SLLNode<TreeNode<Integer>> children = new SLLNode<TreeNode<Integer>>(null,null);
		
		if (root == null) {
			
			return null;
			
		}
		
		else if (root.getChildren() == null) {
			
			getTail(current).setNext(new SLLNode<>(root.getElement(),null));
		}
		
		else {
			
			
			getTail(current).setNext(new SLLNode<>(root.getElement(),null));
			
			
			children = root.getChildren();
				
	        size  = getSize(children);
			
			int counter = 0;
			
			while (counter < size) {
				
				
				getList(current,children.getElement());
				children = children.getNext();
				
					counter ++;
		}
			
		}
	
		
		return current;
		
	}
	
	
public SLLNode<Integer> getNode(SLLNode<Integer> head, int i){
		
		int index = 1;
		
		SLLNode<Integer> current = head;
		
		while( index < i) {
			
			index ++;
			
			current = current.getNext();
			
			
		}
		
		return current;
	
		
	}
	
public SLLNode<Integer> getTail(SLLNode<Integer> head){
		
		SLLNode<Integer> current = head;
		
		SLLNode<Integer> tail = null;
		
		while (current != null) {
			
			tail = current;
			
			current = current.getNext();
			
			
		}
		
		return tail;
	}

public SLLNode<Integer> getBeforeTail(SLLNode<Integer> head){
	
	SLLNode<Integer> current = head;
	
	SLLNode<Integer> tail = null;
	
	while (current.getNext() != null) {
		
		tail = current;
		
		current = current.getNext();
		
		
	}
	
	return tail;
}

public int getSize(SLLNode<TreeNode<Integer>> children) {
	
	SLLNode<TreeNode<Integer>> current = children;
	
	int size = 0;
	
	while(current != null) {
		
		size ++;
		
		current = current.getNext();
	}
		
		return size;
	
	
}


	public TreeNode<String> getStats(TreeNode<Integer> n1) {
		
	TreeNode<Integer> rootOfSizes = getSizes(n1);
	TreeNode<Integer> rootOfSums = getSums(n1);
	return getStatsHelper(rootOfSizes,rootOfSums);
		
		
	}
	
	private TreeNode<Integer> getSums(TreeNode<Integer> n){
		
		TreeNode<Integer> result = new TreeNode<>(n.getElement());
		if (n.getChildren() != null){
			
			SLLNode<TreeNode<Integer>> currentChild = n.getChildren();
			
			while (currentChild != null) {
				
				TreeNode<Integer> sumOfChild = getSums(currentChild.getElement());
				result.setElement(result.getElement()+sumOfChild.getElement());
				result.addChild(sumOfChild);
				sumOfChild.setParent(result);
				currentChild = currentChild.getNext();
	
			}
		}
		
		return result;
		
	}
	
	private TreeNode<Integer> getSizes(TreeNode<Integer> n) {
		
		
		
		TreeNode<Integer> result = new TreeNode<Integer>(1);
		
		if(n.getChildren() != null) {
			
			SLLNode<TreeNode<Integer>> currentChild = n.getChildren();
			
			while (currentChild != null) {
				
				TreeNode<Integer> sumOfSize = getSizes(currentChild.getElement());
				result.setElement(result.getElement()+sumOfSize.getElement());
				result.addChild(sumOfSize);
				sumOfSize.setParent(result);
				currentChild = currentChild.getNext();
			}
			
		}
		
		return result;
		
	}
	
	private TreeNode<String> getStatsHelper(TreeNode<Integer> currentSize, TreeNode<Integer> currentSum){
		
		
		String stat = String.format("Number of descendants: %d; Sum of descendants: %d",currentSize.getElement(),currentSum.getElement());
		
		TreeNode<String> result = new TreeNode<>(stat);
		
		if(currentSize.getChildren() != null) {
			
			SLLNode<TreeNode<Integer>> currentSizeChild = currentSize.getChildren();
			SLLNode<TreeNode<Integer>> currentSumChild = currentSum.getChildren();
			
			while (currentSizeChild != null) {
				
				TreeNode<String> statOfChild = getStatsHelper(currentSizeChild.getElement(),currentSumChild.getElement());
				
				result.addChild(statOfChild);
				statOfChild.setParent(result);
				
				
				currentSizeChild = currentSizeChild.getNext();
				currentSumChild = currentSumChild.getNext();

	
			}
			
	
		}
		
		
             return result;		
		
	
	}
	
	

}
