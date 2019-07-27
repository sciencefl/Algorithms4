package jianzhiOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

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
       // System.out.println(s);
        int[] numbers={1,2,3,4,5};
        solution40_49.multiply(numbers);
       // System.out.println(solution40_49.isContinuous(numbers));
        int a=solution40_49.LastRemaining_Solution(5,3);
      //  System.out.println(a);
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

    /**
     *  扑克牌顺子
     *  解题思路 ：1.先判断 容量够不够5个，不够false
     *              2.对数组进行排序
     *              3.统计大小王的个数。
     *              4.从第一个非大小王的位置遍历，1)前后两数相等，false 前后两数相差数，小于剩余大小王数量，true
     *              5.坑点，连续的两个数字之间天然的相差1
     * @param numbers 顺子的参数，大小王均为 0
     * @return
     */
    public boolean isContinuous(int [] numbers) {
        if(numbers.length<5){
            return false;
        }
        Arrays.sort(numbers);
        int countKings=0;
        for(int i=0;i<numbers.length&&numbers[i]==0;i++) countKings++;
        if(countKings>=4){
            return true;
        }
        int n=countKings+1;
        for(int j=n;j<numbers.length;j++){
            if(numbers[j]==numbers[j-1]||numbers[j]-numbers[j-1]-1>countKings){
                return false;
            }
            else
                countKings-=(numbers[j]-numbers[j-1]-1);
        }
        return true;
    }

    /**
     * 圆圈中最后剩下的数
     *  采用模拟的方式来进行 ，环形链表来解决
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
        if(n==0||m==0){
            return -1;
        }
        LinkedList<Integer> list= new LinkedList<>();
        for(int i=0;i<n;i++){
            list.add(i);
        }
        int index=0; //游标位置
        while(list.size()>1){
            for(int i=1;i<m;i++){
                //要删除元素的位置
                index++;
            }
            index=index%list.size();
            list.remove(index);
        }
        return list.get(0);
    }

    /**
     * 不用 for,等循环控制语句进行 加法。
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {
        if(n==1)
            return 1;
        else {
            return n+Sum_Solution(n-1);
        }
    }

    /**
     * 不用加减乘除做加法
     * @param num1
     * @param num2
     * @return
     */
    public int Add(int num1,int num2) {
        // 没有考虑进位的两数各位相加
        int sum=num1^num2;
        // 两数相加的进位   <<1很重要
        int carry=(num1&num2)<<1;
        //当没有进位的时候，就说明两数相加的结果就是加的结果
        while(carry!=0){
            num1=sum;
            num2=carry;
            sum=num1^num2;
            carry=(num1&num2)<<1;

        }
        return sum;
    }

    /**
     * 字符串转化为整数
     * @param str
     * @return
     */
    public int StrToInt(String str) {
        if(str==null||str.length()==0){
            return 0;
        }
        boolean isNegtive=str.charAt(0)=='-'?true:false;
        int number=0;
        for(int i=0;i<str.length();i++){
            if(i==0&&(str.charAt(i)=='-'||str.charAt(i)=='+'))
                continue;
            if(str.charAt(i)>'9'||str.charAt(i)<'0'){
                return 0;
            }else {
                number=10*number+(str.charAt(i)-'0');
            }
        }
        return isNegtive?-number:number;
    }

    /**
     *  数组中重复的数，可以想到用 HashSet来实现，但是复杂度为O(logn)，空间复杂度也为O(logn)
     * 所以另辟蹊径 ，采用比较每个位置的方法
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers==null||numbers.length==0){
            return false;
        }
        for(int i = 0;i<length;i++){
            while(numbers[i]!=i){
                if(numbers[i]==numbers[numbers[i]]){
                    duplication[0]=numbers[i];
                    return true;
                }else {
                    int temp=numbers[i];
                    numbers[i]=numbers[numbers[i]];
                    numbers[temp]=temp;
                }
            }
        }
        return false;
    }

    /**
     * 构建乘积数组  ，画图写作，一目了然
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        if(A==null||A.length==0){
            return null;
        }
        int count=A.length;
        int[] B=new int[count];
        int[] C=new int[count];
        int[] D=new int[count];
        C[0]=1;D[count-1]=1;
        for(int i=1,j=count-2;i<count&&j>=0;i++,j--){
            C[i]=C[i-1]*A[i-1];
            D[j]=D[j+1]*A[j+1];
        }
        for(int i=0;i<count;i++){
            B[i]=C[i]*D[i];
        }
        return B;
    }

    /**
     * 删除链表中重复的节点
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead)
    {
            return pHead;
    }

    /**
     *  二叉树的下一个节点
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        // 第一种情况，如果节点有右子节点，则返回右子节点的最左节点
        if(pNode.right!=null){
            pNode=pNode.right;
            while(pNode.left!=null){
                pNode=pNode.left;
            }// 第二种情况，如果节点没有右子节点，如果当前节点不是父节点的右子节点，则向上返回到为不是右子节点为
        }else if(pNode.next!=null){
            while(pNode.next.left!=pNode&&pNode.next!=null){
                pNode=pNode.next;
            }
            pNode=pNode.next;
        }
        return pNode;
    }

    /**
     * 判断一个树是不是对称的
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot)
    {
        return isSymmetrical(pRoot,pRoot);
    }
    boolean isSymmetrical(TreeNode pRoot1,TreeNode pRoot2){
        if(pRoot1==null&&pRoot2==null){
            return true;
        }else if(pRoot1==null|| pRoot2==null){
            return false;
        }else {
            if(pRoot1.val!=pRoot2.val){
                return false;
            }
            return isSymmetrical(pRoot1.left,pRoot2.right)&&isSymmetrical(pRoot1.right,pRoot2.left);
        }
    }

}
