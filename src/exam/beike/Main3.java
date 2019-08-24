package exam.beike;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Classname Main3
 * @Description TODO
 * @Date 2019/8/10 19:40
 * @Created by flzhang
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 数量，输入的数均为正整数
        int[] weight=new int[n];
        for (int i = 0; i < n; i++) {
            weight[i]=sc.nextInt();
       }
        Arrays.sort(weight);
        int count=0;
        double less=0.0;
        for (int i = 0; i < weight.length; i++) {
            for(int j=i+1;j<weight.length;j++){
                if(weight[i]>=weight[j]*0.9){
                    count++;
                }else{
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
