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
	//ð������ʱ�临�Ӷ�ΪO(n2)���ռ临�Ӷ�ΪO(1),��һ���ȶ��������㷨
	public void bubbleSort(int[] a ,int n) {
		//����Ҫ��������
		if(n<=1) {
			return ;
		}
		int temp=0;
		//���ѭ���� ���������ݸ���
		for(int i=0;i<n;i++) {
			//����ж��Ƿ������ݽ��������û�����ݽ������ʾ�Ѿ���ȫ����ֱ����������
			boolean flag=false;
			//�ڲ�ѭ������ʾÿ��ð�ݵĹ���
			for(int j=0;j<n-i-1;j++ ) {
				if(a[j]>a[j+1]) {
					temp=a[j+1];
					a[j+1]=a[j];
					a[j]=temp;
					//�������ݽ�������־λ��Ϊtrue
					flag=true;
				}
			}
			for(int k=0;k<n;k++)
				System.out.print(a[k]+" ");
			System.out.println();
			if(!flag) break;
		}
	}
	//���������ص��Ϊ��������δ������ ʱ�临�Ӷ�ΪO(n2),���ȶ��������㷨��Ϊԭ������
	public void insertionSort(int[] a,int n) {
		//����Ҫ��������
		if(n<=1) {
			return ;
		}
		//����i��ʾ�������Ѿ������Ԫ������
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
	//ѡ������ ÿ�δ�δ������ѡ����С��Ԫ�أ�Ȼ����뵽����������ĩβ
	public void selectionSort(int[] a,int n) {
		if(n<=1) {
			return ;
		}
		// i��ʾ�Ѿ������Ԫ�ظ���
		for(int i=0;i<n-1;i++) {
			int k=i; //k��ʾ ��������С��Ԫ���±�
			int temp=0;// ����ʱ��������
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
	//�鲢���򣬲����˷����㷨��˼�룬�����ڵݹ飬�ݹ���һ�ֱ�̼��ɣ����ǣ����÷����㷨��Ҳ��Ҫд�����ƹ�ʽ����ֹ����
	//���ƹ�ʽ��merge_sort(p,r)=merge(merge_sort(p,q),merge_sort(q+1,r));
	//��ֹ������p>=r;
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
	//��·�鲢 ,��ģ���������̫��Ҫ�ˡ�����
	public void merge(int[] a,int p,int q,int r) {
		//���жϱ߽�����
		int[] array=new int[r-p+1];//��������
		int i=p;
		int j=q+1;
		int k=0;  //���������������α�
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
	// ��������Ҳ�������˷��ε�˼�룬���ƹ�ʽquickSort(p,r)=quickSort(p,q-1)+quickSort(q+1,r);
	//��ֹ���� p>=r
	public void quickSort(int[] a ,int n) {
		quickSort_c(a,0, n-1);
	}
	//�ݹ��ʵ��
	public void quickSort_c(int[] a,int low,int high ) {
		if(low<high) {
			//��ȡ������
			int privot=partition(a, low, high);
			quickSort_c(a, low, privot-1);
			quickSort_c(a, privot+1, high);
		}
	}
	//������������������ֵ�±� 
	//���ѡһ��Ԫ����Ϊ���ֵ㣬һ��ѡ����������һ��Ԫ��
	public  int  partition(int[] a,int low,int high) {
		int privot=a[high]; //��ȡ�����㣬ѭ���Ƚ�Ԫ�أ�С�ڵĽ�������С�ڵķ���
		int cursor=low;  // ��ȡλ�õ��α� 
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
