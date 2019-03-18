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
