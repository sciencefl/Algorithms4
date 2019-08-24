package exam.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname Main2
 * @Description TODO
 * @Date 2019/8/14 19:28
 * @Created by flzhang
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine(); //
        String[] arr=str.split(",");
        System.out.println(Arrays.toString(arr));
        List<String> stringList=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            String tmp="";
            if(!arr[i].equals("")){
                if(arr[i].charAt(0)=='"'&&arr[i].charAt(arr[i].length()-1)!='\"'){
                    tmp+=(arr[i].substring(1,arr[i].length()).replaceAll("\"\"","\"")+",");
                    while(++i<arr.length&&!isRight(arr[i])){
                        tmp+=(arr[i].replaceAll("\"\"","\"")+",");
                    }
                    try{
                        tmp+=arr[i].substring(0,arr[i].length()-1).replaceAll("\"\"","\"");
                    }catch(Exception e){
                        System.out.println("ERROR");
                        return ;
                    }
                }else if(arr[i].charAt(0)=='"'&&arr[i].charAt(arr[i].length()-1)=='\"'){
                    tmp=arr[i].substring(1,arr[i].length()-1).replaceAll("\"\"","\"");
                }else {
                    tmp=arr[i];
                }
            }
            stringList.add(tmp);
        }
        int j=str.length()-1;
        while(j>=0&&str.charAt(j)==','){
            stringList.add("");
            j--;
        }
        if(j==-1){
            stringList.add("");
        }

        System.out.println(stringList.size());
        for(String s:stringList){
            if(s.equals("")){
                System.out.println("--");
            }else {
                System.out.println(s);
            }
        }
    }
    public static boolean isRight(String s){
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='\"'){
                count++;
            }
        }
        if((count&1)==1){
            return true;
        }else{
            return false;
        }
    }
}
