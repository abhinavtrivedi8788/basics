package com.engineering.dsa.linkedlistpkg;

/***
 *
 * @author abhinavtrivedi
 *
 * This is Singly Linked List that has all the user defined operations
 *
 */
public class SinglyLinkedList {

        Node headPointerNodeObject ;

        public static SinglyLinkedList insertNewNode(SinglyLinkedList list , int data) {
        Node newNode = new Node(data);
        newNode.next = null;

        if(isEmpty(list)) {
            list.headPointerNodeObject= newNode;
        }else {
            Node lastNode= list.headPointerNodeObject;
            while(lastNode.next!=null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
        return list;
    }
        public static SinglyLinkedList insertNewNodeAtGivenPosition(SinglyLinkedList list , int data , int position) {
        Node newNode = new Node(data);
        newNode.next = null;

        if(isEmpty(list)) {
            list.headPointerNodeObject= newNode;
        }else {
            Node currentNode= list.headPointerNodeObject;
            Node tempNode;
            for(int i=0;i<position-1;i++) {
                currentNode = currentNode.next;
            }
            tempNode = currentNode.next;
            currentNode.next = newNode;
            newNode.next = tempNode;
        }
        return list;
    }
        public static SinglyLinkedList deleteFirstNode(SinglyLinkedList list) {
        if(isEmpty(list)) {
            System.out.println("Linked List is Empty so deleteFirstNode can't proceed : ");
        }else {
            Node node = list.headPointerNodeObject;
            list.headPointerNodeObject = node.next;
            node=null;
        }
        return list;
    }
        public static SinglyLinkedList deleteLastNode(SinglyLinkedList list) {
        if(isEmpty(list)) {
            System.out.println("Linked List is Empty so deleteLastNode can't proceed : ");
        }else {
            Node node = list.headPointerNodeObject;
            int counter  = SinglyLinkedList.size(list)-1;
            while(counter>1) {
                node = node.next;
                counter--;
            }
            node.next=null;
        }
        return list;
    }
        public static SinglyLinkedList deleteNodeAtSpecificPostion(SinglyLinkedList list,int position) {
        if(isEmpty(list)) {
            System.out.println("Linked List is Empty so deleteNodeAtSpecificPostion can't proceed : ");
        }else {
            Node nodeBefore = list.headPointerNodeObject;
            Node nodetoBeDeleted  = null;
            Node tempNode;
            for(int i=0;i<position-1;i++) {
                nodeBefore = nodeBefore.next;
            }
            nodetoBeDeleted = nodeBefore.next;
            tempNode = nodetoBeDeleted.next;
            nodeBefore.next = tempNode;
        }
        return list;
    }
        public static void traversal(SinglyLinkedList list) {
        if(isEmpty(list)) {
            System.out.println("Linked List is Empty : ");
        }else {
            Node currentNodeObject = list.headPointerNodeObject;
            while (currentNodeObject!=null) {
                System.out.println("currentNodeObject has data : "+currentNodeObject.data);
                currentNodeObject = currentNodeObject.next;
            }
            System.out.println("LinkedList has total "+ SinglyLinkedList.size(list) +" ELEMETS  ");
        }
    }
        public static Boolean isEmpty(SinglyLinkedList linkedList) {
        return linkedList.headPointerNodeObject==null ? Boolean.TRUE: Boolean.FALSE;
    }
        public static int size(SinglyLinkedList linkedList) {
        int nodeCounter =0;
        if (isEmpty(linkedList)) {
            return 0;
        }
        Node currentNodeObject = linkedList.headPointerNodeObject;
        while (currentNodeObject!=null) {
            currentNodeObject = currentNodeObject.next;
            ++nodeCounter;
        }
        return nodeCounter;
    }


        static void main(String[] args) {
        SinglyLinkedList newLinkedListObject = new SinglyLinkedList();
        /*
         * newLinkedListObject = insertNewNode(newLinkedListObject, 10);
         * newLinkedListObject = insertNewNode(newLinkedListObject, 20);
         * newLinkedListObject = insertNewNode(newLinkedListObject, 30);
         * newLinkedListObject = insertNewNode(newLinkedListObject, 40);
         * newLinkedListObject = insertNewNode(newLinkedListObject, 50);
         * newLinkedListObject = insertNewNodeAtGivenPosition(newLinkedListObject, 3000,3);
         */
        SinglyLinkedList.traversal(newLinkedListObject);
        newLinkedListObject =SinglyLinkedList.deleteFirstNode(newLinkedListObject);
        newLinkedListObject =SinglyLinkedList.deleteLastNode(newLinkedListObject);
        newLinkedListObject =SinglyLinkedList.deleteNodeAtSpecificPostion(newLinkedListObject, 3);
        SinglyLinkedList.traversal(newLinkedListObject);
    }
    }
