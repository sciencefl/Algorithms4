package jianzhiOffer;

import java.util.*;

/**
 * @Classname Solution50_59
 * @Description TODO
 * @Date 2019/7/27 19:55
 * @Created by flzhang
 */
public class Solution50_59 {
    public static void main(String[] args) {
        Solution50_59 solution50_59=new Solution50_59();
    }

    /**
     * 二叉树的层次遍历
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        LinkedList<TreeNode> leftFirst=new LinkedList<>();
        LinkedList<TreeNode> rightFirst=new LinkedList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(pRoot==null) {
            return list;
        }
        leftFirst.push(pRoot);
        boolean leftFlag=true;
        while (!leftFirst.isEmpty()||!rightFirst.isEmpty()){
            ArrayList<Integer> integers=new ArrayList<>();
            if(leftFlag){
                while(!leftFirst.isEmpty()){
                    TreeNode node=leftFirst.pop();
                    if(node.left!=null)
                        rightFirst.push(node.left);
                    if(node.right!=null)
                        rightFirst.push(node.right);
                    integers.add(node.val);
                }
                leftFlag=false;
                list.add(integers);
            }else {
                while(!rightFirst.isEmpty()){
                    TreeNode node=rightFirst.pop();
                    if(node.right!=null)
                        leftFirst.push(node.right);
                    if(node.left!=null)
                        leftFirst.push(node.left);
                    integers.add(node.val);
                }
                leftFlag=true;
                list.add(integers);
            }

        }
        return list;
    }

    /**
     *  从上到下打印数组，每一层打印一行
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer> > Print1(TreeNode pRoot) {
        LinkedList<TreeNode> queue=new LinkedList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(pRoot==null) {
            return list;
        }
        queue.add(pRoot);
        while(!queue.isEmpty()){
            int count=queue.size();
            ArrayList<Integer> arrayList= new ArrayList<>();
            Collections.reverse(queue);
            for(int i=0;i<count;i++){
                TreeNode node=queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }if(node.right!=null)
                    queue.add(node.right);
                arrayList.add(node.val);
            }
            if(arrayList.size()!=0) {
                list.add(arrayList);
            }
        }
        return list;
    }

    /**
     * 重建二叉树,为了便于查找元素位置，采用map存储中序遍历的 数字及其 位置
     * @param pre
     * @param in
     * @return
     */
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode reConstructBinaryTree(int [] pre,int [] in){
        for (int i = 0; i < in.length; i++) {
            map.put(in[i],i);
        }
        return reConstructBinaryTree2(pre,0,pre.length-1,0);
    }
    public TreeNode reConstructBinaryTree2(int[] pre,int preL,int preR,int inL){
        if(preL>preR){
            return null;
        }
        TreeNode headNode = new TreeNode(pre[preL]);
        int index=map.get(pre[preL]);
        int leftSize=index-inL;
        headNode.left=reConstructBinaryTree2(pre,preL+1,preL+leftSize,inL);
        headNode.right=reConstructBinaryTree2(pre,preL+leftSize+1,preR,index+1);
        return headNode;
    }

    /**
     * 寻找二叉树的第k个节点
     * @param pRoot
     * @param k
     * @return
     */
    private int cnt=0;
    private TreeNode ret=null;
    public TreeNode KthNode(TreeNode pRoot, int k) {
        inOrder(pRoot,k);
        return ret;
    }

    /**
     * 二叉树的中序遍历
     * @param pRoot
     * @param k
     */
    public void inOrder(TreeNode pRoot,int k){
        if(pRoot==null){
            return ;
        }
        inOrder(pRoot.left,k);
        if(pRoot.val<=k){
            cnt++;
        }
        if(k==cnt){
            ret=pRoot;
            return;
        }
        inOrder(pRoot.right,k);
    }

    /**
     * 表示数字的字符串   采用正则表达式更好一点
     * @param str
     * @return
     */
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        return new String(str).matches("[+-]?\\d+(\\.\\d+)?([eE][+-]?\\d+)?");
    }

    /**
     * 滑动窗口的最大值
     * 1.思路，初始化一个size大小的大根堆，每次维护这个大根堆的时候都取区堆顶的元素
     *
     * @param num 输入数组
     * @param size 滑动窗口的值
     * @return   返回每个滑动窗口最大值的ArrayList
     */

    public ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> ret = new ArrayList<>();
        PriorityQueue<Integer> heapMax = new PriorityQueue<>((o1, o2) ->o2-o1 ); // 建立一个大根堆
        if(num==null||size<1){
            return ret;
        }
        //初始化大根堆
        for(int i=0;i<size;i++){
            heapMax.add(num[i]);
        }
        ret.add(heapMax.peek());
        for(int i=0,j=size;j<num.length;j++,i++){
            heapMax.remove(num[i]);
            heapMax.offer(num[j]);
            ret.add(heapMax.peek());
        }
        return ret;
    }

    /**
     * 数据流中的中位数
     * 思路，因为要取中位数，所以可以用大顶堆和小顶堆 每个堆的数量要保持一致
     * @param num 要插入的数字
     */
    PriorityQueue<Integer> heapLeft = new PriorityQueue<>((o1, o2) ->o2-o1);// 大顶堆
    PriorityQueue<Integer> heapRight = new PriorityQueue<>(); // 默认为小顶堆
    int N=0; //已经插入的数量
    public void Insert(Integer num) {
        if(N%2==0){
            /**
             * 大根堆中的元素都小于小根堆中的元素
             * 已经插入偶数个数量的话，要先插在左边的堆（大顶）上，因为左边的堆中元素都小于右边元素，所以要先插在右边堆中
             * ，然后再从右边堆中选出堆顶元素
             */
            heapRight.offer(num);
            heapLeft.offer(heapRight.poll());
        }else{
            heapLeft.offer(num);
            heapRight.offer(heapLeft.poll());
        }
        N++;
    }
    public Double GetMedian() {
        if(N%2==0){
            return (heapRight.peek()+heapLeft.peek())/2.0;
        }else {
            return (double)heapLeft.peek();
        }
    }
    /**
     * 字符流中第一个不重复的 字符，字符计数问题，
     * @param ch
     */
    Queue<Character> queue = new LinkedList<>();
    int[] cntCh = new int[256];
    public void Insert(char ch)
    {
        cntCh[ch]++;
        queue.add(ch);
        while(!queue.isEmpty()&&cntCh[queue.peek()]>1){
            queue.poll();
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        if(queue.isEmpty()){
            return '#';
        }else{
            return queue.peek();
        }
    }

}
