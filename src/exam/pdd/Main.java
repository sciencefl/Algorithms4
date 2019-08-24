package exam.pdd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2019/7/28 13:25
 * @Created by flzhang
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String[] s1 = str1.split(" ");
        int[] A = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            A[i] = Integer.parseInt(s1[i]);
        }

        String str2 = scanner.nextLine();
        String[] s2 = str2.split(" ");
        int[] B = new int[s2.length];
        for (int i = 0; i < s1.length; i++) {
            B[i] = Integer.parseInt(s2[i]);
        }

        int index = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] >= A[i + 1]) {
                index = i;
            }
        }

        Arrays.sort(B);
        boolean flag = false;
        for (int i = B.length - 1; i >= 0; i--) {
            if (index == 0) {
                if ((B[i] > A[index]) &&(B[i] < A[index + 2])) {
                    A[index + 1] = B[i];
                    flag = true;
                    break;
                }else if ((B[i] < A[index + 1])){
                    A[index] = B[i];
                    flag = true;
                    break;
                }
            }else if (index == A.length - 2) {
                if ((B[i] > A[index])) {
                    A[index + 1] = B[i];
                    flag = true;
                    break;
                }else if ((B[i] > A[index - 1]) && (B[i] < A[index + 1])){
                    A[index] = B[i];
                    flag = true;
                    break;
                }
            }else {
                if ((B[i] > A[index]) &&(B[i] < A[index + 2])) {
                    A[index + 1] = B[i];
                    flag = true;
                    break;
                }else if ((B[i] > A[index - 1]) && (B[i] < A[index + 1])){
                    A[index] = B[i];
                    flag = true;
                    break;
                }
            }


        }

        if (flag) {
            for (int i : A) {
                System.out.print(i + " ");
            }
        }else {
            System.out.println("NO");
        }
    }
    public void test(){
        Scanner scanner=new Scanner(System.in);
        String str1=scanner.nextLine();
        String[] s1=str1.split(" " );
        int[] A =new int[str1.length()];
        for (int i = 0; i < s1.length; i++) {
            A[i]=Integer.parseInt(s1[i]);
        }
        String str2=scanner.nextLine();
        String[] s2=str1.split(" " );
        int[] B =new int[str2.length()];
        for (int i = 0; i < s2.length; i++) {
            B[i]=Integer.parseInt(s2[i]);
        }
        int index=0;
        for (int i = 0; i < A.length-1; i++) {
            if(A[i]>=A[i+1]){
                index=i;
            }
        }
        Arrays.sort(B);
        boolean flag=false;
        for (int i = B.length - 1; i >= 0; i--) {
            if(B[i]>A[index]&&(B[i]<A[index+2])){
                A[index+1]=B[i];
                flag=true;
                break;
            }else if(B[i]>A[index-1]&&(B[i]<A[index+1])){
                A[index]=B[i];
                flag=true;
                break;
            }
        }
        if(flag){
            for(int i:A){
                System.out.print(i+" ");
            }
        }else
            System.out.println("NO");
    }

}
