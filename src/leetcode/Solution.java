package leetcode;

import java.awt.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Foundamentals.Stack;
import edu.princeton.cs.algs4.SET;

public class Solution {
	public int climbStairs(int n) {
		if(n==1) {
			return 1;
		}else if(n==2) {
			return 2;
		}
		return climbStairs(n-1)+climbStairs(n-2);     
    }

    public boolean isValid(String s) {
    	Map<Character, Character> mappings=new HashMap<>();
    	Stack<Character> stack=new Stack<Character>();
    	mappings.put(')', '(');
    	mappings.put('}', '{');
    	mappings.put(']', '[');
    	for(int i=0;i<s.length();i++) {
    		char current=s.charAt(i);
    		if(mappings.containsKey(current)) {
    			char etop=stack.isEmpty()?'#':stack.pop();
    			if(etop!=mappings.get(current)) {
    				return false;
    			}
    		}else {
    			stack.push(current);
    		}
    	}
    	return stack.isEmpty();
    }
    public int longestValidParentheses(String s) {
    	Map<Character, Character> mappings=new HashMap<>();
    	Stack<Character> stack=new Stack<Character>();
    	int maxMatch=0;
    	int count=0;
    	mappings.put(')', '(');
    	for(int i=0;i<s.length();i++) {
    		char current=s.charAt(i);
    		if(mappings.containsKey(current)) {
    			char etop=stack.isEmpty()?'#':stack.pop();
    			if(etop!=mappings.get(current)) {
    				count=0;
    			}else{
    				count=count+2;
        			maxMatch=maxMatch>count?maxMatch:count;
                }
    		}else {
    			stack.push(current);
    		}
    	}
        return maxMatch;
    }
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists==null||lists.length==0) {
			return null;
		}
		ListNode  headNode=lists[0];
		for(int i=1;i<lists.length;i++) {
			headNode=mergeTwoLists(headNode, lists[i]);
		} 
		return headNode;
    }
	/*
	 * 合并两个有序链表，需要注意
	 * 1.边界问题
	 * 2.鲁棒性问题
	 */
	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if(l1==null) {
    		return l2;
    	} 
    	if(l2==null) {
    		return l1;
    	}
    	ListNode mergedList=null;
    	if(l1.val<l2.val) {
    		mergedList=l1;
    		mergedList.next=mergeTwoLists(l1.next, l2);
    	}else {
    		mergedList=l2;
    		mergedList.next=mergeTwoLists(l1, l2.next);
    	}
    	return mergedList;
        
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	//引入哨兵机制
    	ListNode sentry=new ListNode(0);
    	sentry.next=head;
    	ListNode first=sentry;
    	ListNode second=sentry;
    	for(int i=1;i<=n;i++) {
    		first=first.next;
    	}
    	while(first.next!=null) {
    		first=first.next;
    		second=second.next;
    	}
    	second.next=second.next.next;
    	return sentry.next;
    	
    }
    public ListNode reverseList(ListNode head) {
    	ListNode prevNode=null;
    	ListNode currentNode=head;
    	ListNode nextNode=null;
    	while(currentNode!=null) {
    		nextNode=currentNode.next;
    		currentNode.next=prevNode;
    		prevNode=currentNode;
    		currentNode=nextNode;
    	}
        return prevNode;
    }
    //数组存储法
    public ListNode middleNode(ListNode head) {
    	ListNode slow;
    	ListNode fast;
    	
    	return head;
    }
    public static void main(String[] args) {
    	Solution solution =new Solution();
    	System.out.println(solution.climbStairs(2));;
    }


}
