package exam.netbase;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2019/8/3 14:40
 * @Created by flzhang
 */

import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] score=new int[n];
        for(int i = 0; i < n; i++){
            score[i]=sc.nextInt();
        };
        int[] rankScore=score.clone();
        Arrays.sort(rankScore);
        int q=sc.nextInt();
        int[] que= new int[q];
        for (int i = 0; i < que.length; i++) {
            que[i]=sc.nextInt();
        }
        for(int i=0;i<q;i++){
            int query=que[i];
            int count=0;
            int k=0;
            while(score[query-1]>rankScore[k]&&k<rankScore.length){
                count++;
                k++;
            }
            double m=count*1.0/score.length*100;
            System.out.println(String.format("%.6f",m));
            //BigDecimal b=new BigDecimal(m);
            //m=b.setScale(6,BigDecimal.ROUND_HALF_UP).doubleValue();
           // DecimalFormat df=new DecimalFormat("0.000000");
           // System.out.println(df.format(m));
           // System.out.println(m);
        }
    }
}
