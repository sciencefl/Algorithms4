package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Classname GreedyAlgo
 * @Description TODO
 * @Date 2019/8/2 15:44
 * @Created by flzhang
 */
public class GreedyAlgo {
    public static void main(String[] args) {

    }

    /**
     * leetcode 121 买卖股票的最佳时间
     *  限制值：只能选一次
     *  期望值： 前一个数与后一个数的差的最大
     *  测试用例：
     *  没有完成交易 数组少与一个值  或者所有的值都小于前面的数，返回 0
     *  思路：当前节点都跟前面的最小值比，对限定值贡献一定的情况下，期望值最大
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices.length<=1){
            return 0;
        }
        int minIn=prices[0];
        int maxProfit=0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit=prices[i]-minIn>maxProfit?prices[i]-minIn:maxProfit;
            minIn=prices[i]-minIn>0?minIn:prices[i];
        }
        return maxProfit;
    }

    /**
     * leetcode 392 判断是否是子序列 判断s是否是t的子序列
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int index=-1;
        for(char c:s.toCharArray()){
            index=t.indexOf(c,index+1);
            if(index==-1){
                return false;
            }
        }
        return true;
    }

    /**
     * leetcode 455 分发饼干
     * 典型的贪心算法，
     * 限制值：饼干的尺寸一定的情况下
     * 期望值： 满足孩子的个数
     * 模型： 在相同尺寸饼干优先选择胃口小的孩子。
     * @param g  孩子胃口的 数组
     * @param s  饼干的尺寸数组
     * @return   能够满足孩子的数量
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count=0;
        for(int i=0,j=0;i<s.length&&j<g.length;i++){
            if(s[i]>=g[j]){
                count++;
                j++;
            }
        }
        return count;
    }

    /**
     * leetcode 435 不重叠区间  区间覆盖
     * 思想： 求出不重叠区间的数量，然后用总数减去不重叠的数量，就是要减少的数量
     * 贪心：最坐的数为lmin ，最右的数为rmax,就是从lmin-rmax中选择区间，尽可能多的不重复
     * 每次选择左端点与前面右端点不重合的，后端点尽量小的，这样以让给后面的区间更大，选择更多。
     * @param intervals 二维数组，每个数组都代表一个区间
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length<=0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int count=1;
        int end=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<end){
                continue;
            }
            end=intervals[i][1];
            count++;
        }
        return intervals.length-count;
    }
}
