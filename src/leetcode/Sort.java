package leetcode;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Sort  sort=new Sort();
		int[] array= {6,5,4,3,7,7,2,1,9,100};
		int[] array2= {1,2,3,4,5,6,7,8};
		int[] array3= {};
//		sort.bubbleSort(array2, array2.length);
//		sort.insertionSort(array,array.length); 
//		sort.selectionSort(array,array.length);
//		sort.mergeSort(array, array.length);
		System.out.println(df.format(new Date()));
		sort.quickSort(array, array.length);
		System.out.println(df.format(new Date()));
		for(int i=0;i<array.length;i++)
		System.out.println(array[i]);
		System.out.println(Arrays.toString(array));
	}
	//冒泡排序，时间复杂度为O(n2)，空间复杂度为O(1),是一种稳定的排序算法
	public void bubbleSort(int[] a ,int n) {
		//不需要排序的情况
		if(n<=1) {
			return ;
		}
		int temp=0;
		//外层循环是 已排序数据个数
		for(int i=0;i<n;i++) {
			//标记判断是否发生数据交换，如果没有数据交换则表示已经完全排序，直接跳出函数
			boolean flag=false;
			//内层循环，表示每次冒泡的过程
			for(int j=0;j<n-i-1;j++ ) {
				if(a[j]>a[j+1]) {
					temp=a[j+1];
					a[j+1]=a[j];
					a[j]=temp;
					//发生数据交换，标志位置为true
					flag=true;
				}
			}
			for(int k=0;k<n;k++)
				System.out.print(a[k]+" ");
			System.out.println();
			if(!flag) break;
		}
	}
	//插入排序，重点分为排序区和未排序区 时间复杂度为O(n2),是稳定的排序算法，为原地排序
	public void insertionSort(int[] a,int n) {
		//不需要排序的情况
		if(n<=1) {
			return ;
		}
		//变量i表示排序区已经有序的元素数量
		for(int i=1;i<n;i++) {
			int temp=a[i];
			int j=i;
			for(;j>0;j--) {
				if(a[j-1]>temp) {
					a[j]=a[j-1];
				}else {
					 break;
				}
			}
			a[j]=temp;
		}
	}
	//选择排序， 每次从未排序区选择最小的元素，然后插入到已排序区的末尾
	public void selectionSort(int[] a,int n) {
		if(n<=1) {
			return ;
		}
		// i表示已经有序的元素个数
		for(int i=0;i<n-1;i++) {
			int k=i; //k表示 无序区最小的元素下标
			int temp=0;// 交换时候辅助变量
			for(int j=k;j<n-1;j++) {
				if(a[j+1]<a[k]) {
					k=j+1;
				}
			}
			temp=a[i];
			a[i]=a[k];
			a[k]=temp;
		}	
	}
	//归并排序，采用了分治算法的思想，类似于递归，递归是一种编程技巧，于是，采用分治算法的也需要写出递推公式和终止条件
	//递推公式：merge_sort(p,r)=merge(merge_sort(p,q),merge_sort(q+1,r));
	//终止条件：p>=r;
	public void mergeSort(int[] a,int n) {
		mergeSort_c(a, 0, n-1);
	}
	public void mergeSort_c(int[] a,int p,int r) {
		if(p<r) {
			mergeSort_c(a, p, (p+r)/2);
			
			mergeSort_c(a, ((p+r)/2+1), r);
			merge(a, p, (p+r)/2, r);
		}
	}
	//二路归并 ,真的，变量命名太重要了。。。
	public void merge(int[] a,int p,int q,int r) {
		//先判断边界条件
		int[] array=new int[r-p+1];//辅助数组
		int i=p;
		int j=q+1;
		int k=0;  //三个辅助变量，游标
		while(i<=q&&j<=r) {
			if(a[i]<=a[j]) {
				array[k++]=a[i++];
			}else {
				array[k++]=a[j++];
			}	
		}
		if(i>q) {
			while(j<=r) {
				array[k++]=a[j++];
			}
		}else {
			while(i<=q) {
				array[k++]=a[i++];
			}
		}
		k=0;
		for(int x=p;x<=r;x++) {
			a[x]=array[k];
			k++;
		}
	}
	// 快速排序，也是利用了分治的思想，递推公式quickSort(p,r)=quickSort(p,q-1)+quickSort(q+1,r);
	//终止条件 p>=r
	public void quickSort(int[] a ,int n) {
		quickSort_c(a,0, n-1);
	}
	//递归的实现
	public void quickSort_c(int[] a,int low,int high ) {
		if(low<high) {
			//获取分区点
			int privot=partition(a, low, high);
			quickSort_c(a, low, privot-1);
			quickSort_c(a, privot+1, high);
		}
	}
	//分区函数，分区的数值下标 
	//随机选一个元素作为区分点，一般选择数组的最后一个元素
	public  int  partition(int[] a,int low,int high) {
		int privot=a[high]; //获取分区点，循环比较元素，小于的交换，不小于的放着
		int cursor=low;  // 获取位置的游标 
		int temp=0;
		for(int i=low;i<high;i++) {
			if(a[i]<privot) {
				temp=a[cursor];
				a[cursor]=a[i];
				a[i]=temp;
				cursor++;
			}
		}
		a[high]=a[cursor];
		a[cursor]=privot;
		System.out.println(Arrays.toString(a));
		return cursor;
	}
}
