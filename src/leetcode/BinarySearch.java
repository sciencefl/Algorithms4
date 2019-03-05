package leetcode;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BinarySearch {

	/**
	 * ���ֲ��ұʼ�:
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		BinarySearch  binarySerach=new BinarySearch();
		int[] array= {6,5,4,3,7,7,2,1,9,100};
		int[] array2= {1,2,3,4,5,6,7,8};
		int[] array3= {};
		int result=-1;
//		result=binarySerach.simpleBinarySearch(array2,array2.length,8);
		result=binarySerach.simpleBinarySearchRecursion(array2,array2.length,10);
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
	//�򵥶��ֲ��ң������������������ظ�����,�ǵݹ�д��
	/*
	 * ע�����㣺
	 * 1.ѭ���˳�������low<=high
	 * 2.mid��ȡֵ Ϊ  mid =low+(high-low)>>1;
	 * 3.low��high�ĸ���
	 * ϸ��ע�⣺
	 *��mid = lo + (hi - lo) /2���������Ż�����λ����ʱ��
	 *��ע������������ȼ���ǧ����д��������mid = lo + (hi - lo) >> 1
	 */
	public int simpleBinarySearch(int[] a,int n,int value){
		int low=0;
		int high=n-1;
		while(low<=high) {
			int mid =low+((high-low)>>1); //ͨ��λ���� �������� (high+low)/2  ��Ϊ�˷�ֹ �������λ����Ϊ���������λ����Ҫ��ö�
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
	//���ֲ��ҵĵݹ鷽��
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

}
