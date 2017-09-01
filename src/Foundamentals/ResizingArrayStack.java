/**
 * 
 */
package Foundamentals;
import java.util.Iterator;

/**
 * @author flzhang
 * ��ѹջ���ܹ���̬���������С��ʵ�֣�
 */
public class ResizingArrayStack<Item> implements Iterable<Item>{
	private Item[] a;    //�洢���ݵ�����
	private int N;     //�洢ջ��Ԫ�صĸ���
	/**
	 * ��ʼ��һ����ջ
	 */
	public ResizingArrayStack(){
		a =(Item[])new Object[2];
		N=0;
	}
	public boolean isEmpty(){
		return N==0;
	}
	/**
	 * ���½�ջ�ƶ���һ����СΪmax ��������
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
		//��ջ֮��ջ��Ԫ������+1
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
		//֧�ֺ���ȳ��ĵ���
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
