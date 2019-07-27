package jianzhiOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

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

}
