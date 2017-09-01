package Foundamentals;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	Scanner in=new Scanner(System.in);
    	int N=in.nextInt();
    	//in.nextLine();
    	String[] str=new String[N];
    	for(int i=0;i<N;i++){
    		str[i]=in.next();
    	}
    	int Q=in.nextInt();
    	for(int i=0;i<Q;i++){
    		String key=in.next();
    		int count=0;
    		for(int j=0;j<str.length;j++){
    			if(str[j].equals(key)) count++;
    		}
    		System.out.println(count);
    	}
    }
}