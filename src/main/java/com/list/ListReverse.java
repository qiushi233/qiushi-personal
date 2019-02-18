package com.list;

/**
 * Description : TODO
 * Author : qiushi02
 * Version : 1.0.0
 * CreateTime : 2019年01月24日 14:25:00
 */
public class ListReverse {
    static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public Node setNext(Node next) {
            this.next = next;
            return next;
        }

        public void printNode(){
            System.out.println(this.data);
            if (this.next!=null){
                this.next.printNode();
            }
        }
    }

    public static void reverse(Node n, Node pre){
        if (n == null) return;
        Node next = n.next;
        n.next = pre;
        reverse(next, n);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.setNext(n2).setNext(n3).setNext(n4).setNext(n5);
        n1.printNode();
        reverse(n1, null);
        n5.printNode();
    }
}
