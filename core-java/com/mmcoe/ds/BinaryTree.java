package com.mmcoe.ds;

public class BinaryTree<Type extends Comparable<Type>> {
	private class Node {
		private Type data;
		public Node left, right;
		
		public Node(Type data) {
			this.data = data;
		}
		
		public Type getData()
		{
			return data;
		}
	}
	
	private Node root;
	
	public void add(Type data)
	{
		Node n = new Node(data);
		if (root == null)
			root = n;
		else
			addRecursive(root, n);
	}
	
	private void addRecursive(Node current, Node newNode)
	{
		int cmp = newNode.getData().compareTo(current.getData());
		if (cmp < 0) {
			if (current.left == null)
				current.left = newNode;
			else
				addRecursive(current.left, newNode);
		} else {
			if (current.right == null)
				current.right = newNode;
			else
				addRecursive(current.right, newNode);
		}
	}
	
	public void traverse()
	{
		inOrder(root);
	}
	
	private void inOrder(Node node)
	{
		if (node != null) {
			inOrder(node.left);
			System.out.println(node.getData());
			inOrder(node.right);
		}
	}
	
}
