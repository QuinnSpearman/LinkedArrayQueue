package linkedArrayQueue;

public class LinkedArrayQueue<E> {
	// variable that specifies the index of the front of the array in the head node
	private int front = 0;
	// variable that specifies the index of the back of the array in the tail node
	private int back = 0;
	// variable that initializes a singly linked list object
	SinglyLinkedList<E> linkedList;

	// constructor that creates an empty singly linked list
	public LinkedArrayQueue() {
		linkedList = new SinglyLinkedList<E>();
	}

	// returns how many elements are stored in the queue over all arrays.
	public int size() {
		return linkedList.size();
	}

	// returns how many arrays are in the linked list
	public int numArrays() {
		return linkedList.numArrays();
	}

	// test if the queue is empty
	public boolean isEmpty() {
		// if size equals 0, return true
		if (linkedList.size() == 0) {

			return true;
		}
		// otherwise return false
		return false;
	}

	// return the element at the front of the queue returns null if queue is empty
	public E first() {
		return linkedList.getFirstElement(front);
	}

	// returns the element at the back of the queue, returns null if queue is empty
	public E last() {
		return linkedList.getLastElement(back);
	}

	// add e to the back of the queue
	public void enqueue(E e) {

		// if there is nothing in the queue, create a new node first
		if (size() == 0) {
			linkedList.createFirstNode();
		}

		// if the index of back is less than 7
		if (back < 7) {

			/*
			 * if back is at the index 0, only increase the index of back if the value at 0
			 * is not null; or always increase the index if back is already greater than 0
			 */
			if ((linkedList.getLastElement(back) != null && back == 0) || back > 0) {
				++back;
			}

			// add element new element to index of back
			linkedList.appendElement(e, back);
		}
		// otherwise if else equals 7
		else {
			// set back to 0
			back = 0;
			// append a new node to the list and move tail to the new node
			linkedList.appendNode();
			// add the new element to the index of back (0)
			linkedList.appendElement(e, back);
		}
	}

	/* pop and return the element at the front of the queue. return null if queue is
	 * empty
	 */
	public E dequeue() {
		// declares a temporary generic element
		E e;

		// if there is nothing in the list return null
		if (linkedList.size() == 0) {
			return null;
		}

		// if the index of front is less than 7
		if (front < 7) {
			// sets e equal to the first element in the list
			e = linkedList.getFirstElement(front);
			// deletes the element from the list
			linkedList.deleteElement(front);
			// increases the index of front by 1
			++front;

			// if there is nothing in the list, deletes the final remaining node
			if (size() == 0) {
				linkedList.deleteFinalNode();
			}
			// returns the element
			return e;
		} else {
			// sets e equal to the first elment in the list
			e = linkedList.getFirstElement(front);
			// deletes the element from the list
			linkedList.deleteElement(front);
			// sets the index of front equal to 0
			front = 0;

			// if there is nothing in the list, deletes the final remaining node
			if (size() == 0) {
				linkedList.deleteFinalNode();
			}

			// set head equal to the next node
			linkedList.next();
			// decrease the counter representing the number of nodes in the list
			linkedList.decreaseNumNodesVar();
			// returns the element
			return e;
		}
	}

}
