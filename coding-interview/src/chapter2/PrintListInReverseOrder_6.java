package chapter2;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

class Node{
	int val;
	Node next;
	public Node(int val)
	{
		this.val=val;
	}
}

public class PrintListInReverseOrder_6 {
	
	private Node built_linked_list(int[] arr)
	{
		Node head=new Node(0);
		Node rehead=head;
		
		for(int i=0;i<arr.length;i++)
		{
			Node node=new Node(arr[i]);
			head.next=node;
			head=head.next;
		}
		
		return rehead.next;
	}
	
	private void print(Node head)
	{
		while(head!=null)
		{
			System.out.print(head.val+" ");
			head=head.next;
		}
	}
	
	private void reverse(Node head)
	{
		Stack<Integer> stack=new Stack<Integer>();
		
		while(head!=null)
		{
			stack.push(head.val);
			head=head.next;
		}
		
		while(!stack.isEmpty())
		{
			int value=stack.pop();
			System.out.print(value+" ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintListInReverseOrder_6 rpll=new PrintListInReverseOrder_6();
		
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int []arr=new int[N];
		for(int i=0;i<N;i++)
			arr[i]=sc.nextInt();
		
		Node head=rpll.built_linked_list(arr);
		
		rpll.print(head);
		System.out.println();
	
		rpll.reverse(head);
	}

}
