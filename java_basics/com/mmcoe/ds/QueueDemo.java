package com.mmcoe.ds;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.offer(10);
		queue.offer(20);
		queue.offer(30);

		System.out.println("Queue: " + queue);
		System.out.println("Peek: " + queue.peek());
		System.out.println("Poll: " + queue.poll());
		System.out.println("Poll: " + queue.poll());
		System.out.println("Size: " + queue.size());
		System.out.println("Is empty: " + queue.isEmpty());
		System.out.println("Poll: " + queue.poll());
		System.out.println("Is empty: " + queue.isEmpty());
	}
}
