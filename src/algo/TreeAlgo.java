package algo;

import java.util.LinkedList;

public class TreeAlgo {
	
	//�ڲ���
	class TreeNode{
		int  val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val=x;
		}
	
	} 
	/**
	 * 	��ת������
	 * 	˼·1.�ȷ�ת���ڵ�������������ٷ�ת���������� �������������͵� �ݹ鷽��
	 * 	��������Էֽ�ΪС���������
	 * 	���������ģ�������˼·��ͬ
	 * 	���ڵݹ���ֹ����
	 * @param root
	 * @return
	 */
	public TreeNode invertTree(TreeNode root) {
		//��0�����ж���Ч��
		if(root==null) {
			return root;
		}
		if(root.left==null&&root.right==null) {
			return root;
		}
		TreeNode tempNode=new TreeNode(0);
		tempNode=root.right;
		root.right=root.left;
		root.left=tempNode;
		invertTree(root.left);
		invertTree(root.right);
        return root;
    }
	/**
	 * 	�ǵݹ�汾����α���
	 * @param root
	 * @return
	 */
	public TreeNode invertTreeLevel(TreeNode root) {
		//��0�����ж���Ч��
		if(root==null) {
			return root;
		}
		LinkedList<TreeNode> list=new LinkedList<>();
		list.add(root);
		while(!list.isEmpty()) {
			TreeNode tempNode=list.removeFirst(); //ȡ����һ���ڵ�
			if(tempNode.left==null&&tempNode.right==null) {
				continue;
			}
			TreeNode temp=tempNode.left;
			tempNode.left=tempNode.right;
			tempNode.right=temp;
			if(tempNode.left!=null) {
				list.add(tempNode.left);
			}
			if(tempNode.right!=null) {
				list.add(tempNode.right);
			}
		}
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
