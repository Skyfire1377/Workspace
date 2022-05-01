package arrays;

import java.util.Iterator;
import utils.Out;
public class Stack<Item> implements Iterable<Item>{
	private Item[] a = (Item[])new Object[1];
	private int N = 0;
	public Iterator<Item> iterator(){
		return new ReverseArrayIterator();	
	}
	private class ReverseArrayIterator implements Iterator<Item>{
		private int i = N;
		public void remove(){
		}
		public Item next(){
			return a[--i];
		}
		public boolean hasNext(){
			return i > 0;
		}
	};
	public void resize(int max){
		Item[] temp = (Item[])new Object[max];
		for(int i = 0; i< N; i++){
			temp[i]=a[i];
		}
		a= temp;
		Out out = new Out();
		out.println(a.length);
	}
	public boolean isEmpty() {return N==0;}
	public void push(Item item){
		if(N==a.length/2) resize(a.length*2);
		a[N++]=item;
	}
	public Item pop(){
		Item item = a[--N];
		a[N]=null;
		if(N>0&&N==a.length/4) resize(a.length/2);
		return item;
	}
	public int size(){
		return N;
	}
	public String toString(){
		return N + " " + a.length + "\n";
	}
}
