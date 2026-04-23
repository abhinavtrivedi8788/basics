package com.engineering.dsa.linkedlistpkg;

public class LinkedListImpl {

    Node headPointer;

    private void addNewNode(LinkedListImpl linkedList, int data) {
        Node newNode = new Node(data);
        if(isEmpty(linkedList)){
            linkedList.headPointer = newNode;
        }else{
            Node currentPointer = linkedList.headPointer;
            while(currentPointer.next !=null){
                currentPointer =  currentPointer.next;
            }
            currentPointer.next = newNode;
        }
    }

    private void insertNodeAtSpecifiedIndex(LinkedListImpl linkedList, int data, int index) {
        Node newNode = new Node(data);
        Node currentPointer = linkedList.headPointer;
        Node tempNode;
        if(index==0){
            linkedList.headPointer = newNode;
            linkedList.headPointer.next = currentPointer;
        }else {
            for(int i=1;i<index;i++){
                currentPointer = currentPointer.next;
            }
            tempNode = currentPointer.next;
            currentPointer.next= newNode;
            newNode.next = tempNode;
        }
    }

    private void deleteNodeAtSpecifiedIndex(LinkedListImpl linkedList, int index) {
        if(isEmpty(linkedList)){
            System.out.println("LinkedList is Empty , nothing to delete ");
        }else{
            Node currentPointer = linkedList.headPointer;
            Node toBeDeleted=null;
            Node tempNode = null;
            for(int i=0;i<index-1;i++){
                currentPointer = currentPointer.next;
            }
            toBeDeleted=currentPointer.next;
            tempNode=toBeDeleted.next;
            currentPointer.next=tempNode;
        }
    }

    private void traversal(LinkedListImpl linkedList){
        if(isEmpty(linkedList)){
            System.out.println("Linked List is Empty , nothing to traverse");
        } else{
            Node currentPointer = linkedList.headPointer;
            while(currentPointer !=null){
                System.out.println("Nodes : "+currentPointer.data);
                currentPointer = currentPointer.next;
            }
        }
    }

    private static boolean isEmpty(LinkedListImpl linkedList) {
        return linkedList.headPointer == null;
    }

    static void main() {
        LinkedListImpl linkedList = new LinkedListImpl();
        //linkedList.addNewNode(linkedList, 10);
        linkedList.addNewNode(linkedList, 20);
        linkedList.addNewNode(linkedList, 30);
        linkedList.addNewNode(linkedList, 50);
        linkedList.addNewNode(linkedList, 70);
        linkedList.addNewNode(linkedList, 90);
        System.out.println("Linked List after adding new Node :" +linkedList);
        linkedList.insertNodeAtSpecifiedIndex(linkedList,10,0);
        linkedList.insertNodeAtSpecifiedIndex(linkedList,40,3);
        linkedList.insertNodeAtSpecifiedIndex(linkedList,60,5);
        linkedList.insertNodeAtSpecifiedIndex(linkedList,80,7);
        linkedList.deleteNodeAtSpecifiedIndex(linkedList,3);
        linkedList.traversal(linkedList);
    }


    @Override
    public String toString() {
        return "LinkedListImpl{" +
                "headPointer=" + headPointer +
                '}';
    }
}
