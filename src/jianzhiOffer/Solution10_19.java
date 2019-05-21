package jianzhiOffer;

import java.lang.reflect.Array;
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
}
