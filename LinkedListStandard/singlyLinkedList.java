import java.util.Scanner;

public class singlyLinkedList{
    node head;
    static class node{
        node next;
        int data;
    }
    public  node search(int key) {
        if(head == null)
            return head;
        else{
            node temp = head;
            while( temp !=null && temp.data != key ){
                temp = temp.next;
            }
            if(temp==null){
                return null;
            }
            else{
                return temp;
            }
        }
    }
    
    public  void reverse() {
        if(head == null){

        }else{
            node current =head;
            node prev = null;
            node next;
            while(current!=null){
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            
            head = prev;
        }
    } 
    public  void print_linkedList() {
        node temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }

    }
    public  boolean insert_node( node temp) {
        if(head == null){
            head = temp;
            return true;
        }
        else{
            node temp1 = head;
            while(temp1.next!=null){
                temp1 = temp1.next;
            }
            temp1.next = temp;
            return true;
        }
    }
    public  boolean delete_node(int key) {
        node temp = search(key);
        if(temp == null)
            return false;
        
       else if(temp==head){
            head = head.next;
            return true;
        }
        else{
            node temp1 = head;
            while(temp1.next != temp){
                temp1 = temp1.next;
            }
            temp1.next = temp.next;
            return true;
        }
    }
    
    public  void create_linkedList(int no_of_nodes) {
        for(int i=0;i<no_of_nodes;i++){
            node temp = new node();
            temp.data = (int) (10*Math.random());
            temp.next = null;
            insert_node(temp);
        }
    }
    public static void main(String[] args) {
        singlyLinkedList obj = new singlyLinkedList();
        obj.create_linkedList(2);
        obj.print_linkedList();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter key to search");
        int key = in.nextInt();
        node temp = obj.search(key);
        if(temp != null){
            System.out.println(temp.data);
        }
        else{
            System.out.println("Not found");
        }
        System.out.println("Enter value to delete");
        key = in.nextInt();
        obj.delete_node(key);
        obj.print_linkedList();
        obj.reverse();
        obj.print_linkedList();
    }
}
