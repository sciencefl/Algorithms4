package exam.bigo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Classname NumStars
 * @Description TODO
 * @Date 2019/8/21 15:12
 * @Created by flzhang
 */
public class NumStars {
    public static void main(String[] args) {
        NumStars numStars=new NumStars();
       // String str=numStars.reverseVowels("leetcode");
        System.out.println(numStars.validPalindrome("atbbga"));
        int[] nums={3,2,3,1,2,4,5,5,6};
        numStars.findKthLargest(nums,5);
       // System.out.println(str);
    }
    private final static HashSet<Character> set =new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public String reverseVowels(String s) {
        char[] str=new char[s.length()];
        int lo=0,high=str.length-1;
        while(lo<=high){
            char charLow=s.charAt(lo);
            char charHigh=s.charAt(high);
            if(!set.contains(charLow)){
                str[lo++]=charLow;
            }else if(!set.contains(charHigh)){
                str[high--]=charHigh;
            }else {
                str[high--] = charLow;
                str[lo++] = charHigh;
            }
        }
        return new String(str);
    }
    private boolean count=true;
    public boolean validPalindrome(String s) {
        int lo=0,high=s.length()-1;
        return validPalindrome_c(s,lo,high);
    }
    private boolean validPalindrome_c(String s,int lo,int high){
        if(lo>=high){
            return true;
        }else if(s.charAt(lo)==s.charAt(high)){
            lo++;
            high--;
            return validPalindrome_c(s,lo,high);
        }else {
            if (count == false) {
                return false;
            } else {
                count = false;
                return validPalindrome_c(s, lo + 1, high) || validPalindrome_c(s, lo, high - 1);
            }
        }
    }
    public int findKthLargest(int[] nums, int k) {
        // 采用堆排序的方法
        PriorityQueue<Integer> queue = new PriorityQueue<>();// 小顶堆
        for(int num: nums){
            queue.offer(num);
            if(queue.size()>k){
                queue.poll();
            }
            System.out.println(Arrays.toString(queue.toArray()));
        }
       // System.out.println(Arrays.toString(queue.toArray()));
        return queue.peek();
    }
    PriorityQueue<Map.Entry<Integer,Integer>>  pr = new PriorityQueue<>((o1,o2)->o2.getValue()-o1.getValue());// 大根堆
}
