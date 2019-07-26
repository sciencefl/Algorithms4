package algo;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BinarySearch {

	/**
	 * 二分查找笔记:
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object object=new Object();
		String s="dafd";
		int[] a=new int[100];
		System.out.println("aaaa "+a.length);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		BinarySearch  binarySerach=new BinarySearch();
		int t=256;
		t = 0x5f3759df - (t >> 1);
		System.out.println(t);
		int[] array= {6,5,4,3,7,7,2,1,9,100};
		int[] array2= {1,2,3,4,5,6,7,8};
		int[] array3= {1,2,2,2,2,4,4,4,4,4};
		int result=-1;
//		result=binarySerach.simpleBinarySearch(array2,array2.length,8);
//		result=binarySerach.simpleBinarySearchRecursion(array2,array2.length,10);
		result=binarySerach.binarySearchFirstPos(array3,4);
		System.out.println("第一个位置为："+result);
		result=binarySerach.binarySearchLastPos(array3,2);
		System.out.println("最后位置为："+result);
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
	/*  时间复杂度是 logn
	 * 注意三点：
	 * 1.循环退出条件是low<=high
	 * 2.mid的取值 为  mid =low+(high-low)>>1;
	 * 3.low和high的更新
	 * 细节注意：
	 *将mid = lo + (hi - lo) /2，将除法优化成移位运算时，
	 *得注意运算符的优先级，千万不能写成这样：mid = lo + (hi - lo) >> 1
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
	//二分查找的递归方法
	public int simpleBinarySearchRecursion(int[] a,int n,int value) {
		return simpleBinarySearchRecursion_c(a, 0, n-1, value);
	}
	public int simpleBinarySearchRecursion_c(int[] a,int low ,int high,int value) {
		if(low>high) {
			return -1;
		}
		int mid=low+((high-low)>>1);
		if(a[mid]==value) {
			return mid;
		}else if(a[mid]>value) {
			return simpleBinarySearchRecursion_c(a, low, mid-1, value);
		}else {
			return simpleBinarySearchRecursion_c(a, mid+1, high, value);
		}
	}

	/**
	 * 获取array数组中 value出现的第一个位置的下标
	 * @param array
	 * @param value
	 * @return
	 */
	public int binarySearchFirstPos(int[] array,int value){
		if(array==null||array.length==0){
			return -1;
		}
		int low=0;
		int high=array.length-1;
		while(low<=high){
			int mid=low+((high-low)>>1);
			if(array[mid]<value){
				low=mid+1;
			}else if(array[mid]>value){
				high=mid-1;
			}else {
				if(mid==0||array[mid-1]!=value)
					return mid;
				else high=mid-1;
			}
		}
		return -1;
	}
	/**
	 * 获取array数组中 value出现的最后位置的下标
	 * @param array
	 * @param value
	 * @return
	 */
	public int binarySearchLastPos(int[] array,int value){
		if(array==null||array.length==0){
			return -1;
		}
		int low=0;
		int high=array.length-1;
		while(low<=high){
			int mid=low+((high-low)>>1);
			if(array[mid]<value){
				low=mid+1;
			}else if(array[mid]>value){
				high=mid-1;
			}else {
				if(mid==(array.length-1)||array[mid+1]!=value)
					return mid;
				else low=mid+1;
			}
		}
		return -1;
	}


}
