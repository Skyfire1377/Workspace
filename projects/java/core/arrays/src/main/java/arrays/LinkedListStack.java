package arrays;

import java.util.Iterator;

public class LinkedListStack<Item> implements Iterable<Item>{
	private Node first;
	private int N=0;
	protected class Node{
		Item item;
		Node next;
	}
	public void push(Item item){
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	public Item pop(){
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	public boolean isEmpty(){
		return N==0;
	}
	public int length(){
		return N;
	}
	public Iterator<Item> iterator(){
		return new LinkedListIterator();
	}
	private class LinkedListIterator implements Iterator<Item>{
			
		Node current = new Node();
		public LinkedListIterator(){
			current.next = first;
		}	
		public Item next(){

			current = current.next;
			return current.item;
		}
		public boolean hasNext(){
			return current.next != null;
		}
		public void remove(){
		
		}

	}
}
