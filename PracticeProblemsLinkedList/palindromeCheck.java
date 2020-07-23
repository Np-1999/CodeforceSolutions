/*
    Problem Statement : Given a singly linked list, determine if its a palindrome. 
    Return 1 or 0 denoting if its a palindrome or not, respectively.
        https://www.interviewbit.com/problems/palindrome-list/
    Logic: We reverse linked list from middle node and checks it with intial linked list. If it 
    matches then its palindrome else not palindrome.

*/
import java.util.Scanner;

public class palindromeCheck {
    Node head;
    static class Node{
        int val;
        Node next;
    }
    public int palindrome(){
        Node temp = head;
        int n=0;
        while(temp!=null){
            n++;
            temp = temp.next;
        }
        if(n%2 == 1){
            n = (int)Math.ceil(n/2);
        }
        else{
            n = n/2;
        }
        temp = head;
        for(int i=1;i<n;i++){
            temp = temp.next;
        }
        Node second = reverse(temp);
        temp = head;
        while(temp!=null){
            if(temp.val != second.val){
                return 0;
            }
            temp = temp.next;
            second =second.next;
        }
        return 1;
    }
    public  Node reverse(Node head_temp) {
        if(head_temp == null){
            return head_temp;
        }else{

            Node current =head_temp;
            Node prev = null;
            Node next;
            while(current!=null){
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            head_temp = prev;
            return head_temp;
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
    public static void main(String[] args) {
        palindromeCheck  obj = new palindromeCheck();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter no of integer characters to check for palindrome");
        int n = in.nextInt();
        System.out.println("Enter integers");
        for(int i=0;i<n;i++){
            Node temp = new Node();
            temp.val = in.nextInt();
            obj.insert_Node(temp);
        }
        System.out.println(obj.palindrome());

    }
}