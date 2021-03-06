package jianzhiOffer;

import java.util.Arrays;

public class Solution10_19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array= {3,4,5,6,1,2};
		Solution10_19 solution10_19=new Solution10_19();
		System.out.println(solution10_19.minNumberInRotateArray(array));
		System.out.println(solution10_19.NumberOf2(9));
		System.out.println(solution10_19.Power(2, 4));
		solution10_19.reOrderArray(array);
		System.out.println(Arrays.toString(array));
		//System.out.println(solution10_19.RectCover1(5));
	}
	/**   ：动态规划
	 * 矩形覆盖
	 * 思路，有两种方式，当第一步是竖着放的时候，那么要解决 2*（n-1）个位置的摆放
	 * 当第一步是横着放的时候，要解决 2*（n-2）个位置的摆放
	 * 所以 f(n)= 1   n=1
	 * 			2   n=2
	 * 			f(n-1)+f(n-2)
	 */
    public int RectCover1(int target) {
    	//分治算法
    	if(target<=2) {
    		return target;
    	}else
    		return RectCover1(target-1)+RectCover1(target-2);
    }
    public int RectCover2(int target) {
    	//动态规划，自底向上的思路解决问题，每个上层的问题都依赖，子问题给出最优解
    	if(target<=2) {
    		return target;
    	}
    	int count=0;
    	int count1=1;
    	int count2=2;
    	for(int i=3;i<=target;i++) {
    		count=count2;
    		count2=count1+count2;
    		count1=count;
    	}
    	return count2;
    }
    /**
     * 旋转数组的最小数组  本质：二分查找的变形
     * 二分查找的注意点
     * 1.循环退出条件
     * low<=high
     * 2.mid的取值 ：mid=low+(high-low)/2: low+((high-low)>>1)
     * 3.low和 high的更新：  low=mid+1； high=mid-1；
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {
    	int low=0;
    	int high=array.length-1;
    	int minNum=array[high];
    	while(low<=high) {
    		int mid=low+((high-low)>>1);
    		if(array[mid]>minNum) {
    			low=mid+1;
    		}else if(array[mid]<minNum) {
    			high=mid-1;
    			minNum=array[mid];
    		}else {
    			break;
    		}
    		
    	}
        return minNum;
    }
    /**
     * 二进制中1的个数   考察位运算
     * @param n
     * @return
     */
    public int NumberOf2(int n) {
    	int  count=0;
    	int flag=1;
    	while(flag!=0) {
    		if((n&flag)!=0) {
    			count++;
    		}
    		flag=flag<<1;
    	}
    	return count;
    }
    public int NumberOf3(int n) {
    	//思路：把一个整数减去1在和原来的数做与运算，相当于把原来的的整数的二进制数的最右边的 1 变为0
    	int count=0;
    	while(n!=0) {
    		count++;
    		n=(n-1)&n;
    	}
    	return count;
    }
    /** 
     * 数值的 N 次方
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
    	final double  epslion=0.001;
    	if(Math.abs(base-0.0)<epslion&&exponent<0) {
    		System.out.println("Invilid Input");
    	}
    	int unsignedExponent=Math.abs(exponent);
    	double result=PowerWithExponent(base, unsignedExponent);
    	if(exponent>0) {
    		return result;
    	}else 
    		return  1.0/result;
    }
    public double PowerWithExponent(double base, int exponent) {
    	if(exponent==0) {
    		return 1;
    	}else if(exponent==1) {
    		return base;
    	}
    	double result=PowerWithExponent(base, exponent>>1);
    	result*=result;
    	if((exponent&1)==1) {
    		result*=base;
    	}
    	return result;
    }
    public void reOrderArray(int [] array) {
        int oddCount=0;
        for(int i:array) {
        	if(!isEven(i)) {
        		oddCount++;
        	}
        }
        int[] result=array.clone();
        int even=oddCount;
        int odd=0;
        for(int num:result) {
        	if(isEven(num)) {
        		array[even++]=num;
        	}else
        		array[odd++]=num;
        }
        System.out.println(Arrays.toString(array));
    }
    private boolean isEven(int n) {
    	return (n&1)==0;
    }
    /**
              *   返回倒数第K个节点，采用双指针策略, ，考查代码的鲁棒性
     * @param head  
     * @param k
     * @return 
     */
    public ListNode FindKthToTail(ListNode head,int k) {
    	ListNode firstNode=head;
    	ListNode secondNode=head;
    	if(head==null||k==0) {
    		return null;
    	}
    	for(int i=0;i<k-1;i++) {
    		firstNode=firstNode.next;
    		if(firstNode==null) {
    			return null;
    		}
    	}
    	while(firstNode.next!=null) {
    		firstNode=firstNode.next;
    		secondNode=secondNode.next;
    	}
    	return secondNode;
    }
    /**
     * @des  反转链表 
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
    	ListNode preNode=null;
    	ListNode pNode=head;
    	ListNode nextNode=null;
    	while(pNode!=null) {
    		nextNode=pNode.next;
    		pNode.next=preNode;
    		preNode=pNode;
    		pNode=nextNode;	
    	}
    	return preNode;
    }
    /**
     * @  合并有序的链表
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1==null) {
			return list2;
		}
        if (list2==null) {
        	return list1;
        }
        ListNode mergeNode=null;
        if(list1.val<list2.val) {
        	mergeNode=list1;
        	mergeNode.next=Merge(list1.next, list2);
        }else {
			mergeNode=list2;
			mergeNode.next=Merge(list1, list2.next);
		}
        return mergeNode;
    }
    /**
     * @ 树的子结构 考查二叉树的遍历操作  递归和 和循环   1.查找是否有根节点相同的节点，2.查找是否存在子树
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
    	boolean result=false;
    	if(root1==null||root2==null) {
    		return result;
    	}
    	if(root1.val==root2.val) {
    		result=isRoot1HasRoot2(root1,root2);
    	}else {
			result=HasSubtree(root1.left, root2);
			if(!result) {
				result=HasSubtree(root1.right, root2);
			}
		}
        return result;
    }
    public boolean isRoot1HasRoot2(TreeNode root1,TreeNode root2) {
    	boolean result=false;
    	if(root2==null) {
    		return true;
    	}
    	if(root1==null) {
    		return false;
    	}
    	if(root1.val==root2.val) {
    		result=isRoot1HasRoot2(root1.left, root2.left)&&isRoot1HasRoot2(root1.right, root2.right);
    	} else {
			result=false;
		}
    	return result;
    }
}
