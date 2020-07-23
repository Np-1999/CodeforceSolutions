/*
    Problem Statement: Remove duplicate nodes from sorted linkedlist
        https://www.interviewbit.com/problems/remove-duplicates-from-sorted-list/
    Logic: As list is sorted duplicate element will be side by side so we will
    traverse until we get some different element, once we get that we will point
    it with next of our intial node.
*/
import java.util.Scanner;

public class removeDuplicates {
    Node head;
    static class Node{
        int val;
        Node next;
    }
    public void remove_duplicates(){
        Node temp1 = head;
        while(temp1 != null ){
            int key = temp1.val;
            Node temp = temp1;
            while(temp!= null && temp.val == key){
                temp = temp.next;
            }
            if(temp1 == temp)
                temp1 = temp.next;
            else{
                temp1.next = temp;
                temp1 = temp1.next;
            }
                
        }
    }
    public  boolean insert_Node( Node temp) {
        if(head == null){
            head = temp;
            return true;
        }
        else{
            Node temp1 = head;
            while(temp1.next!=null){
                temp1 = temp1.next;
            }
            temp1.next = temp;
            return true;
        }
    }
    public  void print_linkedList() {
        Node temp = head;
        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }

    } 
    public static void main(String[] args) {
        removeDuplicates obj = new removeDuplicates();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter size of list");
        int n = in.nextInt();
        System.out.println("Enter values");
        for(int i=0;i<n;i++){
            Node temp = new Node();
            temp.val = in.nextInt();
            obj.insert_Node(temp);
        }
        obj.remove_duplicates();
        obj.print_linkedList();
    }
    
}