package jianzhiOffer;

import java.util.ArrayList;

public class Solution30_39 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution30_39 solution30_39=new Solution30_39();
		int i=solution30_39.FirstNotRepeatingChar("abcd345");
		int[] abc=new int[100];
		abc['a']=1111;
		for(int j:abc) {
			System.out.println('a');
		}
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
}
