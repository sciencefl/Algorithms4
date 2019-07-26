package algo;

import edu.princeton.cs.algs4.Queue;

import java.util.LinkedList;
public class Graph {
	//内部类,存储图的顶点
	public class Vertex{
		int data;
		public Vertex(int data) {
			this.data=data;
		}
	}
	/**
	 * 无向图
	 * 邻接表
	 */
	 private int size; // 图的大小
	 private Vertex[] vertexs;// 图的顶点
	 private LinkedList<Integer>  adj[];//邻接表中用来存储顶点之间的连接关系，创建了一个 linkedlist的数组，还要初始化
	 //初始化
	 @SuppressWarnings("unchecked")
	public Graph(int size) {
		 this.size=size;
		 vertexs=new Vertex[size];
		 adj=new LinkedList[size];
		 for(int i=0;i<size;i++) {
			 vertexs[i]=new Vertex(i);
			 adj[i]=new LinkedList<>();
		 }
		
	}
	 // 无向图，添加边的信息,一条边存两次
	public void addEdge(int s,int t) {
		adj[s].add(t);
		adj[t].add(s);
	}
	//广度优先遍历
	public void bfs(int s,int t) {
		if(s==t) {
			return ;
		}
		boolean[] visited=new boolean[size];
		visited[s]=true;
		Queue<Integer> queue= new Queue<>();
		queue.enqueue(s);
		int[] prev=new int[size];
		for(int i=0;i<size;i++) {
			prev[i]=-1;
		}
		while(!queue.isEmpty()) {
			int front=queue.dequeue();
			for(int i=0;i<adj[front].size();i++) {
				int current=adj[front].get(i);
				if(visited[current]!=true) {
					visited[current]=true;
					prev[current]=front;
					if(t==current) {
						print(prev, s, t);
						return ;
					}else {
						queue.enqueue(current);
					}
				}
				
			}
		}
	}
	//深度优先遍历--非递归实现
	public  void dfs(int s,int t) {
		if(s==t) {
			return ;
		}
		//初始化
		boolean[] visited=new boolean[size];
		visited[s]=true;
		//确定是否已经找到
		boolean found=false;
		
		int[] prev=new int[size];
		for(int i=1;i<size;i++) {
			prev[i]=-1;
		}
	}
	// 由于prev中存储的是逆序的，所以采用递归反序打印
	public void print(int[] prev,int s,int t) {
		if(prev[t]!=-1&&s!=t) {
			print(prev, s, prev[t]);
			return ;
		}
		System.out.print(t+"->");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
