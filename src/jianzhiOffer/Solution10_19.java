package jianzhiOffer;

public class Solution10_19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution10_19 solution10_19=new Solution10_19();
		System.out.println(solution10_19.RectCover1(5));
	}
	/**
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
     * 变态跳台阶
     * @param n
     * @return
     */
}
