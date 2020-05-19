package JAVA;

public class LinkedList {
    Node head;

    public void appendNode(int data){
        if(head == null) head = new Node(data);
        Node currentNode = head;

        if(currentNode != null){
            currentNode = currentNode.next;
        }
        currentNode = new Node(data);
    }

    public void prependNode(int data){
        if(head == null) head = new Node(data);
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }

    public void deleteNode(int data){
        Node currentNode=head;
        if(head.data == data){
            currentNode = head.next;
        }
        while(currentNode.next !=null){
            if(currentNode.next.data == data){
                currentNode.next = currentNode.next.next;
            }
            currentNode=currentNode.next;         
        }

    }
}