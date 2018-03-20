package Foundamentals;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Node {
    int data;
    Node next;
 }
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */


    }
    int FindMergeNode(Node headA, Node headB) {
        // Complete this function
        // Do not write the main method. 
    	while(headA!=null){
    		while(headB!=null){
    			if(headB==headA){
    				return headB.data;
    			}
    			headB=headB.next;
    		}
    		headA=headA.next;
    	}
    	 return headA.data;
    }
}
		
		

		


		