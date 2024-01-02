
public class DLStack<T> implements DLStackADT<T>{

/*
 * Private reference node to the top of the stack
 */
	private DoubleLinkedNode<T> top;

/*
 * Private variable created to store number of data items stored in the stack
 */
	private int numItems;

/*
 * This method is used to create an empty stack to set corresponding values 
 * @param top set to null
 * @param numItems set to 0
 */
	public DLStack() {
		top = null;
		numItems = 0;
	}

/*
 * This method is used to add the given data item to the top of the stack
 */
	public void push(T dataItem) {
		DoubleLinkedNode<T> currentNode = new DoubleLinkedNode<T>(dataItem); 
		//Created a new node which passes the dataItem being used to the constructor
		if(top != null) {
			currentNode.setPrevious(top);
			//used to set the head of the new node to the top of the stack
			top.setNext(currentNode);
			//used to set the head of the old node to the new node 
			top = currentNode;
			currentNode.setNext(null);
		}
		
		else {
			top = new DoubleLinkedNode<T>(dataItem);
		}
		
		numItems++;
	}

/*
 * This method is used to remove and return the data item at the top of the stack with a throws exception added as well
 * @return poppingValue returns the popped value
 */
	public T pop() throws EmptyStackException {
		
		if(top == null) {
			throw new EmptyStackException("Empty Stack");
		}
		
		T poppingValue = top.getElement();
		//used to store the value of the top of the stack in the newly created node poppingValue
		
		if (top.getPrevious() != null) {
			top = top.getPrevious();
			top.setNext(null);
		}
		
		else {
			top = null;
		}

		numItems--;
		return poppingValue;
	}
	
/*
 * This method is used to remove and return the k-th data item from the top of the stack
 * @return poppingValue returns the popped value
 */
	public T pop(int k) throws InvalidItemException {
		T poppingValue = null;
		
		if (k > numItems || k <= 0) {
		//if statement used to set throws declaration if specified conditions are not met
			throw new InvalidItemException("Invalid item");
		}	
		else if (k == 1){
			poppingValue = pop();
			//used to call the pop method if the k value is equal to 1
		}
		
		else {
			DoubleLinkedNode<T> currentNode = top;
			
			for (int i = 1; i < k - 1; i++) {
			//for loop created to go through the stack and determine the node at the correct index
				currentNode = currentNode.getPrevious();
			}
			
			poppingValue = currentNode.getPrevious().getElement();
				
			if (currentNode.getPrevious().getPrevious() != null){
			//if statement used to check if the node previous to the previous node is equal to null
				currentNode.getPrevious().getPrevious().setNext(currentNode);
				currentNode.setPrevious(currentNode.getPrevious().getPrevious());
			}
			else {
				currentNode.setPrevious(null);
			}
		}
	
		numItems--;
		return poppingValue;
		}

/*
 * This method is used to return the data item at the top of the stack without removing it 
 * @return top.getElement() returns the stored value of the top of the stack
 */
	public T peek() throws EmptyStackException {
		
		if (numItems == 0) {
			throw new EmptyStackException("Empty Stack");
		}
		return top.getElement();
	}

/*
 * This method is used to show whether the stack is empty and return true or false accordingly
 */
	public boolean isEmpty() {
		return numItems == 0;
	}

/*
 * This method is used to return the number of data items in the stack created
 * @return numItems returns the number of data items
 */
	public int size() {
		return numItems;
	}

/*
 * This method is used to return the top stack
 * @return top returns top node
 */
	public DoubleLinkedNode<T> getTop() {
		return top;
	}

/*
 * This method is used to return the proper formatting for the data in the stack 
 * @return display returns the display value
 */
	public String toString() {
		String display = "[";
		DoubleLinkedNode<T> currentNode = top;
		
		while (currentNode != null) {
			display += currentNode.getElement();
			currentNode = currentNode.getPrevious();
			
			if (currentNode != null) {
				display += " ";
			}
		}
		display += "]";
		return display;
	}
}


