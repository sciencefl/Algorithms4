package Foundamentals;
import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
/**
 * 下压堆栈，链表实现
 * @param args
 */
	private Node first;
	private int N=0;
	private class Node{
		Item item;
		Node next;
	}
	public boolean isEmpty(){
		return  first==null; //或者N==0;
	}
	public void push(Item item){
		Node oldfirst= first;
		first= new Node();
		first.item=item;
		first.next=oldfirst;
		N++;
	}
	public Item pop(){
		Item item=first.item;
		first=first.next;
		N--;
		return item;
	}
	public int size(){
		return N;
	}
	public Iterator<Item> iterator(){
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item>{
		private Node current=first;
		public boolean hasNext(){
			return current!=null;
		}
		public Item next(){
			Item item=current.item;
			current=current.next;
			return item;
		}
		public void remove(){}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
