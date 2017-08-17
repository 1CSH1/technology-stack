package com.csh.leetcode.c0002;

/**
 * Created by jamescsh on 8/16/17.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class AddTwoNumbers {

/*
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
 */


    /*
    Time complexity: O(max(m, n))
    Space complexity: O(max(m, n))
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int a = 0;
        int b = 0;
        ListNode l4 = new ListNode(0);
        ListNode l3 = l4;
        while (null != l1 && null != l2) {
            a = l1.val + l2.val + b;
            b = a / 10;
            a = a % 10;
            l3.next = new ListNode(a);
            l3 = l3.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (null != l1) {
            a = l1.val + b;
            b = a / 10;
            a = a % 10;
            l3.next = new ListNode(a);
            l3 = l3.next;
            l1 = l1.next;
        }

        while (null != l2) {
            a = l2.val + b;
            b = a / 10;
            a = a % 10;
            l3.next = new ListNode(a);
            l3 = l3.next;
            l2 = l2.next;
        }

        if (0 != b) {
            l3.next = new ListNode(b);
        }

        return l4.next;
    }

    /*
    Time complexity: O(max(m, n))
    Space complexity: O(max(m, n))
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int a = 0;
        int b = 0;
        ListNode l4 = new ListNode(0);
        ListNode l3 = l4;
        while (null != l1 || null != l2) {
            a = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + b;
            b = a / 10;
            l3.next = new ListNode(a % 10);
            l3 = l3.next;
            if (null != l1) {
                l1 = l1.next;
            }
            if (null != l2) {
                l2 = l2.next;
            }
        }
        if (b > 0) {
            l3.next = new ListNode(b);
        }

        return l4.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        AddTwoNumbers atn = new AddTwoNumbers();
        ListNode l3 = atn.addTwoNumbers(l1, l2);
        print(l3);
    }

    public static void print (ListNode l3) {
        while (null != l3) {
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

