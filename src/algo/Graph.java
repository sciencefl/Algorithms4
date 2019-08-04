package algo;


import java.util.LinkedList;
import java.util.Queue;

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
		Queue<Integer> queue= new LinkedList<>();
		queue.offer(s);
		int[] prev=new int[size];
		for(int i=0;i<size;i++) {
			prev[i]=-1;
		}
		while(!queue.isEmpty()) {
			int front=queue.poll();
			for(int i=0;i<adj[front].size();i++) {
				int current=adj[front].get(i);
				if(visited[current]!=true) {
					visited[current]=true;
					prev[current]=front;
					if(t==current) {
						print(prev, s, t);
						return ;
					}else {
						queue.offer(current);
					}
				}
				
			}
		}
	}
	//深度优先遍历--递归实现
    //确定是否已经找到
    boolean found=false;
	public  void dfs(int s,int t) {
		if(s==t) {
		    found=true;
			return  ;
		}
		//初始化
		boolean[] visited=new boolean[size];
		visited[s]=true;
		int[] prev=new int[size];
		for(int i=1;i<size;i++) {
			prev[i]=-1;
		}
		reDfs(visited,s,t,prev);
		print(prev,s,t);
	}
	public  void reDfs(boolean[] visited,int s,int t,int[] prev){
        if(found==true){
            return ;
        }
        visited[s]=true;
        if(s==t){
            found=true;
            return;
        }
        for(int i=0;i<adj[s].size();i++){
            int current=adj[s].get(i);
            if(!visited[current]){
                prev[current]=s;
                reDfs(visited,current,t,prev);
            }
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
