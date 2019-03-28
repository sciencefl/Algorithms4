package algo;

import java.util.LinkedList;

import edu.princeton.cs.algs4.Queue;
public class Graph {
	//�ڲ���,�洢ͼ�Ķ���
	public class Vertex{
		int data;
		public Vertex(int data) {
			this.data=data;
		}
	}
	/**
	 * ����ͼ
	 * �ڽӱ�
	 */
	 private int size; // ͼ�Ĵ�С
	 private Vertex[] vertexs;// ͼ�Ķ���
	 private LinkedList<Integer>  adj[];//�ڽӱ��������洢����֮������ӹ�ϵ��������һ�� linkedlist�����飬��Ҫ��ʼ��
	 //��ʼ��
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
	 // ����ͼ����ӱߵ���Ϣ,һ���ߴ�����
	public void addEdge(int s,int t) {
		adj[s].add(t);
		adj[t].add(s);
	}
	//������ȱ���
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
	//������ȱ���
	public  void dfs(int s,int t) {
		
	}
	// ����prev�д洢��������ģ����Բ��õݹ鷴���ӡ
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
