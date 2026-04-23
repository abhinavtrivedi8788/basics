package com.engineering.dsa.linkedlistpkg;

/**
* @author abhinavtrivedi
 * Node object that has data and Node Object pointing to next node
*
 */
public class Node {
    int data ;
    Node next ;

    public Node() {

    }
    public Node (int value ) {
        this.data = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}