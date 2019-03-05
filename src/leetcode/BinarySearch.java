package leetcode;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BinarySearch {

	/**
	 * 二分查找笔记:
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		BinarySearch  binarySerach=new BinarySearch();
		int[] array= {6,5,4,3,7,7,2,1,9,100};
		int[] array2= {1,2,3,4,5,6,7,8};
		int[] array3= {};
		int result=binarySerach.simpleBinarySearch(array2,array2.length,8);
		System.out.println(result);
//		sort.bubbleSort(array2, array2.length);
//		sort.insertionSort(array,array.length); 
//		sort.selectionSort(array,array.length);
//		sort.mergeSort(array, array.length);
		System.out.println(df.format(new Date()));
		
		System.out.println(df.format(new Date()));
		for(int i=0;i<array.length;i++)
		System.out.println(array[i]);
		System.out.println(Arrays.toString(array));

	}
	//简单二分查找，假设数据有序，且无重复数据,非递归写法
	/*
	 * 注意三点：
	 * 1.循环退出条件是low<=high
	 * 2.mid的取值 为  mid =low+(high-low)>>1;
	 * 3.low和high的更新
	 */
	public int simpleBinarySearch(int[] a,int n,int value){
		int low=0;
		int high=n-1;
		while(low<=high) {
			int mid =low+((high-low)>>1); //通过位运算 ，而不是 (high+low)/2  是为了防止 溢出，移位是因为计算机处理位运算要快得多
			if(value==a[mid]) {
				return mid;
			}else if(a[mid]<value) {
				low=mid+1;
			}else {
				high=mid-1;
			}
		}
		return -1;
	}

}
