 package com.operr.list;

/** Node of a singly linked list*/
public class Node implements Comparable<Integer>{

	private int element; 
	private Node next;

	public int getElement() { 
		return element; 
	}

	public Node getNext() { 
		return next; 
	}

	// Modifier methods:
	public void setElement(int element) { 
		this.element = element; 
	}

	public void setNext(Node next) { 
		this.next = next; 
	}

	@Override
	public int compareTo(Integer o) {
		return o.compareTo(element);
	}
}