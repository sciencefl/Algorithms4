package exam.pdd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Classname class2
 * @Description TODO
 * @Date 2019/7/28 15:38
 * @Created by flzhang
 */
public class Main2 {
    public  static String x=null;
    public static void main(String[] args) {
        ;
        Scanner scanner= new Scanner(System.in);
        String[] str=scanner.nextLine().split(" ");
        if(str==null){
            System.out.println("false");
        }else {
            fun(str, 0);
            if (x != null) {
                System.out.println("true");
            } else
                System.out.println("false");
        }
    }
    private  static void fun(String[] str,int k){
        if(k==str.length&&judge(str[str.length-1],str[0])){
            x= Arrays.toString(str);
            return;
        }
        for(int i=k;i<str.length;i++){
            if(k>0&&judge(str[k-1],str[i])){
                swap(str,k,i);
                fun(str,k+1);
                swap(str,k,i);
            }else if(k==0){
                swap(str,k,i);
                fun(str,k+1);
                swap(str,k,i);
            }
        }
    }
    private  static void swap(String[] a,int s,int i){
        String t=a[s];
        a[s]=a[i];
        a[i]=t;
    }
    private static boolean judge(String s1,String s2){
        if(s1.charAt(s1.length()-1)==s2.charAt(0)){
            return true;
        }else
            return false;
    }

}
