package jianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;

import edu.princeton.cs.algs4.Stack;

public class Solution11_19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution11_19 solution11_19=new Solution11_19();
		TreeNode root=null;
		ArrayList<Integer> arrayList=solution11_19.PrintFromTopToBottom(root);
		System.out.println(arrayList);
		int[] sequence= {};
		System.out.println(solution11_19.VerifySquenceOfBST(sequence));
	}
	/**
	 * 镜像二叉树
	 *  
	 */
    public void Mirror(TreeNode root) {
        if(root==null) {
        	return ;
        }
        TreeNode tempNode=root.left;
        root.left=root.right;
        root.right=tempNode;
        Mirror(root.left);
        Mirror(root.right);
    }
    /**
     * 顺时针打印矩阵
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        //分为上下左右四个方向的遍历
        int r1=0;
        int r2=matrix.length-1;
        int c1=0;
        int c2=matrix[0].length-1;
        
        while(r1<=r2&&c1<=c2) {
        	//以下代码考察鲁棒性， 考察逻辑思维的缜密程度
        	for(int i=c1;i<=c2;i++) {
        		arrayList.add(matrix[r1][i]);
        	}
        	for(int i=r1+1;i<=r2;i++) {
        		arrayList.add(matrix[i][c2]);
        	}
        	if(r1!=r2) {
        		for(int i=c2-1;i>=c1;i--) {
        			arrayList.add(matrix[r2][i]);
        		}
        	}
        	if(c1!=c2) {
        		for(int i=r2-1;i>r1;i--) {
        			arrayList.add(matrix[i][c1]);
        		}
        	}
        	r1++;r2--;c1++;c2--;	
        }
        return arrayList;
    }
    /**
     * 包含
     */
    Stack<Integer> stack1= new Stack<>();
    Stack<Integer> stackMin=new Stack<>(); 
    public void push(int node) {
        stack1.push(node);
        if(stackMin.isEmpty()){
            stackMin.push(node);
        }else{
            int min=stackMin.peek();
            if(node<min){
                stackMin.push(node);
            }else {
                stackMin.push(min);
            }
        }
    }
    public void pop() {
       stack1.pop();
       stackMin.pop();
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int min() {
        return stackMin.peek();
    }
    /**
     * 栈的压入、弹出序列
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
    	if(pushA==null|| pushA.length==0) {
    		return false;
    	}
    	if(popA==null||popA.length==0) {
    		return true;
    	}
    	Stack<Integer> dataStack=new Stack<>();
    	int j=0;
    	for(int i=0;i<pushA.length;i++) {
    		dataStack.push(pushA[i]);
    		while(dataStack.peek()==popA[j]) {
    			dataStack.pop();
    			j++;
    		}
    	}
    	return dataStack.isEmpty();
    }
    /**
     *  从上往下打印二叉树（二叉树的层次遍历）
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    	LinkedList<TreeNode> linkedlist =new LinkedList();
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(root==null)
        	return arrayList;
        linkedlist.add(root);
        while(!linkedlist.isEmpty()) {
        	TreeNode tempNode=linkedlist.poll();
        	arrayList.add(tempNode.val);
        	if(tempNode.left!=null) {
        		linkedlist.add(tempNode.left);
        	}
        	if(tempNode.right!=null) {
        		linkedlist.add(tempNode.right);
        	}
        }
        return arrayList;
    }
    /**
     * 二叉搜索树的后续遍历序列
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
    	if(sequence==null||sequence.length==0) {
    		return false;
    	}
    	return VerifySubSeqOfBST(0, sequence.length-1, sequence);

    }
    public boolean VerifySubSeqOfBST(int start,int end,int[] sequence) {
        int mid=end;// 表示右子树的第一个节点
        boolean flag=false;
        if(end-start<=1) { // 如果这个左子树只有一个节点或者没有节点，直接返回true；
        	return true;
        }
        for(int i=start;i<end;i++) {
        	if(sequence[i]>sequence[end]&&flag==false) {
        		mid=i;
        		flag=true;
        	}
        	if(sequence[i]<sequence[end]&&flag) {
        		return false;
        	}
        }
        boolean left=VerifySubSeqOfBST(start,mid-1, sequence);
        boolean right=VerifySubSeqOfBST(mid, end-1, sequence);
        return left&&right;
    }
    /**
     *  二叉树中和为某一值的路径::没有弄懂
     */
    ArrayList<ArrayList<Integer>> listAll=new ArrayList<>();
    ArrayList<Integer> list=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
    	if(root==null) {
    		return listAll;
    	}
    	list.add(root.val);
    	if(root.val==target&&root.left==null&&root.right==null) {
    		listAll.add(new ArrayList<>(list));
    	}
    	target-=root.val;
    	FindPath(root.left, target);
    	FindPath(root.right, target);
   		list.remove(list.size()-1);
        return listAll;
    }
    /**
     * 复杂链表的复制
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead)
    {
        RandomListNode head=new RandomListNode(0);
        return head;
        
    }
}
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
