package algo;

public class Heap {
	private int[] a; //�Ѵ洢������
	private int n;   // �ѵĴ�С
	private int count; //��������Ԫ������
	public Heap(int capacity) {
		a=new int[capacity];
		n=capacity;
		count=0;	
	}
	//�����в���һ��Ԫ��
	public  void insert(int data) {
		//���������
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
	//ɾ���Ѷ�Ԫ��
	public  void  removeMax() {
		if(count==0) { // ��Ϊ�յ����
			return ;
		}
		a[1]=a[count];
		count--;
		heapify(a, count, 1);
	}
	//�������¶ѻ�
	public void heapify(int[] a,int count,int i) {
		int maxPos=i;
		//Ҫע�� �߽�������Ҷ�ӽڵ���±� ҪС�� count
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
	// ������a�н����±�Ϊ i,j��Ԫ�ص�ֵ
	public void  swap(int[]a,int i,int j) {
		int temp;
		temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	//���Ѳ���
	public void buildHeap(int[] a,int count) {
		// �Ӻ���ǰ�������飬����ÿ�����ݴ������¶ѻ�
		for(int i=2/count;i>0;i--) {
			heapify(a, count, i);
		}
	}
	//������
	// ʱ�临�Ӷ�ΪO(nlogn),�ռ临�Ӷ�ΪO(1),�ǲ��ȶ��������㷨
	public  void  sort(int[] a,int count) {
		if(count==0) {
			//�ն�ֱ���˳�
			return ;
		}
		//����:�����
		buildHeap(a, count);
		for(int i=count;i>1;i--) {
			swap(a, i, 1);
			//������������
			heapify(a, count, 1);
		}
	}

}
