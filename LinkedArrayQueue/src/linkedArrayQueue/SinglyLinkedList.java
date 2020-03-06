package linkedArrayQueue;

public class SinglyLinkedList<E> {
	// pointer to head node
	private Node<E> head;
	// pointer to tail node
	private Node<E> tail;
	// size of list
	private int listSize;
	// number of nodes
	private int numNodes;

	// constructor that initializes listSize and numNodes
	SinglyLinkedList() {
		listSize = 0;
		numNodes = 0;
	}

	// decreases the numNodes variable by 1
	public void decreaseNumNodesVar() {
		--numNodes;
	}

	// node creating method for when there are not already nodes present in the class
	public void createFirstNode() {
		tail = new Node<E>();
		head = tail;
		++numNodes;
	}

	/* sets last remaining node to null so the number of nodes equals 0 when the
	 * array is empty
	 */
	public void deleteFinalNode() {
		tail = null;
		head = null;
		numNodes = 0;
	}

	// returns the element at the back of the list
	public E getLastElement(int index) {
		if (listSize > 0) {
			return tail.getElement(index);
		}
		return null;
	}

	// returns the element at the front of the list
	public E getFirstElement(int index) {
		if (listSize > 0) {
			return head.getElement(index);
		}
		return null;
	}

	// returns the number of elements in the array
	public int size() {
		return listSize;
	}

	// returns the number of nodes or arrays in the list
	public int numArrays() {
		return numNodes;
	}

	// adds an element to the back of the array and increases the listSize variable by 1
	public void appendElement(E it, int index) {
		tail.setElement(it, index);
		++listSize;

	}

	// adds a new node to the list
	public void appendNode() {
		// adds a new node
		tail.setNext(new Node<E>());
		// sets tail to the newly created node
		tail = tail.next();
		// increases the numNodes variable by 1
		++numNodes;
	}

	/* as long as the node that head is linked to isn't null, sets head to the node
	 * its linked to
	 */
	public void next() {
		if (head.next() != null) {
			head = head.next();
		}
	}

	// deletes an element from the list and increases the listSize variable
	public void deleteElement(int index) {
		head.setElement(null, index);
		--listSize;
	}

}

class Node<E> {
	// array that node contains
	private E[] arr;
	// value of the node that array is pointing to
	private Node<E> next;

	// constructor that initializes an array of length 8
	Node() {
		arr = (E[]) new Object[8];
	}

	// sets an element in the array at a particular index
	void setElement(E it, int index) {
		arr[index] = it;
	}

	// returns an element in the array at a particular index
	E getElement(int index) {
		return arr[index];
	}

	// sets value of next node as being a node
	Node<E> setNext(Node<E> inn) {
		return next = inn;
	}

	// returns the value of the next node in the array
	Node<E> next() {
		return next;
	}

	// deletes an element at a particular index in the array
	void deleteElement(int index) {
		arr[index] = null;
	}

}