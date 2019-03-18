package algo;

public class BinarySearchTree {
	/**
	 * ������������֧�ֿ��ٵĲ��ҡ����롢ɾ������
	 * ���������Ҫ�������е�����һ���ڵ㣬��������ÿ���ڵ�
	 * ֵ��ҪС������ڵ��ֵ����������ÿ���ڵ��ֵ��Ҫ��������ڵ��ֵ
	 */
	// ���ĸ��ڵ�
	private Node tree;
	// ����������Ĳ��Ҳ��� ʱ�临�Ӷ�Ϊ O(logn)
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
	// ����������Ĳ������ ��ʱ�临�Ӷ�ҲΪO(logn)
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
	//�����������ɾ������
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
