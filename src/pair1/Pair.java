package pair1;

import javax.annotation.Generated;

/*
 * 这是一个泛型类示例
 */
public  class Pair<T>{
	public T getFirst() {
		return first;
	}
	public void setFirst(T first) {
		this.first = first;
	}
	public T getSecond() {
		return second;
	}
	public void setSecond(T second) {
		this.second = second;
	}
	private T first;
	private T second;
	public Pair() {
		first=null;
		second=null;
	}
	public Pair(T first,T second) {
		this.first=first;
		this.second=second;
	}

}
