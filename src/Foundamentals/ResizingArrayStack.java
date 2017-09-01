/**
 * 
 */
package Foundamentals;
import java.util.Iterator;

/**
 * @author flzhang
 * 下压栈（能够动态调整数组大小的实现）
 */
public class ResizingArrayStack<Item> implements Iterable<Item>{
	private Item[] a;    //存储数据的数组
	private int N;     //存储栈中元素的个数
	/**
	 * 初始化一个空栈
	 */
	public ResizingArrayStack(){
		a =(Item[])new Object[2];
		N=0;
	}
	public boolean isEmpty(){
		return N==0;
	}
	/**
	 * 重新将栈移动到一个大小为max 的数组中
	 * @param max
	 */
	public void resize(int max){
		Item[] temp=(Item[])new Object[max]; 
		for(int i=0;i<N;i++){
			temp[i]=a[i];
		}
		a=temp;
	}
	public void push(Item item){
		if(N==a.length) resize(a.length*2);
		//入栈之后将栈中元素数量+1
		a[N++]=item;  //
	}
	public Item pop(){
		Item item = a[--N];
		a[N]=null;
		if(N > 0 && N == a.length/4) resize(a.length/2);
		return item;
	}
	public int size(){
		return N;
	}
	public Iterator<Item> iterator(){
		return new RevserseArrayIterator();
	}
	public class RevserseArrayIterator implements Iterator<Item>{
		//支持后进先出的迭代
		private int i=N;
		public boolean hasNext() { return i>0;}
		public Item next() {return a[--i];}
		public void remove(){}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
