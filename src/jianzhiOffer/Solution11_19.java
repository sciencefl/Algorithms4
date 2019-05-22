package jianzhiOffer;

import java.util.ArrayList;

public class Solution11_19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 镜像二叉树
	 *  
	 */
    public void Mirror(TreeNode root) {
        if(root==null) {
        	return ;
        }
        TreeNode tempNode=root.left;
        root.left=root.right;
        root.right=tempNode;
        Mirror(root.left);
        Mirror(root.right);
    }
    /**
     * 顺时针打印矩阵
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        //分为上下左右四个方向的遍历
        int r1=0;
        int r2=matrix.length-1;
        int c1=0;
        int c2=matrix[0].length-1;
        
        while(r1<=r2&&c1<=c2) {
        	//以下代码考察鲁棒性， 考察逻辑思维的缜密程度
        	for(int i=c1;i<=c2;i++) {
        		arrayList.add(matrix[r1][i]);
        	}
        	for(int i=r1+1;i<=r2;i++) {
        		arrayList.add(matrix[i][c2]);
        	}
        	if(r1!=r2) {
        		for(int i=c2-1;i>=c1;i--) {
        			arrayList.add(matrix[r2][i]);
        		}
        	}
        	if(c1!=c2) {
        		for(int i=r2-1;i>r1;i--) {
        			arrayList.add(matrix[i][c1]);
        		}
        	}
        	r1++;r2--;c1++;c2--;	
        }
        return arrayList;
    }

}
