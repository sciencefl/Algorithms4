package Foundamentals;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * ��Ȩquick-union�Ķ�̬��ͨ��������㷨
 * @author Stone
 *
 */
public class WeightedQuickUnionUF {
    private int[] parent;  //parent[i]��ʾ ����i�ĸ�����
    private int[] rank;    //rank[i]��ʾ�Դ���iΪ���������ĸ߶�
    private int count;       //��ͨ��������
    //���췽������ʼ��
    public WeightedQuickUnionUF(int n){
    	if(n<0) throw new IllegalArgumentException();
    	count=n;
    	parent=new int[n];
    	rank=new int[n];
    	for(int i=0;i<n;i++){
    		parent[i]=i;
    		rank[i]=0;
    	}
    }
    public int count(){
    	return count;
    }
    //���Ҵ���p�ĸ����㣬������
    public int find(int p){
    	while(p!=parent[p]) p=parent[p];
    	return p;
    }
    //�ж����������Ƿ�����
    public boolean connected(int p,int q){
    	int pRoot=find(p);
    	int qRoot=find(q);
    	return pRoot==qRoot;
    }
    //������������
    public void union(int p,int q){
    	int pRoot=find(p);
    	int qRoot=find(q);
    	if(pRoot==qRoot) return;
    	//�ж����ĸ߶ȣ�Ȼ����в���
    	if(rank[pRoot]<rank[qRoot]){
    		parent[pRoot]=qRoot;
    	}else if(rank[pRoot]<rank[qRoot]){
    		parent[qRoot]=pRoot;
    	}else{
    		parent[pRoot]=qRoot;
    		rank[qRoot]++;
    	}
    	count--;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int n = StdIn.readInt();
		 WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);
	        while (!StdIn.isEmpty()) {
	            int p = StdIn.readInt();
	            int q = StdIn.readInt();
	            if (uf.connected(p, q)) continue;
	            uf.union(p, q);
	            StdOut.println(p + " " + q);
	        }
	        StdOut.println(uf.count() + " components");

	}

}
