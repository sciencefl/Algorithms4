package leetcode;

public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sort  sort=new Sort();
		int[] array= {6,5,4,3,7,7,2,1};
		int[] array2= {1,2,3,4,5,6,7};
		int[] array3= {};
//		sort.bubbleSort(array2, array2.length);
//		sort.insertionSort(array,array.length); 
		sort.selectionSort(array,array.length);
		for(int i=0;i<array.length;i++)
		System.out.println(array[i]);
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

}
