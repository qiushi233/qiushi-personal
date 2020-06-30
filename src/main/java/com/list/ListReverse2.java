package com.list;
/*
给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
        k 是一个正整数，它的值小于或等于链表的长度。
        如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
        示例 :
        给定这个链表：1->2->3->4->5
        当 k = 2 时，应当返回: 2->1->4->3->5
        当 k = 3 时，应当返回: 3->2->1->4->5
        说明 :
        你的算法只能使用常数的额外空间。
        你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
*/


/**
 * Description : TODO
 * Author : qiushi
 * Version : 1.0.0
 * CreateTime : 2019年10月09日 16:18:00
 */
public class ListReverse2 {
    public static Node reverseKGroup(Node head, int k) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node pre = dummy;
        Node end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            Node start = pre.next;
            Node next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    private static Node reverse(Node head) {
        Node pre = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.setNext(n2).setNext(n3).setNext(n4).setNext(n5);
        n1.printNode();
        Node node = reverseKGroup(n1, 3);
        node.printNode();
    }

}
