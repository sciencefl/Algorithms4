package Foundamentals;
import java.util.Iterator;


public class Queue<Item> implements Iterable<Item> {
/**
 * 先进先出队列的链表实现
 * @param args
 */
	private Node<Item> first;
	private Node<Item> last;
	private int N=0;
	private class Node<Item>{
		Item item;
		Node<Item> next;
	}
	public boolean isEmpty(){
		return first==null;
	}
	public int  size(){
		return N;
	}
	public void enqueue(Item item){
		Node<Item> oldlast=last;
		last=new Node<Item>();
		last.item=item;
		last.next=null;
//		oldlast.next=last;
		if(isEmpty()){
			first=last;
		}else{
			oldlast.next=last;
		}
		N++;
	}
	public Item dequeue(){
		Item item =first.item;
		first=first.next;
		if(isEmpty()){
			last=null;
		}
		N--;
		return item;
		
	}
	//迭代器的方法
	public Iterator<Item> iterator(){
		return new ListIterator<Item>(first);
	}
	//迭代器的类
	private class ListIterator<Item> implements Iterator<Item> {
		private Node<Item> current=null;
        public ListIterator(Node<Item> first) {
            current = first;
        }
		public boolean hasNext(){
			return current!=null;
		}
		public Item next(){
			Item item=current.item;
			current=current.next;
			return item;
		}
		public void remove(){ }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
