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
    	// �����Ͻǿ�ʼѰ�ң���Ϊ�����Ͻ� �����½ǲ�����С��Χ
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
     * ��ָoffer �滻�ո�
     */
    public String replaceSpace(StringBuffer str) {
    	/**
    	 * ���ַ�������һ�־��Ǵ�ǰ��������ַ����������ո���滻����������O(n)���ո�ģ�ʱ�临�Ӷ�ΪO(n2)
    	 * �ڶ����Ǵ�ǰ����һ�α�����ȡ���ո�������Ȼ��Ӻ���ǰ�ƶ�������ÿ���ַ�ֻ���ƶ�һ�Σ���������O(n)
    	 */
    	//��0��������߽�
    	if(str==null||str.length()==0) {
    		return str.toString();
    	}
    	//��1���� �����ַ������鿴�ո�����,������
    	int orgionalNum=str.length()-1;
    	for(int i=0;i<=orgionalNum;i++) {
    		if(str.charAt(i) == ' ') {
    			str.append("  ");
    		}
    	}
    	//�ڶ��������и���
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
     * ��β��ͷ��ӡ������ת����, Ҫѯ�����Թ��Ƿ�����޸����������
     * ������Ҫ��ͷ��β��������Ҫ��β��ͷ�������ջ�ṹ
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
     * �ؽ������������ö�������ǰ��������������ԭ������
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
     * ������ջ��ʵ�ֶ���  ��stack1 ��������in,stack2�������out
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
     *  �������������һ���ڵ�
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
    	//��һ�����������ýڵ�������ӽڵ㣬��ô���ظ����ӽڵ������ڵ�
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
    	//�ڶ������������ýڵ�û�����ӽڵ㣬��ô���� ��һ������������ �����ýڵ�Ľڵ�
        return pNode;
    }
    /**
     * 쳲���������
     */
    public int Fibonacci(int n) {
    	// ��������֮������ظ���ʱ�򣬿��Բ����������ϵķ������㣬�����Ч��
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
