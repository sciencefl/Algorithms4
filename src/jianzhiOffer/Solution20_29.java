package jianzhiOffer;

import java.util.*;

public class Solution20_29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution20_29 solution11_19=new Solution20_29();
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
        	if(sequence[i]>sequence[end]&&!flag) {
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
        if(pHead==null) {
        	return null;
        }
    	RandomListNode head=new RandomListNode(pHead.label);
        // 用一个MAP来存储备忘录
        Map<Integer, RandomListNode> map =new HashMap<>();
        //第一步通过next指针得到 N'
        RandomListNode pHeadTemp=pHead;
        RandomListNode headTemp=head;
        map.put(headTemp.label, headTemp);
        while(pHeadTemp.next!=null) {
        	RandomListNode tempNode=new RandomListNode(pHeadTemp.next.label);
        	headTemp.next=tempNode;
        	headTemp=headTemp.next;
        	pHeadTemp=pHeadTemp.next;
        	map.put(tempNode.label, tempNode);
        }
        headTemp.next=null;
        //第二步，寻找身边的人
        headTemp=head;
        pHeadTemp=pHead;
        while(pHeadTemp.next!=null) {
        	if(pHeadTemp.random!=null) {
        		headTemp.random=map.get(pHeadTemp.random.label);
        	}
        	pHeadTemp=pHeadTemp.next;
        	headTemp=headTemp.next;
        }
        return head;   
    }
    /**
     * 二叉搜索树与双向链表 , java 传参的问题，值传递还是引用传递
     * Java中传参都是值传递，如果是基本类型，就是对值的拷贝，如果是对象，就是对引用地址的拷贝
     */
    private TreeNode pre = null;
    private TreeNode head = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        //中序遍历的变形 ，对于一个节点来说，比它小的节点在左子树，\
    	inOrder(pRootOfTree);
    	return head;
    }
    public void  inOrder(TreeNode root) {
    	if(root==null) {
    		return;
    	}
    	inOrder(root.left);
    	if(root.left==null&&head==null) {
    		head=root;
    	}
    	if(pre!=null) {
    		root.left=pre;
    		pre.right=root;
    	}
    	pre=root;
    	inOrder(root.right);
    }
    /**
     * 字符串的排列,
     */
    private ArrayList<String> ret = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if (str.length() == 0)
            return ret;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backtracking(chars, new boolean[chars.length], new StringBuilder());
        return ret;
    }

    private void backtracking(char[] chars, boolean[] hasUsed, StringBuilder s) {
        if (s.length() == chars.length) {
            ret.add(s.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (hasUsed[i])
                continue;
            if (i != 0 && chars[i] == chars[i - 1] && !hasUsed[i - 1]) /* 保证不重复 */
                continue;
            hasUsed[i] = true;
            s.append(chars[i]);
            backtracking(chars, hasUsed, s);
            s.deleteCharAt(s.length() - 1);
            hasUsed[i] = false;
        }
    }
    public void swap(int i,int j,char[] strChar) {
    	char temp=strChar[i];
    	strChar[i]=strChar[j];
    	strChar[j]=temp;
    }
    /**
     * @ 数组中出现次数超过一半的数字
     */
    public int MoreThanHalfNum_Solution(int [] array) {
    	if(array==null||array.length==0) {
    		return 0;
    	}
    	boolean flag=false;
       Map<Integer,Integer> map = new  HashMap<>();
       int count=array.length;
       for(int i=0;i<array.length;i++) {
    	   if(map.containsKey(array[i])) {
    		  map.put(array[i], map.get(array[i])+1);
    		  if(map.get(array[i])*2>=count) {
    			  flag=true;
    			  return array[i];
    		  }
    	   }
    	   map.put(array[i], 1);
       }
       return 0;
    }
    /**
     * @连续子数组的最大和
     */
    public int FindGreatestSumOfSubArray(int[] array) {
    	int greatSum=array[0];
    	int sum=0;
    	for(int i=0;i<array.length;i++) {
    		if(sum<=0) {
    			sum=array[i];
    		}else {
				sum+=array[i];
			}
    		if(sum>greatSum) {
    			greatSum=sum;
    		}
    	}
    	return greatSum;
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
