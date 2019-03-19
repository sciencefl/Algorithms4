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
	public void  delete(int data) {
		//����ɾ���ڵ���Ҫǰ�ýڵ㣬������Ҫ�����ڵ�洢
		//pNode �����洢�ڵ�
		Node pNode=tree;
		Node pNodePre=null;// �����洢ǰ�ýڵ�
		//Ҫɾ���ڵ㣬���ҵ��ýڵ�
		while(pNode!=null&&pNode.data!=data) {
			pNodePre=pNode;  //����ǰ�ýڵ�
			if(data>pNode.data) {
				pNode=pNode.right;
			}else {
				pNode=pNode.left;
			}
		}
		//û���ҵ��ڵ������Ϊ�յ������
		if(pNode==null) {
			return ;
		}
		//����ɾ���ڵ�p
		//���1���ýڵ�������������������������ҵ�����������Сֵ�ڵ�pMin���滻pNodeȻ��ɾ��pMin
		if(pNode.left!=null&&pNode.right!=null) {
			Node pMin=pNode.right;
			Node pMinPre=pNode;
			//�ҵ���Сֵ�ڵ�pMin
			while(pMin.left!=null) {
				pMinPre=pMin;
				pMin=pMin.left;
			}
			pNode.data=pMin.data;
			pNode=pMin;
			pNodePre=pMinPre;
		}
		//���2��pNodeֻ��һ���ӽڵ�������ӽڵ�
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
		// ͳһɾ���ڵ�
		//��ɾ�����ڵ��ʱ��
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
