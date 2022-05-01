package arrays;

import java.util.Iterator;

public class LinkedListQueue<Item> implements Iterable<Item>{
	private Node first;
	private Node last;
	private int N = 0;
	public void enqueue(Item item){
		Node newlast = new Node();
		newlast.item = item;
		if(N==0){
			first = newlast;
		}else{
			last.next =  newlast;
		}

		last = newlast;
		N++;
	}
	public Item dequeue(){
		Item item = first.item;
		if(N==1){
			first = null;
			last = null;
		}else{
			first=first.next;
		}
		N--;
		return item;
	}
	private class Node{
		Item item;
		Node next;
	}
	public Iterator<Item> iterator(){
		return new LinkedListIterator();
	}
	private class LinkedListIterator implements Iterator<Item>{
		Node current  = first;
		public boolean hasNext(){
			return current.next != null;
		}
		public Item next(){
			Item item = current.item;
			current  = current.next;
			return item;
		}
		public void remove(){

		}
	}
	public String toString(){
		return "length is: " + N;
	}
}
