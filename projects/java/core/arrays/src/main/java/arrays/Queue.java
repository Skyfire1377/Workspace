package arrays;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item>{
	private int N = 0;
	private Item[] a = (Item[])new Object[1];
	public void enqueue(Item item){
		a[N++]=item;
	}
	public Item dequeue(){
		N--;
		return a[0];
	}
	public boolean isEmpty(){
		return N==0;
	}
	public Iterator<Item> iterator(){
		return new QueueIterator();
	}
	private class QueueIterator implements Iterator<Item>{
		private int i = 0;
		public Item next(){
			return a[i++];
		}
		public boolean hasNext(){
			return i<N-1;
		}
		public void remove(){

		}
	
	}
}
