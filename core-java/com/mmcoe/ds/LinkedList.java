package com.mmcoe.ds;

public class LinkedList<X> {
	private class Node {
		private X data;
		private Node next;
		
		public Node(X data)
		{
			this.data = data;
		}
		
		public X getData()
		{
			return data;
		}
	}
	
	private Node head, last;
	//private int size;
	public int size;
	
	public void add(X data)
	{
		Node n  = new Node(data);
		if (head == null)
		{
			head = n;
			last = n;
		} else
			last.next = n;
		last = n;
		size++;
	}
	
	public void insert(int idx, X data)
	{
		if (idx > size || idx < 0)
			throw new IllegalArgumentException("Index out of bounds.");
		Node n = new Node(data);
		if (idx == 0) {
			n.next = head;
			head = n;
			if (size == 0) 
				last = n;
		} else {
			Node prev = head;
			for (int i = 0; i < idx - 1; i++)
				prev = prev.next;
			n.next = prev.next;
			prev.next = n;
			if (n.next == null) 
				last = n;
		}
		size++;
	}
	
	public X remove(int idx)
	{
		if (idx < 0 || idx >= size)
			throw new IllegalArgumentException("Index out of bounds.");
		Node removed;
		if (idx == 0) {
			removed = head;
			head = head.next;
			if (head == null) last = null;
		} else {
			Node prev = head;
			for (int i = 0; i < idx - 1; i++)
				prev = prev.next;
			removed = prev.next;
			prev.next = removed.next;
			if (prev.next == null) last = prev;
		}
		size--;
		return removed.getData();
	}
	
	public void print()
	{
		Node t = head;
		while(t != null)
		{
			System.out.println(t.getData());
			t = t.next;
		}
	}
	
	public X get(int idx) {
	    Node t = head;
	    for (int i = 0; i < idx; i++)
	        t = t.next;
	    return t.getData();
	}
	
}
