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

}
