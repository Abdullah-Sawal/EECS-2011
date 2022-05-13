package model;

import tests.Expression;
import tests.Operand;
import tests.Operator;
import tests.SLLNode;
import tests.TreeNode;

public class TreeUtilities {

	private SLLNode<String> data = new SLLNode<>(null,null);
	private SLLNode<Expression> exp = new SLLNode<>(null,null);


	public TreeNode<Expression> getInfixTree(SLLNode<Expression> expression) {

		TreeNode<Expression> root = new TreeNode<>(null);
		

		int size = getSize(expression);

		for (int i=0;i<size;i++) {

			if (size == 1 ) {

				root.setElement(expression.getElement());


			}
			else if (expression.getElement() instanceof Operand){

				pushExp(expression.getElement());
				expression = expression.getNext();


			}
			else {

				if (i > 2) {

					TreeNode<Expression> head = new TreeNode<>(expression.getElement());
					root.setParent(head);
					head.addChild(root);
					root = head;
					
					TreeNode<Expression> rightChild = new TreeNode<>(popExp());
					
					root.addChild(rightChild);
					rightChild.setParent(root);
					
					expression = expression.getNext();

				}
				
				else {
				root.setElement(expression.getElement());


				TreeNode<Expression> rightChild = new TreeNode<>(popExp());
				TreeNode<Expression> leftChild = new TreeNode<>(popExp());

				root.addChild(leftChild);
				root.addChild(rightChild);

				leftChild.setParent(root);
				rightChild.setParent(root);


				expression = expression.getNext();
				}


			}
		}


		return root;
	}

	public String getInfixSequence(SLLNode<Expression> expression) {

		String result = "";


		String right = null;
		String left = null;

		Operand operand = null;

		int size = getSize(expression);



		for (int i=0; i<size;i++) {

			String temp = "";

			if (size == 1) {

				Operand op =  (Operand) expression.getElement();
				result = String.format("%d",op.getValue());

			}

			else if (expression.getElement() instanceof Operator) {

				right =  pop();
				left =  pop();

				Operator operator = (Operator) expression.getElement();

				result = String.format("(%s %c %s)",left,operator.getOperator(),right);

				if (i != size-1) {


					push(result);



				}

				expression =expression.getNext();

			}

			else {

				operand = (Operand) expression.getElement();
				temp = String.format("%d",operand.getValue());
				push(temp);
				expression =expression.getNext();




			}
		}

		return result;
	}

	public void push (String e) {

		SLLNode<String> node = new SLLNode<String>(e,data.getNext());
		data.setNext(node);
	}


	public String pop() {

		String top = data.getNext().getElement();

		data.setNext(data.getNext().getNext());

		return top;	
	}

	public void pushExp (Expression e) {

		SLLNode<Expression> node = new SLLNode<Expression>(e,exp.getNext());
		exp.setNext(node);
	}


	public Expression popExp() {

		Expression top = exp.getNext().getElement();

		exp.setNext(exp.getNext().getNext());

		return top;	
	}

	public int getSize(SLLNode<Expression> head) {

		SLLNode<Expression> current = head;

		int size = 0;

		while(current != null) {

			size ++;

			current = current.getNext();
		}

		return size;


	}



}
