package com.harris.test;

/**
 * @author Harris
 * @version 1.0
 * @ClassName: spring
 * @Description: 两数之和
 * @date 2022/2/17 14:44
 * <p>
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * </p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * </p>
 */
public class TwoSumExample {

	public static void main(String[] args) {
		int[] l1 = new int[]{2, 4, 3};
		int[] l2 = new int[]{5, 6, 4};

	}

	public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {

		return null;
	}
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}