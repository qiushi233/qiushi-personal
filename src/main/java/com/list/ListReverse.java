package com.list;

/**
 * Description : TODO
 * Author : qiushi02
 * Version : 1.0.0
 * CreateTime : 2019年01月24日 14:25:00
 */
public class ListReverse {

    public static void reverse1(Node n, Node pre) {
        if (n == null) return;
        Node next = n.next;
        n.next = pre;
        reverse1(next, n);
    }

    public static void reverse2(Node n) {
        Node pre = null;
        Node curr = n;
        while(curr != null){
            Node tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.setNext(n2).setNext(n3).setNext(n4).setNext(n5);
        n1.printNode();
        reverse1(n1, null);
        n5.printNode();
        reverse2(n5);
        n1.printNode();
    }
}
