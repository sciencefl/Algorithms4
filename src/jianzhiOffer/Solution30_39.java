package jianzhiOffer;

import java.util.HashMap;

public class Solution30_39 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution30_39 solution30_39=new Solution30_39();
		int i=solution30_39.FirstNotRepeatingChar("abcd345");
		int[] abc=new int[100];
		int[] array={1,2,3,3,3,3};
		int m = solution30_39.bsearch(array,4);
		System.out.println("位置为"+m);
		abc['a']=1111;
//		for(int j:abc) {
//			System.out.println('a');
//		}
	}
	/**
	 *  丑数
	 */
    public int GetUglyNumber_Solution(int N) {
	    if (N <= 6)
	        return N;
	    int i2 = 0, i3 = 0, i5 = 0;
	    int[] dp = new int[N];
	    dp[0] = 1;
	    for (int i = 1; i < N; i++) {
	        int next2 = dp[i2] * 2, next3 = dp[i3] * 3, next5 = dp[i5] * 5;
	        dp[i] = Math.min(next2, Math.min(next3, next5));
	        if (dp[i] == next2)
	            i2++;
	        if (dp[i] == next3)
	            i3++;
	        if (dp[i] == next5)
	            i5++;
	    }
	    return dp[N - 1];
    }
    /**
     *  第一次出现的字符
     */
    public int FirstNotRepeatingChar(String str) {
        //由于字符数量有限，所以采用数组就可以了
        int[]  cnt=new int[256];
        for(int i=0;i<str.length();i++){
            cnt[str.charAt(i)]++;
            System.out.println(str.charAt(i));
        }
        for(int i=0;i<str.length();i++){
            if(cnt[str.charAt(i)]==1){
                return i;
           }
        }
        return -1;
    }
    /**
     *  两个链表的第一个公共节点
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;
        while (l1 != l2) {
            l1 = (l1 == null) ? pHead2 : l1.next;
            l2 = (l2 == null) ? pHead1 : l2.next;
        }
        return l1;
    }

	/**
	 * 坑点： 当array中没有的时候要返回0   采用HashMap的方式时间复杂度为O(n) 空间复杂度为O(n)，没有利用排序的特性
	 * @param array
	 * @param k
	 * @return
	 */
	public int GetNumberOfK(int [] array , int k) {
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<array.length;i++){
			if(map.containsKey(array[i])){
				map.put(array[i],map.get(array[i])+1);
			}else{
				map.put(array[i],1);
			}
		}
		return map.get(k)==null?0:map.get(k);
	}
	public int GetNumberOfK2(int [] array , int k) {
		int first=bsearch(array,k);
		int last=bsearch(array,k+1);
		return last-first;
	}

	/**
	 * 查找最后一个不大于 value的数组下标
	 * @param array
	 * @param value
	 * @return
	 */
	public int bsearch(int[] array,int value){
		if(array==null||array.length==0){
			return -1;
		}
		int low=0;
		int high=array.length-1;
		while(low<=high){
			int mid=low+((high-low)>>1);
			if(array[mid]<value){
				if(mid==array.length-1||array[mid+1]>=value){
					return mid;
				}
				low=mid+1;
			}else if(array[mid]>value) {
				high = mid - 1;
			}else {
				high=mid-1;
			}
		}
		return -1;
	}

	/**
	 *  求二叉树的深度 ，用递归即可，非常简洁
	 * @param root
	 * @return
	 */
	public int TreeDepth(TreeNode root) {
		if( root == null ){
			return 0;
		}
		int leftDepth = TreeDepth(root.left);
		int rightDepth = TreeDepth(root.right);
		return leftDepth>rightDepth?(leftDepth+1):(rightDepth+1);
	}

	/**
	 * 判断是否为平衡二叉树
	 * @param root
	 * @return
	 */
	public boolean IsBalanced_Solution(TreeNode root) {
		if(root==null){
			return true;
		}
		int leftDepth = TreeDepth( root.left);
		int rightDepth = TreeDepth(root.right);
		int diff=rightDepth-leftDepth;
		if(diff>1||diff<-1){
			return false;
		}
		return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
	}

	/**
	 * 数组中只出现一次的数字
	 * @param array
	 * @param num1
	 * @param num2
	 */
	//num1,num2分别为长度为1的数组。传出参数
	//将num1[0],num2[0]设置为返回结果
	public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
		int diff=0; //用来存储各个数组异或的结果
		for (int i : array) {
			diff^=array[i];
		}
		diff&=-diff; //此等操作是为了获得diff中最左侧不为0的数字
		for(int j:array){
			if((array[j]&diff)==0){
				num1[0]^=array[j];
			}else {
				num2[0]^=array[j];
			}
		}
	}
}
