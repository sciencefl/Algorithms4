package leetcode;

/**
 * @Classname Solution
 * @Description TODO
 * @Date 2019/8/2 15:37
 * @Created by flzhang
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public int climbStairs(int n) {
        int[] temp= {0,1};
        if(n==1) {
            return 1;
        }
        int res=0;
        int res0=0,res1=1;
        for(int i=1;i<n;i++) {
            res=res0+res1;
            res0=res1;
            res1=res;
        }
        return res;
    }
    public int fib(int N) {
        if(N==0){
            return 0;
        }
        if(N==1){
            return 1;
        }
        int fibN=0,fib0=0,fib1=1;
        for(int i=2;i<=N;i++) {
            fibN=fib0+fib1;
            fib0=fib1;
            fib1=fibN;
        }
        return fibN;
    }

    public boolean isValid(String s) {
        Map<Character, Character> mappings=new HashMap<>();
        Stack<Character> stack=new Stack<Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
        for(int i=0;i<s.length();i++) {
            char current=s.charAt(i);
            if(mappings.containsKey(current)) {
                char etop=stack.isEmpty()?'#':stack.pop();
                if(etop!=mappings.get(current)) {
                    return false;
                }
            }else {
                stack.push(current);
            }
        }
        return stack.isEmpty();
    }
    public int longestValidParentheses(String s) {
        Map<Character, Character> mappings=new HashMap<>();
        Stack<Character> stack=new Stack<Character>();
        int maxMatch=0;
        int count=0;
        mappings.put(')', '(');
        for(int i=0;i<s.length();i++) {
            char current=s.charAt(i);
            if(mappings.containsKey(current)) {
                char etop=stack.isEmpty()?'#':stack.pop();
                if(etop!=mappings.get(current)) {
                    count=0;
                }else{
                    count=count+2;
                    maxMatch=maxMatch>count?maxMatch:count;
                }
            }else {
                stack.push(current);
            }
        }
        return maxMatch;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0) {
            return null;
        }
        ListNode  headNode=lists[0];
        for(int i=1;i<lists.length;i++) {
            headNode=mergeTwoLists(headNode, lists[i]);
        }
        return headNode;
    }
    /*
     * 合并两个有序链表，需要注意
     * 1.边界问题
     * 2.鲁棒性问题
     */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) {
            return l2;
        }
        if(l2==null) {
            return l1;
        }
        ListNode mergedList=null;
        if(l1.val<l2.val) {
            mergedList=l1;
            mergedList.next=mergeTwoLists(l1.next, l2);
        }else {
            mergedList=l2;
            mergedList.next=mergeTwoLists(l1, l2.next);
        }
        return mergedList;

    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //引入哨兵机制
        ListNode sentry=new ListNode(0);
        sentry.next=head;
        ListNode first=sentry;
        ListNode second=sentry;
        for(int i=1;i<=n;i++) {
            first=first.next;
        }
        while(first.next!=null) {
            first=first.next;
            second=second.next;
        }
        second.next=second.next.next;
        return sentry.next;

    }
    public ListNode reverseList(ListNode head) {
        ListNode prevNode=null;
        ListNode currentNode=head;
        ListNode nextNode=null;
        while(currentNode!=null) {
            nextNode=currentNode.next;
            currentNode.next=prevNode;
            prevNode=currentNode;
            currentNode=nextNode;
        }
        return prevNode;
    }
    //数组存储法
    public ListNode middleNode(ListNode head) {
        ListNode slow;
        ListNode fast;

        return head;
    }
    public int mySqrt1(int x) {
        long t = x;
        t = 0x5f3759df - (t >> 1);
        while (!(t*t <= x && (t+1)*(t+1) > x))
            t = (x/t + t)/2;
        return (int)t;
    }
    public int mySqrt(int x) {
        long low=0;
        long high=0;
        if(x>=46340) {
            high=46340;
        }else {
            high=x;
        }
        long mid=low+((high-low)>>1);
        while(!(mid*mid<=x&&(mid+1)*(mid+1)>x)) {
            if(mid*mid<x) {
                low=mid+1;
            }else {
                high=mid-1;
            }
            mid=low+((high-low)>>1);
        }
        return (int)mid;
    }
    //反转字符串中的所有单词
    public String reverseWords(String s) {
        if(s == null || s.length() == 0)
            return "";
        String[] all_word = s.split(" ");
        int i = 0;
        int j = all_word.length - 1;
        while(i <= j){
            String tmp = all_word[i];
            all_word[i] = all_word[j];
            all_word[j] = tmp;
            i++;
            j--;
        }
        StringBuilder result = new StringBuilder();
        for(int k = 0; k < all_word.length; k++){
            all_word[k] = all_word[k].trim();
            if(all_word[k].equals(""))
                continue;
            result.append(all_word[k] + " ");
        }
        if(result.length() > 0){
            result.setLength(result.length() - 1);
        }
        return result.toString();
    }
    //反转字符串
    public void reverseString(char[] s) {
        if(s==null||s.length==0) {
            return ;
        }
        //高低数组下标，用于转换字符串
        int low=0;
        int high=s.length-1;
        while(low<high) {
            //创建辅助变量，用于数据交换
            char temp=s[low];
            s[low]=s[high];
            s[high]=temp;
            low++;
            high--;
        }
    }
    /**
     * 反转单词
     * @param s
     * 思路：
     * 1.要想反转所有单词，则需要按照反转字符串的思想，只是把单位由字符，变化为字符串
     * 2.按照" "空格分割字符串，存入字符串数组，然后反转。
     * 3.按照“ ”空格拼接原则，拼接， 返回即可
     * @return
     */
    public String reverseWord(String s) {
        // 第0步：边界判断
        if(s==null||s=="") {
            return "";
        }
        //第一步:分割整个字符串，成为字符串数组
        String[] arrayWord=s.split(" ");
        //第二步：反转整个字符串
        int low=0;
        int high=arrayWord.length-1;
        while(low<high) {
            String temp=arrayWord[low];
            arrayWord[low]=arrayWord[high];
            arrayWord[high]=temp;
            low++;
            high--;
        }
        //第三部，空格拼接原则
        StringBuilder result=new StringBuilder();//String ，StringBuffer,StringBuilder区别。
        for(int i=0;i<arrayWord.length;i++) {
            arrayWord[i]=arrayWord[i].trim();
            if(arrayWord[i].equals("")) {
                continue;
            }
            result.append(arrayWord[i]+" ");
        }
        //去除末尾最后一个空格
        if(result.length()>0) {
            result.setLength(result.length()-1);
        }
        return result.toString();
    }
    /**
     * 字符串转换整数
     * 如果前面有空格，需要剔除空格；
     * 剔除空格后，第一个字符串如果是+号，认为是正数；如果是-号，认为是负数；
     * 后面的字符如果不是数字，那么返回0，如果是数字，返回实际的数字。遇到不是数字的字符，转换结束。
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        //第0步，判断有效性
        if(str==null||str=="") {
            return 0;
        }
        //第1步，剔除空格
        int strLength=str.length();
        int index=0;//字符游标
        int sign=1;//判断正负的时候用的
        while(index<strLength&&str.charAt(index)==' ') {
            index++;
        }
        //如果全是空格的话
        if(index==strLength) {
            return 0;
        }
        //第2步，判断正负
        if(str.charAt(index)=='-') {
            sign=-1;
            index++;
        }else if(str.charAt(index)=='+') {
            sign=1;
            index++;
        }
        //第3步，累加运算
        double sum=0;
        while(index<strLength) {
            char temp=str.charAt(index);
            if(temp>='0'&&temp<='9') {
                sum=sum*10+(int)(temp-'0');
                index++;
            }else
                break;
        }
        sum=sum*sign;

        return  (int)sum;
    }
    public void test(String s) {
        s=s.trim();
        System.out.println(s);

    }
    public static void main(String[] args) {
        algo.Solution solution =new algo.Solution();
        //	System.out.println(solution.climbStairs(2));
        //	System.out.println(solution.mySqrt(2147395600));
        solution.test("    zhangfulinag     ");
        System.out.println(solution.myAtoi(" "));
        System.out.println("Solution's ClassLoader is "+ algo.Solution.class.getClassLoader());
        System.out.println("Solution's  Parent ClassLoader is "+ algo.Solution.class.getClassLoader().getParent());
        System.out.println("Solution's   Parent  Parent ClassLoader is "+ algo.Solution.class.getClassLoader().getParent().getParent());
    }


}
