package com.leetcode.problem;

import java.util.Arrays;

public class Solution {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuffer str1 = new StringBuffer();
        StringBuffer str2 = new StringBuffer();
        while(l1!=null) {
            str1.append(l1.val);
            l1 = l1.next;
        }
        
        while(l2!=null) {
            str2.append(l2.val);
            l2 = l2.next;
        }
        int a = Integer.parseInt(str1.reverse().toString());
        int b = Integer.parseInt(str2.reverse().toString());
        int c = a+b;
       String sol = Integer.toString(c);
       StringBuilder sb = new StringBuilder(sol);
       sol = sb.reverse().toString();
       ListNode ln = null;
       for(int i=0; i<sol.length(); i++) {
           switch (i) {
               case 0:
                   ln = new ListNode(Integer.parseInt(String.valueOf(sol.charAt(i))));
                   break;
               case 1:
                   ln.next = new ListNode(Integer.parseInt(String.valueOf(sol.charAt(i))));
                   break;
               case 2:
                   ln.next.next = new ListNode(Integer.parseInt(String.valueOf(sol.charAt(i))));
                   break;
               case 3:
                   ln.next.next.next = new ListNode(Integer.parseInt(String.valueOf(sol.charAt(i))));
                   break;
               case 4:
                   ln.next.next.next.next = new ListNode(Integer.parseInt(String.valueOf(sol.charAt(i))));
                   break;
               case 5:
                   ln.next.next.next.next.next = new ListNode(Integer.parseInt(String.valueOf(sol.charAt(i))));
                   break;
               case 6:
                   ln.next.next.next.next.next.next = new ListNode(Integer.parseInt(String.valueOf(sol.charAt(i))));
                   break;
                   case 7:
                   ln.next.next.next.next.next.next.next = new ListNode(Integer.parseInt(String.valueOf(sol.charAt(i))));
                   break;
                   case 8:
                   ln.next.next.next.next.next.next.next.next = new ListNode(Integer.parseInt(String.valueOf(sol.charAt(i))));
                   break;
                   case 9:
                   ln.next.next.next.next.next.next.next.next.next = new ListNode(Integer.parseInt(String.valueOf(sol.charAt(i))));
                   break;
                   
           }
    	   
       }
        return ln;
    
    }
	
	

	public static void main(String[] args) {
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(9);
		l2.next.next = new ListNode(9);
		l2.next.next.next = new ListNode(9);
		l2.next.next.next.next = new ListNode(9);
		l2.next.next.next.next.next = new ListNode(9);
		l2.next.next.next.next.next.next = new ListNode(9);
		l2.next.next.next.next.next.next.next = new ListNode(9);
		l2.next.next.next.next.next.next.next.next = new ListNode(9);
		l2.next.next.next.next.next.next.next.next.next = new ListNode(9);
		
		ListNode l1 = new ListNode(9);
		
		ListNode ln = new Solution().addTwoNumbers(l1, l2);
	}
}
