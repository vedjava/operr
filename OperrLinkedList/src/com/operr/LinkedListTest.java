package com.operr;

import com.operr.list.LinkedList;
/**
 * Test class to custom singly linked list
 * */
public class LinkedListTest {
	
	public static void main(String[] args) {
		 LinkedList list = new LinkedList();
	        list.add(3);
	        list.add(32);
	        list.add(54);
	        list.add(89);
	        list.add(90);
	        list.add(95);
	        list.addAfter(76, 54);
	        list.addAfter(76, 54);
	        list.traverse();
	        
	        list.deleteFront();
	        list.traverse();
	        
	        list.deleteAfter(76);
	        list.traverse();
	        
	        list.deleteTail();
	        list.traverse();
	       
	        list.deleteIfGreater(50);
	        list.traverse();
	        
	}

}
