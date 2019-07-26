package jianzhiOffer;

import java.util.ArrayList;

/**
 * @Classname Solution40_49
 * @Description 题解
 * @Date 2019/7/26 20:10
 * @Created by flzhang
 */
public class Solution40_49 {
    public static void main(String[] args) {
        Solution40_49 solution40_49=new Solution40_49();
 //       String s = solution40_49.ReverseSentence("     I am a Student.     ");
        String s = solution40_49.LeftRotateString("ab c XYZdef",3);
        System.out.println(s);
    }

    /**
     * 和为S的连续正整数序列，本题中可以从1,2开始，如果小了，就高位增加，如果大了，就低位减少，
     * 当在数组数组中求两数和为S的两个数时候，采用的是从前后两个指针，分别向中间探索，这样时间复杂度为O(logn)
     * @param sum 和s
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        int start = 1,end = 2;
        int curSum = 3;
        while(end<((1+sum)>>1)){
            if(curSum>sum){
                curSum-=start;
                start++;
            }else if(curSum<sum){
                end++;
                curSum+=end;
            }else {
                ArrayList<Integer> list = new ArrayList<>();
                for(int i = start ; i <= end ; i++) {
                    list.add(i);
                }
                arrayLists.add(list);
                curSum-=start;
                start++;
                end++;
                curSum+=end;
            }
        }
        return arrayLists;
    }

    /**
     *  翻转单词顺序列
     *  首先翻转单词，再翻转整个字符串
     * @param str
     * @return
     */
    public String ReverseSentence(String str) {
        // 第一步, 检查状态
        if(str==null||str==""){
            return null;
        }
        // 第二步，翻转每个单词
        char[] array=str.toCharArray();
        int start=0,end;
        for (int i = 0; i <= array.length; i++) {
            if(i==array.length||array[i]==' '){ // 坑点在于最后一个单词如果是遇不到 " "的
                end=i-1;
                Reverse(array,start,end);
                start=i+1;
            }
        }
        Reverse(array,0,array.length-1);
         return new String(array);
    }
    public  void Reverse(char[] array,int i,int j){
        while(i<j){
            char temp=array[i];
            array[i]=array[j];
            array[j]=temp;
            i++;
            j--;
        }
    }

    /**
     *  左旋转字符串 n位
     *  相当于 翻转两个单词，先将两个单词分别反转，然后再整个字符串翻转，以达到效果
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str,int n) {
        if(str==null || str==" ") {
            return null;
        }
        if(n > str.length()){
            return str;  // 不合理的地方，大于str.length() 不应该是 取余数进行吗
        }
        char[] array=str.toCharArray();
        Reverse(array,0,n-1);
        Reverse(array,n,array.length-1);
        Reverse(array,0,array.length-1);
        return new String(array);
    }
}
