package Foundamentals;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 加权quick-union的动态连通性问题的算法
 * @author Stone
 *
 */
public class WeightedQuickUnionUF {
    private int[] parent;  //parent[i]表示 触点i的父触点
    private int[] rank;    //rank[i]表示以触点i为根的子树的高度
    private int count;       //连通分量数量
    //构造方法，初始化
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
    //查找触点p的根触点，并返回
    public int find(int p){
    	while(p!=parent[p]) p=parent[p];
    	return p;
    }
    //判断两个触点是否相连
    public boolean connected(int p,int q){
    	int pRoot=find(p);
    	int qRoot=find(q);
    	return pRoot==qRoot;
    }
    //将两触点相连
    public void union(int p,int q){
    	int pRoot=find(p);
    	int qRoot=find(q);
    	if(pRoot==qRoot) return;
    	//判断树的高度，然后进行操作
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
