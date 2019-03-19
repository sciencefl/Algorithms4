package algo;

public class BinarySearchTree {
	/**
	 * 二叉搜索树，支持快速的查找、插入、删除操作
	 * 二叉查找树要求，在树中的任意一个节点，其左子树每个节点
	 * 值，要小于这个节点的值，其右子树每个节点的值，要大于这个节点的值
	 */
	// 树的根节点
	private Node tree;
	// 二叉查找树的查找操作 时间复杂度为 O(logn)
	public Node find(int data) {
		Node pNode=tree;
		while(pNode!=null) {
			if(data>pNode.data) {
				pNode=pNode.right;
			}else if(data<pNode.data) {
				pNode=pNode.left;
			}else {
				return pNode;
			}
		}
		return null;
	}
	// 二叉查找树的插入操作 ，时间复杂度也为O(logn)
	public Node insert(int data) {
		Node pNode=tree;
		if(pNode==null) {
			return new Node(data);
		}
		while(pNode!=null) {
			if(data>pNode.data) {
				if(pNode.right==null) {
					pNode.right=new Node(data);
					return tree;
				}
				pNode=pNode.right;
			}else  if(data<=pNode.data) {
				if(pNode.left==null) {
					pNode.left=new Node(data);
					return tree;
				}
				pNode=pNode.left;
			}
		}
		return tree;
	}
	//二叉查找树的删除操作
	public void  delete(int data) {
		//由于删除节点需要前置节点，所以需要两个节点存储
		//pNode 用来存储节点
		Node pNode=tree;
		Node pNodePre=null;// 用来存储前置节点
		//要删除节点，先找到该节点
		while(pNode!=null&&pNode.data!=data) {
			pNodePre=pNode;  //保存前置节点
			if(data>pNode.data) {
				pNode=pNode.right;
			}else {
				pNode=pNode.left;
			}
		}
		//没有找到节点或者树为空的情况下
		if(pNode==null) {
			return ;
		}
		//整体删除节点p
		//情况1：该节点既有左子树，又有右子树，找到右子树的最小值节点pMin，替换pNode然后删除pMin
		if(pNode.left!=null&&pNode.right!=null) {
			Node pMin=pNode.right;
			Node pMinPre=pNode;
			//找到最小值节点pMin
			while(pMin.left!=null) {
				pMinPre=pMin;
				pMin=pMin.left;
			}
			pNode.data=pMin.data;
			pNode=pMin;
			pNodePre=pMinPre;
		}
		//情况2：pNode只有一个子节点或者无子节点
		Node child=null;
		if(pNode.left!=null) {
			child=pNode.left;
		}
		else if(pNode.right!=null) {
			child=pNode.right;
		}
		else {
			child =null;
		}
		// 统一删除节点
		//当删除根节点的时候
		if(pNodePre==null) {
			tree=child;
		}
		if(pNodePre.left==pNode) {
			pNodePre.left=child;
		}else {
			pNodePre.right=child;
		}
	}
	public static class Node{
		private int data;
		private Node left;
		private Node right;
		public Node(int data) {
			this.data=data;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
