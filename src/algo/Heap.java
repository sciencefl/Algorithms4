package algo;

import java.util.LinkedList;

public class Heap {
	private int[] a; //堆存储的数组
	private int n;   // 堆的大小
	private int count; //堆中已有元素数量
	public Heap(int capacity) {
		a=new int[capacity];
		n=capacity;
		count=0;	
	}
	//往堆中插入一个元素
	public  void insert(int data) {
		//如果堆已满
		if(count==n) {
			return ;
		}
		a[++count]=data;
		int i=count;
		while(i>0&&a[i/2]<a[i]) {
			swap(a, i/2, i);
			i=i/2;
		}
	}
	//删除堆顶元素
	public  void  removeMax() {
		if(count==0) { // 堆为空的情况
			return ;
		}
		a[1]=a[count];
		count--;
		heapify(a, count, 1);
	}
	//自上往下堆化
	public void heapify(int[] a,int count,int i) {
		int maxPos=i;
		//要注意 边界条件：叶子节点的下标 要小于 count
		while(true) {
			if(2*i<=count&&a[2*i]>a[maxPos]) maxPos=2*i;
			if((2*i+1)<=count&&a[2*i+1]>a[maxPos]) maxPos=2*i+1;
			if(maxPos==i) {
				break;
			}
			swap(a,maxPos,i);
			i=maxPos;
		}
	}
	// 在数组a中交换下标为 i,j的元素的值
	public void  swap(int[]a,int i,int j) {
		int temp;
		temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	//建堆操作
	public void buildHeap(int[] a,int count) {
		// 从后往前处理数组，并且每个数据从上往下堆化
		for(int i=2/count;i>0;i--) {
			heapify(a, count, i);
		}
	}
	//堆排序
	// 时间复杂度为O(nlogn),空间复杂度为O(1),是不稳定的排序算法
	public  void  sort(int[] a,int count) {
		if(count==0) {
			//空堆直接退出
			return ;
		}
		//建堆:大根堆
		buildHeap(a, count);
		for(int i=count;i>1;i--) {
			swap(a, i, 1);
			//从上往下排序
			heapify(a, count, 1);
		}
	}

}
