package com.operr.list;

/** Singly linked list .*/
public class LinkedList {

	/** head node of the list **/
	private Node head;

	/**tail node of the list**/
	private Node tail;

	/**
	 * constructor to init params
	 */
	public LinkedList(){
		head = null;
		tail = null;
	}

	/**
	 * clear to list
	 */
	public void clear() {
		head = null;
		tail = null;
	}

	/**
	 * Tests whether the linked list is empty.
	 * @return true if the linked list is empty, false otherwise
	 */
	public boolean isEmpty() {
		if (head == null) 
			return true;
		else
			return false;
	}
	/**
	 * Adds an element into list.
	 * @param element the new element to add
	 */
	public void add(int element){
		Node nd = new Node();
		nd.setElement(element);
		/**
		 * check if the list is empty
		 */
		if(head == null){
			//if there is only one element, both head and tail points to the same object.
			head = nd;
			tail = nd;
		} else {
			//set current tail next link to new node
			tail.setNext(nd);
			//set tail as newly created node
			tail = nd;
		}
	}

	/**
	 * Adds an element to the list.
	 * @param element the new element to add
	 * @param after add element after the given element
	 */
	public void addAfter(int element, int after){
		Node tmp = head;
		Node refNode = null;

		/** finding the given node **/
		while(true){
			if(tmp == null){
				break;
			}
			if(tmp.compareTo(after) == 0){
				//found the target node, add after this node
				refNode = tmp;
				break;
			}
			tmp = tmp.getNext();
		}

		/** If found the given node, add after the the particular element */
		if(refNode != null){
			//add element after the target node
			Node nd = new Node();
			nd.setElement(element);
			nd.setNext(tmp.getNext());
			if(tmp == tail){
				tail = nd;
			}
			tmp.setNext(nd);

		} else {
			System.out.println("Unable to find the element:" + after);
		}
	}

	
	/**
	 * Delete tail element to the list.
	 */
	public void deleteTail() {
		if (isEmpty()) {
			System.out.println("List is empty... Cannot remove from tail.");
			return;
		}
		//if only one element into list 
		if (head == tail) {
			head = tail = null;
			return;
		}
		Node currentNode = head;
		//getting second last node
		while (currentNode.getNext() != tail) {
			currentNode = currentNode.getNext();
		}
		currentNode.setNext(null);
		tail = currentNode;
	}

	/**
	 * Delete front element to the list.
	 */
	public void deleteFront(){
		if(head == null){
			System.out.println("List is empty... Cannot remove from front.");
			return;
		}
		Node tmp = head;
		head = tmp.getNext();
		if(head == null){
			tail = null;
		}
	}

	/**
	 * Delete a single node after given element to the list.
	 */
	public void deleteAfter(int after){
		Node tmp = head;
		Node refNode = null;
		/**
		 * searching till given element to list
		 */
		while(true){
			if(tmp == null){
				break;
			}
			if(tmp.compareTo(after) == 0){
				//found the target node, add after this node
				refNode = tmp;
				break;
			}
			tmp = tmp.getNext();
		}
		if(refNode != null){
			tmp = refNode.getNext();
			refNode.setNext(tmp.getNext());
			if(refNode.getNext() == null){
				tail = refNode;
			}
		} else {
			System.out.println("Unable to find the given element..." + after);
		}
	}

	/**
	 * Delete a particular element to the list.
	 */
	public void delete(int element) {
		//if list is empty, return
		if (isEmpty()) {
			System.out.println("List is empty... Cannot remove from given element...");
			return;
		}
		//head node contains element then move head to the next node  
		if (head.compareTo(element) == 0) {
			head = head.getNext();
			if (head == null)
				tail = null;
			return;
		}

		//One of the other nodes contains element then link around the node
		Node prev = head;
		Node curr = head.getNext();
		while(curr != null) {
			if (curr.compareTo(element)==0) {
				if (curr == tail)
					tail = prev;
				prev.setNext(curr.getNext());
				return;
			} else {
				prev = curr;
				curr = curr.getNext();
			}
		}
		//if list does not contain element just return
		return;
	}

	/**
	 * Delete element(s) if element is greater then from target
	 */
	public void deleteIfGreater(int target){
		Node tmp = head;
		while(true){
			if(tmp == null){
				break;
			}
			if(tmp.getElement() > target) {
				delete(tmp.getElement());
			}
			tmp = tmp.getNext();
		}
	}

	public void traverse(){
		System.out.println("traverse list......");
		Node tmp = head;
		while(true){
			if(tmp == null){
				break;
			}
			System.out.println(tmp.getElement() + ",");
			tmp = tmp.getNext();
		}
	}
}