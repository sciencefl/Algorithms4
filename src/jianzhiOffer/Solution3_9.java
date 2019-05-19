package jianzhiOffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class Solution3_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution3_9 solution=new Solution3_9();
		int[] pre= {1,2,4,7,3,5,6,8};
		int[] in ={4,7,2,1,5,3,8,6};
		TreeNode headNode=solution.reConstructBinaryTree(pre, in);
		int k=solution.Fibonacci(6);
		System.out.println(k);
	}
    public boolean Find(int target, int [][] array) {
    	boolean found=false;
    	if(array==null) {
    		return  found;
    	}
    	int rows=array.length;
    	int columns=array[0].length;
    	// 从右上角开始寻找，因为从左上角 和右下角不能缩小范围
    	int row=0;
    	int column=columns-1;
    	while(row<rows&&column>=0) {
    		if(array[row][column]==target) {
    			found=true;
    			break;
    		} else if(array[row][column]>target) {
    			column--;
    		} else {
    			row++;
    		}
    	}
    	return found;
    }
    /**
     * 剑指offer 替换空格
     */
    public String replaceSpace(StringBuffer str) {
    	/**
    	 * 两种方法，第一种就是从前到后遍历字符串，遇到空格就替换，这样的有O(n)个空格的，时间复杂度为O(n2)
    	 * 第二就是从前到后一次遍历，取出空格数量，然后从后向前移动，这样每个字符只是移动一次，这样就是O(n)
    	 */
    	//第0步，检验边界
    	if(str==null||str.length()==0) {
    		return str.toString();
    	}
    	//第1步： 遍历字符串，查看空格数量,并扩容
    	int orgionalNum=str.length()-1;
    	for(int i=0;i<=orgionalNum;i++) {
    		if(str.charAt(i) == ' ') {
    			str.append("  ");
    		}
    	}
    	//第二步，进行复制
    	int newNum=str.length()-1;
    	while(orgionalNum>=0) {
    		if(str.charAt(orgionalNum)==' ') {
    			str.setCharAt(newNum--,'0' );
    			str.setCharAt(newNum--,'2' );
    			str.setCharAt(newNum--,'%' );
    		}else {
    			str.setCharAt(newNum--,str.charAt(orgionalNum));
    		}
    		orgionalNum--;
    	}
    	
    	return  str.toString();	
    }
    /**
     * 从尾到头打印链表（反转链表）, 要询问面试官是否可以修改输入的数据
     * 由于需要从头到尾遍历，又要从尾到头输出，是栈结构
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arraIntegers=new ArrayList<>();
        Stack<Integer> stack=new Stack<Integer>();
        while(listNode!=null) {
        	stack.push(listNode.val);
        	listNode=listNode.next;
        }
        while(!stack.isEmpty()) {
        	arraIntegers.add(stack.pop());
        }
        return arraIntegers;
    }
    /**
     * 重建二叉树，利用二叉树的前序和中序遍历来还原二叉树
     */
    Map<Integer,Integer> map=new HashMap<Integer, Integer>();
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
    	for(int i=0;i<in.length;i++) {
    		map.put(in[i],i);
    	}
        return reConstructBinaryTree2(pre,0,pre.length-1,0);
    }
    public TreeNode reConstructBinaryTree2(int[] pre,int preL,int preR,int inL) {
    	if(preL>preR) {
    		return null;
    	}
    	TreeNode headNode=new TreeNode(pre[preL]);
    	int indexL=map.get(pre[preL]);
    	int leftTreeSize=indexL-inL;
    	headNode.left=reConstructBinaryTree2(pre,preL+1,preL+leftTreeSize,inL);
    	headNode.right=reConstructBinaryTree2(pre,preL+leftTreeSize+1,preR,inL + leftTreeSize + 1);
    	return headNode;
    }
    /**
     * 用两个栈来实现队列  ，stack1 用来输入in,stack2用来输出out
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
    	while(!stack2.isEmpty()) {
    		stack1.push(stack2.pop());
    	}
        stack1.push(node);
    }
    
    public int pop() {
    	while(!stack1.isEmpty()) {
    		stack2.push(stack1.pop());
    	}
    	if(stack2.isEmpty()) {
    		System.out.println("Queue is empty");
    	}
    	return stack2.pop();
    }
    /**
     *  二叉树中序的下一个节点
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
    	//第一种情况，如果该节点存在右子节点，那么返回该右子节点的最左节点
    	if(pNode.right!=null) {
    		pNode=pNode.right;
    		while(pNode.left!=null) {
    			pNode=pNode.left;
    		}
    	} else {
    		while( pNode.next!=null&&pNode.next.left!=pNode) {
    			pNode=pNode.next;
    		}
    		if(pNode.next==null) {
    			pNode=null;
    		}else {
    			pNode=pNode.next;
			}
    		
    	}
    	//第二种情况，如果该节点没有右子节点，那么返回 第一个链接左子树 包含该节点的节点
        return pNode;
    }
    /**
     * 斐波那契数列
     */
    public int Fibonacci(int n) {
    	// 当子问题之间存在重复的时候，可以采用自下向上的方法计算，来提高效率
    	if(n==0) {
    		return  0;
    	}
    	if(n==1) {
    		return 1;
    	}
    	int fibOne=0;
    	int fibTwo=1;
    	int fibTemp=0;
    	for(int i=2;i<=n;i++) {
    		fibTemp=fibTwo;
    		fibTwo=fibOne+fibTwo;
    		fibOne=fibTemp;
    	}
    	return fibTwo;
    }
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
}
class TreeLinkNode {

    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
