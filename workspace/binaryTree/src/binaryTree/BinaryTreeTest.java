package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTest {
	
}

class Node{
	Node left, right;
	int value;
	
	public Node(int value) {
		left = null;
		right = null;
		this.value = value;
	}
}

class BinaryTree{
	
	Node head;
	int size;
	
	public BinaryTree() {
		this.head = null;
		this.size = 0;
	}
	
	public void push(Node nd) {
//		해당 이진트리의 크기가 0 일때 : 처음
		if(this.size == 0) {
			Node node = nd;
			this.head = node;
		}
		
		else {
			Node node = this.head;
			
			Queue<Node> que = new LinkedList<Node>();
			que.add(node);
		}
	}
}
