package huawei01;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Classname Test01
 * @Description TODO
 * @Date 2019/7/24 19:09
 * @Created by flzhang
 */
public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] score = new int[n];
            for (int i = 0; i < n; i++) {
                score[i] = sc.nextInt();
            }
            for (int i = 0; i < m; i++) {
                String op = sc.next();
                int low = sc.nextInt();
                int high = sc.nextInt();
                if(op.equals("U")){
                    score[low-1]=high;
                    System.out.println(Arrays.toString(score));
                }else if(op.equals("Q")){
                    if(low>high){
                        int temp=low;
                        low=high;
                        high=temp;
                    }
                    int max=-1;
                    for(int j=low-1;j<high;j++){
                        if(score[j]>max){
                            max=score[j];
                        }
                    }
                    System.out.println(max);
                }
            }
        }
    }
}
