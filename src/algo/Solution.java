package algo;

import java.awt.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;

import org.omg.CORBA.TRANSACTION_MODE;

import Foundamentals.Stack;
import edu.princeton.cs.algs4.SET;

public class Solution {
	public int climbStairs(int n) {
		int[] temp= {0,1};
		if(n==1) {
			return 1;
		}
		int res=0;
		int res0=0,res1=1;
			for(int i=1;i<n;i++) {
				res=res0+res1;
				res0=res1;
				res1=res;
			}
		return res;
    }
    public int fib(int N) {
        if(N==0){
            return 0;
        }
        if(N==1){
            return 1;
        }
        int fibN=0,fib0=0,fib1=1;
        for(int i=2;i<=N;i++) {
        	fibN=fib0+fib1;
        	fib0=fib1;
        	fib1=fibN;
        }
        return fibN;   
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
	 * �ϲ���������������Ҫע��
	 * 1.�߽�����
	 * 2.³��������
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
    	//�����ڱ�����
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
    //����洢��
    public ListNode middleNode(ListNode head) {
    	ListNode slow;
    	ListNode fast;
    	
    	return head;
    }
    public int mySqrt1(int x) {
        long t = x;
	t = 0x5f3759df - (t >> 1);
	while (!(t*t <= x && (t+1)*(t+1) > x))
		t = (x/t + t)/2;
	return (int)t;
    }
    public int mySqrt(int x) {
    	long low=0;
    	long high=0;
    	if(x>=46340) {
    		 high=46340;
    	}else {
    		 high=x;
    	} 
    	long mid=low+((high-low)>>1);
    	while(!(mid*mid<=x&&(mid+1)*(mid+1)>x)) {
    		if(mid*mid<x) {
    			low=mid+1;
    		}else {
    			high=mid-1;
    		}
    		mid=low+((high-low)>>1);
    	}
    	return (int)mid;
    }
    //��ת�ַ����е����е���
    public String reverseWords(String s) {
        if(s == null || s.length() == 0)
        	return "";
        String[] all_word = s.split(" ");
        int i = 0;
        int j = all_word.length - 1;
        while(i <= j){
            String tmp = all_word[i];
            all_word[i] = all_word[j];
            all_word[j] = tmp;
            i++;
            j--;
        }
        StringBuilder result = new StringBuilder();
        for(int k = 0; k < all_word.length; k++){
            all_word[k] = all_word[k].trim();
            if(all_word[k].equals(""))
                continue;
            result.append(all_word[k] + " ");
        }
        if(result.length() > 0){
            result.setLength(result.length() - 1);
        }
        return result.toString();
    }
    //��ת�ַ���
    public void reverseString(char[] s) {
    	if(s==null||s.length==0) {
    		return ;
    	}
    	//�ߵ������±꣬����ת���ַ���
        int low=0;
        int high=s.length-1;
        while(low<high) {
        	//���������������������ݽ���
        	 char temp=s[low];
        	 s[low]=s[high];
        	 s[high]=temp;
        	 low++;
        	 high--;
        }
    }
    /**
     * ��ת����
     * @param s
     * ˼·��
     * 1.Ҫ�뷴ת���е��ʣ�����Ҫ���շ�ת�ַ�����˼�룬ֻ�ǰѵ�λ���ַ����仯Ϊ�ַ���
     * 2.����" "�ո�ָ��ַ����������ַ������飬Ȼ��ת��
     * 3.���ա� ���ո�ƴ��ԭ��ƴ�ӣ� ���ؼ���
     * @return
     */
    public String reverseWord(String s) {
    	// ��0�����߽��ж�
    	if(s==null||s=="") {
    		return "";
    	}
    	//��һ��:�ָ������ַ�������Ϊ�ַ�������
    	String[] arrayWord=s.split(" ");
    	//�ڶ�������ת�����ַ���
    	int low=0;
    	int high=arrayWord.length-1;
    	while(low<high) {
    		String temp=arrayWord[low];
    		arrayWord[low]=arrayWord[high];
    		arrayWord[high]=temp;
    		low++;
    		high--;
    	}
    	//���������ո�ƴ��ԭ��
    	StringBuilder result=new StringBuilder();//String ��StringBuffer,StringBuilder����
    	for(int i=0;i<arrayWord.length;i++) {
    		arrayWord[i]=arrayWord[i].trim();
    		if(arrayWord[i].equals("")) {
    			continue;
    		}
    		result.append(arrayWord[i]+" ");
    	}
    	//ȥ��ĩβ���һ���ո�
    	if(result.length()>0) {
    		result.setLength(result.length()-1);
    	}
    	return result.toString();
    }
    /**
     * �ַ���ת������
     * ���ǰ���пո���Ҫ�޳��ո�
     * �޳��ո�󣬵�һ���ַ��������+�ţ���Ϊ�������������-�ţ���Ϊ�Ǹ�����
     * ������ַ�����������֣���ô����0����������֣�����ʵ�ʵ����֡������������ֵ��ַ���ת��������
     * @param str
     * @return
     */
    public int myAtoi(String str) {
    	//��0�����ж���Ч��
    	if(str==null||str=="") {
    		return 0;
    	}
    	//��1�����޳��ո�
    	int strLength=str.length();
    	int index=0;//�ַ��α�
    	int sign=1;//�ж�������ʱ���õ�
    	while(index<strLength&&str.charAt(index)==' ') {
    		index++;
    	}
    	//���ȫ�ǿո�Ļ�
    	if(index==strLength) {
    		return 0;
    	}
    	//��2�����ж�����
    	if(str.charAt(index)=='-') {
    		sign=-1;
    		index++;
    	}else if(str.charAt(index)=='+') {
    		sign=1;
    		index++;
    	}
    	//��3�����ۼ�����
    	double sum=0;
    	while(index<strLength) {
    		char temp=str.charAt(index);
    		if(temp>='0'&&temp<='9') {
    			sum=sum*10+(int)(temp-'0');
    			index++;
    		}else 
    			break;
    	}
    	sum=sum*sign;
    	
        return  (int)sum;
    }
    public void test(String s) {
    	s=s.trim();
    	System.out.println(s);
    	
    }
    public static void main(String[] args) {
    	Solution solution =new Solution();
    //	System.out.println(solution.climbStairs(2));
    //	System.out.println(solution.mySqrt(2147395600));
    	solution.test("    zhangfulinag     ");
    	System.out.println(solution.myAtoi(" "));
    }


}
