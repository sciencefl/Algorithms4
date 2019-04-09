package algo;

import java.util.LinkedList;

public class TreeAlgo {
	
	//内部类
	class TreeNode{
		int  val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val=x;
		}
	
	} 
	/**
	 * 	翻转二叉树
	 * 	思路1.先翻转根节点的左右子树，再翻转左右子树的 左右子树，典型的 递归方法
	 * 	大问题可以分解为小问题来求解
	 * 	除了问题规模以外求解思路相同
	 * 	存在递归终止条件
	 * @param root
	 * @return
	 */
	public TreeNode invertTree(TreeNode root) {
		//第0步，判断有效性
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
	 * 	非递归版本：层次遍历
	 * @param root
	 * @return
	 */
	public TreeNode invertTreeLevel(TreeNode root) {
		//第0步，判断有效性
		if(root==null) {
			return root;
		}
		LinkedList<TreeNode> list=new LinkedList<>();
		list.add(root);
		while(!list.isEmpty()) {
			TreeNode tempNode=list.removeFirst(); //取出第一个节点
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
