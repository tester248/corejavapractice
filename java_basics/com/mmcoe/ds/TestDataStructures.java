package com.mmcoe.ds;

public class TestDataStructures {
	 public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		
		list.insert(2,25);
		list.insert(0,5);
		list.insert(2, 15);
		list.insert(5,28);
		
		list.remove(4);
		System.out.println("Linked List:");
		list.print();
		
		
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		
		tree.add(5);
		tree.add(2);
		tree.add(8);
		tree.add(55);
		System.out.println("Binary Tree:");
		tree.traverse();
		
		
	}
}
